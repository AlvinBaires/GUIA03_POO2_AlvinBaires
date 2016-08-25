/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.sql.Blob;

public class TipoGafe {
    private int codi_tipo_gafe;
    private String nomb_tipo_gafe;
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

    public String getNomb_tipo_gafe() {
        return nomb_tipo_gafe;
    }

    public void setNomb_tipo_gafe(String nomb_tipo_gafe) {
        this.nomb_tipo_gafe = nomb_tipo_gafe;
    }

    public int getCodi_tipo_gafe() {
        return codi_tipo_gafe;
    }

    public void setCodi_tipo_gafe(int codi_tipo_gafe) {
        this.codi_tipo_gafe = codi_tipo_gafe;
    }

    public TipoGafe() {
    }

    public TipoGafe(int codi_tipo_gafe, String nomb_tipo_gafe, String fech_alta, String fech_baja, Blob esta) {
        this.codi_tipo_gafe = codi_tipo_gafe;
        this.nomb_tipo_gafe = nomb_tipo_gafe;
        this.fech_alta = fech_alta;
        this.fech_baja = fech_baja;
        this.esta = esta;
    }
    
    
}
