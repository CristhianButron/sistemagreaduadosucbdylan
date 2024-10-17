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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
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
    @NamedQuery(name = "Estudiantes.findByLinkedin", query = "SELECT e FROM Estudiantes e WHERE e.linkedin = :linkedin"),
    @NamedQuery(name = "Estudiantes.findByUsuarioInsercion", query = "SELECT e FROM Estudiantes e WHERE e.usuarioInsercion = :usuarioInsercion"),
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
    @Column(name = "correo_personal")
    private String correoPersonal;
    @Column(name = "linkedin")
    private String linkedin;
    @Basic(optional = false)
    @Column(name = "usuario_insercion")
    private Integer usuarioInsercion;
    @Basic(optional = false)
    @Column(name = "foto_titulo")
    private String fotoTitulo;
    @Basic(optional = false)
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "fecha_insercion")
    @Temporal(TemporalType.DATE)
    private Date fechaInsercion;
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

    public Estudiantes(Integer idEstudiante, int usuarioInsercion, Date fechaIngreso, Date fechaFin, Date fechaInsercion) {
        this.idEstudiante = idEstudiante;
        this.usuarioInsercion = usuarioInsercion;
        this.fechaIngreso = fechaIngreso;
        this.fechaFin = fechaFin;
        this.fechaInsercion = fechaInsercion;
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

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
  
    public int getUsuarioInsercion() {
        return usuarioInsercion;
    }

    public void setUsuarioInsercion(int usuarioInsercion) {
        this.usuarioInsercion = usuarioInsercion;
    }

    public String getFotoTitulo() {
        return fotoTitulo;
    }

    public void setFotoTitulo(String fotoTitulo) {
        this.fotoTitulo = fotoTitulo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInsercion() {
        return fechaInsercion;
    }

    public void setFechaInsercion(Date fechaInsercion) {
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
        // TODO: Warning - this method won't work in the case the id fields are not set
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
