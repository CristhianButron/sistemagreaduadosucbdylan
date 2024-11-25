package bo.edu.ucb.sistemagraduados.service;


import org.springframework.stereotype.Service;

import bo.edu.ucb.sistemagraduados.repository.UsuarioRepository;
import bo.edu.ucb.sistemagraduados.utility.HashingUtility;
import bo.edu.ucb.sistemagraduados.dto.LoginDto;
import bo.edu.ucb.sistemagraduados.dto.TokenDto;
import bo.edu.ucb.sistemagraduados.entity.Usuario;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;


@Service
public class AuthService {
    public static final String KEY = "$5tR0nGp@$$W0rD!2024";
    private final UsuarioRepository usuariosRepository;

    public AuthService(UsuarioRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public TokenDto login(LoginDto loginDto) {
        try {
            //saber si el usuario existe
            Usuario user = usuariosRepository.findByCorreoInstitucional(loginDto.getUsuario());
            if (user == null) {
                TokenDto tokenDto = new TokenDto();
                tokenDto.setAuthToken("Usuario no existe");
                tokenDto.setId(-1);
                return tokenDto;
            }
            HashingUtility hashingUtility = new HashingUtility();
            if(!hashingUtility.checkPassword(loginDto.getClave(), user.getContrasenha())){
                TokenDto tokenDto = new TokenDto();
                tokenDto.setAuthToken("Contraseña incorrecta");
                tokenDto.setId(-2);
                return tokenDto;
            }
            TokenDto tokenDto = new TokenDto();
            tokenDto.setAuthToken(generateToken(user.getIdUsuario(),user.getCorreoInstitucional(),30));
            tokenDto.setRefreshToken(generateToken(user.getIdUsuario(),user.getCorreoInstitucional(),60*2));
            tokenDto.setId(user.getIdUsuario());
            tokenDto.setCorreo(user.getCorreoInstitucional());
            return tokenDto;


        }catch (Exception e){
            System.out.println("Error al hacer login: "+e.getMessage());
            return null;
        }
    }








     //Generar un token
     private String generateToken(Integer idUser,String nombre,int minutes){
        try{
            Algorithm algorithm = Algorithm.HMAC256(KEY);
            String token = JWT.create()
                    .withIssuer("bo.ucb.sistemagraduados")
                    .withClaim("id", idUser)
                    .withClaim("nombre", nombre)
                    .withClaim("minutes", minutes)
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException exception){
            throw new RuntimeException("Error al generar el token", exception);
        }
    }


    //Validar un token
    public String validateToken(String token,int idPath) {
        if(token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256(KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("bo.ucb.sis213.todo")
                    .build();
            decodedJWT = verifier.verify(token);
            //Verificar que el id del usuario sea valido
            int id = decodedJWT.getClaim("id").asInt();
            if(id != idPath){
                return "Invalido";
            }
            return decodedJWT.getClaim("nombre").asString();
        } catch (JWTVerificationException exception){
            return "Invalido";
        }
    }

    
}
