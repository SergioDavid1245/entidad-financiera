package pe.com.entidadfinanciera.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.entidadfinanciera.modelo.TipoPlazo;
import pe.com.entidadfinanciera.service.TipoPlazoService;

import java.util.List;

@RestController
@RequestMapping("/api/tipoplazo")
public class TipoPlazoController {
    private final TipoPlazoService tipoPlazoService;

    public TipoPlazoController(TipoPlazoService tipoPlazoService) {
        this.tipoPlazoService = tipoPlazoService;
    }

    @GetMapping
    public List<TipoPlazo> listar() {
        return tipoPlazoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPlazo> obtenerPorId(@PathVariable Long id) {
        return tipoPlazoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoPlazo> crear(@RequestBody TipoPlazo tipoPlazo) {
        return ResponseEntity.ok(tipoPlazoService.guardar(tipoPlazo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPlazo> actualizar(@PathVariable Long id, @RequestBody TipoPlazo actualizado) {
        if (tipoPlazoService.obtenerPorId(id).isPresent()) {
            actualizado.setId(id);
            return ResponseEntity.ok(tipoPlazoService.guardar(actualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tipoPlazoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
