package com.wind.project.card.service.impl;

import com.wind.project.card.domain.User;
import com.wind.project.card.mapper.UserMapper;
import com.wind.project.card.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：
 *
 * @auther: zjf
 * @sine: 1.0
 */
@Service
public class UserServiceImpl implements IUserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据条件查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<User> selectUserList(User user) {
        return userMapper.selectUserList(user);
    }

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public User selectUserByUserName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public User selectUserById(Long userId) {
        return userMapper.selectUserById(userId);
    }

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    /**
     * 删除指定id的用户
     *
     * @param userId
     * @return
     */
    @Override
    public int deleteUserById(Long userId) {
        return userMapper.deleteUserById(userId);
    }
}
