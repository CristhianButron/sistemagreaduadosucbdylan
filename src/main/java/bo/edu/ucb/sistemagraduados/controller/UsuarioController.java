package bo.edu.ucb.sistemagraduados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import bo.edu.ucb.sistemagraduados.dto.UsuarioDto;
import bo.edu.ucb.sistemagraduados.service.UsuarioService;



@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/getUsuarios")
    @ResponseBody
    public List<UsuarioDto> listaUsuarios() {
        return usuarioService.findAll();
        }

    @GetMapping("/getUsuarios/{id}")
    @ResponseBody
    public UsuarioDto getUsuarioById(Integer id) {
        return usuarioService.findById(id);
    }

    @PostMapping("/postUsuarios")
    @ResponseBody
    public UsuarioDto saveUsuario(UsuarioDto usuarioDto) {
        return usuarioService.save(usuarioDto);
    }


}


