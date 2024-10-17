package bo.edu.ucb.sistemagraduados.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import bo.edu.ucb.sistemagraduados.entity.Postgrados;

@Repository
public interface PostgradosRepository extends JpaRepository<Postgrados, Integer> {

}
