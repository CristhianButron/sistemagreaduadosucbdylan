package bo.edu.ucb.sistemagraduados.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TrabajosDto {
    
    private Integer idTrabajo;
    private Date fechaInicio;
    private Date fechaFin;
    private String cargo;
    private String pais;
    private String ciudad;
    private String empresa;
    private String contactoEmpresa;
    private boolean activo;
    private Integer estudiante_id_estudiante;
}
