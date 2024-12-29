package com.spring;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ContactController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView model = new ModelAndView("template");
		model.addObject("addressComp", "<p style=\"padding-left:10px;\">Adress: xyz Street</p>\n"
				+ "                <p style=\"padding-left:10px;\">abc Colony</p>\n"
				+ "                <p style=\"padding-left:10px;\">Chennai</p>\n"
				+ "                <p style=\"padding-left:10px;\">PhoneNumber: xxxxxxx</p>");
		return model;
	}
	
}

