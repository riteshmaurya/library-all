package com.manning.library.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.manning.library.model.Library;





public class LibraryValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Library.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		Library library=(Library)obj;
		if(library.getLibraryName().isEmpty()){
			errors.rejectValue("libraryName", "project.name.error","Please provide a valid Library Name");
		}
		if((library.getZipcode().length()>5)||(library.getZipcode().length()==0)){
			errors.rejectValue("libraryName", "project.zipcode.error.invalidLength", "Zipcode can be longer than 5");
		}
		
	}

	
}
