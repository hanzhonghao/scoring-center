package com.huaxi.scoring.center.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Material 实体.
 */
@Entity // 实体
public class Material {

	@Id // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增策略
	private Long id; // 实体一个唯一标识

    @NotEmpty(message = "材料名称不能为空")
    @Column(nullable = false, length = 20) // 映射为字段，值不能为空
    private String materialName;

    @NotEmpty(message = "材料描述不能为空")
    @Size(max=50)
    @Column(nullable = false, length = 50)
    private String materialDesc;

    @NotEmpty(message = "备注不能为空")
    @Column(nullable = false, length = 20)
    private String materialComment;

	@Column(nullable = false)
	private int point;

	protected Material() { // 无参构造函数;设为 protected 防止直接使用
	}
	public Material(Long id, String materialName, String materialDesc, String materialComment,int point) {
		this.id = id;
		this.materialName = materialName;
		this.materialDesc = materialDesc;
		this.materialComment = materialComment;
		this.point = point;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialDesc() {
		return materialDesc;
	}

	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}

	public String getMaterialComment() {
		return materialComment;
	}

	public void setMaterialComment(String materialComment) {
		this.materialComment = materialComment;
	}

	@Override
	public String toString() {
		return "Material{" +
				"id=" + id +
				", materialName='" + materialName + '\'' +
				", materialDesc='" + materialDesc + '\'' +
				", materialComment='" + materialComment + '\'' +
				'}';
	}
}
