package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PasswordController {

	@RequestMapping(value = "/esqueci-minha-senha")
	public ModelAndView password() {
		// definindo a p�gina que ser� aberta no navegador:
		// WEB-INF/views/password.jsp
		ModelAndView modelAndView = new ModelAndView("password");
		return modelAndView;
	}

}
