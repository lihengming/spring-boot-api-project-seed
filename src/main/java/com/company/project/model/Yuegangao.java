package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

public class Yuegangao {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类别
     */
    private String psr;

    /**
     * 一级指标
     */
    @Column(name = "firstIndex")
    private String firstindex;

    /**
     * 二级指标
     */
    @Column(name = "secondIndex")
    private String secondindex;

    /**
     * 生态因子分类
     */
    @Column(name = "ecologicalFactor")
    private String ecologicalfactor;

    /**
     * 单位
     */
    private String unit;

    /**
     * 标准值
     */
    private String standard;

    /**
     * 现状值
     */
    @Column(name = "currentValue")
    private String currentvalue;

    /**
     * 达标时间
     */
    @DateTimeFormat(pattern = "yyyyMMdd")
    @Column(name = "finishTime")
    private Date finishtime;

    /**
     * 备注
     */
    private String comment;

    /**
     * @return Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取类别
     *
     * @return psr - 类别
     */
    public String getPsr() {
        return psr;
    }

    /**
     * 设置类别
     *
     * @param psr 类别
     */
    public void setPsr(String psr) {
        this.psr = psr;
    }

    /**
     * 获取一级指标
     *
     * @return firstIndex - 一级指标
     */
    public String getFirstindex() {
        return firstindex;
    }

    /**
     * 设置一级指标
     *
     * @param firstindex 一级指标
     */
    public void setFirstindex(String firstindex) {
        this.firstindex = firstindex;
    }

    /**
     * 获取二级指标
     *
     * @return secondIndex - 二级指标
     */
    public String getSecondindex() {
        return secondindex;
    }

    /**
     * 设置二级指标
     *
     * @param secondindex 二级指标
     */
    public void setSecondindex(String secondindex) {
        this.secondindex = secondindex;
    }

    /**
     * 获取生态因子分类
     *
     * @return ecologicalFactor - 生态因子分类
     */
    public String getEcologicalfactor() {
        return ecologicalfactor;
    }

    /**
     * 设置生态因子分类
     *
     * @param ecologicalfactor 生态因子分类
     */
    public void setEcologicalfactor(String ecologicalfactor) {
        this.ecologicalfactor = ecologicalfactor;
    }

    /**
     * 获取单位
     *
     * @return unit - 单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置单位
     *
     * @param unit 单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 获取标准值
     *
     * @return standard - 标准值
     */
    public String getStandard() {
        return standard;
    }

    /**
     * 设置标准值
     *
     * @param standard 标准值
     */
    public void setStandard(String standard) {
        this.standard = standard;
    }

    /**
     * 获取现状值
     *
     * @return currentValue - 现状值
     */
    public String getCurrentvalue() {
        return currentvalue;
    }

    /**
     * 设置现状值
     *
     * @param currentvalue 现状值
     */
    public void setCurrentvalue(String currentvalue) {
        this.currentvalue = currentvalue;
    }

    /**
     * 获取达标时间
     *
     * @return finishTime - 达标时间
     */
    public Date getFinishtime() {
        return finishtime;
    }

    /**
     * 设置达标时间
     *
     * @param finishtime 达标时间
     */
    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    /**
     * 获取备注
     *
     * @return comment - 备注
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置备注
     *
     * @param comment 备注
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}