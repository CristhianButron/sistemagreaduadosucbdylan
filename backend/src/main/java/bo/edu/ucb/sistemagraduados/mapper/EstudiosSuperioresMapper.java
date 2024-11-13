package bo.edu.ucb.sistemagraduados.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import bo.edu.ucb.sistemagraduados.dto.EstudiosSuperioresDto;
import bo.edu.ucb.sistemagraduados.entity.Estudiantes;
import bo.edu.ucb.sistemagraduados.entity.EstudiosSuperiores;
import bo.edu.ucb.sistemagraduados.entity.Postgrados;

public class EstudiosSuperioresMapper {
    public static EstudiosSuperioresDto toEstudiosSuperioresDto(EstudiosSuperiores estudiosSuperiores) {
        EstudiosSuperioresDto estudiosSuperioresDto = new EstudiosSuperioresDto();
        estudiosSuperioresDto.setIdEstudio(estudiosSuperiores.getIdEstudio());
        estudiosSuperioresDto.setFechaInicio(estudiosSuperiores.getFechaInicio());
        estudiosSuperioresDto.setFechaFin(estudiosSuperiores.getFechaFin());
        estudiosSuperioresDto.setInstitucion(estudiosSuperiores.getInstitucion());
        estudiosSuperioresDto.setPais(estudiosSuperiores.getPais());
        estudiosSuperioresDto.setCiudad(estudiosSuperiores.getCiudad());
        estudiosSuperioresDto.setActivo(estudiosSuperiores.getActivo());
        estudiosSuperioresDto.setEstudiante_id_estudiante(estudiosSuperiores.getEstudiantesIdEstudiante().getIdEstudiante());
        estudiosSuperioresDto.setPostgrados_id_postgrado(estudiosSuperiores.getPostgradosIdPostgrado().getIdPostgrado());
        return estudiosSuperioresDto;
    }

    public static EstudiosSuperiores toEstudiosSuperiores(EstudiosSuperioresDto estudiosSuperioresDto) {
        EstudiosSuperiores estudiosSuperiores = new EstudiosSuperiores();
        estudiosSuperiores.setIdEstudio(estudiosSuperioresDto.getIdEstudio());
        estudiosSuperiores.setFechaInicio(estudiosSuperioresDto.getFechaInicio());
        estudiosSuperiores.setFechaFin(estudiosSuperioresDto.getFechaFin());
        estudiosSuperiores.setInstitucion(estudiosSuperioresDto.getInstitucion());
        estudiosSuperiores.setPais(estudiosSuperioresDto.getPais());
        estudiosSuperiores.setCiudad(estudiosSuperioresDto.getCiudad());
        estudiosSuperiores.setActivo(estudiosSuperioresDto.isActivo());

        Estudiantes estudiantes = new Estudiantes();
        estudiantes.setIdEstudiante(estudiosSuperioresDto.getEstudiante_id_estudiante());
        estudiosSuperiores.setEstudiantesIdEstudiante(estudiantes);

        Postgrados postgrados = new Postgrados();
        postgrados.setIdPostgrado(estudiosSuperioresDto.getPostgrados_id_postgrado());
        estudiosSuperiores.setPostgradosIdPostgrado(postgrados);
        
        return estudiosSuperiores;
    }

    public static List<EstudiosSuperioresDto> toEstudiosSuperioresDtoList(List<EstudiosSuperiores> estudiosSuperioresList) {
        List<EstudiosSuperioresDto> estudiosSuperioresDtoList = new ArrayList<>();
        for (EstudiosSuperiores estudiosSuperiores : estudiosSuperioresList) {
            estudiosSuperioresDtoList.add(toEstudiosSuperioresDto(estudiosSuperiores));
        }
        return estudiosSuperioresDtoList;
    }

    public static EstudiosSuperiores updateEstudiosSuperioresFromDto(EstudiosSuperioresDto estudiosSuperioresDto, EstudiosSuperiores estudiosSuperioresExistente) {
        
        if (estudiosSuperioresDto.getFechaInicio() != null && !Objects.equals (estudiosSuperioresDto.getFechaInicio(), estudiosSuperioresExistente.getFechaInicio())) {
            estudiosSuperioresExistente.setFechaInicio(estudiosSuperioresDto.getFechaInicio());
        }
        if (estudiosSuperioresDto.getFechaFin() != null && !Objects.equals (estudiosSuperioresDto.getFechaFin(), estudiosSuperioresExistente.getFechaFin())) {
            estudiosSuperioresExistente.setFechaFin(estudiosSuperioresDto.getFechaFin());
        }
        if (estudiosSuperioresDto.getInstitucion() != null && !Objects.equals (estudiosSuperioresDto.getInstitucion(), estudiosSuperioresExistente.getInstitucion())) {
            estudiosSuperioresExistente.setInstitucion(estudiosSuperioresDto.getInstitucion());
        }
        if (estudiosSuperioresDto.getPais() != null && !Objects.equals (estudiosSuperioresDto.getPais(), estudiosSuperioresExistente.getPais())) {
            estudiosSuperioresExistente.setPais(estudiosSuperioresDto.getPais());
        }
        if (estudiosSuperioresDto.getCiudad() != null && !Objects.equals (estudiosSuperioresDto.getCiudad(), estudiosSuperioresExistente.getCiudad())) {
            estudiosSuperioresExistente.setCiudad(estudiosSuperioresDto.getCiudad());
        }
        if (estudiosSuperioresDto.isActivo() != estudiosSuperioresExistente.getActivo()) {
            estudiosSuperioresExistente.setActivo(estudiosSuperioresDto.isActivo());
        }
        if (estudiosSuperioresDto.getEstudiante_id_estudiante() != estudiosSuperioresExistente.getEstudiantesIdEstudiante().getIdEstudiante() && estudiosSuperioresDto.getEstudiante_id_estudiante() != null) {
            Estudiantes estudiantes = new Estudiantes();
            estudiantes.setIdEstudiante(estudiosSuperioresDto.getEstudiante_id_estudiante());
            estudiosSuperioresExistente.setEstudiantesIdEstudiante(estudiantes);
        }
        if (estudiosSuperioresDto.getPostgrados_id_postgrado() != estudiosSuperioresExistente.getPostgradosIdPostgrado().getIdPostgrado() && estudiosSuperioresDto.getPostgrados_id_postgrado() != null) {
            Postgrados postgrados = new Postgrados();
            postgrados.setIdPostgrado(estudiosSuperioresDto.getPostgrados_id_postgrado());
            estudiosSuperioresExistente.setPostgradosIdPostgrado(postgrados);
        }
        return estudiosSuperioresExistente;
    }
}
