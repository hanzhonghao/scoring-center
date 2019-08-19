package com.huaxi.scoring.center.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.huaxi.scoring.center.domain.User;
import com.huaxi.scoring.center.repository.UserRepository;

import java.util.Optional;

/**
 * 用户服务接口实现.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.blog.service.UserService#saveOrUpateUser(com.waylau.spring.boot.blog.domain.User)
	 */
	@Transactional
	@Override
	public User saveOrUpateUser(User user) {
		return userRepository.save(user);
	}

	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.blog.service.UserService#registerUser(com.waylau.spring.boot.blog.domain.User)
	 */
	@Transactional
	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.blog.service.UserService#removeUser(java.lang.Long)
	 */
	@Transactional
	@Override
	public void removeUser(Long id) {
		userRepository.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.blog.service.UserService#getUserById(java.lang.Long)
	 */
	@Override
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.blog.service.UserService#listUsersByNameLike(java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<User> listUsersByNameLike(String name, Pageable pageable) {
        // 模糊查询
        name = "%" + name + "%";
        Page<User> users = userRepository.findByNameLike(name, pageable);
        return users;
	}

}
