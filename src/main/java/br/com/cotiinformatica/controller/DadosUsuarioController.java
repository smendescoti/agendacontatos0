package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class DadosUsuarioController {

	@RequestMapping(value = "/admin/dados-usuario")
	public ModelAndView dadosUsuario() {
		// WEB-INF/views/admin/dados-usuario.jsp
		ModelAndView modelAndView = new ModelAndView("admin/dados-usuario");
		return modelAndView;
	}

	@RequestMapping(value = "/admin/alterar-senha", method = RequestMethod.POST)
	public ModelAndView alterarSenha(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("admin/dados-usuario");

		try {
		
			//capturar o usuário autenticado na sessão
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			
			//capturando a nova senha enviada para edição
			usuario.setSenha(request.getParameter("novaSenha"));
			
			//atualizando os dados do usuário no banco de dados
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			usuarioRepository.update(usuario);
			
			modelAndView.addObject("mensagem_sucesso", "Senha atualizada com sucesso.");
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao alterar senha: " + e.getMessage());
		}
		
		return modelAndView;
	}
}
