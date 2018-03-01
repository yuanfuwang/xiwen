package com.xiwen_video.model;

import java.util.Date;
import javax.persistence.*;

public class Users {
    /**
     * Id
     */
    @Id
    private String id;

    /**
     * 手机号码(登录用)
     */
    private String mobile;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 0：普通用户、1：会员
     */
    private String type;

    private Date createon;

    private String createby;

    private Date modifyon;

    private String modifyby;

    /**
     * 状态（0：正常、9：删除）
     */
    private String status;

    /**
     * 说明
     */
    private String remarks;

    /**
     * 获取Id
     *
     * @return id - Id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置Id
     *
     * @param id Id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取手机号码(登录用)
     *
     * @return mobile - 手机号码(登录用)
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号码(登录用)
     *
     * @param mobile 手机号码(登录用)
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取0：普通用户、1：会员
     *
     * @return type - 0：普通用户、1：会员
     */
    public String getType() {
        return type;
    }

    /**
     * 设置0：普通用户、1：会员
     *
     * @param type 0：普通用户、1：会员
     */
    public void setType(String type) {
        this.type = type;
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
     * 获取状态（0：正常、9：删除）
     *
     * @return status - 状态（0：正常、9：删除）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0：正常、9：删除）
     *
     * @param status 状态（0：正常、9：删除）
     */
    public void setStatus(String status) {
        this.status = status;
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