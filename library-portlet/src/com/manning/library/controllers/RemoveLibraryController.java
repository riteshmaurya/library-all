package com.manning.library.controllers;


import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.mvc.AbstractController;

import com.manning.library.model.Library;
import com.manning.library.services.LibraryService;

@Controller("removeLibraryController")
@RequestMapping("VIEW")
public class RemoveLibraryController{

	@Autowired
	private LibraryService libraryService;
	private Library libraryToRemove;
	
	private Logger logger=Logger.getLogger(RemoveLibraryController.class);

	@ActionMapping(params = "myaction=removeLibrary")
	public void removeLibraryAction(ActionRequest request, ActionResponse response){
		String libraryZipCodeRemove= request.getParameter("zipcode");
		logger.info("REMOVE LIBRARY ZIPCODE  :"+libraryZipCodeRemove);

		if(!libraryZipCodeRemove.isEmpty()){
		for(Library library:libraryService.searchByZip(libraryZipCodeRemove)){
			if(library.getZipcode().equals(libraryZipCodeRemove)){
				this.libraryToRemove=library;
			}
		}
		
		libraryService.removeLibrary(libraryToRemove);
		
	}
		response.setRenderParameter("myaction", "library");
	}
	
	
	
	
	public Library getLibraryToRemove() {
		return libraryToRemove;
	}

	public void setLibraryToRemove(Library libraryToRemove) {
		this.libraryToRemove = libraryToRemove;
	}
}
