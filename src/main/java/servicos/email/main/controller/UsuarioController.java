package servicos.email.main.controller;

import java.util.Optional;

import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import servicos.email.main.dtos.UsuarioDTO;
import servicos.email.main.models.UsuarioModel;
import servicos.email.main.service.UsuarioService;


@RestController
@RequestMapping("/api-user")
public class UsuarioController {
	
	@Autowired
	UsuarioService userService;
	
	@PostMapping("/newuser")
	@ApiOperation(value="Criando um novo usuário")
	@ResponseStatus(HttpStatus.CREATED)
	public void insertUser(@Valid @RequestBody  UsuarioDTO userDto){
		try{
			UsuarioModel userModel = new UsuarioModel();		
			BeanUtils.copyProperties(userDto,userModel);			
			
			userService.insertNewUser(userModel);				
		}catch(UsernameNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

}
