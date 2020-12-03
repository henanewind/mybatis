package com.wind.cache.service;

import com.wind.cache.domain.Person;
import com.wind.project.card.domain.User;
import com.wind.cache.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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
        return repository.findById(id).orElse(null);
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
}
