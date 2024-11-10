/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.sistemagraduados.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author danielaldazosa
 */
@Entity
@Table(name = "estudiantes")
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e"),
    @NamedQuery(name = "Estudiantes.findByIdEstudiante", query = "SELECT e FROM Estudiantes e WHERE e.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "Estudiantes.findByCorreoPersonal", query = "SELECT e FROM Estudiantes e WHERE e.correoPersonal = :correoPersonal"),
    @NamedQuery(name = "Estudiantes.findByCelular", query = "SELECT e FROM Estudiantes e WHERE e.celular = :celular"),
    @NamedQuery(name = "Estudiantes.findByRedSocial", query = "SELECT e FROM Estudiantes e WHERE e.redSocial = :redSocial"),
    @NamedQuery(name = "Estudiantes.findByCiudadNacimiento", query = "SELECT e FROM Estudiantes e WHERE e.ciudadNacimiento = :ciudadNacimiento"),
    @NamedQuery(name = "Estudiantes.findByTipoTitulacion", query = "SELECT e FROM Estudiantes e WHERE e.tipoTitulacion = :tipoTitulacion"),   
    @NamedQuery(name = "Estudiantes.findByFotoTitulo", query = "SELECT e FROM Estudiantes e WHERE e.fotoTitulo = :fotoTitulo"),
    @NamedQuery(name = "Estudiantes.findByFechaIngreso", query = "SELECT e FROM Estudiantes e WHERE e.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Estudiantes.findByFechaFin", query = "SELECT e FROM Estudiantes e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "Estudiantes.findByFechaInsercion", query = "SELECT e FROM Estudiantes e WHERE e.fechaInsercion = :fechaInsercion")})
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estudiante")
    private Integer idEstudiante;
    @Basic(optional = false)
    @Column(name = "correo_personal")
    private String correoPersonal;
    @Basic(optional = false)
    @Column(name = "celular")
    private String celular;
    @Column(name = "red_social")
    private String redSocial;
    @Basic(optional = false)
    @Column(name = "ciudad_nacimiento")
    private String ciudadNacimiento;
    @Basic(optional = false)
    @Column(name = "tipo_titulacion")
    private String tipoTitulacion;
    @Basic(optional = false)
    @Column(name = "foto_titulo")
    private String fotoTitulo;
    @Basic(optional = false)
    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;
    @Basic(optional = false)
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
    @Basic(optional = false)
    @Column(name = "fecha_insercion")
    private LocalDate fechaInsercion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiantesIdEstudiante", fetch = FetchType.LAZY)
    private List<EstudiosSuperiores> estudiosSuperioresList;
    @JoinColumn(name = "carreras_id_carrera", referencedColumnName = "id_carrera")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Carreras carrerasIdCarrera;
    @JoinColumn(name = "persona_id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona personaIdPersona;
    @JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioIdUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiantesIdEstudiante", fetch = FetchType.LAZY)
    private List<Trabajos> trabajosList;

    public Estudiantes() {
    }

    public Estudiantes(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Estudiantes(Integer idEstudiante, LocalDate fechaIngreso, LocalDate fechaFin, LocalDate fechaInsercion) {
        this.idEstudiante = idEstudiante;
        this.fechaIngreso = fechaIngreso;
        this.fechaFin = fechaFin;
        this.fechaInsercion = fechaInsercion;
    }

    public Estudiantes(Integer idEstudiante, String correoPersonal, String celular, String redSocial, String ciudadNacimiento) {
        this.idEstudiante = idEstudiante;
        this.correoPersonal = correoPersonal;
        this.celular = celular;
        this.redSocial = redSocial;
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRedSocial() {
        return redSocial;
    }

    public void setRedSocial(String redSocial) {
        this.redSocial = redSocial;
    }

    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public String getTipoTitulacion() {
        return tipoTitulacion;
    }

    public void setTipoTitulacion(String tipoTitulacion) {
        this.tipoTitulacion = tipoTitulacion;
    }

    public String getFotoTitulo() {
        return fotoTitulo;
    }

    public void setFotoTitulo(String fotoTitulo) {
        this.fotoTitulo = fotoTitulo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaInsercion() {
        return fechaInsercion;
    }

    public void setFechaInsercion(LocalDate fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }

   
    public List<EstudiosSuperiores> getEstudiosSuperioresList() {
        return estudiosSuperioresList;
    }

    public void setEstudiosSuperioresList(List<EstudiosSuperiores> estudiosSuperioresList) {
        this.estudiosSuperioresList = estudiosSuperioresList;
    }

    public Carreras getCarrerasIdCarrera() {
        return carrerasIdCarrera;
    }

    public void setCarrerasIdCarrera(Carreras carrerasIdCarrera) {
        this.carrerasIdCarrera = carrerasIdCarrera;
    }

    public Persona getPersonaIdPersona() {
        return personaIdPersona;
    }

    public void setPersonaIdPersona(Persona personaIdPersona) {
        this.personaIdPersona = personaIdPersona;
    }

    public Usuario getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Usuario usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public List<Trabajos> getTrabajosList() {
        return trabajosList;
    }

    public void setTrabajosList(List<Trabajos> trabajosList) {
        this.trabajosList = trabajosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudiante != null ? idEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.idEstudiante == null && other.idEstudiante != null) || (this.idEstudiante != null && !this.idEstudiante.equals(other.idEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.sistemagraduados.entity.Estudiantes[ idEstudiante=" + idEstudiante + " ]";
    }

}
