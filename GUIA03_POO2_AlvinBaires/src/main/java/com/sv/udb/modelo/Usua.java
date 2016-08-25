/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.sql.Blob;

public class Usua {
    private int codi_usua;
    private Pers codi_pers;
    private String acce_usua;
    private String cont_usua;
    private String fech_camb_clav_usua;
    private String fech_alta;
    private String fech_baja;
    private Blob esta;

    public Blob getEsta() {
        return esta;
    }

    public void setEsta(Blob esta) {
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

    public String getFech_camb_clav_usua() {
        return fech_camb_clav_usua;
    }

    public void setFech_camb_clav_usua(String fech_camb_clav_usua) {
        this.fech_camb_clav_usua = fech_camb_clav_usua;
    }

    public String getCont_usua() {
        return cont_usua;
    }

    public void setCont_usua(String cont_usua) {
        this.cont_usua = cont_usua;
    }

    public String getAcce_usua() {
        return acce_usua;
    }

    public void setAcce_usua(String acce_usua) {
        this.acce_usua = acce_usua;
    }

    public Pers getCodi_pers() {
        return codi_pers;
    }

    public void setCodi_pers(Pers codi_pers) {
        this.codi_pers = codi_pers;
    }

    public int getCodi_usua() {
        return codi_usua;
    }

    public void setCodi_usua(int codi_usua) {
        this.codi_usua = codi_usua;
    }

    public Usua() {
    }

    public Usua(int codi_usua, Pers codi_pers, String acce_usua, String cont_usua, String fech_camb_clav_usua, String fech_alta, String fech_baja, Blob esta) {
        this.codi_usua = codi_usua;
        this.codi_pers = codi_pers;
        this.acce_usua = acce_usua;
        this.cont_usua = cont_usua;
        this.fech_camb_clav_usua = fech_camb_clav_usua;
        this.fech_alta = fech_alta;
        this.fech_baja = fech_baja;
        this.esta = esta;
    }
    
    
}
