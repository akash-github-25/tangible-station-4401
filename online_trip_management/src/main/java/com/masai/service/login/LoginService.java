package com.masai.service.login;

import com.masai.bean.LoginDTO;
import com.masai.exception.LoginException;

public interface LoginService {
	public String logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;
}
