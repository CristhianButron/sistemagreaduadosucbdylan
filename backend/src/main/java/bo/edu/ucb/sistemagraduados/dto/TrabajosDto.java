package bo.edu.ucb.sistemagraduados.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TrabajosDto {
    
    private Integer idTrabajo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String cargo;
    private String pais;
    private String ciudad;
    private String empresa;
    private String contactoEmpresa;
    private boolean activo;
    private Integer estudiante_id_estudiante;
}
