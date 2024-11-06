package bo.edu.ucb.sistemagraduados.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PostgradosDto {
    private Integer idPostgrado;
    private String tipo;
    private Integer duracion;
}
