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
@Table(name = "persona")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Persona.findByAPaterno", query = "SELECT p FROM Persona p WHERE p.aPaterno = :aPaterno"),
    @NamedQuery(name = "Persona.findByAMaterno", query = "SELECT p FROM Persona p WHERE p.aMaterno = :aMaterno"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Persona.findByCi", query = "SELECT p FROM Persona p WHERE p.ci = :ci"),
    @NamedQuery(name = "Persona.findByGeneroNacimiento", query = "SELECT p FROM Persona p WHERE p.generoNacimiento = :generoNacimiento"),
    @NamedQuery(name = "Persona.findByNacionalidad", query = "SELECT p FROM Persona p WHERE p.nacionalidad = :nacionalidad")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Basic(optional = false)
    @Column(name = "a_paterno")
    private String aPaterno;
    @Basic(optional = false)
    @Column(name = "a_materno")
    private String aMaterno;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "ci")
    private String ci;
    @Basic(optional = false)
    @Column(name = "genero_nacimiento")
    private String generoNacimiento;
    @Basic(optional = false)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaIdPersona", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaIdPersona", fetch = FetchType.LAZY)
    private List<Estudiantes> estudiantesList;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Integer idPersona, String aPaterno, String aMaterno, String nombre, LocalDate fechaNacimiento, String ci, String generoNacimiento, /*Object celular,*/ String nacionalidad) {
        this.idPersona = idPersona;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.ci = ci;
        this.generoNacimiento = generoNacimiento;
        this.nacionalidad = nacionalidad;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getAPaterno() {
        return aPaterno;
    }

    public void setAPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getAMaterno() {
        return aMaterno;
    }

    public void setAMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getGeneroNacimiento() {
        return generoNacimiento;
    }

    public void setGeneroNacimiento(String generoNacimiento) {
        this.generoNacimiento = generoNacimiento;
    }


    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<Estudiantes> getEstudiantesList() {
        return estudiantesList;
    }

    public void setEstudiantesList(List<Estudiantes> estudiantesList) {
        this.estudiantesList = estudiantesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.sistemagraduados.entity.Persona[ idPersona=" + idPersona + " ]";
    }

}
