package bo.edu.ucb.sistemagraduados.mapper;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

import bo.edu.ucb.sistemagraduados.dto.UsuarioDto;
import bo.edu.ucb.sistemagraduados.entity.Carreras;
import bo.edu.ucb.sistemagraduados.entity.Usuario;
import bo.edu.ucb.sistemagraduados.utility.HashingUtility;

public class UsuarioMapper {
    private static HashingUtility hashingUtility = new HashingUtility();

    public static UsuarioDto toUsuarioDto(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setIdUsuario(usuario.getIdUsuario());
        usuarioDto.setCorreoinstitucional(usuario.getCorreoInstitucional());
        usuarioDto.setContrasenha(usuario.getContrasenha());
        usuarioDto.setCargo(usuario.getCargo());
        usuarioDto.setAdmin(usuario.getAdmin());

        usuarioDto.setPersonaDto(PersonaMapper.toPersonaDto(usuario.getPersonaIdPersona()));

        usuarioDto.setCarrera_id_carrera(usuario.getCarrerasIdCarrera().getIdCarrera());
        return usuarioDto;
    }

    public static Usuario toUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setCorreoInstitucional(usuarioDto.getCorreoinstitucional());

        String hashedPassword = hashingUtility.hashPassword(usuarioDto.getContrasenha());
        usuario.setContrasenha(hashedPassword);
        
        usuario.setCargo(usuarioDto.getCargo());
        usuario.setAdmin(usuarioDto.getAdmin());
        
        usuario.setPersonaIdPersona(PersonaMapper.toPersona(usuarioDto.getPersonaDto()));

        Carreras carrera = new Carreras();
        carrera.setIdCarrera(usuarioDto.getCarrera_id_carrera());
        usuario.setCarrerasIdCarrera(carrera);
        
        return usuario;
    }

    public static List<UsuarioDto> toUsuarioDtoList(List<Usuario> usuarios) {
        List<UsuarioDto> usuariosDtos = new ArrayList<>();
        for(Usuario usuario : usuarios) {
            usuariosDtos.add(toUsuarioDto(usuario));
        }
        return usuariosDtos;
    }

    public static Usuario updateUsuarioFromDto(UsuarioDto usuarioactualizadoDto, Usuario usuarioExistente) {
        if (usuarioactualizadoDto == null || usuarioExistente == null) {
            return null;
        }
        if (usuarioactualizadoDto.getCorreoinstitucional() != null && !Objects.equals(usuarioExistente.getCorreoInstitucional(), usuarioactualizadoDto.getCorreoinstitucional())) {
            usuarioExistente.setCorreoInstitucional(usuarioactualizadoDto.getCorreoinstitucional());
            
        }
        if (usuarioactualizadoDto.getContrasenha() != null && !Objects.equals(usuarioExistente.getContrasenha(), usuarioactualizadoDto.getContrasenha())) {
            usuarioExistente.setContrasenha(usuarioactualizadoDto.getContrasenha());
        }
        if (usuarioactualizadoDto.getCargo() != null && !Objects.equals(usuarioExistente.getCargo(), usuarioactualizadoDto.getCargo())) {
            usuarioExistente.setCargo(usuarioactualizadoDto.getCargo());
        }
        if (usuarioactualizadoDto.getAdmin() != usuarioExistente.getAdmin()) {
            usuarioExistente.setAdmin(usuarioactualizadoDto.getAdmin());
        }
        if (usuarioactualizadoDto.getPersonaDto() != null) {
            usuarioExistente.setPersonaIdPersona(PersonaMapper.updatePersonaFromDto(usuarioactualizadoDto.getPersonaDto(), usuarioExistente.getPersonaIdPersona()));
        }
        if (usuarioactualizadoDto.getCarrera_id_carrera() != null && !Objects.equals(usuarioExistente.getCarrerasIdCarrera().getIdCarrera(), usuarioactualizadoDto.getCarrera_id_carrera())) {
            Carreras carrera = new Carreras();
            carrera.setIdCarrera(usuarioactualizadoDto.getCarrera_id_carrera());
            usuarioExistente.setCarrerasIdCarrera(carrera);
        }
        
        return usuarioExistente;
    }
}
