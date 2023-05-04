package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.ContatoRepository;

@Controller
public class EdicaoContatosController {

	@RequestMapping(value = "/admin/edicao-contatos")
	public ModelAndView edicaoContatos(HttpServletRequest request) {
		// WEB-INF/views/admin/edicao-contatos.jsp
		ModelAndView modelAndView = new ModelAndView("admin/edicao-contatos");
		
		try {
			
			//capturar o usuário autenticado na sessão
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			
			//capturar o id enviado na URL do link
			Integer idContato = Integer.parseInt(request.getParameter("id"));
			
			//consultando o contato no banco de dados através do id
			ContatoRepository contatoRepository = new ContatoRepository();
			Contato contato = contatoRepository.findById(idContato);
			
			//verificando se o contato foi encontrado e se pertence ao usuário autenticado
			if(contato != null && contato.getIdUsuario() == usuario.getIdUsuario()) {
				//enviando os dados do contato para a página
				modelAndView.addObject("contato", contato);
			}			
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao obter o contato: " + e.getMessage());
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/atualizar-contato", method = RequestMethod.POST)	
	public ModelAndView atualizarContato(HttpServletRequest request) {
		
		// WEB-INF/views/admin/edicao-contatos.jsp
		ModelAndView modelAndView = new ModelAndView("admin/edicao-contatos");
		
		try {
			
			//capturar os dados do usuário autenticado
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			
			//resgatar os dados do contato enviados pelo formulário
			Integer idContato = Integer.parseInt(request.getParameter("idContato"));
			
			//consultar no banco de dados o contato de acordo com o id
			ContatoRepository contatoRepository = new ContatoRepository();
			Contato contato = contatoRepository.findById(idContato);
			
			//verificando se o contato foi encontrado e se pertence ao usuário autenticado
			if(contato != null && contato.getIdUsuario() == usuario.getIdUsuario()) {
				
				//capturando os demais campos enviados pelo formulário
				contato.setNome(request.getParameter("nome"));
				contato.setTelefone(request.getParameter("telefone"));
				contato.setEmail(request.getParameter("email"));
				contato.setObservacoes(request.getParameter("observacoes"));
				
				//atualizando o contato no banco de dados
				contatoRepository.update(contato);
				
				modelAndView.addObject("mensagem_sucesso", "Contato atualizado com sucesso.");
				modelAndView.addObject("contato", contato);
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao atualizar contato: " + e.getMessage());
		}
		
		return modelAndView;
	}
	
}














