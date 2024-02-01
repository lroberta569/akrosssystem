package br.com.larissa.akrosssystem.repository;

import br.com.larissa.akrosssystem.model.Squad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Larissa Silva
 * @description Repositorio relacionado ao Squad
 **/
@Repository
public interface SquadRepository extends JpaRepository<Squad, Long> {
}
