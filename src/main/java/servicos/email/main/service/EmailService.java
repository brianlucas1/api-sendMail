package servicos.email.main.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import servicos.email.main.enums.StatusEmail;
import servicos.email.main.models.EmailModel;
import servicos.email.main.repository.EmailRepository;


@Service
public class EmailService {

	
	@Autowired
	EmailRepository emailRepository;

	@Autowired
	private JavaMailSender emailSender;

	 
	 public EmailModel sendEmail(EmailModel emailModel) {
	        emailModel.setSendDateEmail(LocalDateTime.now());
	        try{
	            SimpleMailMessage message = new SimpleMailMessage();
	            message.setFrom(emailModel.getEmailFrom());
	            message.setTo(emailModel.getEmailTo());
	            message.setSubject(emailModel.getSubject());
	            message.setText(emailModel.getText());
	            emailSender.send(message);

	            emailModel.setStatusEmail(StatusEmail.SENT);
	        } catch (MailException e){
	            emailModel.setStatusEmail(StatusEmail.ERROR);
	        } finally {
	            return emailRepository.save(emailModel);
	        }
	    }

	    public Page<EmailModel> findAll(Pageable pageable) {
	        return  emailRepository.findAll(pageable);
	    }

//	    public Optional<EmailModel> findById(UUID emailId) {
//	        return emailRepository.findById(emailId);
//	    }
	 
}
