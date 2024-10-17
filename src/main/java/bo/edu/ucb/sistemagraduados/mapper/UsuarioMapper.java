package bo.edu.ucb.sistemagraduados.mapper;

import java.util.List;
import java.util.ArrayList;

import bo.edu.ucb.sistemagraduados.dto.UsuarioDto;
import bo.edu.ucb.sistemagraduados.entity.Persona;
import bo.edu.ucb.sistemagraduados.entity.Usuario;

public class UsuarioMapper {
    public static UsuarioDto toUsuarioDto(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setIdUsuario(usuario.getIdUsuario());
        usuarioDto.setCorreoinstitucional(usuario.getCorreoInstitucional());
        usuarioDto.setContrasenha(usuario.getContrasenha());
        usuarioDto.setCargo(usuario.getCargo());
        usuarioDto.setNombre(usuario.getPersonaIdPersona().getNombre());
        usuarioDto.setApaterno(usuario.getPersonaIdPersona().getAPaterno());
        usuarioDto.setAmaterno(usuario.getPersonaIdPersona().getAMaterno());
        usuarioDto.setCi(usuario.getPersonaIdPersona().getCi());
        usuarioDto.setFechaNacimiento(usuario.getPersonaIdPersona().getFechaNacimiento());
        usuarioDto.setGenero(usuario.getPersonaIdPersona().getGeneroNacimiento());
        usuarioDto.setNacionalidad(usuario.getPersonaIdPersona().getNacionalidad());
        return usuarioDto;
    }

    public static Usuario toUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(usuarioDto.getIdUsuario());
        usuario.setCorreoInstitucional(usuarioDto.getCorreoinstitucional());
        usuario.setContrasenha(usuarioDto.getContrasenha());
        usuario.setCargo(usuarioDto.getCargo());
        
        Persona persona = new Persona();
        persona.setNombre(usuarioDto.getNombre());
        persona.setAPaterno(usuarioDto.getApaterno());
        persona.setAMaterno(usuarioDto.getAmaterno());
        persona.setCi(usuarioDto.getCi());
        persona.setFechaNacimiento(usuarioDto.getFechaNacimiento());
        persona.setGeneroNacimiento(usuarioDto.getGenero());
        persona.setNacionalidad(usuarioDto.getNacionalidad());

        usuario.setPersonaIdPersona(persona);
        
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
