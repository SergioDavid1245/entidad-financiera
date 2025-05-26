package pe.com.entidadfinanciera.service;

import org.springframework.stereotype.Service;
import pe.com.entidadfinanciera.modelo.CancelacionAnticipada;
import pe.com.entidadfinanciera.repositorio.CancelacionAnticipadaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CancelacionAnticipadaService {
    private final CancelacionAnticipadaRepository cancelacionRepository;

    public CancelacionAnticipadaService(CancelacionAnticipadaRepository cancelacionRepository) {
        this.cancelacionRepository = cancelacionRepository;
    }

    public List<CancelacionAnticipada> listarTodas() {
        return cancelacionRepository.findAll();
    }

    public Optional<CancelacionAnticipada> obtenerPorId(Long id) {
        return cancelacionRepository.findById(id);
    }

    public CancelacionAnticipada guardar(CancelacionAnticipada cancelacion) {
        return cancelacionRepository.save(cancelacion);
    }

    public void eliminar(Long id) {
        cancelacionRepository.deleteById(id);
    }
}