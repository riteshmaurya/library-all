package com.manning.books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class LibraryDAO {

	
	private List<Library> library=Collections.synchronizedList(new ArrayList<Library>());
	
	
	
	public LibraryDAO() {
		System.out.println("LibraryDAO invoked...");
		
		library.add(new Library("Tahalia Library","21481","Tahalia St"));
		
		library.add(new Library("Balad Library","21482","Balad St"));
		
		library.add(new Library("Hira Library","21483","Hira St"));
		
		library.add(new Library("Tahalia Library","21481","Tahalia St"));
		
		library.add(new Library("Balad Library","21482","Balad St"));
		
		library.add(new Library("Hira Library","21483","Hira St"));
		
		library.add(new Library("Tahalia Library","21481","Tahalia St"));
		
		library.add(new Library("Balad Library","21482","Balad St"));
		
		library.add(new Library("Hira Library","21483","Hira St"));
		
		library.add(new Library("Tahalia Library","21481","Tahalia St"));
		
		library.add(new Library("Balad Library","21482","Balad St"));
		
		library.add(new Library("Hira Library","21483","Hira St"));
	}
	
	public List<Library> getLibrary(){
		return library;
	}
	
	public void addLibrary(String libraryName, String zipcode, String street ){
		library.add(new Library(libraryName,zipcode,street));
	}
	
}