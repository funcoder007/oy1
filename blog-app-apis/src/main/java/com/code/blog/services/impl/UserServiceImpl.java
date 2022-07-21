package com.code.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.blog.entities.User;
import com.code.blog.exceptions.ResourceNotFoundException;
import com.code.blog.payloads.UserDto;
import com.code.blog.repositories.UserRepo;
import com.code.blog.services.UserService;

/*****
 * @author Sneha Soni
 * @Service
   In order to autowire a class implementing any Entity , we need to have that class decorated with @Service or @Component 
   in order for Spring to inject it into Service when Service is itself of course injected in our controller.
 * 
 * 
 */


@Service
public class UserServiceImpl implements UserService {
	
	/***
	 * @author Sneha Soni
	 * @Autowired - It allows Spring to resolve and inject collaborating beans into our bean.@Autowired is to inject the dependancy into a bean.
	 * Repository is autowired so that we can use the methods present in the repository.
	 * Model Mapper is autowired so that the dto is converted into entity object and vice versa.
	 * The ResourceNotFoundException exception is thrown if a security provider looks for a resource that should exist, but is unable to find that resource.
	 * */

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtoToUser(userDto);
		User  savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user = this.userRepo.findById(userId).
				orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		//user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById( Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User", "id", userId));
	
	return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		
	User user=	this.userRepo.findById(userId)
		.orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		
	  this.userRepo.delete(user);
		
		
		

	}
	
	private User dtoToUser(UserDto userDto)
	{
		User user = this.modelMapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		return user;
	}
	
	public UserDto userToDto(User user)
	{
		UserDto userDto =  this.modelMapper.map(user , UserDto.class);
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user.getPassword());
		return userDto;
	}

}
