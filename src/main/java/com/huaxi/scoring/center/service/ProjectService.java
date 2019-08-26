package com.huaxi.scoring.center.service;

import com.huaxi.scoring.center.domain.Material;
import com.huaxi.scoring.center.domain.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * 竞标项目接口.
 */
public interface ProjectService {
	 /**
     * 新增、编辑、保存竞标项目
     * @param project
     * @return
     */
     Project saveOrUpateProject(Project project);

    /**
     * 注册项目
     * @param  project
     * @return
     */
    Project registerProject(Project project);

    /**
     * 删除竞标项目
     * @return
     */
    void removeProject(Long id);

    /**
     * 根据id获取竞标项目
     * @return
     */
    Optional<Project> getProjectById(Long id);

    /**
     * 根据竞标项目名称进行分页模糊查询
     * @return
     */
    Page<Project> listUsersByProjectNameLike(String project, Pageable pageable);

    /**
    * 查找所有竞标项目
    */
    List<Project> findAllProjects();

    Page<Project> findAllProjectsForPage(Pageable pageable);
}