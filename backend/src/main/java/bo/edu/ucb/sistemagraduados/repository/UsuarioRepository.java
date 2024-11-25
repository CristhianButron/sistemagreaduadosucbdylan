package bo.edu.ucb.sistemagraduados.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import bo.edu.ucb.sistemagraduados.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByCorreoInstitucional(String correoInstitucional);

}
