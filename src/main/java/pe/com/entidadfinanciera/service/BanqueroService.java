package pe.com.entidadfinanciera.service;

import org.springframework.stereotype.Service;
import pe.com.entidadfinanciera.modelo.Banquero;
import pe.com.entidadfinanciera.repositorio.BanqueroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BanqueroService {
    private final BanqueroRepository banqueroRepository;

    public BanqueroService(BanqueroRepository banqueroRepository) {
        this.banqueroRepository = banqueroRepository;
    }

    public List<Banquero> listarTodos() {
        return banqueroRepository.findAll();
    }

    public Optional<Banquero> obtenerPorId(Long id) {
        return banqueroRepository.findById(id);
    }

    public Banquero guardar(Banquero banquero) {
        return banqueroRepository.save(banquero);
    }

    public void eliminar(Long id) {
        banqueroRepository.deleteById(id);
    }
}
