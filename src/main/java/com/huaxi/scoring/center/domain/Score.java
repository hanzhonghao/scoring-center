package com.huaxi.scoring.center.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
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
    private Integer total;

    public Score(Long id,String companyName, Integer techRequire, Integer afterSale, Integer geneSitu, Integer standard, Integer total) {
        this.id=id;
        this.companyName = companyName;
        this.techRequire = techRequire;
        this.afterSale = afterSale;
        this.geneSitu = geneSitu;
        this.standard = standard;
        this.total = total;
    }
}
