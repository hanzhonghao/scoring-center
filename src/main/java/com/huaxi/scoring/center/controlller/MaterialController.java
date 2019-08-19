package com.huaxi.scoring.center.controlller;

import com.huaxi.scoring.center.domain.Material;
import com.huaxi.scoring.center.service.MaterialService;
import com.huaxi.scoring.center.util.ConstraintViolationExceptionHandler;
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
 * Material 控制器.
 */
@RestController
@RequestMapping("/materials")
public class MaterialController {
	@Autowired
	private MaterialService materialService;
	
	/**
     * 查询所有材料
     * @param async
     * @param pageIndex
     * @param pageSize
     * @param materialName
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(@RequestParam(value="async",required=false) boolean async,
            @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
            @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
            @RequestParam(value="materialName",required=false,defaultValue="") String materialName,
            Model model) {

        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<Material> page = materialService.listUsersByMaterialNameLike(materialName, pageable);
        List<Material> list = page.getContent();    // 当前所在页面数据列表

        model.addAttribute("page", page);
        model.addAttribute("materialList", list);
        return new ModelAndView(async==true?"materials/list :: #mainContainerRepleace":"materials/list", "materialModel", model);
    }
	
    /**
     * 获取创建表单页面
     * @param model
     * @return
     */
    @GetMapping("/add")
    public ModelAndView createForm(Model model) {
        model.addAttribute("material", new Material(null,null,null, null, 0));
        return new ModelAndView("materials/add", "materialModel", model);
    }

	
    /**
     * 保存或者修改材料
     * @param material
     * @return
     */
    @PostMapping
    public ResponseEntity<Response> saveOrUpateUser(Material material) {

        try {
            materialService.saveOrUpateMaterial(material);
        }  catch (ConstraintViolationException e)  {
            return ResponseEntity.ok().body(new Response(false, ConstraintViolationExceptionHandler.getMessage(e)));
        }

        return ResponseEntity.ok().body(new Response(true, "处理成功", material));
    }

	
    /**
     * 删除材料
     * @param id
     * @param model
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Long id, Model model) {
        try {
            materialService.removeMaterial(id);
        } catch (Exception e) {
            return  ResponseEntity.ok().body( new Response(false, e.getMessage()));
        }
        return  ResponseEntity.ok().body( new Response(true, "处理成功"));
    }
	
    /**
     * 获取修改用户的界面
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "edit/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        Optional<Material> materialOp = materialService.getMaterialById(id);
        Material material = materialOp.get();
        model.addAttribute("material", material);
        return new ModelAndView("materials/edit", "materialModel", model);
    }

    /**
     * 获取汇总分数的页面
     *
     * @param model
     * @return
     */
    @GetMapping("/calculate")
    public ModelAndView calculate(Model model) {
        List<Material> allMaterials = materialService.findAllMaterials();
        int calculatePoint = 0;
        for (Material material:allMaterials){
            int point = material.getPoint();
            calculatePoint = calculatePoint + point;
        }
        model.addAttribute("points", calculatePoint);
        return new ModelAndView("materials/calculate", "materialModel", model);
    }
}
