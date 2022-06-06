package servicos.email.main.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import servicos.email.main.dtos.UsuarioDTO;
import servicos.email.main.models.UsuarioModel;
import servicos.email.main.repository.UsuarioRepository;



@Service
public class UsuarioService  implements UserDetailsService{
	
	@Autowired
	UsuarioRepository userRepo;
	
	public Optional<UsuarioModel> findByUsuario(String usuario) {

		return userRepo.findByUsuario(usuario);
	
	}
	
	public UsuarioModel insertNewUser(UsuarioModel userModel){
		
		boolean exists =  userRepo.existsByUsuario(userModel.getUsuario());
				if(exists){
					throw new UsernameNotFoundException("USUARIO JÁ CADASTRADO NA BASE");
				}else{
					return userRepo.save(userModel);					
				}			 
			 
			}


	@Override
	public UserDetails loadUserByUsername(String usuario)
			throws UsernameNotFoundException {
		
		UsuarioModel user = userRepo
				.findByUsuario(usuario)
				.orElseThrow( () -> new UsernameNotFoundException("USUARIO NAO ENCONTRADO NA BASE"));
		 return User
				 .builder()
				 .username(user.getUsuario())
				 .password(user.getSenha())
				 .roles("USER")
				 .build();
	}



	
}
