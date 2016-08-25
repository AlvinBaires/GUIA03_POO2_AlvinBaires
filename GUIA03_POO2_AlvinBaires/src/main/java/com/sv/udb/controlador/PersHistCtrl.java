/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.*;
import com.sv.udb.recursos.Conexion;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersHistCtrl {
    
    
    
    public boolean guardar(PersHist objeto, InputStream inputStream)
    {
        boolean resp=false;
        try
        {
            Connection cn = new Conexion().getConn();
            String Consulta = "INSERT INTO `pers_hist` (`CODI_PERS_HIST`, `CODI_PERS`, `NOMB_PERS`, `APEL_PERS`, `FOTO_PERS`, `CODI_TIPO_PERS`, `CODI_UBIC_GEOG`, `FECH_ALTA`, `FECH_BAJA`, `ESTA`) VALUES (?, ?, ?, ?, ?, ?, ?, now(), NULL, ?)";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, getUltimoCodigo()+1);
            cmd.setInt(2, getPers());
            cmd.setString(3, objeto.getNomb_pers());
            cmd.setString(4, objeto.getApel_pers());
            cmd.setBinaryStream(5, inputStream, inputStream.available());;
            cmd.setInt(6, objeto.getCodi_tipo_pers().getCodi_tipo_pers());
            cmd.setInt(7, objeto.getCodi_ubic_geog().getCODI_UBIC_GEOG());
            cmd.setInt(8, objeto.getEsta());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception err)
        {
            System.out.println(err.getMessage());
            return false;
        }
        return resp;
    }
    
    
    
    public int getPers()
    {
        int resp=0;
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "SELECT MAX(CODI_PERS) FROM PERS";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp=rs.getInt(1);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(cn != null)
            {
                try
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }     
        return resp;
    }
    
    public int getUltimoCodigo()
    {
        int resp=0;
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "SELECT MAX(CODI_PERS_HIST) FROM PERS_HIST";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp=rs.getInt(1);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(cn != null)
            {
                try
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }     
        return resp;
    }
    
    public List<PersHist> consTodo()
    {
        List<PersHist> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "select * from pers_hist, pers, tipo_pers, ubic_geog where pers.CODI_PERS = pers_hist.CODI_PERS and tipo_pers.CODI_TIPO_PERS = pers_hist.CODI_TIPO_PERS and ubic_geog.CODI_UBIC_GEOG = pers_hist.CODI_UBIC_GEOG and pers_hist.CODI_PERS_HIST=(select max(p.CODI_PERS_HIST) from pers_hist p where p.CODI_PERS = pers.CODI_PERS) order by pers.codi_pers";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                PersHist objePersHist = new PersHist();
                Pers objePers = new Pers();
                TipoPers objeTipoPers = new TipoPers();
                UbicGeog objeUbicGeog = new UbicGeog();
                
                objePers.setCodi_pers(rs.getInt("pers.codi_Pers"));
                objePers.setNomb_pers(rs.getString("pers.nomb_pers"));
                objePers.setApel_pers(rs.getString("pers.apel_pers"));
                objePers.setFoto_pers(rs.getBlob("pers.foto_pers"));
                objePers.setCodi_tipo_pers(new TipoPers(rs.getInt("pers.codi_tipo_pers"),null,null, null,null));
                objePers.setGene_pers(rs.getString("pers.gene_pers"));
                objePers.setFech_naci_pers(rs.getString("pers.fech_naci_pers"));
                objePers.setDui_pers(rs.getString("pers.dui_pers"));
                objePers.setNit_pers(rs.getString("pers.nit_pers"));
                objePers.setTipo_sang_pers(rs.getString("pers.tipo_sang_pers"));
                objePers.setCodi_ubic_geog(new UbicGeog(rs.getInt("pers.codi_ubic_geog"),null,1,null,null,null));
                objePers.setFech_alta(rs.getString("pers.fech_alta"));
                objePers.setFech_baja(rs.getString("pers.fech_baja"));
                objePers.setEsta(rs.getInt("pers.esta"));
                    
                
                objePersHist.setCodi_pres_hist(rs.getInt("pers_hist.codi_pers_hist"));                
                objePersHist.setNomb_pers(rs.getString("pers_hist.nomb_pers"));
                objePersHist.setApel_pers(rs.getString("pers_hist.apel_pers"));
                objePersHist.setFoto_pers(rs.getBlob("pers_hist.foto_pers"));
                objePersHist.setCodi_pers(objePers);
                
                objeTipoPers.setCodi_tipo_pers(rs.getInt("tipo_pers.codi_tipo_pers"));
                objeTipoPers.setNomb_tipo_pers(rs.getString("tipo_pers.nomb_tipo_pers"));
                objePersHist.setCodi_tipo_pers(objeTipoPers);
                
                objeUbicGeog.setCODI_UBIC_GEOG(rs.getInt("ubic_geog.codi_ubic_geog"));
                objeUbicGeog.setNOMB_UBIC_GEOG(rs.getString("ubic_geog.nomb_ubic_geog"));
                objeUbicGeog.setCODI_UBIC_GEOG_SUPE(rs.getInt("ubic_geog.codi_ubic_geog_supe"));
                objePersHist.setCodi_ubic_geog(objeUbicGeog);
                
                objePersHist.setFech_alta("pers_hist.fech_alta");
                objePersHist.setFech_baja("pers_hist.fech_baja");
                objePersHist.setEsta(rs.getInt("pers_hist.esta"));
                
                resp.add(objePersHist);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(cn != null)
            {
                try
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        return resp;
    }
    
    public PersHist consRegistro(int codigoPersona)
    {
        PersHist resp = null;
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "select *, DATE_FORMAT(fech_naci_pers,'%Y-%m-%d') AS fechaConvertida from pers_hist, pers, tipo_pers, ubic_geog where pers.CODI_PERS = pers_hist.CODI_PERS and tipo_pers.CODI_TIPO_PERS = pers_hist.CODI_TIPO_PERS and ubic_geog.CODI_UBIC_GEOG = pers_hist.CODI_UBIC_GEOG and pers_hist.CODI_PERS_HIST=(select max(p.CODI_PERS_HIST) from pers_hist p where p.CODI_PERS = pers.CODI_PERS) AND pers.codi_pers="+codigoPersona;
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = new PersHist();
                PersHist objePersHist = new PersHist();
                Pers objePers = new Pers();
                TipoPers objeTipoPers = new TipoPers();
                UbicGeog objeUbicGeog = new UbicGeog();
                
                objePers.setCodi_pers(rs.getInt("pers.codi_Pers"));
                objePers.setNomb_pers(rs.getString("pers.nomb_pers"));
                objePers.setApel_pers(rs.getString("pers.apel_pers"));
                objePers.setFoto_pers(rs.getBlob("pers.foto_pers"));
                objePers.setCodi_tipo_pers(new TipoPers(rs.getInt("pers.codi_tipo_pers"),null,null, null,null));
                objePers.setGene_pers(rs.getString("pers.gene_pers"));
                objePers.setFech_naci_pers(rs.getString("fechaConvertida"));
                objePers.setDui_pers(rs.getString("pers.dui_pers"));
                objePers.setNit_pers(rs.getString("pers.nit_pers"));
                objePers.setTipo_sang_pers(rs.getString("pers.tipo_sang_pers"));
                objePers.setCodi_ubic_geog(new UbicGeog(rs.getInt("pers.codi_ubic_geog"),null,1,null,null,null));
                objePers.setFech_alta(rs.getString("pers.fech_alta"));
                objePers.setFech_baja(rs.getString("pers.fech_baja"));
                objePers.setEsta(rs.getInt("pers.esta"));
                    
                
                objePersHist.setCodi_pres_hist(rs.getInt("pers_hist.codi_pers_hist"));                
                objePersHist.setNomb_pers(rs.getString("pers_hist.nomb_pers"));
                objePersHist.setApel_pers(rs.getString("pers_hist.apel_pers"));
                objePersHist.setFoto_pers(rs.getBlob("pers_hist.foto_pers"));
                objePersHist.setCodi_pers(objePers);
                
                objeTipoPers.setCodi_tipo_pers(rs.getInt("tipo_pers.codi_tipo_pers"));
                objeTipoPers.setNomb_tipo_pers(rs.getString("tipo_pers.nomb_tipo_pers"));
                objePersHist.setCodi_tipo_pers(objeTipoPers);
                
                objeUbicGeog.setCODI_UBIC_GEOG(rs.getInt("ubic_geog.codi_ubic_geog"));
                objeUbicGeog.setNOMB_UBIC_GEOG(rs.getString("ubic_geog.nomb_ubic_geog"));
                objeUbicGeog.setCODI_UBIC_GEOG_SUPE(rs.getInt("ubic_geog.codi_ubic_geog_supe"));
                objePersHist.setCodi_ubic_geog(objeUbicGeog);
                
                objePersHist.setFech_alta("pers_hist.fech_alta");
                objePersHist.setFech_baja("pers_hist.fech_baja");
                objePersHist.setEsta(rs.getInt("pers_hist.esta"));
                resp=objePersHist;
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(cn != null)
            {
                try
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        return resp;
    }   
    
    public boolean Modificar(PersHist objeto, InputStream inputStream)
    {
        boolean resp=false;
        if(inputStream!=null)
        {            
            try
            {
                Connection cn = new Conexion().getConn();
                String Consulta = "UPDATE pers set ESTA = 0, FECH_BAJA= now() where CODI_PERS = ?";
                PreparedStatement cmd = cn.prepareStatement(Consulta);
                cmd = cn.prepareStatement(Consulta);
                cmd.setInt(1, objeto.getCodi_pers().getCodi_pers());
                cmd.executeUpdate();
                
                
                Consulta = "UPDATE pers_hist set esta = 0, fech_baja= now() where codi_pers_hist = ?";
                cmd = cn.prepareStatement(Consulta);
                cmd.setInt(1, objeto.getCodi_pres_hist());
                cmd.executeUpdate();
                Consulta = "INSERT INTO `pers_hist` (`CODI_PERS_HIST`, `CODI_PERS`, `NOMB_PERS`, `APEL_PERS`, `FOTO_PERS`, `CODI_TIPO_PERS`, `CODI_UBIC_GEOG`, `FECH_ALTA`, `FECH_BAJA`, `ESTA`) VALUES (?, ?, ?, ?, ?, ?, ?, now(), NULL, ?)";
                cmd = cn.prepareStatement(Consulta);
                cmd.setInt(1, getUltimoCodigo()+1);
                
                cmd.setInt(2, objeto.getCodi_pers().getCodi_pers());
                cmd.setString(3, objeto.getNomb_pers());
                cmd.setString(4, objeto.getApel_pers());
                cmd.setBinaryStream(5, inputStream, inputStream.available());;
                cmd.setInt(6, objeto.getCodi_tipo_pers().getCodi_tipo_pers());
                cmd.setInt(7, objeto.getCodi_ubic_geog().getCODI_UBIC_GEOG());
                cmd.setInt(8, objeto.getEsta());
                cmd.executeUpdate();   
                
                resp=true;
            }
            catch(Exception err)
            {
                System.out.println(err.getMessage());
                return false;
            }            
        }
        return resp;
    }
}
