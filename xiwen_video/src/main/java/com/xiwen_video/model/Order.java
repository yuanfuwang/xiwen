package com.xiwen_video.model;

import java.util.Date;
import javax.persistence.*;

public class Order {
    @Id
    private String id;

    /**
     * 购买商品
     */
    private String goods;

    /**
     * 支付金额
     */
    private Long amount;

    /**
     * 支付方式
     */
    private String way;

    /**
     * 支付会员
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 状态（0：成功、9：删除）
     */
    private String status;

    /**
     * 支付时间
     */
    @Column(name = "pay_time")
    private Date payTime;

    /**
     * 支付账号
     */
    @Column(name = "account_code")
    private String accountCode;

    private Date createon;

    private String createby;

    private Date modifyon;

    private String modifyby;

    /**
     * 说明
     */
    private String remarks;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取购买商品
     *
     * @return goods - 购买商品
     */
    public String getGoods() {
        return goods;
    }

    /**
     * 设置购买商品
     *
     * @param goods 购买商品
     */
    public void setGoods(String goods) {
        this.goods = goods;
    }

    /**
     * 获取支付金额
     *
     * @return amount - 支付金额
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 设置支付金额
     *
     * @param amount 支付金额
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * 获取支付方式
     *
     * @return way - 支付方式
     */
    public String getWay() {
        return way;
    }

    /**
     * 设置支付方式
     *
     * @param way 支付方式
     */
    public void setWay(String way) {
        this.way = way;
    }

    /**
     * 获取支付会员
     *
     * @return user_id - 支付会员
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置支付会员
     *
     * @param userId 支付会员
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取状态（0：成功、9：删除）
     *
     * @return status - 状态（0：成功、9：删除）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0：成功、9：删除）
     *
     * @param status 状态（0：成功、9：删除）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取支付时间
     *
     * @return pay_time - 支付时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置支付时间
     *
     * @param payTime 支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取支付账号
     *
     * @return account_code - 支付账号
     */
    public String getAccountCode() {
        return accountCode;
    }

    /**
     * 设置支付账号
     *
     * @param accountCode 支付账号
     */
    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
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

    /**
     * 获取说明
     *
     * @return remarks - 说明
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置说明
     *
     * @param remarks 说明
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}