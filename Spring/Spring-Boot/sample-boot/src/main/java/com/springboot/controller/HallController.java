package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.HallDAO;
import com.springboot.domain.Hall;

@RestController
@RequestMapping("/hall")
public class HallController {
	
	HallDAO hld=new HallDAO();
	
	@GetMapping(value = "/list", produces = "application/json")
	public List<Hall> getHalls() {
				
				return hld.list();

	}
	
	@GetMapping(path="/w",produces="application/json")
	public List<String> WelCome()
	{
		List<String> lst=new ArrayList<String>();
		lst.add("new");
		lst.add("new2");
		return lst;
	}
	
    @GetMapping(value="/show/{id}", produces="application/json")
	public Hall showHall(@PathVariable Long id) {

		//List<Hall> hl=new ArrayList<Hall>();
		for (Hall hall : hld.list()) {
			if(hall.getId().equals(id))
			{
				return hall;
			}
		}
		return null;
		
	}
	
}
