/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.sql.Blob;

public class Visi {
    private int codi_visi;
    private Usua codi_usua;
    private Pers codi_pers;
    private int codi_pers_visi;
    private UnidOrga codi_unid_orga_visi;
    private TipoDocu codi_tipo_docu;
    private GafeIden codi_gafe;
    private LugaAcce codi_luga_entr;
    private LugaAcce codi_luga_sali;
    private String fech_hora_entr_visi;
    private String fech_hora_sali_visi;
    private String moti_visi;
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

    public String getMoti_visi() {
        return moti_visi;
    }

    public void setMoti_visi(String moti_visi) {
        this.moti_visi = moti_visi;
    }

    public String getFech_hora_sali_visi() {
        return fech_hora_sali_visi;
    }

    public void setFech_hora_sali_visi(String fech_hora_sali_visi) {
        this.fech_hora_sali_visi = fech_hora_sali_visi;
    }

    public String getFech_hora_entr_visi() {
        return fech_hora_entr_visi;
    }

    public void setFech_hora_entr_visi(String fech_hora_entr_visi) {
        this.fech_hora_entr_visi = fech_hora_entr_visi;
    }

    public LugaAcce getCodi_luga_sali() {
        return codi_luga_sali;
    }

    public void setCodi_luga_sali(LugaAcce codi_luga_sali) {
        this.codi_luga_sali = codi_luga_sali;
    }

    public LugaAcce getCodi_luga_entr() {
        return codi_luga_entr;
    }

    public void setCodi_luga_entr(LugaAcce codi_luga_entr) {
        this.codi_luga_entr = codi_luga_entr;
    }

    public GafeIden getCodi_gafe() {
        return codi_gafe;
    }

    public void setCodi_gafe(GafeIden codi_gafe) {
        this.codi_gafe = codi_gafe;
    }

    public TipoDocu getCodi_tipo_docu() {
        return codi_tipo_docu;
    }

    public void setCodi_tipo_docu(TipoDocu codi_tipo_docu) {
        this.codi_tipo_docu = codi_tipo_docu;
    }

    public UnidOrga getCodi_unid_orga_visi() {
        return codi_unid_orga_visi;
    }

    public void setCodi_unid_orga_visi(UnidOrga codi_unid_orga_visi) {
        this.codi_unid_orga_visi = codi_unid_orga_visi;
    }

    public int getCodi_pers_visi() {
        return codi_pers_visi;
    }

    public void setCodi_pers_visi(int codi_pers_visi) {
        this.codi_pers_visi = codi_pers_visi;
    }

    public Pers getCodi_pers() {
        return codi_pers;
    }

    public void setCodi_pers(Pers codi_pers) {
        this.codi_pers = codi_pers;
    }

    public Usua getCodi_usua() {
        return codi_usua;
    }

    public void setCodi_usua(Usua codi_usua) {
        this.codi_usua = codi_usua;
    }

    public int getCodi_visi() {
        return codi_visi;
    }

    public void setCodi_visi(int codi_visi) {
        this.codi_visi = codi_visi;
    }

    public Visi() {
    }

    public Visi(int codi_visi, Usua codi_usua, Pers codi_pers, int codi_pers_visi, UnidOrga codi_unid_orga_visi, TipoDocu codi_tipo_docu, GafeIden codi_gafe, LugaAcce codi_luga_entr, LugaAcce codi_luga_sali, String fech_hora_entr_visi, String fech_hora_sali_visi, String moti_visi, String fech_alta, String fech_baja, Blob esta) {
        this.codi_visi = codi_visi;
        this.codi_usua = codi_usua;
        this.codi_pers = codi_pers;
        this.codi_pers_visi = codi_pers_visi;
        this.codi_unid_orga_visi = codi_unid_orga_visi;
        this.codi_tipo_docu = codi_tipo_docu;
        this.codi_gafe = codi_gafe;
        this.codi_luga_entr = codi_luga_entr;
        this.codi_luga_sali = codi_luga_sali;
        this.fech_hora_entr_visi = fech_hora_entr_visi;
        this.fech_hora_sali_visi = fech_hora_sali_visi;
        this.moti_visi = moti_visi;
        this.fech_alta = fech_alta;
        this.fech_baja = fech_baja;
        this.esta = esta;
    }
    
    
}
