package bo.edu.ucb.sistemagraduados.dto;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String correoinstitucional;
    private String contrasenha;
}