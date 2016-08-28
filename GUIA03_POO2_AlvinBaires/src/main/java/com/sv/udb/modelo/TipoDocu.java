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
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "tipo_docu", catalog = "rceron_poo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocu.findAll", query = "SELECT t FROM TipoDocu t WHERE t.esta=1"),
    @NamedQuery(name = "TipoDocu.findByCodiTipoDocu", query = "SELECT t FROM TipoDocu t WHERE t.codiTipoDocu = :codiTipoDocu"),
    @NamedQuery(name = "TipoDocu.findByNombTipoDocu", query = "SELECT t FROM TipoDocu t WHERE t.nombTipoDocu = :nombTipoDocu"),
    @NamedQuery(name = "TipoDocu.findByFechAlta", query = "SELECT t FROM TipoDocu t WHERE t.fechAlta = :fechAlta"),
    @NamedQuery(name = "TipoDocu.findByFechBaja", query = "SELECT t FROM TipoDocu t WHERE t.fechBaja = :fechBaja"),
    @NamedQuery(name = "TipoDocu.findByEsta", query = "SELECT t FROM TipoDocu t WHERE t.esta = :esta")})
public class TipoDocu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_tipo_docu")
    private Long codiTipoDocu;
    @Size(max = 50)
    @Column(name = "nomb_tipo_docu")
    private String nombTipoDocu;
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
    public TipoDocu() {
    }

    /**
     * Método constructor
     * @param codiTipoDocu código del Registor
     */
    public TipoDocu(Long codiTipoDocu) {
        this.codiTipoDocu = codiTipoDocu;
    }

    /**
     * Método que obtiene un valor
     * @return Long código del Registro
     */
    public Long getCodiTipoDocu() {
        return codiTipoDocu;
    }

    /**
     * Método que fija un valor
     * @param codiTipoDocu código del Registor
     */
    public void setCodiTipoDocu(Long codiTipoDocu) {
        this.codiTipoDocu = codiTipoDocu;
    }

    /**
     * Método que obtiene un valor
     * @return String Nombre del Tipo Docu
     */
    public String getNombTipoDocu() {
        return nombTipoDocu;
    }

    /**
     * Método que fija un valor
     * @param nombTipODocu nombre del tipo documento
     */
    public void setNombTipoDocu(String nombTipoDocu) {
        this.nombTipoDocu = nombTipoDocu;
    }

    /**
     * Método que obtiene un valor
     * @return Date Fecha Alta
     */
    public Date getFechAlta() {
        return fechAlta;
    }

    /**
     * Método que fija un valor
     * @param fechAlta Fecha de Alta
     */
    public void setFechAlta(Date fechAlta) {
        this.fechAlta = fechAlta;
    }

    /**
     * Método que obtiene un valor
     * @return Date Fecha Baja
     */
    public Date getFechBaja() {
        return fechBaja;
    }

    /**
     * Método que fija un valor
     * @param fechBaja Fecha de Baja
     */
    public void setFechBaja(Date fechBaja) {
        this.fechBaja = fechBaja;
    }

    /**
     * Método que obtiene un valor
     * @return Integer estado
     */
    public Integer getEsta() {
        return esta;
    }

    /**
     * Método que fija un valor
     * @param esta Estado
     */
    public void setEsta(Integer esta) {
        this.esta = esta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiTipoDocu != null ? codiTipoDocu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocu)) {
            return false;
        }
        TipoDocu other = (TipoDocu) object;
        if ((this.codiTipoDocu == null && other.codiTipoDocu != null) || (this.codiTipoDocu != null && !this.codiTipoDocu.equals(other.codiTipoDocu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.TipoDocu[ codiTipoDocu=" + codiTipoDocu + " ]";
    }
    
}
