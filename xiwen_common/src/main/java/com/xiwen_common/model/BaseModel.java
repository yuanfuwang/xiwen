package com.xiwen_common.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.xiwen_common.util.AuthConstants;
import com.fasterxml.jackson.annotation.JsonFormat;

public abstract class BaseModel<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String createby;

    private Date createon;

    private String modifyby;

    private Date modifyon;

    private String status;
    
    @Id
    private String id;
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 插入之前执行方法，需要手动调用
	 */
	public void preInsert() {
		this.modifyon = new Date();
		this.createon = this.modifyon;
		this.status = AuthConstants.DEL_FLAG_NORMAL;
		this.id = UUID.randomUUID().toString();
	}

	/**
	 * 插入之前执行方法，需要手动调用
	 */
	public void preInsert(String userid) {
		preInsert();
		this.createby = userid;
	}

	/**
	 * 更新之前执行方法，需要手动调用
	 */
	public void preUpdate(String userid) {
		this.modifyon = new Date();
		this.modifyby = userid;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getCreateon() {
		return createon;
	}

	public void setCreateon(Date createon) {
		this.createon = createon;
	}

	public String getModifyby() {
		return modifyby;
	}

	public void setModifyby(String modifyby) {
		this.modifyby = modifyby;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getModifyon() {
		return modifyon;
	}

	public void setModifyon(Date modifyon) {
		this.modifyon = modifyon;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
