package com.masai.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrentUserSession {
	
	@Id
	private Integer Id=0;
	@NotNull
	private Integer userId;
	@NotNull
	@NotBlank
	@NotEmpty
	private String uuid;
	
	public CurrentUserSession() {
		super();
	}

	public CurrentUserSession(Integer userId, String uuid) {
		super();
		this.userId = userId;
		this.uuid = uuid;
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
