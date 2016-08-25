/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.sql.Blob;

public class EquiComp {
    private int codi_equi_comp;
    private String nomb_equi_comb;
    private LugaAcce codi_luga_acce;
    private String mac_addr_equi_comp;
    private String ip_addr_equi_comp;
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
    

    public String getIp_addr_equi_comp() {
        return ip_addr_equi_comp;
    }

    public void setIp_addr_equi_comp(String ip_addr_equi_comp) {
        this.ip_addr_equi_comp = ip_addr_equi_comp;
    }
    

    public String getMac_addr_equi_comp() {
        return mac_addr_equi_comp;
    }

    public void setMac_addr_equi_comp(String mac_addr_equi_comp) {
        this.mac_addr_equi_comp = mac_addr_equi_comp;
    }    

    public LugaAcce getCodi_luga_acce() {
        return codi_luga_acce;
    }

    public void setCodi_luga_acce(LugaAcce codi_luga_acce) {
        this.codi_luga_acce = codi_luga_acce;
    }
    

    public String getNomb_equi_comb() {
        return nomb_equi_comb;
    }

    public void setNomb_equi_comb(String nomb_equi_comb) {
        this.nomb_equi_comb = nomb_equi_comb;
    }
    

    public int getCodi_equi_comp() {
        return codi_equi_comp;
    }

    public void setCodi_equi_comp(int codi_equi_comp) {
        this.codi_equi_comp = codi_equi_comp;
    }

    public EquiComp() {
    }

    public EquiComp(int codi_equi_comp, String nomb_equi_comb, LugaAcce codi_luga_acce, String mac_addr_equi_comp, String ip_addr_equi_comp, String fech_alta, String fech_baja, Blob esta) {
        this.codi_equi_comp = codi_equi_comp;
        this.nomb_equi_comb = nomb_equi_comb;
        this.codi_luga_acce = codi_luga_acce;
        this.mac_addr_equi_comp = mac_addr_equi_comp;
        this.ip_addr_equi_comp = ip_addr_equi_comp;
        this.fech_alta = fech_alta;
        this.fech_baja = fech_baja;
        this.esta = esta;
    }

    
    
    
    
}
