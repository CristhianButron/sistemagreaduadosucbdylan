package bo.edu.ucb.sistemagraduados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bo.edu.ucb.sistemagraduados.exception.CustomException;
import bo.edu.ucb.sistemagraduados.dto.UsuarioDto;
import bo.edu.ucb.sistemagraduados.dto.PersonaDto;
import bo.edu.ucb.sistemagraduados.entity.Usuario;
import bo.edu.ucb.sistemagraduados.entity.Persona;
import bo.edu.ucb.sistemagraduados.mapper.UsuarioMapper;
import bo.edu.ucb.sistemagraduados.mapper.PersonaMapper;
import bo.edu.ucb.sistemagraduados.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import bo.edu.ucb.sistemagraduados.repository.PersonaRepository;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private final PersonaRepository personaRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PersonaRepository personaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.personaRepository = personaRepository;
    }

    public List<UsuarioDto> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioMapper.toUsuarioDtoList(usuarios);
    }

    public UsuarioDto findById(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return UsuarioMapper.toUsuarioDto(usuario);
    }

    public UsuarioDto findByCorreoInstitucional(String correoInstitucional) {
        Usuario usuario = usuarioRepository.findByCorreoInstitucional(correoInstitucional);
        return usuario != null ? UsuarioMapper.toUsuarioDto(usuario) : null;
    }

    public UsuarioDto save(UsuarioDto usuarioDto) {
         if (usuarioRepository.findByCorreoInstitucional(usuarioDto.getCorreoinstitucional()) != null) {
            throw new CustomException("El correo electrónico ya está registrado");
        }

        // Verificar si la persona ya está registrada (por CI por ejemplo)
        if (usuarioDto.getPersonaDto() != null && 
            usuarioRepository.existsByPersonaIdPersonaCi(usuarioDto.getPersonaDto().getCi())) {
            throw new CustomException("Esta persona ya está registrada en el sistema");
        }
        // Crear y guardar la nueva Persona
        PersonaDto personaDto = usuarioDto.getPersonaDto();
        Persona persona = PersonaMapper.toPersona(personaDto);
       
        // Crear y guardar el nuevo Usuario
        Usuario usuario = UsuarioMapper.toUsuario(usuarioDto);
        usuario.setPersonaIdPersona(personaRepository.save(persona)); 
        usuario = usuarioRepository.save(usuario);

        return UsuarioMapper.toUsuarioDto(usuario);
    }

    @Transactional
    public UsuarioDto update(Integer id, UsuarioDto usuarioactualizadoDto) {
        // Buscar el usuario existente por ID
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        // Actualizar los campos del usuario existente utilizando el mapper
        Usuario usuarioActualizado = UsuarioMapper.updateUsuarioFromDto(usuarioactualizadoDto, usuarioExistente);
        usuarioActualizado = usuarioRepository.save(usuarioActualizado);
        // Devolver el DTO del usuario actualizado
        return UsuarioMapper.toUsuarioDto(usuarioActualizado);
    }

    public void delete(Integer id) {
        UsuarioDto usuarioDto = findById(id);
        PersonaDto personaDto = usuarioDto.getPersonaDto();
        usuarioRepository.deleteById(id);
        personaRepository.deleteById(personaDto.getIdPersona());
    }
}
