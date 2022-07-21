package com.code.blog.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/********************************************
 * @author Sneha Soni
 * Api Response it is created to generate specific variables that can be used for displaying the error messages . 
 * @NoArgsConstructor - Annotation is used to generate the no-argument constructor for a class.
 * @Getter - To generate the default getter implementation for fields that are annotated with the annotation.
 * @Setter - To generate the default setter implementation for fields that are annotated with the annotation.
 *
 * ******************************************/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ApiResponse {
  private String message;
  private boolean success;
}
