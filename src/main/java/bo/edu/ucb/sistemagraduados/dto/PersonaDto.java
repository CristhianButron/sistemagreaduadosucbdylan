package bo.edu.ucb.sistemagraduados.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonaDto {
    private Integer idPersona;
    private String aPaterno;
    private String aMaterno;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String ci;
    private String generoNacimiento;
    private String nacionalidad;
}
