package ar.edu.fie.undef.soporteCOM.infrastructure;

import ar.edu.fie.undef.soporteCOM.domain.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
}