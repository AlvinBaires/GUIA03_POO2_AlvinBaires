/**
 * @author Alvin
 * @version 1.0 27 de Agosto de 2016
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "luga_acce", catalog = "rceron_poo", schema = "")
@NamedQueries({
    @NamedQuery(name = "LugaAcce.findAll", query = "SELECT l FROM LugaAcce l WHERE l.esta=1"),
    @NamedQuery(name = "LugaAcce.findActivos", query = "SELECT l FROM LugaAcce l where l.esta = 1")})
public class LugaAcce implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_luga_acce")
    private Long codiLugaAcce;
    
    @Size(max = 100)
    @Column(name = "nomb_luga_acce")
    private String nombLugaAcce;
    @Column(name = "fech_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "fech_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechBaja;
    @Column(name = "esta")
    private Integer esta;
    
    /**
     * Método constructor
     */
    public LugaAcce() {
    }
    
    /**
     * Método constructor
     * @param códio registro
     */
    public LugaAcce(Long codiLugaAcce) {
        this.codiLugaAcce = this.codiLugaAcce;
    }

    /**
     * Método para obtener valor
     * @return Entero código lugar
     */
    public Long getCodiLugaAcce() {
        return codiLugaAcce;
    }

    /**
     * Método para fijar valor a una variable del objeto
     * @param Entero código lugar
     */
    public void setCodiLugaAcce(Long codiLugaAcce) {
        this.codiLugaAcce = codiLugaAcce;
    }

    /**
     * Método para obtener valor
     * @return String nombre lugar
     */
    public String getNombLugaAcce() {
        return nombLugaAcce;
    }

    /**
     * Método para fijar valor a una variable del objeto
     * @param String nombre lugar
     */
    public void setNombLugaAcce(String nombLugaAcce) {
        this.nombLugaAcce = nombLugaAcce;
    }

    /**
     * Método para obtener valor
     * @return Date fecha alta lugar
     */
    public Date getFechAlta() {
        return fechAlta;
    }

    /**
     * Método para fijar valor a una variable del objeto
     * @param Date fecha Alta
     */
    public void setFechAlta(Date fechAlta) {
        this.fechAlta = fechAlta;
    }
    
    /**
     * Método para obtener valor
     * @return Date fecha baja lugar
     */
    public Date getFechBaja() {
        return fechBaja;
    }

    /**
     * Método para fijar valor a una variable del objeto
     * @param Date fecha de baja
     */
    public void setFechBaja(Date fechBaja) {
        this.fechBaja = fechBaja;
    }

    /**
     * Método para obtener valor
     * @return Entero estado
     */
    public Integer getEsta() {
        return esta;
    }

    /**
     * Método para fijar valor a una variable del objeto
     * @param Integer estado
     */
    public void setEsta(Integer esta) {
        this.esta = esta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiLugaAcce != null ? codiLugaAcce.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LugaAcce)) {
            return false;
        }
        LugaAcce other = (LugaAcce) object;
        if ((this.codiLugaAcce == null && other.codiLugaAcce != null) || (this.codiLugaAcce != null && !this.codiLugaAcce.equals(other.codiLugaAcce))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.LugaAcce[ codiLugaAcce=" + codiLugaAcce + " ]";
    }
    
}
