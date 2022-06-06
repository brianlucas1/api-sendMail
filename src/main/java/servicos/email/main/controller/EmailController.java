package servicos.email.main.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import servicos.email.main.dtos.EmailDTO;
import servicos.email.main.models.EmailModel;
import servicos.email.main.service.EmailService;



@RestController
@CrossOrigin(origins="*")
@Api(value="API E-MAIL")
@RequestMapping("/api-mail")
public class EmailController {

	@Autowired
	EmailService emailService;
	
	
	@PostMapping("/send-email")
	@ApiOperation(value="Enviar um e-mail conforme o enviado os parametros")
	public ResponseEntity<EmailModel> enviarEmail(@RequestBody @Valid EmailDTO emailDTO){
		
		EmailModel emailModel = new EmailModel();
		BeanUtils.copyProperties(emailDTO,emailModel);
		emailService.sendEmail(emailModel);
		return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
		
	}
	
	@GetMapping("get")
	public String teste(){
		return "teste";
	}
	
}
