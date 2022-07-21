package com.code.blog.services;

import com.code.blog.entities.Comment;
import com.code.blog.payloads.CommentDto;


/***************************************************
 * @author Sneha Soni
* It is used to mark the Services that are available.
* It is Autowired to the Controller and is implemented by the Service Implementation 
* 
* **************************************************/



public interface CommentService {
CommentDto createComment (CommentDto commentDto, Integer postId);
void deleteComment(Integer commentId);

}
