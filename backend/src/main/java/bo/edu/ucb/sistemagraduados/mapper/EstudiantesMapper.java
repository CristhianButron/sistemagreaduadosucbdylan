package bo.edu.ucb.sistemagraduados.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import bo.edu.ucb.sistemagraduados.dto.EstudiantesDto;
import bo.edu.ucb.sistemagraduados.entity.Carreras;
import bo.edu.ucb.sistemagraduados.entity.Estudiantes;
import bo.edu.ucb.sistemagraduados.entity.Usuario;

public class EstudiantesMapper {

    public static EstudiantesDto toEstudiantesDto(Estudiantes estudiantes) {
        EstudiantesDto estudiantesDto = new EstudiantesDto();
        estudiantesDto.setIdEstudiante(estudiantes.getIdEstudiante());
        estudiantesDto.setCorreoPersonal(estudiantes.getCorreoPersonal());
        estudiantesDto.setCelular(estudiantes.getCelular());
        estudiantesDto.setRedSocial(estudiantes.getRedSocial());   
        estudiantesDto.setCiudadNacimiento(estudiantes.getCiudadNacimiento());
        estudiantesDto.setTipoTitulacion(estudiantes.getTipoTitulacion());
        estudiantesDto.setFotoTitulo(estudiantes.getFotoTitulo());
        estudiantesDto.setFechaIngreso(estudiantes.getFechaIngreso());
        estudiantesDto.setFechaFin(estudiantes.getFechaFin());
        estudiantesDto.setFechaInsercion(estudiantes.getFechaInsercion());
        
        estudiantesDto.setPersonaDto(PersonaMapper.toPersonaDto(estudiantes.getPersonaIdPersona()));
        
        estudiantesDto.setUsuario_id_usuario(estudiantes.getUsuarioIdUsuario().getIdUsuario());

        estudiantesDto.setCarrera_id_carrera(estudiantes.getCarrerasIdCarrera().getIdCarrera());
        return estudiantesDto;
    }

    public static Estudiantes toEstudiantes(EstudiantesDto estudiantesDto) {
        Estudiantes estudiantes = new Estudiantes();
        estudiantes.setCorreoPersonal(estudiantesDto.getCorreoPersonal());
        estudiantes.setCelular(estudiantesDto.getCelular());
        estudiantes.setRedSocial(estudiantesDto.getRedSocial());
        estudiantes.setCiudadNacimiento(estudiantesDto.getCiudadNacimiento());
        estudiantes.setTipoTitulacion(estudiantesDto.getTipoTitulacion());
        estudiantes.setFotoTitulo(estudiantesDto.getFotoTitulo());
        estudiantes.setFechaIngreso(estudiantesDto.getFechaIngreso());
        estudiantes.setFechaFin(estudiantesDto.getFechaFin());
        estudiantes.setFechaInsercion(estudiantesDto.getFechaInsercion());
        estudiantes.setPersonaIdPersona(PersonaMapper.toPersona(estudiantesDto.getPersonaDto()));

        Carreras carrera = new Carreras();
        carrera.setIdCarrera(estudiantesDto.getCarrera_id_carrera());
        estudiantes.setCarrerasIdCarrera(carrera);

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(estudiantesDto.getUsuario_id_usuario());
        estudiantes.setUsuarioIdUsuario(usuario);
        

        return estudiantes;
    }

    public static List<EstudiantesDto> toEstudiantesDtoList(List<Estudiantes> estudiantes) {
        List<EstudiantesDto> estudiantesDtos = new ArrayList<>();
        for(Estudiantes estudiante : estudiantes) {
            estudiantesDtos.add(toEstudiantesDto(estudiante));
        }
        return estudiantesDtos;
    }

    public static Estudiantes updateEstudiantesFromDto (EstudiantesDto estudianteActualizadoDto, Estudiantes estudianteExistente){
        if (estudianteActualizadoDto == null || estudianteExistente == null) {
            return null;
        }
        if (estudianteActualizadoDto.getCorreoPersonal() != null && !Objects.equals(estudianteExistente.getCorreoPersonal(), estudianteActualizadoDto.getCorreoPersonal())) {
            estudianteExistente.setCorreoPersonal(estudianteActualizadoDto.getCorreoPersonal());
        }
        if (estudianteActualizadoDto.getCelular() != null && !Objects.equals(estudianteExistente.getCelular(), estudianteActualizadoDto.getCelular())) {
            estudianteExistente.setCelular(estudianteActualizadoDto.getCelular());
        }
        if (estudianteActualizadoDto.getRedSocial() != null && !Objects.equals(estudianteExistente.getRedSocial(), estudianteActualizadoDto.getRedSocial())) {
            estudianteExistente.setRedSocial(estudianteActualizadoDto.getRedSocial());
        }
        if (estudianteActualizadoDto.getCiudadNacimiento() != null && !Objects.equals(estudianteExistente.getCiudadNacimiento(), estudianteActualizadoDto.getCiudadNacimiento())) {
            estudianteExistente.setCiudadNacimiento(estudianteActualizadoDto.getCiudadNacimiento());
        }
        if (estudianteActualizadoDto.getTipoTitulacion() != null && !Objects.equals(estudianteExistente.getTipoTitulacion(), estudianteActualizadoDto.getTipoTitulacion())) {
            estudianteExistente.setTipoTitulacion(estudianteActualizadoDto.getTipoTitulacion());
        }
        if (estudianteActualizadoDto.getFotoTitulo() != null && !Objects.equals(estudianteExistente.getFotoTitulo(), estudianteActualizadoDto.getFotoTitulo())) {
            estudianteExistente.setFotoTitulo(estudianteActualizadoDto.getFotoTitulo());
        }
        if (estudianteActualizadoDto.getFechaIngreso() != null && !Objects.equals(estudianteExistente.getFechaIngreso(), estudianteActualizadoDto.getFechaIngreso())) {
            estudianteExistente.setFechaIngreso(estudianteActualizadoDto.getFechaIngreso());
        }
        if (estudianteActualizadoDto.getFechaFin() != null && !Objects.equals(estudianteExistente.getFechaFin(), estudianteActualizadoDto.getFechaFin())) {
            estudianteExistente.setFechaFin(estudianteActualizadoDto.getFechaFin());
        }
        if (estudianteActualizadoDto.getFechaInsercion() != null && !Objects.equals(estudianteExistente.getFechaInsercion(), estudianteActualizadoDto.getFechaInsercion())) {
            estudianteExistente.setFechaInsercion(estudianteActualizadoDto.getFechaInsercion());
        }
        if (estudianteActualizadoDto.getPersonaDto() != null) {
            estudianteExistente.setPersonaIdPersona(PersonaMapper.updatePersonaFromDto(estudianteActualizadoDto.getPersonaDto(), estudianteExistente.getPersonaIdPersona()));
        }
        if (estudianteActualizadoDto.getCarrera_id_carrera() != null && !Objects.equals(estudianteExistente.getCarrerasIdCarrera().getIdCarrera(), estudianteActualizadoDto.getCarrera_id_carrera())) {
            Carreras carrera = new Carreras();
            carrera.setIdCarrera(estudianteActualizadoDto.getCarrera_id_carrera());
            estudianteExistente.setCarrerasIdCarrera(carrera);
        }
        if (estudianteActualizadoDto.getUsuario_id_usuario() != null && !Objects.equals(estudianteExistente.getUsuarioIdUsuario().getIdUsuario(), estudianteActualizadoDto.getUsuario_id_usuario())) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(estudianteActualizadoDto.getUsuario_id_usuario());
            estudianteExistente.setUsuarioIdUsuario(usuario);
        }
        
        return estudianteExistente;
    }
}
