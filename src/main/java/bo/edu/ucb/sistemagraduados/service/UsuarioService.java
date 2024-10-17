package bo.edu.ucb.sistemagraduados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.sistemagraduados.dto.UsuarioDto;
import bo.edu.ucb.sistemagraduados.entity.Usuario;
import bo.edu.ucb.sistemagraduados.mapper.UsuarioMapper;
import bo.edu.ucb.sistemagraduados.repository.UsuarioRepository;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;
    
  
    public List<UsuarioDto> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioMapper.toUsuarioDtoList(usuarios);
    }

    public UsuarioDto findById(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return UsuarioMapper.toUsuarioDto(usuario);
    }

    public UsuarioDto save(UsuarioDto usuarioDto) {
        Usuario usuario = UsuarioMapper.toUsuario(usuarioDto);
        usuario = usuarioRepository.save(usuario);
        return UsuarioMapper.toUsuarioDto(usuario);
    }

    public UsuarioDto update(UsuarioDto usuarioDto) {
        Usuario usuario = UsuarioMapper.toUsuario(usuarioDto);
        usuario = usuarioRepository.save(usuario);
        return UsuarioMapper.toUsuarioDto(usuario);
    }
}
