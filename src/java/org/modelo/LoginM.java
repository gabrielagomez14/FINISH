
package org.modelo;
import java.sql.*;
import org.conexion.Conexion;

/**
 * Nombre de la clase:LoginM
 Fecha:13/10/2017
 Version:1.0
 Copyright:UEFA
 * @author Ale Gomez
 */
public class LoginM  extends Conexion
{
    private PreparedStatement pre;
    private String sql;
    private ResultSet res;
    public int login(String usuario ,String clave)throws Exception
    {
        int nivel =0;
        try 
        {
            this.conectar();
            sql="select nivel from usuarios where username='"+usuario+"' and clave='"+clave+"'";
            pre=this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                nivel=res.getInt(1);
            }
        } catch (Exception e) 
        {
            throw e;
        }
        return nivel;
    }
}
