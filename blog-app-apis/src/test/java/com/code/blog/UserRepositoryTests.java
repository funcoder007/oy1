package com.code.blog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.code.blog.entities.User;
import com.code.blog.payloads.UserDto;
import com.code.blog.repositories.UserRepo;

@SpringBootTest

public class UserRepositoryTests {
	
	@Autowired
	private UserRepo userRepository;
	
	//save user JUnit test
	@Test
	
	public void SaveUserTest()
	{
		User user = new User();
		
		user.setName("Test");
		user.setEmail("test@gmail.com");
		user.setAbout("About this user");
		User Testuser=userRepository.save(user);
		assertThat(Testuser).isNotNull();
        assertThat(Testuser.getId()).isPositive();
	}
	@Test
	
	public void AllUsersTest()
	{
		List<User> list= userRepository.findAll();
		assertThat(list).isNotNull();
        assertThat(list.size()).isGreaterThanOrEqualTo(2);
	}
	@Test
	
	public void SingleUserTest()
	{
		User user= userRepository.findById(9).get();
		assertEquals("test@gmail.com",user.getEmail());
	}
	
	@Test
	public void  UpdateUserTest()
	{
	User user =	userRepository.findById(9).get();
	user.setName("User 9");
	userRepository.save(user);
	assertNotEquals("Test",userRepository.findById(9).get().getName());
	}
	
	@Test
	
	public void testDelete()
	{
		userRepository.deleteById(9);
		assertThat(userRepository.existsById(9)).isFalse();
	}

}
