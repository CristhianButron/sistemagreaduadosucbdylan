package bo.edu.ucb.sistemagraduados.mapper;

import java.util.List;
import java.util.ArrayList;

import bo.edu.ucb.sistemagraduados.dto.UsuarioDto;
import bo.edu.ucb.sistemagraduados.entity.Carreras;
import bo.edu.ucb.sistemagraduados.entity.Usuario;

public class UsuarioMapper {
    public static UsuarioDto toUsuarioDto(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setIdUsuario(usuario.getIdUsuario());
        usuarioDto.setCorreoinstitucional(usuario.getCorreoInstitucional());
        usuarioDto.setContrasenha(usuario.getContrasenha());
        usuarioDto.setCargo(usuario.getCargo());

        usuarioDto.setPersonaDto(PersonaMapper.toPersonaDto(usuario.getPersonaIdPersona()));

        usuarioDto.setCarrera_id_carrera(usuario.getCarrerasIdCarrera().getIdCarrera());
        return usuarioDto;
    }

    public static Usuario toUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setCorreoInstitucional(usuarioDto.getCorreoinstitucional());
        usuario.setContrasenha(usuarioDto.getContrasenha());
        usuario.setCargo(usuarioDto.getCargo());
        
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
}
