package pe.com.entidadfinanciera.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.entidadfinanciera.modelo.Oficina;
import pe.com.entidadfinanciera.service.OficinaService;

import java.util.List;

@RestController
@RequestMapping("/api/oficinas")
public class OficinaController {
    private final OficinaService oficinaService;

    public OficinaController(OficinaService oficinaService) {
        this.oficinaService = oficinaService;
    }

    @GetMapping
    public List<Oficina> listar() {
        return oficinaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oficina> obtenerPorId(@PathVariable Long id) {
        return oficinaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Oficina> crear(@RequestBody Oficina oficina) {
        return ResponseEntity.ok(oficinaService.guardar(oficina));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Oficina> actualizar(@PathVariable Long id, @RequestBody Oficina actualizada) {
        if (oficinaService.obtenerPorId(id).isPresent()) {
            actualizada.setId(id);
            return ResponseEntity.ok(oficinaService.guardar(actualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        oficinaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
