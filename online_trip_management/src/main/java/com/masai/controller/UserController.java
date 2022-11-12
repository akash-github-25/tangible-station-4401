package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.bean.Hotel;
import com.masai.bean.User;
import com.masai.exception.HotelException;
import com.masai.exception.UserException;
import com.masai.service.user.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService us;
	@PostMapping("/user")
	public ResponseEntity<User> saveCustomer(@RequestBody User user) throws  UserException {
		us.addUser(user);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
}
