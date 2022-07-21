package com.code.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.blog.entities.Category;
import com.code.blog.exceptions.ResourceNotFoundException;
import com.code.blog.payloads.CategoryDto;
import com.code.blog.repositories.CategoryRepo;
import com.code.blog.services.CategoryService;


/*****
 * @author Sneha Soni
 * @Service
   In order to autowire a class implementing any Entity , we need to have that class decorated with @Service or @Component 
   in order for Spring to inject it into Service when Service is itself of course injected in our controller.
 * 
 * 
 */



@Service
public class CategoryServiceImpl implements CategoryService {

	
	/***
	 * @author Sneha Soni
	 * @Autowired - It allows Spring to resolve and inject collaborating beans into our bean.@Autowired is to inject the dependancy into a bean.
	 * Repository is autowired so that we can use the methods present in the repository.
	 * Model Mapper is autowired so that the dto is converted into entity object and vice versa.
	 * ResourceNotFoundException - The ResourceNotFoundException exception is thrown if a security provider looks for a resource that should exist, 
	 * but is unable to find that resource.
	 * */
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","CategoryId", categoryId));
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		Category UpdatedCategory = this.categoryRepo.save(cat);
		return this.modelMapper.map(UpdatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {

		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId));
		
		this.categoryRepo.delete(cat);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {

		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId));
		
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {

		
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> catDtos= categories.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return catDtos ;
	}

	
	
}
