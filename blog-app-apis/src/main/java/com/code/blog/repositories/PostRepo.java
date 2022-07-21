package com.code.blog.repositories;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import com.code.blog.entities.Category;
import com.code.blog.entities.Post;
import com.code.blog.entities.User;

/********************************************************
 * @Author - Sneha Soni
 * JpaRepository is a JPA (Java Persistence API) specific extension of Repository. 
 * It contains the full API of CrudRepository and PagingAndSortingRepository. 
 * The Java Persistence API (JPA) is the standard way of persisting java objects into relational databases.
 * Repository -> JPA -> Hibernate -> JDBC.
 * <Entity , Type Of Primary Key>
 * Custom Methods Can also be created which in turn uses methos from JpaRepository
 * 
 * 
 * *****************************************************/

public interface PostRepo extends JpaRepository<Post, Integer> {

	//custom finder methods
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);
}
