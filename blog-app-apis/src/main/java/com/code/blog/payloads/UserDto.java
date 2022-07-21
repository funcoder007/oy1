package com.code.blog.payloads;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
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


@NoArgsConstructor
@Getter
@Setter

public class UserDto {

	
	private int id;
	@NotNull
	@Size(min=4 , message="Usernsme must be atleast 4 characters long")
	private String name;
	@Email(message="Email Address Not Valid!!")
	private String email;
	
	@Size(min=3, max=10 , message="Password must be min 3 chars and max 10")
	
	private String password;
	@NotNull
	private String about;
}
