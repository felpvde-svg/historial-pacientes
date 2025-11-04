package com.felipe.historialpacientes.Infraestructura;

import com.felipe.historialpacientes.Domain.Service.PacienteService;
import com.felipe.historialpacientes.Domain.model.DTO.PacienteDTO;
import com.felipe.historialpacientes.Domain.model.Entity.PacienteEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @PostMapping("/crear")
    public PacienteEntity crear(@RequestBody PacienteDTO dto) {
        return service.crearPaciente(dto);
    }

    @GetMapping("/listar")
    public List<PacienteEntity> listar() {
        return service.obtenerPacientes();
    }

    @GetMapping("/buscar/{documento}")
    public PacienteEntity buscar(@PathVariable String documento) {
        return service.buscarPorDocumento(documento);
    }

    @PutMapping("/actualizarTratamiento/{documento}")
    public PacienteEntity actualizar(@PathVariable String documento, @RequestParam String tratamiento) {
        return service.actualizarTratamiento(documento, tratamiento);
    }

    @DeleteMapping("/eliminar/{documento}")
    public String eliminar(@PathVariable String documento) {
        return service.eliminarPaciente(documento);
    }
}
