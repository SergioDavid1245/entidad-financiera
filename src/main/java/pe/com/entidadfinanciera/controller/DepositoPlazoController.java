package pe.com.entidadfinanciera.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.entidadfinanciera.modelo.DepositoPlazo;
import pe.com.entidadfinanciera.modelo.Estado;
import pe.com.entidadfinanciera.service.DepositoPlazoService;

import java.util.List;

@RestController
@RequestMapping("/api/depositos")
public class DepositoPlazoController {
    private final DepositoPlazoService depositoPlazoService;

    public DepositoPlazoController(DepositoPlazoService depositoPlazoService) {
        this.depositoPlazoService = depositoPlazoService;
    }

    @GetMapping
    public List<DepositoPlazo> listar() {
        return depositoPlazoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepositoPlazo> obtenerPorId(@PathVariable Long id) {
        return depositoPlazoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DepositoPlazo> crear(@RequestBody DepositoPlazo deposito) {
        return ResponseEntity.ok(depositoPlazoService.guardar(deposito));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepositoPlazo> actualizar(@PathVariable Long id, @RequestBody DepositoPlazo actualizado) {
        if (depositoPlazoService.obtenerPorId(id).isPresent()) {
            actualizado.setId(id);
            return ResponseEntity.ok(depositoPlazoService.guardar(actualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        depositoPlazoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{idCliente}")
    public List<DepositoPlazo> listarPorCliente(@PathVariable Long idCliente) {
        return depositoPlazoService.listarPorClienteId(idCliente);
    }

    @GetMapping("/estado/{estado}")
    public List<DepositoPlazo> listarPorEstado(@PathVariable Estado estado) {
        return depositoPlazoService.listarPorEstado(estado);
    }
}