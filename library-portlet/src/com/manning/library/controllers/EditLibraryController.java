package com.manning.library.controllers;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.manning.library.model.Library;
import com.manning.library.services.LibraryService;

@Controller(value="editLibraryController")
@RequestMapping(value="VIEW")
@SessionAttributes(value="libraryToEdit")
public class EditLibraryController {

	@Autowired
	@Qualifier("libraryService")
	private LibraryService libraryService;
		
	@Autowired
	private Validator myValidator;
	
	private Logger logger = Logger.getLogger(EditLibraryController.class);
	@ActionMapping(params = "myaction=editLibrary")
	public void editLibraryAction(@ModelAttribute("libraryToEdit") Library libraryToEdit, ActionRequest request, ActionResponse response, SessionStatus sessionStatus){
	
		logger.info("ACTION REQUEST libraryto edit"+libraryToEdit);
		libraryService.editLibrary(libraryToEdit);
		response.setRenderParameter("myaction", "library");
		sessionStatus.setComplete();
	}
	
	@RenderMapping(params = "myaction=editLibraryForm")
	public String editLibraryForm(){
		
		return "editLibrary";
	}	
	
	@ModelAttribute("libraryToEdit")
	public Library getLibrary(@RequestParam String zipcode) {
		logger.info("libraryToEdit model attribute zipcode value"+zipcode);
		return libraryService.findLibrary(zipcode);
	}
}