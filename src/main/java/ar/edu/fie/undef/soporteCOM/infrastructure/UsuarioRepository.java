package ar.edu.fie.undef.soporteCOM.infrastructure;

import ar.edu.fie.undef.soporteCOM.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
