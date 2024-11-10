package bo.edu.ucb.sistemagraduados.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EstudiantesDto {
    private Integer idEstudiante;
    private String correoPersonal;
    private String celular;
    private String redSocial;
    private String ciudadNacimiento;
    private String tipoTitulacion;
    private String fotoTitulo;
    private LocalDate fechaIngreso;
    private LocalDate fechaFin;
    private LocalDate fechaInsercion;
    private PersonaDto personaDto;
    private Integer usuario_id_usuario;
    private Integer carrera_id_carrera;

}
