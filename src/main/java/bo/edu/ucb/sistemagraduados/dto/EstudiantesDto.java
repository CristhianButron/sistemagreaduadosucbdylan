package bo.edu.ucb.sistemagraduados.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EstudiantesDto {
    private Integer idEstudiante;
    private String correoPersonal;
    private String linkedin;
    private Integer usuarioInsercion;
    private String fotoTitulo;
    private Date fechaIngreso;
    private Date fechaFin;
    private Date fechaInsercion;
    private Integer carrera_id_carrera;
    private PersonaDto personaDto;
    private Integer usuario_id_usuario;

}
