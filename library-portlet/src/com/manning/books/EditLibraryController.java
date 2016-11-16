package com.manning.books;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

@Controller("editLibraryController")
public class EditLibraryController extends AbstractController {

	@Autowired
	private LibraryService libraryService;
	
	/*public LibraryService getLibraryService() {
		return libraryService;
	}

	public void setLibraryService(LibraryService libraryService) {
		this.libraryService = libraryService;
	}*/

	public void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception{
	
		logger.info("Entering editLibraryController");
		String libraryNewName = request.getParameter("libraryName");
		logger.info(request.getParameter("libraryName"));
		String newZipcode = request.getParameter("zipcode");
		logger.info(request.getParameter("zipcode"));
		String newStreet = request.getParameter("street");
		logger.info(request.getParameter("libraryZipCodeEdit"));
		
		
		
		
		Map<String, String> errorMap = new HashMap<String, String>();
		
		Map<String, String> valuesMap = new HashMap<String, String>();
		
		if(libraryNewName == null || libraryNewName.trim().equalsIgnoreCase("")){
			errorMap.put("libraryName", "Please enter Library name");
		}
		if(!errorMap.isEmpty()){
			request.setAttribute("errors", errorMap);
			request.setAttribute("library", valuesMap);
			response.setRenderParameter("myaction", "editLibraryForm");
		}
		else{
			valuesMap.put("libraryName", libraryNewName);
			valuesMap.put("zipcode", newZipcode);
			valuesMap.put("street", newStreet);
			//request.setAttribute("library", valuesMap);
			
			libraryService.removeLibrary(libraryService.searchByZip(request.getParameter("libraryZipCodeEdit")).get(0));
			
			libraryService.editLibrary(new Library(libraryNewName, newZipcode, newStreet));
			
			response.setRenderParameter("myaction", "");

		}

		logger.info("zipcode to in actionrender method search:"+libraryService.showAllLibrary());
		
	}
	
	public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response){
		
		Map<String, String> valuesMap = new HashMap<String, String>();
		String libraryZipCodeEdit=request.getParameter("libraryZipCodeEdit");
		logger.info("library to edit"+libraryZipCodeEdit);
		Library library=libraryService.searchByZip(libraryZipCodeEdit).get(0);
		valuesMap.put("libraryName", library.getLibraryName());
		
		valuesMap.put("zipcode", library.getZipcode());
		valuesMap.put("street", library.getStreet());
		valuesMap.put("libraryZipCodeEdit", libraryZipCodeEdit);
		
		return new ModelAndView("editLibrary",valuesMap);
	}
	
}
