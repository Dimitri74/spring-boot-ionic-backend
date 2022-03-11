/**
 * 
 */
package com.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.cursomc.domain.Pedido;

/**
 * @author Marcus Dimitri
 *
 */
public class SmtpEmailService extends AbstractEmailService {

	//@Autowired
	//private MailSender mailSender;
	
	//@Autowired
//	private JavaMailSender sender;
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Enviando email...");
		//mailSender.send(msg);
		LOG.info("Email enviado com sucesso.");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Enviando email html...");
		//sender.send(msg);
		LOG.info("Email enviado com sucesso.");
		
	}

	@Override
	public void sendOrderConfirmationHtmlEmail(Pedido obj) {
		// TODO Auto-generated method stub
		
	}
	
	

}
