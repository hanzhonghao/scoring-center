package com.huaxi.scoring.center.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.huaxi.scoring.center.service.UserService;

/**
 * 主页控制器.
 */
@Controller
public class MainController {
	
	@GetMapping("/")
	public String root() {
		return "redirect:admins";
	}
}
