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
public class ExclusaoContatosController {

	@RequestMapping(value = "/admin/exclusao-contatos")
	public ModelAndView exclusaoContatos(HttpServletRequest request) {
		
		//WEB-INF/views/admin/consulta-contatos.jsp
		ModelAndView modelAndView = new ModelAndView("admin/consulta-contatos");
		
		try {
			
			//capturando o usuário autenticado no sistema (sessão)
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			
			//capturando a variavel 'id' enviada na URL do link
			Integer idContato = Integer.parseInt(request.getParameter("id"));
			
			//consultando no banco de dados 1 contato através do ID
			ContatoRepository contatoRepository = new ContatoRepository();
			Contato contato = contatoRepository.findById(idContato);
			
			//verificando se o contato foi encontrado e se é um contato do usuário que está autenticado
			if(contato != null && contato.getIdUsuario() == usuario.getIdUsuario()) {
				//excluindo o contato
				contatoRepository.delete(contato);
				modelAndView.addObject("mensagem_sucesso", "Contato excluído com sucesso!");
			}
			
			//fazendo uma nova consulta de contatos e retornando os dados para a página
			List<Contato> contatos = contatoRepository.findByUsuario(usuario.getIdUsuario());
			modelAndView.addObject("contatos", contatos);
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao excluir contato: " + e.getMessage());
		}
		
		return modelAndView;
	}
}
