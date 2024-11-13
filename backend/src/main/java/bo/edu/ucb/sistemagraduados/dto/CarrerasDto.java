package bo.edu.ucb.sistemagraduados.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarrerasDto {

     private Integer idCarrera;
     private String nombre;
     private String sigla;
        
}
