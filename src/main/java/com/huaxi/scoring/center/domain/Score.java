package com.huaxi.scoring.center.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity // 实体
public class Score {

    @Id // 主键
    @GeneratedValue(strategy= GenerationType.IDENTITY) // 自增策略
    private Long id; // 实体一个唯一标识

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private Integer techRequire;

    @Column(nullable = false)
    private Integer afterSale;

    @Column(nullable = false)
    private Integer geneSitu;

    @Column(nullable = false)
    private Integer standard;

    @Column(nullable = false)
    private Integer apply;

    @Column(nullable = false)
    private Integer total;

    public Score(Long id,String companyName, Integer techRequire, Integer afterSale, Integer geneSitu, Integer standard,Integer apply, Integer total) {
        this.id=id;
        this.companyName = companyName;//参选公司
        this.techRequire = techRequire;//商务技术
        this.afterSale = afterSale;//售后服务
        this.apply=apply;//投标
        this.geneSitu = geneSitu;//综合情况
        this.standard = standard;//规范
        this.total = total;//合计
    }

    protected Score() { // 无参构造函数;设为 protected 防止直接使用
    }
}
