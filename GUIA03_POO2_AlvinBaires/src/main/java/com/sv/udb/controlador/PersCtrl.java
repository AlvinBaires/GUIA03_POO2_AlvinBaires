/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.*;
import com.sv.udb.recursos.Conexion;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Blob;
import java.util.UUID;
import javax.swing.JOptionPane;

public class PersCtrl {
    
    public static int codigoPersona;
        
    public boolean guardar(Pers objeto, InputStream inputStream)
    {
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try
        {
            String Consulta="SELECT * FROM pers WHERE dui_pers = ? or nit_pers = ?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, objeto.getDui_pers());   
            cmd.setString(2, objeto.getNit_pers());   
            ResultSet rs = cmd.executeQuery();
            if(rs.last())
            {
                return false;
            }
            else
            {
                Consulta = "INSERT INTO `pers` (`CODI_PERS`, `NOMB_PERS`, `APEL_PERS`, `FOTO_PERS`, `CODI_TIPO_PERS`, `GENE_PERS`, `FECH_NACI_PERS`, `DUI_PERS`, `NIT_PERS`, `TIPO_SANG_PERS`, `CODI_UBIC_GEOG`, `FECH_ALTA`, `FECH_BAJA`, `ESTA`) SELECT (select (max(CODI_PERS)+1)), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), null, 1 FROM `pers`";
                cmd = cn.prepareStatement(Consulta);
                cmd.setString(1, objeto.getNomb_pers());
                cmd.setString(2, objeto.getApel_pers());
                cmd.setBinaryStream(3, inputStream, inputStream.available());;
                cmd.setInt(4, objeto.getCodi_tipo_pers().getCodi_tipo_pers());
                cmd.setString(5, objeto.getGene_pers());
                cmd.setString(6, objeto.getFech_naci_pers());
                cmd.setString(7, objeto.getDui_pers());
                cmd.setString(8, objeto.getNit_pers());
                cmd.setString(9, objeto.getTipo_sang_pers());
                cmd.setInt(10, objeto.getCodi_ubic_geog().getCODI_UBIC_GEOG());
                cmd.executeUpdate();
                resp=true;
            }
            return true;
        }
        catch(Exception err)
        {
            System.out.println(err.getMessage());
            return false;
        }
    }
    
    public List<Pers> consTodo()
    {
        List<Pers> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "SELECT * FROM pers inner join tipo_pers on tipo_pers.CODI_TIPO_PERS = pers.CODI_TIPO_PERS inner join ubic_geog on pers.CODI_UBIC_GEOG = ubic_geog.CODI_UBIC_GEOG";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Pers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBlob(4), new TipoPers(rs.getInt(5), rs.getString(16), rs.getString(17), rs.getString(18), rs.getBlob(19)), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), new UbicGeog(rs.getInt(20), rs.getString(21), rs.getInt(22), rs.getString(23), rs.getString(24), rs.getBlob(25)), rs.getString(12), rs.getString(13), rs.getInt(14)));
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
}
