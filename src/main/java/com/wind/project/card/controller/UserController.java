package com.wind.project.card.controller;

import com.wind.project.card.domain.User;
import com.wind.project.card.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述：
 *
 * @auther: zjf
 * @sine: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public List<User> list(User user) {
        List<User> list = userService.selectUserList(user);
        return list;
    }
}
