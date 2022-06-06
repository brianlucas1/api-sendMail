package servicos.email.main.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Entity
@Data
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUser;
	
	private String usuario;		
	private String senha;	

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
	
	@PrePersist
	public void prePersist(){
		setDataCadastro(LocalDate.now());
	}
	
	
}
