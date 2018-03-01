package com.xiwen_video.model;

import java.util.Date;
import javax.persistence.*;

public class Video {
    @Id
    private String id;

    /**
     * 视频名称
     */
    @Column(name = "video_name")
    private String videoName;

    /**
     * 视频存放URL
     */
    @Column(name = "video_url")
    private String videoUrl;

    /**
     * 视频分类
     */
    private String category;

    /**
     * 可查看视频人员的类型
     */
    @Column(name = "user_type")
    private String userType;

    private String status;

    /**
     * 视频播放时长
     */
    private String duration;

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
     * 获取视频名称
     *
     * @return video_name - 视频名称
     */
    public String getVideoName() {
        return videoName;
    }

    /**
     * 设置视频名称
     *
     * @param videoName 视频名称
     */
    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    /**
     * 获取视频存放URL
     *
     * @return video_url - 视频存放URL
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * 设置视频存放URL
     *
     * @param videoUrl 视频存放URL
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    /**
     * 获取视频分类
     *
     * @return category - 视频分类
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置视频分类
     *
     * @param category 视频分类
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 获取可查看视频人员的类型
     *
     * @return user_type - 可查看视频人员的类型
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置可查看视频人员的类型
     *
     * @param userType 可查看视频人员的类型
     */
    public void setUserType(String userType) {
        this.userType = userType;
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
     * 获取视频播放时长
     *
     * @return duration - 视频播放时长
     */
    public String getDuration() {
        return duration;
    }

    /**
     * 设置视频播放时长
     *
     * @param duration 视频播放时长
     */
    public void setDuration(String duration) {
        this.duration = duration;
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