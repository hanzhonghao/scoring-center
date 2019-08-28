package com.huaxi.scoring.center.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

/**
 *  竞标信息表
 */
@Entity // 实体
public class Project {
	//参选公司company	产地及品牌origin	规格型号type 	报价price	最终报价fprice	备注comment
	//时间：2019年月日（周）date   地  点：华西美庐东楼5楼4会议室 location   记录人：李升午recoder  复核人：肖灿 reviewer 经办人:responer
	//议价内容bargain
	@Id // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增策略
	private Long id; // 实体一个唯一标识

    @NotEmpty(message = "项目名称不能为空")
    @Column(nullable = false, length = 20)
    private String projectName;

    @NotEmpty(message = "产地及品牌不能为空")
//    @Size(max=50)
    @Column(nullable = false)
    private String origin;

    @NotEmpty(message = "规格型号不能为空")
    @Column(nullable = false, length = 20)
    private String type ;

	@Column(nullable = false)
	private Integer price;

	@Column(nullable = false)
	private Integer fprice;

	@Column(nullable = false, length = 20)
	private String comment;

	@Column(nullable = false)
	private Date date;

	@NotEmpty(message = "地点不能为空")
	@Column(nullable = false)
	private String location ;

	//记录人：李升午recoder  复核人：肖灿 reviewer 经办人:responer
	@NotEmpty(message = "记录人不能为空")
	@Column(nullable = false)
	private String recoder ;

	@NotEmpty(message = "复核不能为空")
	@Column(nullable = false)
	private String reviewer ;

	@NotEmpty(message = "经办人不能为空")
	@Column(nullable = false)
	private String responer ;

	//议价内容bargain
	@NotEmpty(message = "议价内容不能为空")
	@Column(nullable = false)
	private String bargain ;


	protected Project() { // 无参构造函数;设为 protected 防止直接使用
	}


	public Project(Long id, String projectName, String origin,String type,int price, int fprice, String comment, Date date, String location, String recoder, String reviewer, String responer,String bargain) {
		this.id = id;
		this.projectName = projectName;
		this.origin = origin;
		this.type = type;
		this.price = price;
		this.fprice = fprice;
		this.comment = comment;
		this.date = date;
		this.location = location;
		this.recoder = recoder;
		this.reviewer = reviewer;
		this.responer = responer;
		this.bargain = bargain;
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
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}



	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getFprice() {
		return fprice;
	}

	public void setFprice(int fprice) {
		this.fprice = fprice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRecoder() {
		return recoder;
	}

	public void setRecoder(String recoder) {
		this.recoder = recoder;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getResponer() {
		return responer;
	}

	public void setResponer(String responer) {
		this.responer = responer;
	}

	public String getBargain() {
		return bargain;
	}

	public void setBargain(String bargain) {
		this.bargain = bargain;
	}
}
