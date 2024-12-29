package com.spring;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class StallController extends AbstractController {

	private StallDAO dao;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ArrayList<Stall> stallList;
		stallList = dao.returnList();
		ModelAndView model = new ModelAndView("home");
		model.addObject("stallList", stallList);
		return model;
	}

	public StallDAO getDao() {
		return dao;
	}

	@Autowired
	public void setDao(StallDAO dao) {
		this.dao = dao;
	}

}
