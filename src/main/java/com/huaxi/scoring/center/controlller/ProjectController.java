package com.huaxi.scoring.center.controlller;

import com.huaxi.scoring.center.domain.Project;
import com.huaxi.scoring.center.service.ProjectService;
import com.huaxi.scoring.center.util.ConstraintViolationExceptionHandler;
import com.huaxi.scoring.center.util.ListUtil;
import com.huaxi.scoring.center.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

/**
 * 竞标项目控制器.
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	/**
     * 查询所有竞标项目信息
     * @param async
     * @param pageIndex
     * @param pageSize
     * @param projectName
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(@RequestParam(value="async",required=false) boolean async,
            @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
            @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
            @RequestParam(value="projectName",required=false,defaultValue="") String projectName,
            Model model) {

        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<Project> page = projectService.listUsersByProjectNameLike(projectName, pageable);
        List<Project> list = page.getContent();    // 当前所在页面数据列表

        model.addAttribute("page", page);
        model.addAttribute("projectsList", list);
        return new ModelAndView(async==true?"projects/list :: #mainContainerRepleace":"projects/list", "projectModel", model);
    }
	
    /**
     * 获取创建表单页面
     * @param model
     * @return
     */
    @GetMapping("/add")
    public ModelAndView createForm(Model model) {
        model.addAttribute("project", new Project(null,null,null, null, null));
        return new ModelAndView("projects/add", "projectModel", model);
    }

	
    /**
     * 保存或者修改竞标项目
     * @param project
     * @return
     */
    @PostMapping
    public ResponseEntity<Response> saveOrUpateProject(Project project) {

        try {
            projectService.saveOrUpateProject(project);
        }  catch (ConstraintViolationException e)  {
            return ResponseEntity.ok().body(new Response(false, ConstraintViolationExceptionHandler.getMessage(e)));
        }

        return ResponseEntity.ok().body(new Response(true, "处理成功", project));
    }

	
    /**
     * 删除竞标项目
     * @param id
     * @param model
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Long id, Model model) {
        try {
            projectService.removeProject(id);
        } catch (Exception e) {
            return  ResponseEntity.ok().body( new Response(false, e.getMessage()));
        }
        return  ResponseEntity.ok().body( new Response(true, "处理成功"));
    }
	
    /**
     * 获取修改竞标项目的界面
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "edit/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        Optional<Project> projectOp = projectService.getProjectById(id);
        Project project = projectOp.get();
        model.addAttribute("project", project);
        return new ModelAndView("projects/edit", "projectModel", model);
    }

    /**
     * 获取随机抽取供应商的的页面
     *
     * @param model
     * @return
     */
    @GetMapping("/random")
    public ModelAndView random(Model model) {
        List<Project> allprojects = projectService.findAllProjects();
        ListUtil.randomProjectName(allprojects);
        model.addAttribute("frontlist", allprojects);
        return new ModelAndView("projects/random", "projectModel", model);
    }
}
