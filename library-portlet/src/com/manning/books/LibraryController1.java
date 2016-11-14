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
import org.springframework.ui.ModelMap;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.Controller;




public class LibraryController1 implements Controller {

	private Logger logger = Logger.getLogger(LibraryController1.class);
	
	private LibraryServiceImpl libraryServiceImpl=new LibraryServiceImpl();
	
	
	
	@Override
	public void handleActionRequest(ActionRequest request, ActionResponse response)
			throws Exception {
		logger.info("Entering handleActionRequest method");
		if("showAllLibrary".equalsIgnoreCase(request.getParameter("myaction"))) {
			
			response.setRenderParameter("myaction", "showAllLibrary");	
		}
		if("searchLibrary".equalsIgnoreCase(request.getParameter("myaction"))) {
			
			String zipcode = request.getParameter("zipcode");
			Map<String, String> valuesMap = new HashMap<String, String>();
			logger.info("zipcode to in actionrender method search:"+zipcode);
			valuesMap.put("zipcode", zipcode);
			//request.setAttribute("library", valuesMap);
			response.setRenderParameter("zipcode", zipcode);
			response.setRenderParameter("myaction", "searchLibrary");
		}
		if("addLibrary".equalsIgnoreCase(request.getParameter("myaction"))){
			/*response.setRenderParameter("myaction", "addLibrary");
			String libraryName = request.getParameter("libraryName");
			String zipcode = request.getParameter("zipcode");
			String street = request.getParameter("street");
			Map<String, String> valuesMap = new HashMap<String, String>();
			logger.info("zipcode to in actionrender method search:"+zipcode);
			valuesMap.put("libraryName", libraryName);
			valuesMap.put("zipcode", zipcode);
			valuesMap.put("street", street);
			//request.setAttribute("library", valuesMap);
			response.setRenderParameter("libraryName", libraryName);
			response.setRenderParameter("zipcode", zipcode);
			response.setRenderParameter("street", street);
*/			response.setRenderParameter("myaction", "addLibrary");
			
		}
		if("editLibrary".equalsIgnoreCase(request.getParameter("myaction"))){
			response.setRenderParameter("myaction", "editLibrary");
		}
		if("removeLibrary".equalsIgnoreCase(request.getParameter("myaction"))){
			response.setRenderParameter("myaction", "removeLibrary");
		}
		if("saveLibrary".equalsIgnoreCase(request.getParameter("myaction"))){
			String libraryName = request.getParameter("libraryName");
			String zipcode = request.getParameter("zipcode");
			String street = request.getParameter("street");
			Map<String, String> valuesMap = new HashMap<String, String>();
			logger.info("zipcode to in actionrender method search:"+zipcode);
			valuesMap.put("libraryName", libraryName);
			valuesMap.put("zipcode", zipcode);
			valuesMap.put("street", street);
			//request.setAttribute("library", valuesMap);
			response.setRenderParameter("libraryName", libraryName);
			response.setRenderParameter("zipcode", zipcode);
			response.setRenderParameter("street", street);
			response.setRenderParameter("myaction", "saveLibrary");
		}
	}

	@Override
	public ModelAndView handleRenderRequest(RenderRequest request,
			RenderResponse response) throws Exception {
		logger.info("Entering handleRenderRequest method with myaction value :"+request.getParameter("myaction"));
		
		ModelAndView modelAndView=null;
		Map<String, Object> modelMap = new ModelMap();
		if(request.getParameter("myaction") == null) {
			logger.info("Entering myaction==null condition");
			modelAndView = new ModelAndView("searchLibrary");
		}
		if("saveLibrary".equalsIgnoreCase(request.getParameter("myaction"))) {
			
			logger.info("Entering myaction==saveLibrary condition");
			String libraryName = request.getParameter("libraryName");
			logger.info("Add parameters: "+libraryName);
			String zipcode = request.getParameter("zipcode");
			logger.info("Add parameters: "+zipcode);
			String street = request.getParameter("street");
			logger.info("Add parameters: "+street);
			
		//	libraryServiceImpl.addLibrary(libraryName, zipcode, street);
			logger.info("Library added to repository :"+libraryServiceImpl.searchByZip(zipcode));
			List<Library> library=libraryServiceImpl.searchByZip(zipcode);
			logger.info("library list value to be passes to jsp:"+library);
			Map<String, Object> valuesMap = new HashMap<String, Object>();
			
			valuesMap.put("library", library);
			
			/*logger.info("Entering myaction==saveLibrary condition");
			String zipcode=request.getParameter("zipcode");
			List<Library> library=libraryServiceImpl.searchByZip(zipcode);
			Map<String, Object> valuesMap = new HashMap<String, Object>();
			valuesMap.put("library", library);
*/			
			modelAndView = new ModelAndView("viewLibrary",valuesMap);
		}
		
		if("searchLibrary".equalsIgnoreCase(request.getParameter("myaction"))) {
			logger.info("Entering myaction==searchLibrary condition");
			
			String zipcode=request.getParameter("zipcode");
			logger.info("zipcode to search:"+zipcode);
			List<Library> library=libraryServiceImpl.searchByZip(zipcode);
			logger.info("library list value to be passes to jsp:"+library);
			Map<String, Object> valuesMap = new HashMap<String, Object>();
			
			valuesMap.put("library", library);
			modelAndView = new ModelAndView("viewLibrary", valuesMap);
		}
		if("showAllLibrary".equalsIgnoreCase(request.getParameter("myaction"))) {
			logger.info("Entering myaction==showAllLibrary condition");
			List<Library> showAllLibrary=libraryServiceImpl.showAllLibrary();
			logger.info("showAllLibrary: "+showAllLibrary);
			Map<String, Object> valuesMap = new HashMap<String, Object>();
			valuesMap.put("showAllLibrary", showAllLibrary);
			modelAndView = new ModelAndView("showAllLibrary",valuesMap );
		}
		if("addLibrary".equalsIgnoreCase(request.getParameter("myaction"))) {
			
			modelAndView = new ModelAndView("addLibrary");
		}
		
	return modelAndView;
	}
}
