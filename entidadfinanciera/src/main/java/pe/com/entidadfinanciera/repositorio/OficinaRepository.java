package pe.com.entidadfinanciera.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.entidadfinanciera.modelo.Oficina;

import java.util.List;
import java.util.Optional;

@Repository
public interface OficinaRepository extends JpaRepository<Oficina, Long> {
    List<Oficina> findByNombreContainingIgnoreCase(String nombre);
}