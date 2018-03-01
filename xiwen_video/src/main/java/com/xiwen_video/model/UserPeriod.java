package com.xiwen_video.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_period")
public class UserPeriod {
    @Id
    private String id;

    /**
     * 会员ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 开始期间
     */
    @Column(name = "period_start")
    private Date periodStart;

    /**
     * 结束时间
     */
    @Column(name = "period_end")
    private Date periodEnd;

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
     * 获取会员ID
     *
     * @return user_id - 会员ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置会员ID
     *
     * @param userId 会员ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取开始期间
     *
     * @return period_start - 开始期间
     */
    public Date getPeriodStart() {
        return periodStart;
    }

    /**
     * 设置开始期间
     *
     * @param periodStart 开始期间
     */
    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    /**
     * 获取结束时间
     *
     * @return period_end - 结束时间
     */
    public Date getPeriodEnd() {
        return periodEnd;
    }

    /**
     * 设置结束时间
     *
     * @param periodEnd 结束时间
     */
    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
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
}