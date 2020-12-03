package com.wind.cache.controller;

import com.wind.cache.domain.Person;
import com.wind.cache.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 描述：
 *
 * @auther: zjf
 * @sine: 1.0
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    private Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService service;

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return service.save(person);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable Long id) {
        Person person = service.findById(id);
        log.warn("person hashcode = {}", person == null ? 0 : person.hashCode());
        HttpStatus status = person == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity(person, status);
    }

    @DeleteMapping("/{id}")
    public String removePerson(@PathVariable Long id) {
        service.deleteById(id);
        return "ok";
    }
}
