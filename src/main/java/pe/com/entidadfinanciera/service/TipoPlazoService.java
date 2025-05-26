package pe.com.entidadfinanciera.service;

import org.springframework.stereotype.Service;
import pe.com.entidadfinanciera.modelo.TipoPlazo;
import pe.com.entidadfinanciera.repositorio.TipoPlazoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPlazoService {
    private final TipoPlazoRepository tipoPlazoRepository;

    public TipoPlazoService(TipoPlazoRepository tipoPlazoRepository) {
        this.tipoPlazoRepository = tipoPlazoRepository;
    }

    public List<TipoPlazo> listarTodos() {
        return tipoPlazoRepository.findAll();
    }

    public Optional<TipoPlazo> obtenerPorId(Long id) {
        return tipoPlazoRepository.findById(id);
    }

    public TipoPlazo guardar(TipoPlazo tipoPlazo) {
        return tipoPlazoRepository.save(tipoPlazo);
    }

    public void eliminar(Long id) {
        tipoPlazoRepository.deleteById(id);
    }
}