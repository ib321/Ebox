package com.spring;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HomeController extends AbstractController {


	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView model = new ModelAndView("home");
		UserDAO usd=new UserDAO();
		ArrayList<User> userList=new ArrayList<User>();
		userList=usd.returnList();
		model.addObject("userList", userList);
		return model;

	}

}
