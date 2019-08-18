package com.waylau.spring.boot.blog.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.waylau.spring.boot.blog.domain.User;
import com.waylau.spring.boot.blog.service.UserService;

/**
 * 主页控制器.
 * 
 * @since 1.0.0 2017年5月28日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String root() {
		return "redirect:/admins";
	}
}
