/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.sql.Blob;

/**
 *
 * @author Alvin
 */
public class UnidOrga {
    int CODI_UNID_ORGA;
    String NOMB_UNID, SIGL_UNID_ORGA;
    int CODI_UNID_ORGA_SUPE;
    String DIRE_UNID_ORGA, TELE_UNID_ORGA, FAX_UNID_ORGA, EMAI_UNID_ORGA,CONT_UNID_ORGA;
    UbicGeog CODI_UBIC_GEO;
    String FECH_ALTA, FECH_BAJA;
    private Blob esta;

    public Blob getEsta() {
        return esta;
    }

    public void setEsta(Blob esta) {
        this.esta = esta;
    }

    public UnidOrga()
    {
        
    }

    public UnidOrga(int CODI_UNID_ORGA, String NOMB_UNID, String SIGL_UNID_ORGA, int CODI_UNID_ORGA_SUPE, String DIRE_UNID_ORGA, String TELE_UNID_ORGA, String FAX_UNID_ORGA, String EMAI_UNID_ORGA, String CONT_UNID_ORGA, UbicGeog CODI_UBIC_GEO, String FECH_ALTA, String FECH_BAJA, Blob esta) {
        this.CODI_UNID_ORGA = CODI_UNID_ORGA;
        this.NOMB_UNID = NOMB_UNID;
        this.SIGL_UNID_ORGA = SIGL_UNID_ORGA;
        this.CODI_UNID_ORGA_SUPE = CODI_UNID_ORGA_SUPE;
        this.DIRE_UNID_ORGA = DIRE_UNID_ORGA;
        this.TELE_UNID_ORGA = TELE_UNID_ORGA;
        this.FAX_UNID_ORGA = FAX_UNID_ORGA;
        this.EMAI_UNID_ORGA = EMAI_UNID_ORGA;
        this.CONT_UNID_ORGA = CONT_UNID_ORGA;
        this.CODI_UBIC_GEO = CODI_UBIC_GEO;
        this.FECH_ALTA = FECH_ALTA;
        this.FECH_BAJA = FECH_BAJA;
        this.esta = esta;
    }
    
    
    
    public int getCODI_UNID_ORGA() {
        return CODI_UNID_ORGA;
    }

    public void setCODI_UNID_ORGA(int CODI_UNID_ORGA) {
        this.CODI_UNID_ORGA = CODI_UNID_ORGA;
    }

    public String getNOMB_UNID() {
        return NOMB_UNID;
    }

    public void setNOMB_UNID(String NOMB_UNID) {
        this.NOMB_UNID = NOMB_UNID;
    }

    public String getSIGL_UNID_ORGA() {
        return SIGL_UNID_ORGA;
    }

    public void setSIGL_UNID_ORGA(String SIGL_UNID_ORGA) {
        this.SIGL_UNID_ORGA = SIGL_UNID_ORGA;
    }

    public int getCODI_UNID_ORGA_SUPE() {
        return CODI_UNID_ORGA_SUPE;
    }

    public void setCODI_UNID_ORGA_SUPE(int CODI_UNID_ORGA_SUPE) {
        this.CODI_UNID_ORGA_SUPE = CODI_UNID_ORGA_SUPE;
    }

    public String getDIRE_UNID_ORGA() {
        return DIRE_UNID_ORGA;
    }

    public void setDIRE_UNID_ORGA(String DIRE_UNID_ORGA) {
        this.DIRE_UNID_ORGA = DIRE_UNID_ORGA;
    }

    public String getTELE_UNID_ORGA() {
        return TELE_UNID_ORGA;
    }

    public void setTELE_UNID_ORGA(String TELE_UNID_ORGA) {
        this.TELE_UNID_ORGA = TELE_UNID_ORGA;
    }

    public String getFAX_UNID_ORGA() {
        return FAX_UNID_ORGA;
    }

    public void setFAX_UNID_ORGA(String FAX_UNID_ORGA) {
        this.FAX_UNID_ORGA = FAX_UNID_ORGA;
    }

    public String getEMAI_UNID_ORGA() {
        return EMAI_UNID_ORGA;
    }

    public void setEMAI_UNID_ORGA(String EMAI_UNID_ORGA) {
        this.EMAI_UNID_ORGA = EMAI_UNID_ORGA;
    }

    public String getCONT_UNID_ORGA() {
        return CONT_UNID_ORGA;
    }

    public void setCONT_UNID_ORGA(String CONT_UNID_ORGA) {
        this.CONT_UNID_ORGA = CONT_UNID_ORGA;
    }

    public UbicGeog getCODI_UBIC_GEO() {
        return CODI_UBIC_GEO;
    }

    public void setCODI_UBIC_GEO(UbicGeog CODI_UBIC_GEO) {
        this.CODI_UBIC_GEO = CODI_UBIC_GEO;
    }

    public String getFECH_ALTA() {
        return FECH_ALTA;
    }

    public void setFECH_ALTA(String FECH_ALTA) {
        this.FECH_ALTA = FECH_ALTA;
    }

    public String getFECH_BAJA() {
        return FECH_BAJA;
    }

    public void setFECH_BAJA(String FECH_BAJA) {
        this.FECH_BAJA = FECH_BAJA;
    }
    
    
}
