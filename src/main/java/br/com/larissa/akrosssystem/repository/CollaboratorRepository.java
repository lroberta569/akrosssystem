package br.com.larissa.akrosssystem.repository;

import br.com.larissa.akrosssystem.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Larissa Silva
 * @description Repositorio relacionado ao Colaborador
 **/
@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {

}
