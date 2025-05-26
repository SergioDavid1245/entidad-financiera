package pe.com.entidadfinanciera.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.entidadfinanciera.modelo.CancelacionAnticipada;
import pe.com.entidadfinanciera.service.CancelacionAnticipadaService;

import java.util.List;

@RestController
@RequestMapping("/api/cancelaciones")
public class CancelacionAnticipadaController {
    private final CancelacionAnticipadaService cancelacionService;

    public CancelacionAnticipadaController(CancelacionAnticipadaService cancelacionService) {
        this.cancelacionService = cancelacionService;
    }

    @GetMapping
    public List<CancelacionAnticipada> listar() {
        return cancelacionService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CancelacionAnticipada> obtenerPorId(@PathVariable Long id) {
        return cancelacionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CancelacionAnticipada> crear(@RequestBody CancelacionAnticipada cancelacion) {
        return ResponseEntity.ok(cancelacionService.guardar(cancelacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CancelacionAnticipada> actualizar(@PathVariable Long id, @RequestBody CancelacionAnticipada actualizada) {
        if (cancelacionService.obtenerPorId(id).isPresent()) {
            actualizada.setId(id);
            return ResponseEntity.ok(cancelacionService.guardar(actualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cancelacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

