package com.huaxi.scoring.center.service;

import com.huaxi.scoring.center.domain.Material;
import com.huaxi.scoring.center.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * 材料服务接口.
 */
public interface MaterialService {
	 /**
     * 新增、编辑、保存材料
     * @param material
     * @return
     */
    Material saveOrUpateMaterial(Material material);

    /**
     * 注册用户
     * @param material
     * @return
     */
    Material registerMaterial(Material material);

    /**
     * 删除材料
     * @return
     */
    void removeMaterial(Long id);

    /**
     * 根据id获取材料
     * @return
     */
    Optional<Material> getMaterialById(Long id);

    /**
     * 根据材料名称进行分页模糊查询
     * @return
     */
    Page<Material> listUsersByMaterialNameLike(String material, Pageable pageable);
}