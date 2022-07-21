package com.code.blog.services;

import java.util.List;

import com.code.blog.entities.Post;
import com.code.blog.payloads.PostDto;
import com.code.blog.payloads.PostResponse;


/***************************************************
 * @author Sneha Soni
* It is used to mark the Services that are available.
* It is Autowired to the Controller and is implemented by the Service Implementation 
* 
* **************************************************/

public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto, Integer userId , Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto , Integer postId);
	
	// delete
	void deletePost(Integer postId);
	
	
	//get ALL posts
//	List<PostDto> getAllPost(Integer PageNumber, Integer PageSize);
	PostResponse getAllPost(Integer PageNumber, Integer PageSize, String sortBy,  String sortDir);
	//getall posts by id
	
	PostDto getPostById(Integer postId);
	
	//get all posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);

	//get all posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//search posts 
	List<PostDto> searchPosts(String keyword);
	
}
