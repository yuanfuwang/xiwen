package com.xiwen_video.model;

import java.util.Date;
import javax.persistence.*;

public class Category {
    @Id
    private String id;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 父级ID
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 分类名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 状态(0:正常、9：删除)
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
     * 获取层级
     *
     * @return level - 层级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置层级
     *
     * @param level 层级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取父级ID
     *
     * @return parent_id - 父级ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父级ID
     *
     * @param parentId 父级ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取分类名称
     *
     * @return category_name - 分类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置分类名称
     *
     * @param categoryName 分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 获取状态(0:正常、9：删除)
     *
     * @return status - 状态(0:正常、9：删除)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态(0:正常、9：删除)
     *
     * @param status 状态(0:正常、9：删除)
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