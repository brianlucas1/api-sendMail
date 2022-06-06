package servicos.email.main.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import servicos.email.main.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, UUID>{

}
