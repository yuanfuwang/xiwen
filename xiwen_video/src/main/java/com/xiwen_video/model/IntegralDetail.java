package com.xiwen_video.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "integral_detail")
public class IntegralDetail {
    /**
     * 积分明细ID
     */
    @Id
    private String id;

    /**
     * 积分数
     */
    private Integer number;

    /**
     * 积分获取方式
     */
    private String way;

    /**
     * 来源
     */
    private String from;

    /**
     * 给予
     */
    private String to;

    private String status;

    private String remarks;

    private Date createon;

    private String createby;

    private Date modifyon;

    private String modifyby;

    /**
     * 获取积分明细ID
     *
     * @return id - 积分明细ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置积分明细ID
     *
     * @param id 积分明细ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取积分数
     *
     * @return number - 积分数
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置积分数
     *
     * @param number 积分数
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取积分获取方式
     *
     * @return way - 积分获取方式
     */
    public String getWay() {
        return way;
    }

    /**
     * 设置积分获取方式
     *
     * @param way 积分获取方式
     */
    public void setWay(String way) {
        this.way = way;
    }

    /**
     * 获取来源
     *
     * @return from - 来源
     */
    public String getFrom() {
        return from;
    }

    /**
     * 设置来源
     *
     * @param from 来源
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * 获取给予
     *
     * @return to - 给予
     */
    public String getTo() {
        return to;
    }

    /**
     * 设置给予
     *
     * @param to 给予
     */
    public void setTo(String to) {
        this.to = to;
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