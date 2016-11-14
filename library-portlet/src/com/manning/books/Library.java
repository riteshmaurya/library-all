package com.manning.books;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Library {
	
	

	public Library(String libraryName, String zipcode, String street) {
		super();
		this.libraryName = libraryName;
		this.zipcode = zipcode;
		this.street = street;
	}
	
	
	private String libraryName;
	
	private String zipcode;
	
	private String street;
	
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Override
	public String toString() {
		return "Library [libraryName=" + libraryName + ", zip=" + zipcode
				+ ", street=" + street + "]";
	}

	@Override
	public boolean equals(Object otherObject) {
		Library library=(Library)otherObject;
		if(library.getZipcode()==this.zipcode){
			return true;
		}else{
			return false;
		}
	
	}
}
