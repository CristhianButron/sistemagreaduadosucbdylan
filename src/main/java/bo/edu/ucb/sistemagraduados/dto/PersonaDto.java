package bo.edu.ucb.sistemagraduados.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonaDto {
    private String aPaterno;
    private String aMaterno;
    private String nombre;
    private Date fechaNacimiento;
    private String ci;
    private String generoNacimiento;
    private String nacionalidad;
}
