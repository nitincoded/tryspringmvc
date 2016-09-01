package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class WelcomeController {
	@RequestMapping("/welcome.do")
	protected ModelAndView welcome() throws Exception {
		ModelAndView model = new ModelAndView("index");
		model.addObject("msg", "Hello world!");
		return model;
	}
	
	@RequestMapping("/contact01.do")
	protected ModelAndView showForm() throws Exception {
		ModelAndView model = new ModelAndView("contact");
		model.addObject("person", new Person());
		return model;
	}
	
	@RequestMapping("/contact02.do")
	protected String processForm(@ModelAttribute("person") Person person, BindingResult result) throws Exception {
		System.out.println(person.getName());
		return "redirect:contact01.do";
	}
}

//http://viralpatel.net/blogs/spring-3-mvc-handling-forms/