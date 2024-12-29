package com.example.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@GetMapping({"/","/hello"})
	public String getHello(Model model) {
		model.addAttribute("name","Indian Bittu");
		model.addAttribute("msg","You have Arrived to HomePage!");

		return "hello";
	}
	@GetMapping("/name")
	public String getHell(Model model, @RequestParam(value="name",required=false,defaultValue="Indian Bittu") String name) {
		model.addAttribute("name",name);
		return "hello";
	}
}