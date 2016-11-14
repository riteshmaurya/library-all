package com.manning.books;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

public class RemoveLibraryController extends AbstractController{

	private LibraryService libraryService;
	private Library libraryToRemove;


	public void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception{
		


		String libraryZipCodeRemove= request.getParameter("libraryZipCodeRemove");
		
		if(!libraryZipCodeRemove.isEmpty()){
		for(Library library:libraryService.searchByZip(libraryZipCodeRemove)){
			if(library.getZipcode().equals(libraryZipCodeRemove)){
				this.libraryToRemove=library;
			}
		}
		
		libraryService.removeLibrary(libraryToRemove);
		
	}
		response.setRenderParameter("myaction", "");
	}
	
	public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception{
		
		return null;
	}
	
	
	public LibraryService getLibraryService() {
		return libraryService;
	}

	public void setLibraryService(LibraryService libraryService) {
		this.libraryService = libraryService;
	}

	public Library getLibraryToRemove() {
		return libraryToRemove;
	}

	public void setLibraryToRemove(Library libraryToRemove) {
		this.libraryToRemove = libraryToRemove;
	}
}
