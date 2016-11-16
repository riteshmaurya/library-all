package com.manning.books;

import java.util.HashMap;
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
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;



@Controller("showLibraryController")
public class LibraryController extends AbstractController {
	
	private Logger logger = Logger.getLogger(LibraryController.class);
	
	@Autowired
	private LibraryService libraryService;
	
/*	public LibraryService getLibraryService() {
		return libraryService;
	}

	public void setLibraryService(LibraryService libraryService) {
		this.libraryService = libraryService;
	}*/

	@Override
	public void handleActionRequestInternal(ActionRequest request, ActionResponse response)
			throws Exception {
		
		logger.info("Entering handleActionRequestInternal method in LibraryController");
		
			}

	@Override
	public ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		logger.info("Entering handleRenderRequestInternal in ControllerLibrary method with myaction value :"+request.getParameter("myaction"));
		ModelAndView modelAndView=null;
		Map<String, Object> modelMap = new ModelMap();
		List<Library> library=libraryService.showAllLibrary();
		modelMap.put("library", library);
		modelAndView = new ModelAndView("library",modelMap);
		return modelAndView;
	}
}
