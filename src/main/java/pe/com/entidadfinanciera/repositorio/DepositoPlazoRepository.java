package pe.com.entidadfinanciera.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.entidadfinanciera.modelo.DepositoPlazo;
import pe.com.entidadfinanciera.modelo.Estado;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepositoPlazoRepository extends JpaRepository<DepositoPlazo, Long> {
    List<DepositoPlazo> findByClienteId(Long clienteId);
    List<DepositoPlazo> findByBanqueroId(Long banqueroId);
    List<DepositoPlazo> findByEstado(Estado estado);
}
