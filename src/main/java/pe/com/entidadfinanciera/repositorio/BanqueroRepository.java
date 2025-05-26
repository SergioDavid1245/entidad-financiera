package pe.com.entidadfinanciera.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.entidadfinanciera.modelo.Banquero;

import java.util.List;
import java.util.Optional;

@Repository
public interface BanqueroRepository extends JpaRepository<Banquero, Long> {
    List<Banquero> findByActivoTrue();
}