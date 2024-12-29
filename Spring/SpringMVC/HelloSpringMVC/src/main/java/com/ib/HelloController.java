package com.ib;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/")
	public String display(Model model) {
		// Sending data to view (jsp page)
		String myName = "Bittu Indian";
		model.addAttribute("NameValue", myName);
		// Just return the page name
		// No Path, no extension
		return "demo";

	}
}