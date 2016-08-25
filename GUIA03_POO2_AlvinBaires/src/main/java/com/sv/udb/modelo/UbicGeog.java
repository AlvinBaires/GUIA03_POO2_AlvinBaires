/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.sql.Blob;

public class UbicGeog {
    int CODI_UBIC_GEOG;
    String NOMB_UBIC_GEOG;
    int CODI_UBIC_GEOG_SUPE;
    String FECH_ALTA, FECH_BAJA;
    private Blob esta;

    public Blob getEsta() {
        return esta;
    }

    public void setEsta(Blob esta) {
        this.esta = esta;
    }
    
    public UbicGeog()
    {
        
    }

    public UbicGeog(int CODI_UBIC_GEOG, String NOMB_UBIC_GEOG, int CODI_UBIC_GEOG_SUPE, String FECH_ALTA, String FECH_BAJA, Blob esta) {
        this.CODI_UBIC_GEOG = CODI_UBIC_GEOG;
        this.NOMB_UBIC_GEOG = NOMB_UBIC_GEOG;
        this.CODI_UBIC_GEOG_SUPE = CODI_UBIC_GEOG_SUPE;
        this.FECH_ALTA = FECH_ALTA;
        this.FECH_BAJA = FECH_BAJA;
        this.esta = esta;
    }

    
    
    public int getCODI_UBIC_GEOG() {
        return CODI_UBIC_GEOG;
    }

    public void setCODI_UBIC_GEOG(int CODI_UBIC_GEOG) {
        this.CODI_UBIC_GEOG = CODI_UBIC_GEOG;
    }

    public String getNOMB_UBIC_GEOG() {
        return NOMB_UBIC_GEOG;
    }

    public void setNOMB_UBIC_GEOG(String NOMB_UBIC_GEOG) {
        this.NOMB_UBIC_GEOG = NOMB_UBIC_GEOG;
    }

    public int getCODI_UBIC_GEOG_SUPE() {
        return CODI_UBIC_GEOG_SUPE;
    }

    public void setCODI_UBIC_GEOG_SUPE(int CODI_UBIC_GEOG_SUPE) {
        this.CODI_UBIC_GEOG_SUPE = CODI_UBIC_GEOG_SUPE;
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
