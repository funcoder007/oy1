package com.code.blog.payloads;

import com.code.blog.entities.Post;

import lombok.Getter;
import lombok.Setter;


/********************************************
 *  @author Sneha Soni
 * Payload -  The payload contains the data that could be stored or updated.
 * DTO     - Not using Dtos lead to recursive calls to mapped identities
 * @NoArgsConstructor - Annotation is used to generate the no-argument constructor for a class.
 * @Getter - To generate the default getter implementation for fields that are annotated with the annotation.
 * @Setter - To generate the default setter implementation for fields that are annotated with the annotation.
 * @NotNull -A method should not return
 * @Size    -If you configure Hibernate to generate the database tables, it will limit the size of the database column based on the maximum size defined by the @Size annotation.
 * @Email   - To say that a string field must be a valid email address.
 * ******************************************/

@Getter
@Setter
public class CommentDto {


	
    private  int id;
	
	private String content;
	

	
}
