package com.huaxi.scoring.center.controlller;

import com.huaxi.scoring.center.domain.Project;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class ScoreController {
    @RequestMapping("/score")
    public ModelAndView score(Model model) {
        return new ModelAndView("score/equipment", "model", model);
    }

    @GetMapping("/score")
    public ModelAndView createForm(Model model) {
        model.addAttribute("score",
                new Project(null, null, null, null, 0, 0,
                        null, null, null, null, null, null, null));
        return new ModelAndView("score/add", "projectModel", model);
    }
}
