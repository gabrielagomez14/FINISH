
package org.modelo;

import java.util.*;
import java.sql.*;
import org.conexion.Conexion;

/**
 * Nombre de la clase:CrudUsuario
 * Fecha:17/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class CrudUsuario extends Conexion
{
    private PreparedStatement pre;
    private ResultSet res;
    private String sql;
    public List<Usuarios>view()throws Exception
    {
        List<Usuarios>lus=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select * from usuarios";
            pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Usuarios us= new Usuarios();
                us.setId(res.getInt("id"));
                us.setNombre(res.getString("nombre"));
                us.setApellido(res.getString("apellido"));
                us.setUsername(res.getString("username"));
                us.setClave(res.getString("clave"));
                us.setNivel(res.getInt("nivel"));
                lus.add(us);
            }
        } catch (Exception e) 
        {
            throw e;
        }
        return lus;
    }
    
    
    public void add(Usuarios us)throws Exception
    {
        try 
        {
            this.conectar();
            sql="INSERT INTO public.usuarios(\n" 
            +"id, nombre, apellido, username, clave, nivel)\n" 
            +"VALUES (?, ?, ?, ?, ?, ?);";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, us.getId());
            pre.setString(2, us.getNombre());
            pre.setString(3, us.getApellido());
            pre.setString(4, us.getUsername());
            pre.setString(5, us.getClave());
            pre.setInt(6, us.getNivel());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void update(Usuarios us)throws Exception
    {
        try 
        {
            this.conectar();
            sql="UPDATE public.usuarios\n" 
            +"SET nombre=?, apellido=?, username=?, clave=?, nivel=?\n"
            +"	WHERE id=?";
            pre=this.getCon().prepareStatement(sql);
            pre.setString(1, us.getNombre());
            pre.setString(2, us.getApellido());
            pre.setString(3, us.getUsername());
            pre.setString(4, us.getClave());
            pre.setInt(5, us.getNivel());
            pre.setInt(6, us.getId());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void delete(Usuarios us)throws Exception
    {
        try 
        {
            this.conectar();
            sql="DELETE FROM public.usuarios\n" 
            +"WHERE id=?";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, us.getId());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    public int Contar(Object obj)throws Exception
    {
        int cont=0;
        try 
        {
           this.conectar();
           sql="select count(*) as cantidad from usuarios";
           pre=this.getCon().prepareStatement(sql);
           res=pre.executeQuery();
            while (res.next()) 
            {                
                cont=res.getInt("cantidad")+1;
            }
        } catch (Exception e) 
        {
            throw e;
        }
        return cont;
    }
}
