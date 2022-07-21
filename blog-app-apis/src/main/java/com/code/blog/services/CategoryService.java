package com.code.blog.services;

import java.util.List;

import com.code.blog.payloads.CategoryDto;


/***************************************************
 * @author Sneha Soni
* It is used to mark the Services that are available.
* It is Autowired to the Controller and is implemented by the Service Implementation 
* 
* **************************************************/

public interface CategoryService {
	
	//create
	 CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	 CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	//delete
	public void deleteCategory (Integer categoryId );
	
	//get
	 CategoryDto getCategory(Integer categoryId);
	//getall
	List< CategoryDto > getCategories();

}
