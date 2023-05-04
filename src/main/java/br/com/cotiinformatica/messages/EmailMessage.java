package br.com.cotiinformatica.messages;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class EmailMessage {

	//atributos
	private final String account = "cotiaulajava@outlook.com";
	private final String password = "@Admin123456";
	private final String smtp = "smtp-mail.outlook.com";
	private final Integer port = 587;
	
	//método para fazer o envio de uma mensagem por email
	public void sendMessage(final String emailTo, final String subject, final String message) throws Exception {
		
		//Configurando a conta que irá fazer o envio dos emails
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		senderImpl.setUsername(account);
		senderImpl.setPassword(password);
		senderImpl.setHost(smtp);
		senderImpl.setPort(port);
		
		//Adicionando outras configurações para realizar o envio dos emails
		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.transport.protocol", "smtp");
		senderImpl.setJavaMailProperties(properties);
		
		//Montando o conteúdo do email
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
				helper.setFrom(account);
				helper.setTo(emailTo);
				helper.setSubject(subject);
				helper.setText(message);
			}
		};

		//enviando o email..
		senderImpl.send(preparator);
	}
}
