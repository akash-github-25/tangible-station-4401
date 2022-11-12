package com.masai.service.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.bean.CurrentUserSession;
import com.masai.bean.LoginDTO;
import com.masai.bean.User;
import com.masai.exception.LoginException;
import com.masai.repository.SessionRepo;
import com.masai.repository.UserRepo;

import net.bytebuddy.utility.RandomString;
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	public UserRepo ud;
	@Autowired
	public SessionRepo sr;

	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
		// TODO Auto-generated method stub
Optional<User> existingUser= ud.findById(dto.getUserId());
      
User user=existingUser.get();
		
		if(user == null) {
			
			throw new LoginException("Please Enter a valid userId");
			
			 
		}
		
		
		Optional<CurrentUserSession> validCustomerSessionOpt =  sr.findById(user.getUserId());
		
		
		
		if(validCustomerSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this number");
			
		}
		
		if(user.getUserPassword().equals(dto.getUserPassword())) {
			
			String key= RandomString.make(6);
			
			
			
			CurrentUserSession currentUserSession = new CurrentUserSession(user.getUserId(),key);
			
			sr.save(currentUserSession);

			return currentUserSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
		
		
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		// TODO Auto-generated method stub

		CurrentUserSession validCustomerSession = sr.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		sr.delete(validCustomerSession);
		
		
		
		return "Logged Out !";
		
		
	}

	}


