package pe.com.entidadfinanciera.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.entidadfinanciera.modelo.TipoPlazo;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoPlazoRepository extends JpaRepository<TipoPlazo, Long> {
    List<TipoPlazo> findByDiasDuracionGreaterThan(int dias);
}
