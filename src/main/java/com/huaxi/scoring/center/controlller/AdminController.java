package com.huaxi.scoring.center.controlller;

import java.util.ArrayList;
import java.util.List;

import com.huaxi.scoring.center.vo.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 后台管理控制器.
 */
@Controller
@RequestMapping("/admins")
public class AdminController {
 
    /**
     * 获取后台管理主页面
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView listUsers(Model model) {
        List<Menu> list = new ArrayList<>();
        list.add(new Menu("材料汇总统计", "/users"));
        model.addAttribute("list", list);
        return new ModelAndView("admins/index", "model", model);
    }
}