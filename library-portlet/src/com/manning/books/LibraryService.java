package com.manning.books;

import java.util.List;

public interface LibraryService {
	//public Library displaySearch();
	 List<Library> searchByZip(String zipcode);
	 List<Library> showAllLibrary();
	 void addLibrary(Library library);
	//public List<Library> displyAll();
	 void editLibrary(Library library);
	 void removeLibrary(Library library);

}
