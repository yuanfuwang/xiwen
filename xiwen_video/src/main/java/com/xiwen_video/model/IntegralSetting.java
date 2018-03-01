package com.xiwen_video.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "integral_setting")
public class IntegralSetting {
    @Id
    private String id;

    /**
     * 积分规则Key
     */
    @Column(name = "integral_key")
    private String integralKey;

    /**
     * 积分规则值
     */
    @Column(name = "integral_val")
    private String integralVal;

    private String status;

    private String remarks;

    private Date createon;

    private String createby;

    private Date modifyon;

    private String modifyby;

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
     * 获取积分规则Key
     *
     * @return integral_key - 积分规则Key
     */
    public String getIntegralKey() {
        return integralKey;
    }

    /**
     * 设置积分规则Key
     *
     * @param integralKey 积分规则Key
     */
    public void setIntegralKey(String integralKey) {
        this.integralKey = integralKey;
    }

    /**
     * 获取积分规则值
     *
     * @return integral_val - 积分规则值
     */
    public String getIntegralVal() {
        return integralVal;
    }

    /**
     * 设置积分规则值
     *
     * @param integralVal 积分规则值
     */
    public void setIntegralVal(String integralVal) {
        this.integralVal = integralVal;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
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