package servicos.email.test;

import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import servicos.email.main.enums.StatusEmail;
import servicos.email.main.exception.EmailNaoEnviadoException;
import servicos.email.main.models.EmailModel;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EmailServiceTest { 


	
	
	@Test
	public void testeEnvioEmail(){
		
		try{
			
			JavaMailSender emailSender = new JavaMailSender() {
				
				@Override
				public void send(SimpleMailMessage... arg0) throws MailException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void send(SimpleMailMessage arg0) throws MailException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void send(MimeMessagePreparator... arg0) throws MailException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void send(MimeMessagePreparator arg0) throws MailException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void send(MimeMessage... arg0) throws MailException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void send(MimeMessage arg0) throws MailException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public MimeMessage createMimeMessage(InputStream arg0) throws MailException {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public MimeMessage createMimeMessage() {
					// TODO Auto-generated method stub
					return null;
				}
			};
			
			SimpleMailMessage message = new SimpleMailMessage();
			
			message.setFrom("brianlucas94@hotmail.com");
			message.setTo("brianlucas94@hotmail.com");
			message.setSubject("OWNER TESTE");
			message.setText("TESTE JUNIT");
			emailSender.send(message);
			
			System.out.println(StatusEmail.SENT);
		}catch(MailException e){
			System.out.println(e);
		}
		
	}
	

	
}
