package com.felipe.historialpacientes.Domain.Service;


import com.felipe.historialpacientes.Domain.Repository.PacienteRepository;
import com.felipe.historialpacientes.Domain.model.DTO.PacienteDTO;
import com.felipe.historialpacientes.Domain.model.Entity.PacienteEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public PacienteEntity crearPaciente(PacienteDTO dto) {
        PacienteEntity paciente = new PacienteEntity();
        paciente.setNombre(dto.getNombre());
        paciente.setApellido(dto.getApellido());
        paciente.setDocumento(dto.getDocumento());
        paciente.setFechaNacimiento(dto.getFechaNacimiento());
        paciente.setTratamiento(dto.getTratamiento());
        return repository.save(paciente);
    }

    public List<PacienteEntity> obtenerPacientes() {
        return repository.findAll();
    }

    public PacienteEntity buscarPorDocumento(String documento) {
        return repository.findByDocumento(documento).orElse(null);
    }

    public PacienteEntity actualizarTratamiento(String documento, String nuevo) {
        PacienteEntity patient = repository.findByDocumento(documento).orElse(null);
        if(patient != null) {
            patient.setTratamiento(nuevo);
            return repository.save(patient);
        }
        return null;
    }

    public String eliminarPaciente(String documento) {
        PacienteEntity p = repository.findByDocumento(documento).orElse(null);
        if (p != null) {
            repository.delete(p);
            return "Paciente eliminado";
        }
        return "No existe";
    }
}
