package bo.edu.ucb.sistemagraduados.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UsuarioDto {
    private Integer idUsuario;
    private String correoinstitucional;
    private String contrasenha;
    private String cargo;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String ci;
    private Date fechaNacimiento;
    private String genero;
    private String nacionalidad;
}
