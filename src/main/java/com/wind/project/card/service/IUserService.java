package com.wind.project.card.service;

import com.wind.project.card.domain.User;

import java.util.List;

/**
 * 描述：
 *
 * @auther: zjf
 * @sine: 1.0
 */
public interface IUserService {
    /**
     * 根据条件查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<User> selectUserList(User user);

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public User selectUserByUserName(String userName);

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public User selectUserById(Long userId);

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除指定id的用户
     *
     * @param userId
     * @return
     */
    int deleteUserById(Long userId);
}
