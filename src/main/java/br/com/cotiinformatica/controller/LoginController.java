package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class LoginController {

	@RequestMapping(value = "/") // raiz do projeto
	public ModelAndView login() {
		// definindo a p�gina que ser� aberta no navegador:
		// WEB-INF/views/login.jsp
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@RequestMapping(value = "/autenticar-usuario", method = RequestMethod.POST)
	public ModelAndView autenticarUsuario(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("login");
		
		try {
			
			//capturar o email e senha enviados pelo formul�rio
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			//consultando o usu�rio no banco de dados
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.findByEmailAndSenha(email, senha);
			
			//verificar se o usu�rio foi encontrado
			if(usuario != null) {
				
				//guardar os dados do usu�rio em uma sess�o
				request.getSession().setAttribute("usuario", usuario);
				
				//redirecionar para a p�gina inicial da agenda
				modelAndView.setViewName("redirect:/admin/home");
			}
			else {
				modelAndView.addObject("mensagem_erro", "Acesso negado. Usu�rio n�o encontrado.");
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao autenticar: " + e.getMessage());
		}
		
		return modelAndView;
	}
}
