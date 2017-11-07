
package org.conexion;


import java.sql.*;

/**
 * Nombre de la clase:Conexion
 * Fecha:13/10/2017
 * Version:1.0
 * Copyright:UEFA
 * @author  Ale Gomez
 */
public class Conexion 
{
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    
    public void conectar() throws Exception
    {
        try /*creo que si XD ya lo areglare calmaod moreno XD perame Ok Si xq intente c*/
        {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/MultiSoccer?user=postgres&password=Admin");
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void desconectar()throws Exception
    {
        try 
        {
            if (con!=null) 
            {
                if (con.isClosed()==false) 
                {
                    con.close();
                }
            }
        } catch (Exception e) 
        {
            throw e;
        }
    }
}
