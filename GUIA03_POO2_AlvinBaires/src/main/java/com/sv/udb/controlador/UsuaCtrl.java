/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.*;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuaCtrl {
    public List<Usua> consTodo()
    {
        List<Usua> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "select * from usua inner join pers on usua.CODI_PERS = pers.CODI_PERS";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                    resp.add(new Usua(rs.getInt(1), new Pers(rs.getInt(2), rs.getString(10), rs.getString(11), rs.getBlob(12), new TipoPers(rs.getInt(13), null, null, null, null), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), new UbicGeog(rs.getInt(19), null, 0, null, null, null), rs.getString(20), rs.getString(21), rs.getInt(22)), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBlob(8)));
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
