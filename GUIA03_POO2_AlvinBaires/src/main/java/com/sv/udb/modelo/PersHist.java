/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.sql.Blob;

public class PersHist {
    private int codi_pres_hist;
    private Pers codi_pers;
    private String nomb_pers;
    private String apel_pers;
    private Blob foto_pers; 
    private TipoPers codi_tipo_pers;
    private UbicGeog codi_ubic_geog;
    private String fech_alta;
    private String fech_baja;
    private int esta;

    public Blob getFoto_pers() {
        return foto_pers;
    }

    public void setFoto_pers(Blob foto_pers) {
        this.foto_pers = foto_pers;
    }

    public int getEsta() {
        return esta;
    }

    public void setEsta(int esta) {
        this.esta = esta;
    }

   

    public String getFech_baja() {
        return fech_baja;
    }

    public void setFech_baja(String fech_baja) {
        this.fech_baja = fech_baja;
    }

    public String getFech_alta() {
        return fech_alta;
    }

    public void setFech_alta(String fech_alta) {
        this.fech_alta = fech_alta;
    }

    public UbicGeog getCodi_ubic_geog() {
        return codi_ubic_geog;
    }

    public void setCodi_ubic_geog(UbicGeog codi_ubic_geog) {
        this.codi_ubic_geog = codi_ubic_geog;
    }

    public TipoPers getCodi_tipo_pers() {
        return codi_tipo_pers;
    }

    public void setCodi_tipo_pers(TipoPers codi_tipo_pers) {
        this.codi_tipo_pers = codi_tipo_pers;
    }
        
    public String getNomb_pers() {
        return nomb_pers;
    }

    public void setNomb_pers(String nomb_pers) {
        this.nomb_pers = nomb_pers;
    }
    
    public String getApel_pers() {
        return apel_pers;
    }

    public void setApel_pers(String apel_pers) {
        this.apel_pers = apel_pers;
    }

    public Pers getCodi_pers() {
        return codi_pers;
    }

    public void setCodi_pers(Pers codi_pers) {
        this.codi_pers = codi_pers;
    }
    

    public int getCodi_pres_hist() {
        return codi_pres_hist;
    }

    public void setCodi_pres_hist(int codi_pres_hist) {
        this.codi_pres_hist = codi_pres_hist;
    }

    public PersHist() {
    }

    public PersHist(int codi_pres_hist, Pers codi_pers, String nomb_pers, String apel_pers, Blob foto_pers, TipoPers codi_tipo_pers, UbicGeog codi_ubic_geog, String fech_alta, String fech_baja, int esta) {
        this.codi_pres_hist = codi_pres_hist;
        this.codi_pers = codi_pers;
        this.nomb_pers = nomb_pers;
        this.apel_pers = apel_pers;
        this.foto_pers = foto_pers;
        this.codi_tipo_pers = codi_tipo_pers;
        this.codi_ubic_geog = codi_ubic_geog;
        this.fech_alta = fech_alta;
        this.fech_baja = fech_baja;
        this.esta = esta;
    }

    
    
    
}
