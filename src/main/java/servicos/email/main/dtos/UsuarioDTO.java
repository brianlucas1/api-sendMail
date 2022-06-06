package servicos.email.main.dtos;

import javax.validation.constraints.NotEmpty;

import lombok.Data;


@Data
public class UsuarioDTO {
	

	@NotEmpty(message = "{campo.usuario.invalido}")
	private String usuario;
	@NotEmpty(message = "{campo.senha.invalido}")
	private String senha;

}
