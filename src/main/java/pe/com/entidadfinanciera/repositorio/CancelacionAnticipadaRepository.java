package pe.com.entidadfinanciera.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.entidadfinanciera.modelo.CancelacionAnticipada;

import java.util.List;
import java.util.Optional;

@Repository
public interface CancelacionAnticipadaRepository extends JpaRepository<CancelacionAnticipada, Long> {
    Optional<CancelacionAnticipada> findByDepositoId(Long depositoId);
}
