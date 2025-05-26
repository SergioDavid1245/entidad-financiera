package pe.com.entidadfinanciera.service;

import org.springframework.stereotype.Service;
import pe.com.entidadfinanciera.modelo.DepositoPlazo;
import pe.com.entidadfinanciera.modelo.Estado;
import pe.com.entidadfinanciera.repositorio.DepositoPlazoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepositoPlazoService {
    private final DepositoPlazoRepository depositoPlazoRepository;

    public DepositoPlazoService(DepositoPlazoRepository depositoPlazoRepository) {
        this.depositoPlazoRepository = depositoPlazoRepository;
    }

    public List<DepositoPlazo> listarTodos() {
        return depositoPlazoRepository.findAll();
    }

    public Optional<DepositoPlazo> obtenerPorId(Long id) {
        return depositoPlazoRepository.findById(id);
    }

    public DepositoPlazo guardar(DepositoPlazo deposito) {
        return depositoPlazoRepository.save(deposito);
    }

    public void eliminar(Long id) {
        depositoPlazoRepository.deleteById(id);
    }

    public List<DepositoPlazo> listarPorClienteId(Long idCliente) {
        return depositoPlazoRepository.findByClienteId(idCliente);
    }

    public List<DepositoPlazo> listarPorEstado(Estado estado) {
        return depositoPlazoRepository.findByEstado(estado);
    }
}