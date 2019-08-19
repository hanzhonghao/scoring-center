package com.huaxi.scoring.center.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
