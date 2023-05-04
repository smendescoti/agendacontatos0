package br.com.cotiinformatica.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.ContatoRepository;

@Controller
public class ConsultaContatosController {

	@RequestMapping(value = "/admin/consulta-contatos")
	public ModelAndView consultaContatos(HttpServletRequest request) {
		// WEB-INF/views/admin/consulta-contatos.jsp
		ModelAndView modelAndView = new ModelAndView("admin/consulta-contatos");
		
		try {
			
			//ler os dados do usu�rio gravado na sess�o
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			
			//acessando o reposit�rio
			ContatoRepository contatoRepository = new ContatoRepository();
			List<Contato> contatos = contatoRepository.findByUsuario(usuario.getIdUsuario());
			
			//enviando a lista de contatos para a p�gina
			modelAndView.addObject("contatos", contatos);
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao consultar contatos: " + e.getMessage());
		}
		
		return modelAndView;
	}
}
