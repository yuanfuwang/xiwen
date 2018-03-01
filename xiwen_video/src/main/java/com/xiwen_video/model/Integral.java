package com.xiwen_video.model;

import java.util.Date;
import javax.persistence.*;

public class Integral {
    /**
     * 积分ID
     */
    @Id
    private String id;

    /**
     * 积分数
     */
    @Column(name = "integral_number")
    private Integer integralNumber;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 状态
     */
    private String status;

    private String remarks;

    private Date createon;

    private String createby;

    private Date modifyon;

    private String modifyby;

    /**
     * 获取积分ID
     *
     * @return id - 积分ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置积分ID
     *
     * @param id 积分ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取积分数
     *
     * @return integral_number - 积分数
     */
    public Integer getIntegralNumber() {
        return integralNumber;
    }

    /**
     * 设置积分数
     *
     * @param integralNumber 积分数
     */
    public void setIntegralNumber(Integer integralNumber) {
        this.integralNumber = integralNumber;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
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