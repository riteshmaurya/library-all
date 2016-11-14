package com.manning.books;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

import com.manning.library.validators.LibraryValidator;



public class AddLibraryController extends AbstractController {

	private Logger logger = Logger.getLogger(AddLibraryController.class);
	
	private LibraryService libraryService;
	
	
	
	public LibraryService getLibraryService() {
		return libraryService;
	}

	public void setLibraryService(LibraryService libraryService) {
		this.libraryService = libraryService;
	}

	@Override
	public void handleActionRequestInternal(ActionRequest request, ActionResponse response)
			throws Exception {
		logger.info("Entering addLibraryController");
		String libraryName = request.getParameter("libraryName");
		logger.info(request.getParameter("libraryName"));
		String zipcode = request.getParameter("zipcode");
		logger.info(request.getParameter("zipcode"));
		String street = request.getParameter("street");
		logger.info(request.getParameter("street"));
		
		Map<String, String> errorMap = new HashMap<String, String>();
		
		Map<String, String> valuesMap = new HashMap<String, String>();
		
		if(libraryName == null || libraryName.trim().equalsIgnoreCase("")){
			errorMap.put("libraryName", "Please enter Library name");
		}
		if(!errorMap.isEmpty()){
			request.setAttribute("errors", errorMap);
			request.setAttribute("library", valuesMap);
			response.setRenderParameter("myaction", "addLibraryForm");
		}
		else{
			valuesMap.put("libraryName", libraryName);
			valuesMap.put("zipcode", zipcode);
			valuesMap.put("street", street);
			//request.setAttribute("library", valuesMap);
			libraryService.addLibrary(new Library(libraryName, zipcode, street));
			
			response.setRenderParameter("myaction", "");

		}
		
		
		
		logger.info("zipcode to in actionrender method search:"+libraryService.showAllLibrary());

	}

	@Override
	public ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		
		return new ModelAndView("addLibrary");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		
		binder.setValidator(new LibraryValidator());
		
	}

}
