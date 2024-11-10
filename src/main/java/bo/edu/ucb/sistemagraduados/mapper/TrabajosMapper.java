package bo.edu.ucb.sistemagraduados.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import bo.edu.ucb.sistemagraduados.dto.TrabajosDto;
import bo.edu.ucb.sistemagraduados.entity.Estudiantes;
import bo.edu.ucb.sistemagraduados.entity.Trabajos;

public class TrabajosMapper {

    public static TrabajosDto toTrabajosDto (Trabajos trabajo){
        TrabajosDto trabajosDto = new TrabajosDto();
        trabajosDto.setIdTrabajo(trabajo.getIdTrabajo());
        trabajosDto.setFechaInicio(trabajo.getFechaInicio());
        trabajosDto.setFechaFin(trabajo.getFechaFin());
        trabajosDto.setCargo(trabajo.getCargo());
        trabajosDto.setPais(trabajo.getPais());
        trabajosDto.setCiudad(trabajo.getCiudad());
        trabajosDto.setEmpresa(trabajo.getEmpresa());
        trabajosDto.setContactoEmpresa(trabajo.getContactoEmpresa());
        trabajosDto.setActivo(trabajo.getActivo());
        trabajosDto.setEstudiante_id_estudiante(trabajo.getEstudiantesIdEstudiante().getIdEstudiante());

        return trabajosDto;
    }

    public static Trabajos toTrabajos (TrabajosDto trabajosdto){
        Trabajos trabajos = new Trabajos();
        trabajos.setFechaInicio(trabajosdto.getFechaInicio());
        trabajos.setFechaFin(trabajosdto.getFechaFin());
        trabajos.setCargo(trabajosdto.getCargo());
        trabajos.setPais(trabajosdto.getPais());
        trabajos.setCiudad(trabajosdto.getCiudad());
        trabajos.setEmpresa(trabajosdto.getEmpresa());
        trabajos.setContactoEmpresa(trabajosdto.getContactoEmpresa());
        trabajos.setActivo(trabajosdto.isActivo());
        
        Estudiantes estudiante = new Estudiantes();
        estudiante.setIdEstudiante(trabajosdto.getEstudiante_id_estudiante());
        trabajos.setEstudiantesIdEstudiante(estudiante);
        return trabajos;
    }

    public static List<TrabajosDto> toTrabajosDtoList(List<Trabajos> trabajosList) {
        List<TrabajosDto> trabajosDtoList = new ArrayList<>();
        for (Trabajos trabajos : trabajosList) {
            trabajosDtoList.add(toTrabajosDto(trabajos));
        }
        return trabajosDtoList;
    }

    public static Trabajos updateTrabajosFromDto(TrabajosDto trabajosDto, Trabajos trabajosExistente) {
    
        if (trabajosDto == null || trabajosExistente == null) {
            return null;
        }
        if (trabajosDto.getFechaInicio() != null && !Objects.equals(trabajosExistente.getFechaInicio(), trabajosDto.getFechaInicio())) {
            trabajosExistente.setFechaInicio(trabajosDto.getFechaInicio());
        }
        if (trabajosDto.getFechaFin() != null) {
            trabajosExistente.setFechaFin(trabajosDto.getFechaFin());
        }
        if (trabajosDto.getCargo() != null && !Objects.equals(trabajosExistente.getCargo(), trabajosDto.getCargo())) {
            trabajosExistente.setCargo(trabajosDto.getCargo());
        }
        if (trabajosDto.getPais() != null && !Objects.equals(trabajosExistente.getPais(), trabajosDto.getPais())) {
            trabajosExistente.setPais(trabajosDto.getPais());
        }
        if (trabajosDto.getCiudad() != null && !Objects.equals(trabajosExistente.getCiudad(), trabajosDto.getCiudad())) {
            trabajosExistente.setCiudad(trabajosDto.getCiudad());
        }
        if (trabajosDto.getEmpresa() != null && !Objects.equals(trabajosExistente.getEmpresa(), trabajosDto.getEmpresa())) {
            trabajosExistente.setEmpresa(trabajosDto.getEmpresa());
        }
        if (trabajosDto.getContactoEmpresa() != null && !Objects.equals(trabajosExistente.getContactoEmpresa(), trabajosDto.getContactoEmpresa())) {
            trabajosExistente.setContactoEmpresa(trabajosDto.getContactoEmpresa());
        }
        if (trabajosDto.isActivo() != trabajosExistente.getActivo()) {
            trabajosExistente.setActivo(trabajosDto.isActivo());
        }
        return trabajosExistente;
    }
}