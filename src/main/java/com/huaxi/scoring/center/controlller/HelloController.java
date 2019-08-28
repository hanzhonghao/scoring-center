package com.huaxi.scoring.center.controlller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Hello 控制器.
 */
@RestController
public class HelloController {
	@RequestMapping("/hello")
	public ModelAndView hello(Model model) {
		return new ModelAndView("admins/hello", "model", model);
	}
}
