package com.wind.cache.repository;

import com.wind.cache.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述：
 *
 * @auther: zjf
 * @sine: 1.0
 */

public interface PersonRepository extends JpaRepository<Person, Long> {


}
