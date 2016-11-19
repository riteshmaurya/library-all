package com.manning.library.controllers;

import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.manning.library.model.Library;
import com.manning.library.services.LibraryService;


@Controller("showLibraryController")
@RequestMapping(value="VIEW")
public class LibraryController{
	
	private Logger logger = Logger.getLogger(LibraryController.class);
	
	@Autowired
	@Qualifier("libraryService")
	private LibraryService libraryService;
	

	public LibraryService getLibraryService() {
		return libraryService;
	}
	public void setLibraryService(LibraryService libraryService) {
		this.libraryService = libraryService;
	}
	@RenderMapping
	public String library( RenderRequest request, RenderResponse response){
		//logger.info("Entering handleRenderRequestInternal in ControllerLibrary method with myaction value :"+library);
		
		return "library";
	}	
	
	@RenderMapping(params="myaction=library")
	public String showLibrary(RenderRequest request, RenderResponse response){
		//logger.info("Entering handleRenderRequestInternal in ControllerLibrary method with myaction value :"+request.getParameter("myaction"));
		
		return "library";
	}
	
	@ModelAttribute("library")
	public List<Library> getLibrary(){
		return libraryService.getLibrary();
	}
}