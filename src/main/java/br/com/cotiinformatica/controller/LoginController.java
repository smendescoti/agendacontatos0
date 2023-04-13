package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/") // raiz do projeto
	public ModelAndView login() {
		// definindo a página que será aberta no navegador:
		// WEB-INF/views/login.jsp
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
}
