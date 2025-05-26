package pe.com.entidadfinanciera.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.entidadfinanciera.modelo.RenovacionDeposito;
import pe.com.entidadfinanciera.service.RenovacionDepositoService;

import java.util.List;

@RestController
@RequestMapping("/api/renovaciones")
public class RenovacionDepositoController {
    private final RenovacionDepositoService renovacionService;

    public RenovacionDepositoController(RenovacionDepositoService renovacionService) {
        this.renovacionService = renovacionService;
    }

    @GetMapping
    public List<RenovacionDeposito> listar() {
        return renovacionService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RenovacionDeposito> obtenerPorId(@PathVariable Long id) {
        return renovacionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RenovacionDeposito> crear(@RequestBody RenovacionDeposito renovacion) {
        return ResponseEntity.ok(renovacionService.guardar(renovacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RenovacionDeposito> actualizar(@PathVariable Long id, @RequestBody RenovacionDeposito actualizado) {
        if (renovacionService.obtenerPorId(id).isPresent()) {
            actualizado.setId(id);
            return ResponseEntity.ok(renovacionService.guardar(actualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        renovacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
