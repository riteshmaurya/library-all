package com.manning.library.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.manning.library.model.Library;

@Component
public interface LibraryService {
	public Library findLibrary(String zipcode);
	 List<Library> getLibrary();
	//public Library displaySearch();
	 List<Library> searchByZip(String zipcode);
	 
	 List<Library> showAllLibrary();
	 void addLibrary(Library library);
	//public List<Library> displyAll();
	 void editLibrary(Library libraryToEdit);
	 void removeLibrary(Library library);

}
