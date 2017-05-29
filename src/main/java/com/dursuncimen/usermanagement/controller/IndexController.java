package com.dursuncimen.usermanagement.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * The only task of this controller is to load home page
*/
@Controller
public class IndexController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);	
	
	
	//Load index.jsp 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome Index Page {}.", locale);		
		return "index";
	}
	
}
