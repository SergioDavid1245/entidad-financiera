package pe.com.entidadfinanciera.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.entidadfinanciera.modelo.RenovacionDeposito;

import java.util.List;
import java.util.Optional;

@Repository
public interface RenovacionDepositoRepository extends JpaRepository<RenovacionDeposito, Long> {
    List<RenovacionDeposito> findByDepositoId(Long depositoId);
}
