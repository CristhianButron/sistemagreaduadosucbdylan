package bo.edu.ucb.sistemagraduados.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.sistemagraduados.dto.LoginDto;
import bo.edu.ucb.sistemagraduados.dto.ResponseDto;
import bo.edu.ucb.sistemagraduados.dto.TokenDto;
import bo.edu.ucb.sistemagraduados.service.AuthService;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/auth")

public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    private static final Logger logger = Logger.getLogger(AuthController.class.getName());
    @PostMapping("/login")
    public ResponseDto<TokenDto> login(@RequestBody LoginDto loginDto) {
        logger.info("POST request login: "+ loginDto);
        ResponseDto<TokenDto> responseDto = new ResponseDto<>();
        TokenDto tokenDto = authService.login(loginDto);
        if(tokenDto==null){
            logger.severe("Error al generar el token");
            responseDto.setCode("500");
            responseDto.setErrorMessage("Error al hacer login");
            responseDto.setResponse(null);
            return responseDto;
        }
        if(tokenDto.getId()<0){
            if(tokenDto.getId()==-1){
                logger.warning("Usuario no existe");
                responseDto.setCode("404");
                responseDto.setErrorMessage("Usuario no existe");
                responseDto.setResponse(null);
                return responseDto;
            }
            else if(tokenDto.getId()==-2){
                logger.warning("Contraseña incorrecta");
                responseDto.setCode("404");
                responseDto.setErrorMessage("Contraseña incorrecta");
                responseDto.setResponse(null);
                return responseDto;
            }


        }
        logger.info("Login exitoso"+ loginDto);
        responseDto.setCode("200");
        responseDto.setErrorMessage("");
        responseDto.setResponse(tokenDto);
        return responseDto;

    }
}


