package bo.edu.ucb.sistemagraduados.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.sistemagraduados.dto.EstudiantesDto;
import bo.edu.ucb.sistemagraduados.dto.PersonaDto;
import bo.edu.ucb.sistemagraduados.entity.Estudiantes;
import bo.edu.ucb.sistemagraduados.entity.Persona;
import bo.edu.ucb.sistemagraduados.mapper.EstudiantesMapper;
import bo.edu.ucb.sistemagraduados.mapper.PersonaMapper;
import bo.edu.ucb.sistemagraduados.repository.EstudiantesRepository;
import bo.edu.ucb.sistemagraduados.repository.PersonaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EstudiantesService {
    @Autowired
    private final EstudiantesRepository estudiantesRepository;

    @Autowired
    private final PersonaRepository personaRepository;

    public EstudiantesService(EstudiantesRepository estudiantesRepository, PersonaRepository personaRepository) {
        this.estudiantesRepository = estudiantesRepository;
        this.personaRepository = personaRepository;
    }

    public List<EstudiantesDto> findAll() {
        List<Estudiantes> estudiantes = estudiantesRepository.findAll();
        return EstudiantesMapper.toEstudiantesDtoList(estudiantes);
    }

    public Long countEstudiantes(){
        return estudiantesRepository.count();
    }

    public EstudiantesDto findById(Integer id) {
        Estudiantes estudiante = estudiantesRepository.findById(id).orElse(null);
        return EstudiantesMapper.toEstudiantesDto(estudiante);
    }

    public EstudiantesDto save(EstudiantesDto estudianteDto) {
        // Crear y guardar la nueva Persona
        PersonaDto personaDto = estudianteDto.getPersonaDto();
        Persona persona = PersonaMapper.toPersona(personaDto);

        // Crear y guardar el nuevo Estudiante
        Estudiantes estudiante = EstudiantesMapper.toEstudiantes(estudianteDto);
        estudiante.setPersonaIdPersona(personaRepository.save(persona));
        estudiante = estudiantesRepository.save(estudiante);

        return EstudiantesMapper.toEstudiantesDto(estudiante);
    }
    
    @Transactional
    public EstudiantesDto update(Integer id, EstudiantesDto estudianteActualizadoDto) {
        Estudiantes estudianteExistente = estudiantesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado"));
        Estudiantes estudianteActualizado = EstudiantesMapper.updateEstudiantesFromDto(estudianteActualizadoDto, estudianteExistente);
        estudianteActualizado = estudiantesRepository.save(estudianteActualizado);
        return EstudiantesMapper.toEstudiantesDto(estudianteActualizado);
    }

    public void delete(Integer id) {
        EstudiantesDto estudianteDto = findById(id);
        PersonaDto personaDto = estudianteDto.getPersonaDto();
        estudiantesRepository.deleteById(id);
        personaRepository.deleteById(personaDto.getIdPersona());
    }

    public List<EstudiantesDto> findByFechasIngresoBetween(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Estudiantes> estudiantes = estudiantesRepository.findByFechasIngresoBetween(fechaInicio, fechaFin);
        return EstudiantesMapper.toEstudiantesDtoList(estudiantes);
    }

    public List<EstudiantesDto> findByFechasFinBetween(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Estudiantes> estudiantes = estudiantesRepository.findByFechasFinBetween(fechaInicio, fechaFin);
        return EstudiantesMapper.toEstudiantesDtoList(estudiantes);
    }
    // public EstudiantesDto findByCi(String ci) {
    //     Estudiantes estudiante = estudiantesRepository.findByPersonaCi(ci);
    //     return EstudiantesMapper.toEstudiantesDto(estudiante);
    // }
}
