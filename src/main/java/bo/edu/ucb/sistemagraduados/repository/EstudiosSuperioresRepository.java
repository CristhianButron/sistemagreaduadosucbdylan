package bo.edu.ucb.sistemagraduados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bo.edu.ucb.sistemagraduados.entity.EstudiosSuperiores;

@Repository
public interface EstudiosSuperioresRepository extends JpaRepository<EstudiosSuperiores, Integer> {

}
