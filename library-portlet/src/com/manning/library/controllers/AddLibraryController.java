package com.manning.library.controllers;



import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;


import com.manning.library.model.Library;
import com.manning.library.services.LibraryService;
import com.manning.library.validators.LibraryValidator;


@RequestMapping(value="VIEW")
@Controller("addLibraryController")
@SessionAttributes(types = Library.class)
public class AddLibraryController{

	private Logger logger = Logger.getLogger(AddLibraryController.class);
	
	@Autowired
	@Qualifier("libraryService")
	private LibraryService libraryService;
	
	@ActionMapping(params = "myaction=addLibrary" )
	public void addLibraryAction(@ModelAttribute("lib")Library lib, ActionRequest request, ActionResponse response)
			throws Exception {
		libraryService.addLibrary(lib);
		response.setRenderParameter("myaction", "library");
	}
	@RenderMapping(params = "myaction=addLibraryForm")
	public String addLibraryForm(RenderRequest request, RenderResponse response) throws Exception {
		
		return "addLibrary";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		
		binder.setValidator(new LibraryValidator());		
	}
	
	@ModelAttribute("lib")
	public Library getCommandObject() {
		return new Library();
	}
}