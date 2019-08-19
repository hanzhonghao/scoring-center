package com.huaxi.scoring.center.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.huaxi.scoring.center.domain.User;

import java.util.Optional;

/**
 * 用户服务接口.
 */
public interface UserService {
	 /**
     * 新增、编辑、保存用户
     * @param user
     * @return
     */
    User saveOrUpateUser(User user);

    /**
     * 注册用户
     * @param user
     * @return
     */
    User registerUser(User user);

    /**
     * 删除用户
     * @return
     */
    void removeUser(Long id);

    /**
     * 根据id获取用户
     * @return
     */
    Optional<User> getUserById(Long id);

    /**
     * 根据用户名进行分页模糊查询
     * @return
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);
}