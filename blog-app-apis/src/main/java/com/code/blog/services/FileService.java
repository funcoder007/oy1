package com.code.blog.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;


/***************************************************
 * @author Sneha Soni
* It is used to mark the Services that are available.
* It is Autowired to the Controller and is implemented by the Service Implementation 
* 
* **************************************************/


public interface FileService {

	String uploadImage(String path , MultipartFile file)throws IOException;
	InputStream getResource(String path , String fileName)throws FileNotFoundException;
}
