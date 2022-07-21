package com.code.blog.entities;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


/***************
 * @Author -  Sneha Soni
 * @Entity -  Specifies that the class is an entity and is mapped to a database table.
 * @Table  -  Specifies the name of the database table to be used for mapping.
 * @NoArgsConstructor - Annotation is used to generate the no-argument constructor for a class.
 * @Getter - To generate the default getter implementation for fields that are annotated with the annotation.
 * @Setter - To generate the default setter implementation for fields that are annotated with the annotation.
 * @Id    -  Indicating the member field below is the primary key of the current entity.
 * @GeneratedValue -Specifies how to generate values for the given column. 
 * This annotation will help in creating primary keys values according to the specified strategy
 * GenerationType.IDENTITY - 
 * @Column - It is used to set a name to a particular column.
 * *************/

@Entity
@Table(name="comments")
@Getter
@Setter
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private  int id;
	
	private String content;
	@ManyToOne
	private Post post;

}
