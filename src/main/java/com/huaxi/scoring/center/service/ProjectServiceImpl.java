package com.huaxi.scoring.center.service;

import com.huaxi.scoring.center.domain.Project;
import com.huaxi.scoring.center.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * 竞标项目接口实现.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Transactional
	@Override
	public Project saveOrUpateProject(Project project) {
		return projectRepository.save(project);
	}

	@Transactional
	@Override
	public Project registerProject(Project project) {
		return projectRepository.save(project);
	}

	@Transactional
	@Override
	public void removeProject(Long id) {
		projectRepository.deleteById(id);
	}

	@Override
	public Optional<Project> getProjectById(Long id) {
		return projectRepository.findById(id);
	}

	@Override
	public Page<Project> listUsersByProjectNameLike(String project, Pageable pageable) {
        // 模糊查询
		project = "%" + project + "%";
        Page<Project> material = projectRepository.findByProjectNameLike(project, pageable);
        return material;
	}

	@Override
	public List<Project> findAllProjects() {
		List<Project> projectList = projectRepository.findAll();
		return projectList;
	}

	@Override
	public Page<Project> findAllProjectsForPage(Pageable pageable) {
		Page<Project> projects = projectRepository.findAll(pageable);
		return projects;
	}

}
