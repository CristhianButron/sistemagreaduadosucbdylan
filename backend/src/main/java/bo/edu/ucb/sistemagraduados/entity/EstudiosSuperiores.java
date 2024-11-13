/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.sistemagraduados.entity;

import jakarta.persistence.Basic;
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
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author danielaldazosa
 */
@Entity
@Table(name = "estudios_superiores")
@NamedQueries({
    @NamedQuery(name = "EstudiosSuperiores.findAll", query = "SELECT e FROM EstudiosSuperiores e"),
    @NamedQuery(name = "EstudiosSuperiores.findByIdEstudio", query = "SELECT e FROM EstudiosSuperiores e WHERE e.idEstudio = :idEstudio"),
    @NamedQuery(name = "EstudiosSuperiores.findByFechaInicio", query = "SELECT e FROM EstudiosSuperiores e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "EstudiosSuperiores.findByFechaFin", query = "SELECT e FROM EstudiosSuperiores e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "EstudiosSuperiores.findByInstitucion", query = "SELECT e FROM EstudiosSuperiores e WHERE e.institucion = :institucion"),
    @NamedQuery(name = "EstudiosSuperiores.findByPais", query = "SELECT e FROM EstudiosSuperiores e WHERE e.pais = :pais"),
    @NamedQuery(name = "EstudiosSuperiores.findByCiudad", query = "SELECT e FROM EstudiosSuperiores e WHERE e.ciudad = :ciudad"),
    @NamedQuery(name = "EstudiosSuperiores.findByActivo", query = "SELECT e FROM EstudiosSuperiores e WHERE e.activo = :activo")})
public class EstudiosSuperiores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estudio")
    private Integer idEstudio;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @Basic(optional = false)
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
    @Basic(optional = false)
    @Column(name = "institucion")
    private String institucion;
    @Basic(optional = false)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name = "estudiantes_id_estudiante", referencedColumnName = "id_estudiante")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Estudiantes estudiantesIdEstudiante;
    @JoinColumn(name = "postgrados_id_postgrado", referencedColumnName = "id_postgrado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Postgrados postgradosIdPostgrado;

    public EstudiosSuperiores() {
    }

    public EstudiosSuperiores(Integer idEstudio) {
        this.idEstudio = idEstudio;
    }

    public EstudiosSuperiores(Integer idEstudio, LocalDate fechaInicio, LocalDate fechaFin, String institucion, String pais, String ciudad, boolean activo) {
        this.idEstudio = idEstudio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.institucion = institucion;
        this.pais = pais;
        this.ciudad = ciudad;
        this.activo = activo;
    }

    public Integer getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(Integer idEstudio) {
        this.idEstudio = idEstudio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Estudiantes getEstudiantesIdEstudiante() {
        return estudiantesIdEstudiante;
    }

    public void setEstudiantesIdEstudiante(Estudiantes estudiantesIdEstudiante) {
        this.estudiantesIdEstudiante = estudiantesIdEstudiante;
    }

    public Postgrados getPostgradosIdPostgrado() {
        return postgradosIdPostgrado;
    }

    public void setPostgradosIdPostgrado(Postgrados postgradosIdPostgrado) {
        this.postgradosIdPostgrado = postgradosIdPostgrado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudio != null ? idEstudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudiosSuperiores)) {
            return false;
        }
        EstudiosSuperiores other = (EstudiosSuperiores) object;
        if ((this.idEstudio == null && other.idEstudio != null) || (this.idEstudio != null && !this.idEstudio.equals(other.idEstudio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.sistemagraduados.entity.EstudiosSuperiores[ idEstudio=" + idEstudio + " ]";
    }

}
