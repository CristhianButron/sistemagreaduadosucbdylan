package bo.edu.ucb.sistemagraduados.controller;

import bo.edu.ucb.sistemagraduados.dto.AuthRequestDto;
import bo.edu.ucb.sistemagraduados.dto.AuthResponseDto;
import bo.edu.ucb.sistemagraduados.dto.UsuarioDto;
import bo.edu.ucb.sistemagraduados.security.JwtTokenUtil;
import bo.edu.ucb.sistemagraduados.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioService usuarioService;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UsuarioService usuarioService, JwtTokenUtil jwtTokenUtil, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDto authRequest) {
        UsuarioDto usuario = usuarioService.findByCorreoInstitucional(authRequest.getCorreoinstitucional());
        
        if (usuario != null && passwordEncoder.matches(authRequest.getContrasenha(), usuario.getContrasenha())) {
            String token = jwtTokenUtil.generateToken(usuario.getCorreoinstitucional(), usuario.getAdmin());
            return ResponseEntity.ok(new AuthResponseDto(token, usuario.getAdmin()));
        }
        
        return ResponseEntity.badRequest().body("Invalid credentials");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsuarioDto usuarioDto) {
        // Encrypt password before saving
        usuarioDto.setContrasenha(passwordEncoder.encode(usuarioDto.getContrasenha()));
        UsuarioDto savedUser = usuarioService.save(usuarioDto);
        return ResponseEntity.ok(savedUser);
    }
}