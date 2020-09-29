package com.wind.project.card.controller;

import com.wind.project.card.domain.User;
import com.wind.project.card.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述：处理用户信息的 CRUD 操作
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

    @PostMapping
    public int add(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @PutMapping
    public int update(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public int deleteUserById(@PathVariable("userId") Long userId) {
        return userService.deleteUserById(userId);
    }
}
