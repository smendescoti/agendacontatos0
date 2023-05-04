package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/admin/home")
	public ModelAndView home() {

		// WEB-INF/views/admin/home.jsp
		ModelAndView modelAndView = new ModelAndView("admin/home");
		return modelAndView;
	}

}
