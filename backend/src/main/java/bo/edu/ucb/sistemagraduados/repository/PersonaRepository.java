package bo.edu.ucb.sistemagraduados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bo.edu.ucb.sistemagraduados.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
