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
import java.util.List;

/**
 *
 * @author danielaldazosa
 */
@Entity
@Table(name = "postgrados")
@NamedQueries({
    @NamedQuery(name = "Postgrados.findAll", query = "SELECT p FROM Postgrados p"),
    @NamedQuery(name = "Postgrados.findByIdPostgrado", query = "SELECT p FROM Postgrados p WHERE p.idPostgrado = :idPostgrado"),
    @NamedQuery(name = "Postgrados.findByTipo", query = "SELECT p FROM Postgrados p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Postgrados.findByDuracion", query = "SELECT p FROM Postgrados p WHERE p.duracion = :duracion")})
public class Postgrados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_postgrado")
    private Integer idPostgrado;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "duracion")
    private Integer duracion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postgradosIdPostgrado", fetch = FetchType.LAZY)
    private List<EstudiosSuperiores> estudiosSuperioresList;

    public Postgrados() {
    }

    public Postgrados(Integer idPostgrado) {
        this.idPostgrado = idPostgrado;
    }

    public Postgrados(Integer idPostgrado, String tipo) {
        this.idPostgrado = idPostgrado;
        this.tipo = tipo;
    }

    public Integer getIdPostgrado() {
        return idPostgrado;
    }

    public void setIdPostgrado(Integer idPostgrado) {
        this.idPostgrado = idPostgrado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public List<EstudiosSuperiores> getEstudiosSuperioresList() {
        return estudiosSuperioresList;
    }

    public void setEstudiosSuperioresList(List<EstudiosSuperiores> estudiosSuperioresList) {
        this.estudiosSuperioresList = estudiosSuperioresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPostgrado != null ? idPostgrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postgrados)) {
            return false;
        }
        Postgrados other = (Postgrados) object;
        if ((this.idPostgrado == null && other.idPostgrado != null) || (this.idPostgrado != null && !this.idPostgrado.equals(other.idPostgrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.sistemagraduados.entity.Postgrados[ idPostgrado=" + idPostgrado + " ]";
    }
    
}
