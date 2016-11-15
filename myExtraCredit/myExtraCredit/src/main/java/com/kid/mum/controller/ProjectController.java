package com.kid.mum.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;


import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


import com.kid.mum.domain.Project;
import com.kid.mum.serviceImpl.ProjectService;

@Controller
public class ProjectController {
	@Autowired
	ProjectService projectService;
	@Autowired
	ServletContext servletContext;
     @Autowired
     Project project;
	
	@RequestMapping({"/","/home"})
	public String welcome(Model model){

		return "home";
	}
	

	@RequestMapping(value = "/editProject", method = RequestMethod.GET)
	public String editProjectGet(@Valid @ModelAttribute("project") Project project, BindingResult result,
			HttpServletRequest request) {
		return "/editProject";
	}
	
	
	@RequestMapping(value = "/editProject{id}", method = RequestMethod.POST)
	public String editProjectPost(@Valid @ModelAttribute("project") Project project, BindingResult result,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "/Admin";
		}
		MultipartFile projectImage = project.getProductImage();
		if (projectImage != null && !projectImage.isEmpty()) {
			try {
				String rootDirectory = servletContext.getRealPath("/");
				projectImage.transferTo(new File(rootDirectory + "\\resources\\images\\" + project.getProjectId() + ".png"));
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("image saving failed", ex);
			}
		}

		projectService.editProject(project);

		return "redirect:/editProject";
	}
	
	
	@RequestMapping("/deleteproject/{id}")
	public String deleteproject(@PathVariable int id, Model model, HttpServletRequest request) throws Throwable {
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path path = Paths.get(rootDirectory + "\\resources\\images\\"+ id + ".png");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	project = projectService.getprojectById(id);
		projectService.deleteproject(project);

		return "redirect:/projects";
	}

	
}
