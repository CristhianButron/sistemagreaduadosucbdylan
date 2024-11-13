package bo.edu.ucb.sistemagraduados.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioDto {
    private Integer idUsuario;
    private String correoinstitucional;
    private String contrasenha;
    private String cargo;
    private Boolean admin;
    private PersonaDto personaDto;
    private Integer carrera_id_carrera;
}
