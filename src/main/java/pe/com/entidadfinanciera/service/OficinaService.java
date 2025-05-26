package pe.com.entidadfinanciera.service;

import org.springframework.stereotype.Service;
import pe.com.entidadfinanciera.modelo.Oficina;
import pe.com.entidadfinanciera.repositorio.OficinaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OficinaService {
    private final OficinaRepository oficinaRepository;

    public OficinaService(OficinaRepository oficinaRepository) {
        this.oficinaRepository = oficinaRepository;
    }

    public List<Oficina> listarTodos() {
        return oficinaRepository.findAll();
    }

    public Optional<Oficina> obtenerPorId(Long id) {
        return oficinaRepository.findById(id);
    }

    public Oficina guardar(Oficina oficina) {
        return oficinaRepository.save(oficina);
    }

    public void eliminar(Long id) {
        oficinaRepository.deleteById(id);
    }
}
