package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.javafaker.Faker;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.messages.EmailMessage;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class PasswordController {

	@RequestMapping(value = "/esqueci-minha-senha")
	public ModelAndView password() {
		// definindo a p�gina que ser� aberta no navegador:
		// WEB-INF/views/password.jsp
		ModelAndView modelAndView = new ModelAndView("password");
		return modelAndView;
	}

	@RequestMapping(value = "/recuperar-senha", method = RequestMethod.POST)
	public ModelAndView recuperarSenha(HttpServletRequest request) {
		// WEB-INF/views/password.jsp
		ModelAndView modelAndView = new ModelAndView("password");
		
		try {
			
			//capturar o email do usu�rio preenchido no formul�rio
			String email = request.getParameter("email");
			
			//Procurando o usu�rio no banco de dados atrav�s do email
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.findByEmail(email);
			
			//verificando se o usu�rio foi encontrado
			if(usuario != null) {

				//gerando uma nova senha para o usu�rio
				Faker faker = new Faker();
				usuario.setSenha(faker.internet().password(8, 20, true, true, true));
				
				//escrevendo um email que ser� enviado para o usu�rio
				String assunto = "Recupera��o de senha de acesso - Agenda de Contatos";
				String mensagem = "Ol�, " + usuario.getNome()
							    + "\nUma nova senha foi gerada com sucesso!"
							    + "\nAcesse o sistema usando a senha: " + usuario.getSenha()
							    + "\nDepois voc� poder� alterar esta senha para outra de sua prefer�ncia."
							    + "\nAtt"
							    + "\nEquipe Agenda de Contatos";
				
				//enviando o email para o usu�rio
				EmailMessage emailMessage = new EmailMessage();
				emailMessage.sendMessage(usuario.getEmail(), assunto, mensagem);
				
				//atualizando a senha do usu�rio no banco de dados
				usuarioRepository.update(usuario);
				
				modelAndView.addObject("mensagem_sucesso", "Recupera��o de senha realizada com sucesso.");
			}
			else {
				modelAndView.addObject("mensagem_erro", "Usu�rio n�o encontrado.");
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao recuperar senha: " + e.getMessage());
		}
		
		return modelAndView;
	}
}
