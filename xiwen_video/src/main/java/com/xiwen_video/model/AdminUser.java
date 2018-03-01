package com.xiwen_video.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "admin_user")
public class AdminUser {
    @Id
    private String id;

    /**
     * 登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 状态（0：正常、9：删除）
     */
    private String status;

    private Date createon;

    private String createby;

    private Date modifyon;

    private String modifyby;

    /**
     * 说明
     */
    private String remarks;

    /**
     * 用户类型（0：超级管理员、1：管理员)
     */
    private String type;

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
     * 获取登录名
     *
     * @return login_name - 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录名
     *
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
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
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
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

    /**
     * 获取用户类型（0：超级管理员、1：管理员)
     *
     * @return type - 用户类型（0：超级管理员、1：管理员)
     */
    public String getType() {
        return type;
    }

    /**
     * 设置用户类型（0：超级管理员、1：管理员)
     *
     * @param type 用户类型（0：超级管理员、1：管理员)
     */
    public void setType(String type) {
        this.type = type;
    }
}