package bo.edu.ucb.sistemagraduados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bo.edu.ucb.sistemagraduados.entity.Carreras;

@Repository
public interface CarrerasRepository extends JpaRepository<Carreras, Integer> {
    Carreras findByNombre(String nombre);
    Carreras findBySigla(String sigla);
}
