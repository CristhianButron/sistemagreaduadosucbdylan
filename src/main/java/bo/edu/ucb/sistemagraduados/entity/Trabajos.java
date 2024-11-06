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
@Table(name = "trabajos")
@NamedQueries({
    @NamedQuery(name = "Trabajos.findAll", query = "SELECT t FROM Trabajos t"),
    @NamedQuery(name = "Trabajos.findByIdTrabajo", query = "SELECT t FROM Trabajos t WHERE t.idTrabajo = :idTrabajo"),
    @NamedQuery(name = "Trabajos.findByFechaInicio", query = "SELECT t FROM Trabajos t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Trabajos.findByFechaFin", query = "SELECT t FROM Trabajos t WHERE t.fechaFin = :fechaFin"),
    @NamedQuery(name = "Trabajos.findByCargo", query = "SELECT t FROM Trabajos t WHERE t.cargo = :cargo"),
    @NamedQuery(name = "Trabajos.findByPais", query = "SELECT t FROM Trabajos t WHERE t.pais = :pais"),
    @NamedQuery(name = "Trabajos.findByCiudad", query = "SELECT t FROM Trabajos t WHERE t.ciudad = :ciudad"),
    @NamedQuery(name = "Trabajos.findByEmpresa", query = "SELECT t FROM Trabajos t WHERE t.empresa = :empresa"),
    @NamedQuery(name = "Trabajos.findByContactoEmpresa", query = "SELECT t FROM Trabajos t WHERE t.contactoEmpresa = :contactoEmpresa"),
    @NamedQuery(name = "Trabajos.findByActivo", query = "SELECT t FROM Trabajos t WHERE t.activo = :activo")})
public class Trabajos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_trabajo")
    private Integer idTrabajo;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @Column(name = "pais")
    private String pais;
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "empresa")
    private String empresa;
    @Column(name = "contacto_empresa")
    private String contactoEmpresa;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name = "estudiantes_id_estudiante", referencedColumnName = "id_estudiante")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Estudiantes estudiantesIdEstudiante;

    public Trabajos() {
    }

    public Trabajos(Integer idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public Trabajos(Integer idTrabajo, LocalDate fechaInicio, LocalDate fechaFin, String cargo, String pais, String empresa, boolean activo) {
        this.idTrabajo = idTrabajo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cargo = cargo;
        this.pais = pais;
        this.empresa = empresa;
        this.activo = activo;
    }

    public Integer getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(Integer idTrabajo) {
        this.idTrabajo = idTrabajo;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getContactoEmpresa() {
        return contactoEmpresa;
    }

    public void setContactoEmpresa(String contactoEmpresa) {
        this.contactoEmpresa = contactoEmpresa;
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

    public void setEstudiantesIdEstudiante(Estudiantes estudiantes) {
        this.estudiantesIdEstudiante = estudiantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrabajo != null ? idTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajos)) {
            return false;
        }
        Trabajos other = (Trabajos) object;
        if ((this.idTrabajo == null && other.idTrabajo != null) || (this.idTrabajo != null && !this.idTrabajo.equals(other.idTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.sistemagraduados.entity.Trabajos[ idTrabajo=" + idTrabajo + " ]";
    }


}
