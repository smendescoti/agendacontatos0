package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class RegisterController {

	@RequestMapping(value = "/criar-conta")
	public ModelAndView register() {
		// definindo a página que será aberta no navegador:
		// WEB-INF/views/register.jsp
		ModelAndView modelAndView = new ModelAndView("register");
		return modelAndView;
	}

	@RequestMapping(value = "/cadastrar-usuario", method = RequestMethod.POST)
	public ModelAndView cadastrarUsuario(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("register");
		
		try {
			
			Usuario usuario = new Usuario();
			
			usuario.setNome(request.getParameter("nome"));
			usuario.setEmail(request.getParameter("email"));
			usuario.setSenha(request.getParameter("senha"));
			
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			
			//verificar se já existe um usuário cadastrado com o email informado
			if(usuarioRepository.findByEmail(usuario.getEmail()) != null) {
				modelAndView.addObject("mensagem_erro", "O email informado já está cadastrado, tente outro.");
			}
			else {
				usuarioRepository.create(usuario); //cadastrando usuário
				modelAndView.addObject("mensagem_sucesso", "Parabéns, sua conta de usuário foi criada com sucesso!");
			}	
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao criar conta: " + e.getMessage());
		}
		
		return modelAndView;
	}
}
