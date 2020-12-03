package com.wind.cache.domain;

import com.wind.common.core.BaseEntity;

import javax.persistence.*;
import java.io.NotSerializableException;
import java.io.Serializable;

/**
 * 描述：实体类，如果缓存需要存盘，则应实现Serializable接口
 * 否则会抛出 java.io.NotSerializableException: com.wind.cache.domain.Person
 * {@link NotSerializableException}
 *
 * @auther: zjf
 * @sine: 1.0
 */
@Entity
@Table(name = "person")
public class Person extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
