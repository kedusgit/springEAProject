package com.kid.mum.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

	
	@RequestMapping({"/","/home"})
	public String welcome(HttpServletRequest request,HttpServletResponse response, Locale locale) {
	
		return "home";
	}
	
}
