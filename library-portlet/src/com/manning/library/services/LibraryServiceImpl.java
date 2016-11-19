package com.manning.library.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.manning.library.model.Library;


@Service(value="libraryService")
public class LibraryServiceImpl implements LibraryService {
		
	private Logger logger = Logger.getLogger(LibraryServiceImpl.class);
	
	private List<Library> library=Collections.synchronizedList(new ArrayList<Library>());
	
	 public Library findLibrary(String zipcode) {
		Library matchingLibrary=null;
		Library returnLibrary=null;
		synchronized (library) {
			for(Library library_:library){
				if(library_.getZipcode().equals(zipcode)){
					matchingLibrary=library_;
					break;
				}
			}
				if(matchingLibrary!=null){
					returnLibrary=new Library();
					returnLibrary.setLibraryName(matchingLibrary.getLibraryName());
					returnLibrary.setStreet(matchingLibrary.getStreet());
					returnLibrary.setZipcode(matchingLibrary.getZipcode());
				}
				
			}
		return returnLibrary;
		}
		
	

		public List<Library> getLibrary() {
			return library;
		}
	public void setLibrary(List<Library> library) {
		this.library = library;
	}
	
	public LibraryServiceImpl() {
		super();
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
			if(library1.getZipcode().equals(zipcode)){
	
				matchingLibrary.add(library1);		
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
	
/*	@Override
	public Library editLibrary(String libraryZipCodeEdit) {
		logger.info("value of library  zipcode to edit :"+libraryZipCodeEdit);
		Library editToLibrary=null;
		for(Library l:library){
			if(l.getZipcode().equals(libraryZipCodeEdit.toString().trim())){
				editToLibrary=l;
			}
		}
		logger.info("value of library object to edit :"+editToLibrary);
		
		return editToLibrary;
	}*/
	
	@Override
	public void editLibrary(Library libraryToEdit) {
		Library matchingLibrary = null;
		String libraryZipCodeEdit=libraryToEdit.getZipcode();

		synchronized (library) {
			for (Library library1 : library) {
				if (library1.getZipcode().equals(libraryZipCodeEdit)) {
					matchingLibrary = library1;
					logger.info("Library to edit found"+matchingLibrary);
					break;
				}
				
			}
			library.remove(matchingLibrary);
			library.add(libraryToEdit);
			
		}
		
	}

	/*@Override
	public void editLibrary(Library lib) {
		logger.info("value of library to edit"+lib);
		Library matchingLibrary=null;
		String zipcodeToEdit=lib.getZipcode();
		
		for (Library lib_ : library) {
			if (lib_.getZipcode().equals(zipcodeToEdit)) {
				matchingLibrary = lib_;
				break;
			}
		}
		library.remove(matchingLibrary);
		library.add(lib);		
	}
*/
	@Override
	public void removeLibrary(Library library){
	 this.library.remove(library);
 }		
}