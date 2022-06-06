package servicos.email.main.repository;

import java.util.Optional;

import net.bytebuddy.implementation.bind.annotation.Super;

import org.springframework.data.jpa.repository.JpaRepository;

import servicos.email.main.models.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer>{

	Optional<UsuarioModel> findByUsuario(String string);

	boolean existsByUsuario(String usuario);
	
}
