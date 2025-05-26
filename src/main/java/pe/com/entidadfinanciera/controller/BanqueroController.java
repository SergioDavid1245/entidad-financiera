package pe.com.entidadfinanciera.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.entidadfinanciera.modelo.Banquero;
import pe.com.entidadfinanciera.service.BanqueroService;

import java.util.List;

@RestController
@RequestMapping("/api/banqueros")
public class BanqueroController {
    private final BanqueroService banqueroService;

    public BanqueroController(BanqueroService banqueroService) {
        this.banqueroService = banqueroService;
    }

    @GetMapping
    public List<Banquero> listar() {
        return banqueroService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banquero> obtenerPorId(@PathVariable Long id) {
        return banqueroService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Banquero> crear(@RequestBody Banquero banquero) {
        return ResponseEntity.ok(banqueroService.guardar(banquero));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Banquero> actualizar(@PathVariable Long id, @RequestBody Banquero actualizado) {
        if (banqueroService.obtenerPorId(id).isPresent()) {
            actualizado.setId(id);
            return ResponseEntity.ok(banqueroService.guardar(actualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        banqueroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
