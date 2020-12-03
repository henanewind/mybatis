package com.wind.cache.service;

import com.wind.cache.domain.Person;

/**
 * 描述：
 *
 * @auther: zjf
 * @sine: 1.0
 */
public interface PersonService {
    Person findById(Long id);

    Person save(Person person);

    void deleteById(Long id);
}
