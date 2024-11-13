package bo.edu.ucb.sistemagraduados.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bo.edu.ucb.sistemagraduados.entity.Estudiantes;

@Repository
public interface EstudiantesRepository extends JpaRepository<Estudiantes, Integer> {
    List <Estudiantes> findByFechasIngresoBetween (LocalDate fechaInicio, LocalDate fechaFin);
    List <Estudiantes> findByFechasFinBetween (LocalDate fechaInicio, LocalDate fechaFin);
}
