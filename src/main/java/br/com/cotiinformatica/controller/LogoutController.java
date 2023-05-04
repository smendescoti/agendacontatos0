package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {

		// apagar os dados do usuário gravados em sessão
		request.getSession().removeAttribute("usuario");

		// navegar para a página de login do sistema
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
}
