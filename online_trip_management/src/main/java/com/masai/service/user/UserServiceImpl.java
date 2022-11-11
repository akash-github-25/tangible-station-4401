package com.masai.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.bean.User;
import com.masai.exception.UserException;
import com.masai.repository.UserRepo;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
public UserRepo ur;
	@Override
	public User addUser(User user) throws UserException {
		// TODO Auto-generated method stub
		User user1=ur.save(user);
		if(user1!=null) {
			return user1;
		}else {
			 throw new UserException("User Error");
		}
		
	}

}
