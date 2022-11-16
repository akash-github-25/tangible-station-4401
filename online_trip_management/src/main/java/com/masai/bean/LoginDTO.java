package com.masai.bean;

public class LoginDTO {
	
	private Integer userId;
	@NotBlank
	@NotEmpty
	private String userPassword;

	public LoginDTO(Integer userId, String userPassword) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
	}

	public LoginDTO() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
