package bo.edu.ucb.sistemagraduados.controller;

import bo.edu.ucb.sistemagraduados.dto.UsuarioDto;
import bo.edu.ucb.sistemagraduados.service.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



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
    public UsuarioDto getUsuarioById(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }

    @PostMapping("/postUsuarios")
    @ResponseBody
    public ResponseEntity<UsuarioDto> saveUsuario(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto savedUsuarioDto = usuarioService.save(usuarioDto);
        return ResponseEntity.ok(savedUsuarioDto);
    }

    @PutMapping("/putUsuarios/{id}")
    @ResponseBody
    public ResponseEntity<UsuarioDto> updateUsuario(@PathVariable Integer id, @RequestBody UsuarioDto usuarioDto) {
        usuarioDto.setIdUsuario(id);
        UsuarioDto updatedUsuarioDto = usuarioService.update(id, usuarioDto);
        return ResponseEntity.ok(updatedUsuarioDto);
    }

    @DeleteMapping("/deleteUsuarios/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteUsuario(@PathVariable Integer id) {
        usuarioService.delete(id);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }


}


