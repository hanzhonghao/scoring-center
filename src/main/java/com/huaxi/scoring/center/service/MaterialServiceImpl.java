package com.huaxi.scoring.center.service;

import com.huaxi.scoring.center.domain.Material;
import com.huaxi.scoring.center.domain.User;
import com.huaxi.scoring.center.repository.MaterialRepository;
import com.huaxi.scoring.center.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * 材料服务接口实现.
 */
@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	private MaterialRepository materialRepository;
	
	@Transactional
	@Override
	public Material saveOrUpateMaterial(Material material) {
		return materialRepository.save(material);
	}

	@Transactional
	@Override
	public Material registerMaterial(Material material) {
		return materialRepository.save(material);
	}

	@Transactional
	@Override
	public void removeMaterial(Long id) {
		materialRepository.deleteById(id);
	}

	@Override
	public Optional<Material> getMaterialById(Long id) {
		return materialRepository.findById(id);
	}

	@Override
	public Page<Material> listUsersByMaterialNameLike(String materialName, Pageable pageable) {
        // 模糊查询
		materialName = "%" + materialName + "%";
        Page<Material> material = materialRepository.findByMaterialNameLike(materialName, pageable);
        return material;
	}

	@Override
	public List<Material> findAllMaterials() {
		List<Material> materialList = materialRepository.findAll();
		return materialList;
	}

}
