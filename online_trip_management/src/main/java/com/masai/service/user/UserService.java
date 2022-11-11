package com.masai.service.user;

import com.masai.bean.User;
import com.masai.exception.UserException;

public interface UserService {
public User addUser(User user) throws UserException;
}
