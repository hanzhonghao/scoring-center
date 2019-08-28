package com.huaxi.scoring.center.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 *  采购项目表
 */
@Entity // 实体
public class ProjectDeprecated {

	@Id // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增策略
	private Long id; // 实体一个唯一标识

    @NotEmpty(message = "项目名称不能为空")
    @Column(nullable = false, length = 20)
    private String projectName;

    @NotEmpty(message = "采购商不能为空")
    @Size(max=50)
    @Column(nullable = false, length = 20)
    private String purchaseName;

    @NotEmpty(message = "采购员姓名不能为空")
    @Column(nullable = false, length = 20)
    private String buyer;

	@Column(nullable = false, length = 20)
	private String comment;

	protected ProjectDeprecated() { // 无参构造函数;设为 protected 防止直接使用
	}

	public ProjectDeprecated(Long id, @NotEmpty(message = "项目名称不能为空") String projectName, @NotEmpty(message = "采购商不能为空") @Size(max = 50) String purchaseName, @NotEmpty(message = "采购员姓名不能为空") String buyer, String comment) {
		this.id = id;
		this.projectName = projectName;
		this.purchaseName = purchaseName;
		this.buyer = buyer;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getPurchaseName() {
		return purchaseName;
	}

	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

    @Override
    public String toString() {
        return "project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", purchaseName='" + purchaseName + '\'' +
                ", buyer='" + buyer + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
