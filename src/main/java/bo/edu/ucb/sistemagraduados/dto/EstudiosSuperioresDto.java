package bo.edu.ucb.sistemagraduados.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EstudiosSuperioresDto {
    private Integer idEstudio;
    private Date fechaInicio;
    private Date fechaFin;
    private String institucion;
    private String pais;
    private String ciudad;
    private boolean activo;
    private Integer estudiante_id_estudiante;
    private Integer postgrados_id_postgrado;

}
