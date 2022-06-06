package servicos.email.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import servicos.email.main.service.UsuarioService;


@EnableWebSecurity
//AUTENTICA OS USUARIOS DO SISTEMA
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

	@Autowired
	UsuarioService userService;
	
	//CONSTROI O GERENCIAMENTO DE AUTENTICAÇÃO DA APLICAÇÃO.
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{	 
		auth
			.userDetailsService(userService)
			.passwordEncoder(passwordEncoder());
 }
	
	@Bean
	public AuthenticationManager authenticationManager() throws Exception{
		return super.authenticationManager();	
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf().disable()
			.cors()
		.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}
}
