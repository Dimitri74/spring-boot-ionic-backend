/**
 * 
 */
package com.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import com.cursomc.domain.Cliente;
import com.cursomc.domain.Pedido;

/**
 * @author Marcus Dimitri
 *
 */
public class MockEmailService extends AbstractEmailService {

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de email...");
		LOG.info(msg.toString());
		LOG.info("Email enviado com sucesso!");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Simulando envio de email html...");
		LOG.info(msg.toString());
		LOG.info("Email enviado com sucesso!");
	}

	@Override
	public void sendOrderConfirmationHtmlEmail(Pedido obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendNewPasswordEmail(Cliente cliente, String newPass) {
		// TODO Auto-generated method stub
		
	}

}
