/**
 * 
 */
package com.cursomc.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.cursomc.domain.Cliente;
import com.cursomc.domain.Pedido;

/**
 * @author Marcus Dimitri
 *
 */
public abstract class AbstractEmailService implements EmailService {

	@Value("${default.sender}")
	private String sender;

	@Autowired
	private TemplateEngine templateEngine;

//	@Autowired
//	private JavaMailSender Mailsender;

	@Override
	public void sendOrderConfirmationEmail(Pedido obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getCliente().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Pedido confirmado! Código: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}

	protected SimpleMailMessage prepareNewPasswordEmail(Cliente cliente, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(cliente.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: " + newPass);
		return sm;
	}

	protected String htmlFromTemplatePedido(Pedido obj) {

		Context context = new Context();
		context.setVariable("pedido", obj);
		return templateEngine.process("email/confirmacaoPedido", context);

	}

	//TIVE PROBLEMAS COM O GMAIL 
	//TODO Verificar outro servidor de emails para atender a funcionalidade
	//@Override
	/*public void sendOrderConfirmationHtmlEmail(Pedido obj) {
		try {
			MimeMessage mm = prepareMineMessageFromPedido(obj);
			sendHtmlEmail(mm);

		} catch (MessagingException e) {

			sendOrderConfirmationEmail(obj);

		}

	}*/

	/*
	 * protected MimeMessage prepareMineMessageFromPedido(Pedido obj) throws
	 * MessagingException {
	 * 
	 * // MimeMessage mm = Mailsender.createMimeMessage(); MimeMessageHelper mmh =
	 * new MimeMessageHelper(mm, true); mmh.setTo(obj.getCliente().getEmail());
	 * mmh.setFrom(sender); mmh.setSubject("Pedido confirmado! Código: " +
	 * obj.getId()); mmh.setSentDate(new Date(System.currentTimeMillis()));
	 * mmh.setText(htmlFromTemplatePedido(obj), true);
	 * 
	 * return mm; }
	 */
	
	@Override
	public void sendNewPasswordEmail(Cliente cliente , String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(cliente , newPass);
		sendEmail(sm);
	}


}
