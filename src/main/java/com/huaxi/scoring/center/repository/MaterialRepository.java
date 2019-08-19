package com.huaxi.scoring.center.repository;

import com.huaxi.scoring.center.domain.Material;
import com.huaxi.scoring.center.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Material Repository 接口.
 */
public interface MaterialRepository extends JpaRepository<Material, Long>{
    /**
     * 根据材料名称分页查询材料列表
     * @param materialName
     * @param pageable
     * @return
     */
    Page<Material> findByMaterialNameLike(String materialName, Pageable pageable);

    /**
     * 根据材料名称查询材料
     * @param materialName
     * @return
     */
    Material findByMaterialName(String materialName);
}
