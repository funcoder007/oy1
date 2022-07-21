package com.code.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.code.blog.entities.Comment;
/********************************************************
 * @Author - Sneha Soni
 * JpaRepository is a JPA (Java Persistence API) specific extension of Repository. 
 * It contains the full API of CrudRepository and PagingAndSortingRepository. 
 * The Java Persistence API (JPA) is the standard way of persisting java objects into relational databases.
 * Repository -> JPA -> Hibernate -> JDBC.
 * <Entity , Type Of Primary Key>
 * 
 * 
 * 
 * *****************************************************/
public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
