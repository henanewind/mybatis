package com.wind.cache.service;

import com.wind.cache.domain.Person;
import com.wind.common.constant.Constants;
import com.wind.common.utils.CacheUtils;
import com.wind.cache.repository.PersonRepository;
import com.wind.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 描述：
 *
 * @auther: zjf
 * @sine: 1.0
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository repository;

    @PostConstruct
    public void init() {
        List<Person> personList = repository.findAll();
        for (Person person : personList) {
            CacheUtils.put(getCacheName(), getCacheKey(person.getId()), person);
        }
    }

    /**
     * 注解@Cacheable:查询的时候才使用该注解!
     * 注意:在Cacheable注解中支持EL表达式
     * redis缓存的key=user_1/2/3....
     * redis的缓存雪崩,缓存穿透,缓存预热,缓存更新...
     * condition = "#result ne null",条件表达式,当满足某个条件的时候才进行缓存
     * unless = "#result eq null":当user对象为空的时候,不进行缓存
     */
    @Cacheable(value = "person", key = "#id", unless = "#result eq null")
    @Override
    public Person findById(Long id) {
        // 1.判断缓存中是否存在 person
        Person person = null;
        person = Person.class.cast(CacheUtils.get(getCacheName(), getCacheKey(id)));
        if (StringUtils.isNotNull(person)) {
            return person;
        }
        // 2.缓存中没有查到，需要重新搜索数据库
        person = repository.findById(id).orElse(null);
        if (StringUtils.isNotNull(person)) {
            // 3、将从数据库中查到的数据重新存到缓存中
            CacheUtils.put(getCacheName(), getCacheKey(person.getId()), person);
        }
        return person;
    }

    /**
     * 注解@CachePut:一般用在添加和修改方法中
     * 既往数据库中添加一个新的对象,于此同时也往redis缓存中添加一个对应的缓存.
     * 这样可以达到缓存预热的目的.
     */
    @CachePut(value = "person", key = "#result.id", unless = "#result eq null")
    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    /**
     * CacheEvict:一般用在删除方法中
     *
     * @param id 删除的人员id
     */
    @CacheEvict(value = "person", key = "#id")
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    /**
     * 获取cache name
     *
     * @return 缓存名
     */
    private String getCacheName() {
        return Constants.PERSON_CACHE;
    }

    /**
     * 设置cache key
     *
     * @param configKey 参数键
     * @return 缓存键key
     */
    private String getCacheKey(Long configKey) {
        return String.format("%s%d", Constants.PERSON_KEY, configKey);
    }
}
