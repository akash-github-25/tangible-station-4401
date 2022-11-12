package com.masai.bean;

import javax.persistence.Entity;

@Entity
public class CurrentUserSession {
	
	@javax.persistence.Id
	private Integer Id=0;

	private Integer userId;
	private String uuid;
	
	public CurrentUserSession(Integer userId, String uuid) {
		super();
		this.userId = userId;
		this.uuid = uuid;
	}

	public CurrentUserSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "CurrentUserSession [userId=" + userId + ", uuid=" + uuid + "]";
	}
	
	

}
