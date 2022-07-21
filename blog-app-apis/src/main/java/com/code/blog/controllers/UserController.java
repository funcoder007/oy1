package com.code.blog.controllers;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.blog.payloads.ApiResponse;
import com.code.blog.payloads.UserDto;
import com.code.blog.services.UserService;

/****
 * @author Sneha Soni
 * @CrossOrigin -By default, its allows all origins, all headers, and the HTTP methods specified in the @RequestMapping annotation. 
 * @RestController-  It's a convenient annotation that combines @Controller and @ResponseBody, which eliminates the need to annotate 
 * every request handling method of the controller class with the @ResponseBody annotation.
 * @RequestMapping - the annotation is used to map web requests to Spring Controller methods.
 * @Component - annotation is used to load a java class as a bean.
 * @Autowired - It allows Spring to resolve and inject collaborating beans into our bean.@Autowired is to inject the dependancy into a bean
 * @Valid The @Valid annotation is a key feature of Bean Validation, as it allows to validate object graphs with a single call to the validator. 
 * To make use of it all fields that should be recursively checked should be annotated with @Valid .
 * @RequestBody - The @ResponseBody annotation tells a controller that the object returned is automatically serialized into 
 * JSON and passed back into the HttpResponse object.
 * @PathVariable-@PathVariable annotation is used to extract the value from the URI. 
 * HttpStatus.CREATED-public static final HttpStatus CREATED 201 Created.
   HttpStatus.OK-public static final HttpStatus OK 200 OK.
   ResponseEntity represents the whole HTTP response: status code, headers, and body. You can specify what type of object to be serialized into the response body.
 * ****/
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	//POST- create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
	
	{
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	}
	//PUT - update user
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId)
	{
		UserDto updatedUser =this.userService.updateUser(userDto,userId);
	
	   return ResponseEntity.ok(updatedUser);
	}
	
	
	//DELETE - delete user
	@DeleteMapping("/{userId}")
	public  ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId)
	{
	 this.userService.deleteUser(userId)	;
	 return new ResponseEntity(new ApiResponse("UserDeleted Successfully", true), HttpStatus.OK);
	}
	
	//GET - User Get
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId)
	{
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
	
	

}
