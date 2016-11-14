package com.manning.books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class LibraryServiceImpl implements LibraryService {
	
	private List<Library> library=Collections.synchronizedList(new ArrayList<Library>());


	
	public LibraryServiceImpl() {
System.out.println("LibraryDAO invoked...");
		
		library.add(new Library("Tahalia Library","21481","Tahalia St"));
		
		library.add(new Library("Balad Library","21482","Balad St"));
		
		library.add(new Library("Hira Library","21483","Hira St"));
		
		library.add(new Library("Tahalia Library","21484","Tahalia St"));
		
		library.add(new Library("Balad Library","21485","Balad St"));
		
		library.add(new Library("Hira Library","21486","Hira St"));
		
		library.add(new Library("Tahalia Library","21487","Tahalia St"));
		
		library.add(new Library("Balad Library","21488","Balad St"));
		
		library.add(new Library("Hira Library","21489","Hira St"));
		
		library.add(new Library("Tahalia Library","21490","Tahalia St"));
		
		library.add(new Library("Balad Library","21491","Balad St"));
		
		library.add(new Library("Hira Library","21492","Hira St"));

		
		
	}

	

	@Override
	public List<Library> searchByZip(String zipcode) {
	
		List<Library> matchingLibrary = new ArrayList<Library>();
		for(Library library1:library){
			//System.out.println("getLibrary "+library);
			if(library1.getZipcode().equals(zipcode)){
				
				matchingLibrary.add(library1);
				
				//System.out.println(library1);
				
			
			}
		}
		return matchingLibrary;
		
		
	}



	public List<Library> showAllLibrary() {
		
		List<Library> matchingLibrary = new ArrayList<Library>();
		for(Library library1:library){
			
				matchingLibrary.add(library1);
				
				//System.out.println(library1);		
			}
		return matchingLibrary;
	}

	@Override
	public void addLibrary(Library library1) {
		library.add(library1);
	}

	@Override
	public void editLibrary(Library library) {
		Library library1=new Library(library.getLibraryName(), library.getZipcode(), library.getStreet());
		if(library1!=null){
			System.out.println("library to be added :"+library);
		//this.library.remove(library);
		this.library.add(library1);
		}
	}
		
	
	@Override
	public void removeLibrary(Library library){
	 this.library.remove(library);
 }
		
		
		

}