package com.code.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.blog.entities.Comment;
import com.code.blog.entities.Post;
import com.code.blog.entities.User;
import com.code.blog.exceptions.ResourceNotFoundException;
import com.code.blog.payloads.CategoryDto;
import com.code.blog.payloads.CommentDto;
import com.code.blog.repositories.CommentRepo;
import com.code.blog.repositories.PostRepo;
import com.code.blog.services.CommentService;



/*****
 * @author Sneha Soni
 * @Service
   In order to autowire a class implementing any Entity , we need to have that class decorated with @Service or @Component 
   in order for Spring to inject it into Service when Service is itself of course injected in our controller.
 * 
 * 
 */


@Service
public class CommentServiceImpl implements CommentService {

	/***
	 * @author Sneha Soni
	 * @Autowired - It allows Spring to resolve and inject collaborating beans into our bean.@Autowired is to inject the dependancy into a bean.
	 * Repository is autowired so that we can use the methods present in the repository.
	 * Model Mapper is autowired so that the dto is converted into entity object and vice versa.
	 * ResourceNotFoundException - The ResourceNotFoundException exception is thrown if a security provider looks for a resource that should exist, 
	 * but is unable to find that resource.
	 * */
	 
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(()->new ResourceNotFoundException("Post", "PostId", postId)); 
		
	 Comment comment = this.modelMapper.map(commentDto, Comment.class);
	 comment.setPost(post);
	 Comment savedComment = this.commentRepo.save(comment);
	return this.modelMapper.map(savedComment,CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		
		Comment com = this.commentRepo.findById(commentId)
				.orElseThrow(()->new ResourceNotFoundException("comment", "CommentId", commentId)); 
		this.commentRepo.delete(com);
	}

}
