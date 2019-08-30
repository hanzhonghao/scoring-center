package com.huaxi.scoring.center.controlller;

import com.huaxi.scoring.center.domain.Project;
import com.huaxi.scoring.center.domain.Score;
import com.huaxi.scoring.center.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/scores")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public ModelAndView list(@RequestParam(value="async",required=false) boolean async,
                             @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                             @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                             @RequestParam(value="scoreName",required=false,defaultValue="") String scoreName,
                             Model model) {

        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<Score> page = scoreService.listUsersByCompanyNameLike(scoreName, pageable);
        List<Score> list = page.getContent();    // 当前所在页面数据列表

        model.addAttribute("page", page);
        model.addAttribute("scoreList", list);
        return new ModelAndView(async==true?"score/equipment :: #mainContainerRepleace":"score/equipment", "scoreModel", model);
    }

    @RequestMapping("/score")
    public ModelAndView score(Model model) {
        return new ModelAndView("score/equipment", "scoremodel", model);
    }

    @GetMapping("/score")
    public ModelAndView createForm(Model model) {
        model.addAttribute("score",
                new Score(null,null,0,0,0,0,0,0));
        return new ModelAndView("score/equipment", "scoreModel", model);
    }


    @GetMapping("/print")
    public ModelAndView print(Model model) {
        //TODO 根据日期获取列表
        List<Score> allScores = scoreService.findAllScores();
        int size = allScores.size()+1;
        Score firstObj = allScores.get(0);
        model.addAttribute("allscores", allScores);
        model.addAttribute("size", size);
        model.addAttribute("firstObj", firstObj);
        return new ModelAndView("score/printscore", "scoreModel", model);
    }
}
