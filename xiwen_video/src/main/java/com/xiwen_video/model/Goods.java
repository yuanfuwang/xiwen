package com.xiwen_video.model;

import java.util.Date;
import javax.persistence.*;

public class Goods {
    /**
     * 商品ID
     */
    @Id
    private String id;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 商品价格
     */
    private Long price;

    /**
     * 商品分类
     */
    private String category;

    /**
     * 状态
     */
    private String status;

    /**
     * 库存数量
     */
    private Integer number;

    private String remarks;

    private Date createon;

    private String createby;

    private Date modifyon;

    private String modifyby;

    /**
     * 获取商品ID
     *
     * @return id - 商品ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置商品ID
     *
     * @param id 商品ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取商品名称
     *
     * @return goods_name - 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名称
     *
     * @param goodsName 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 获取商品价格
     *
     * @return price - 商品价格
     */
    public Long getPrice() {
        return price;
    }

    /**
     * 设置商品价格
     *
     * @param price 商品价格
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * 获取商品分类
     *
     * @return category - 商品分类
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置商品分类
     *
     * @param category 商品分类
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取库存数量
     *
     * @return number - 库存数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置库存数量
     *
     * @param number 库存数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return createon
     */
    public Date getCreateon() {
        return createon;
    }

    /**
     * @param createon
     */
    public void setCreateon(Date createon) {
        this.createon = createon;
    }

    /**
     * @return createby
     */
    public String getCreateby() {
        return createby;
    }

    /**
     * @param createby
     */
    public void setCreateby(String createby) {
        this.createby = createby;
    }

    /**
     * @return modifyon
     */
    public Date getModifyon() {
        return modifyon;
    }

    /**
     * @param modifyon
     */
    public void setModifyon(Date modifyon) {
        this.modifyon = modifyon;
    }

    /**
     * @return modifyby
     */
    public String getModifyby() {
        return modifyby;
    }

    /**
     * @param modifyby
     */
    public void setModifyby(String modifyby) {
        this.modifyby = modifyby;
    }
}