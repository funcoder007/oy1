package com.code.blog.services;

import com.code.blog.payloads.UserDto;


import java.util.List;

import com.code.blog.entities.User;


/***************************************************
 * @author Sneha Soni
* It is used to mark the Services that are available.
* It is Autowired to the Controller and is implemented by the Service Implementation 
* 
* **************************************************/


public interface UserService {

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserById( Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser (Integer userId);
}
