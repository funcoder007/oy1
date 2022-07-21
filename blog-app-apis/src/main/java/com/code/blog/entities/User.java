package com.code.blog.entities;

import java.util.ArrayList;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.Builder;

/***************
 * @Entity -  Specifies that the class is an entity and is mapped to a database table.
 * @Table  -   Specifies the name of the database table to be used for mapping.
 * @NoArgsConstructor - Annotation is used to generate the no-argument constructor for a class.
 * @Getter - To generate the default getter implementation for fields that are annotated with the annotation.
 * @Setter - To generate the default setter implementation for fields that are annotated with the annotation.
 * @Id    -  Indicating the member field below is the primary key of the current entity.
 * @GeneratedValue -Specifies how to generate values for the given column. 
 * This annotation will help in creating primary keys values according to the specified strategy
 * GenerationType.AUTO -
 * @Column - It is used to set a name to a particular column.
 * *************/

@Entity
@Table(name="userss")
@NoArgsConstructor
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="user_name",nullable=false , length= 100)
	private String name;
	private String email;
	//private String password;
	private String about;
	
	
	//One user can have many posts
		@OneToMany(mappedBy="user",cascade =CascadeType.ALL,fetch = FetchType.LAZY)
		private List<Post> posts = new ArrayList<>();
}
