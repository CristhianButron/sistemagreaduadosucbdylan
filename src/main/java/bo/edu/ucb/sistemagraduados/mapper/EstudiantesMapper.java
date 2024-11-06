package bo.edu.ucb.sistemagraduados.mapper;

import java.util.ArrayList;
import java.util.List;

import bo.edu.ucb.sistemagraduados.dto.EstudiantesDto;
import bo.edu.ucb.sistemagraduados.entity.Carreras;
import bo.edu.ucb.sistemagraduados.entity.Estudiantes;
import bo.edu.ucb.sistemagraduados.entity.Usuario;

public class EstudiantesMapper {

    public static EstudiantesDto toEstudiantesDto(Estudiantes estudiantes) {
        EstudiantesDto estudiantesDto = new EstudiantesDto();
        estudiantesDto.setIdEstudiante(estudiantes.getIdEstudiante());
        estudiantesDto.setCorreoPersonal(estudiantes.getCorreoPersonal());
        estudiantesDto.setLinkedin(estudiantes.getLinkedin());
        estudiantesDto.setUsuarioInsercion(estudiantes.getUsuarioInsercion());
        estudiantesDto.setFotoTitulo(estudiantes.getFotoTitulo());
        estudiantesDto.setFechaIngreso(estudiantes.getFechaIngreso());
        estudiantesDto.setFechaFin(estudiantes.getFechaFin());
        estudiantesDto.setFechaInsercion(estudiantes.getFechaInsercion());

        estudiantesDto.setCarrera_id_carrera(estudiantes.getCarrerasIdCarrera().getIdCarrera());
        
        estudiantesDto.setPersonaDto(PersonaMapper.toPersonaDto(estudiantes.getPersonaIdPersona()));
        
        estudiantesDto.setUsuario_id_usuario(estudiantes.getUsuarioIdUsuario().getIdUsuario());
        return estudiantesDto;
    }

    public static Estudiantes toEstudiantes(EstudiantesDto estudiantesDto) {
        Estudiantes estudiantes = new Estudiantes();
        estudiantes.setCorreoPersonal(estudiantesDto.getCorreoPersonal());
        estudiantes.setLinkedin(estudiantesDto.getLinkedin());
        estudiantes.setUsuarioInsercion(estudiantesDto.getUsuarioInsercion());
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

    public static void updateEstudianteFromDto(EstudiantesDto estudiantesDto, Estudiantes estudiantes) {
        estudiantes.setCorreoPersonal(estudiantesDto.getCorreoPersonal());
        estudiantes.setLinkedin(estudiantesDto.getLinkedin());
        estudiantes.setUsuarioInsercion(estudiantesDto.getUsuarioInsercion());
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
        
    }
}
