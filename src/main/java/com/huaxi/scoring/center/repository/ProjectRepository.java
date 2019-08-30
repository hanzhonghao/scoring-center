package com.huaxi.scoring.center.repository;

import com.huaxi.scoring.center.domain.Material;
import com.huaxi.scoring.center.domain.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Project Repository 接口.
 */
public interface ProjectRepository extends JpaRepository<Project, Long>{
    /**
     * 根据项目名称分页查询材料列表
     * @param projectlName
     * @param pageable
     * @return
     */
    Page<Project> findByProjectNameLike(String projectlName, Pageable pageable);

    /**
     * 根据项目名称查询材料
     * @param projectlName
     * @return
     */
    Project findByProjectName(String projectlName);
}
