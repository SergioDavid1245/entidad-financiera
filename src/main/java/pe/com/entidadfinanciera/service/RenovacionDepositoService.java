package pe.com.entidadfinanciera.service;

import org.springframework.stereotype.Service;
import pe.com.entidadfinanciera.modelo.RenovacionDeposito;
import pe.com.entidadfinanciera.repositorio.RenovacionDepositoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RenovacionDepositoService {
    private final RenovacionDepositoRepository renovacionRepository;

    public RenovacionDepositoService(RenovacionDepositoRepository renovacionRepository) {
        this.renovacionRepository = renovacionRepository;
    }

    public List<RenovacionDeposito> listarTodas() {
        return renovacionRepository.findAll();
    }

    public Optional<RenovacionDeposito> obtenerPorId(Long id) {
        return renovacionRepository.findById(id);
    }

    public RenovacionDeposito guardar(RenovacionDeposito renovacion) {
        return renovacionRepository.save(renovacion);
    }

    public void eliminar(Long id) {
        renovacionRepository.deleteById(id);
    }
}