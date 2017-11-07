
package org.modelo;

import java.util.*;
import java.sql.*;
import org.conexion.Conexion;

/**
 * Nombre de la clase:CrudJugador
 * Fecha:17/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class CrudJugador extends Conexion
{
    private PreparedStatement pre;
    private ResultSet res;
    private String sql;
    public List<Jugador>view()throws Exception
    {
        List<Jugador>lju=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select * from jugador";
            pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Jugador ju=new Jugador();
                ju.setIdJugador(res.getInt("idjugador"));
                ju.setNombre(res.getString("nombre"));
                ju.setDui(res.getString("dui"));
                ju.setPosicion(res.getString("posicion"));
                ju.setPais(res.getString("pais"));
                ju.setTelefono(res.getString("telefono"));
                ju.setEmail(res.getString("correo"));
                lju.add(ju);
            }
        } catch (Exception e) 
        {
            throw e;
        }
        return lju;
    }
    
    
    public void add(Jugador ju)throws Exception
    {
        try 
        {
            this.conectar();
            sql="INSERT INTO public.jugador(\n"
            +"idjugador, nombre, dui, posicion, pais, telefono, correo)\n"
            +"VALUES (?, ?, ?, ?, ?, ?, ?);";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, ju.getIdJugador());
            pre.setString(2, ju.getNombre());
            pre.setString(3, ju.getDui());
            pre.setString(4, ju.getPosicion());
            pre.setString(5, ju.getPais());
            pre.setString(6, ju.getTelefono());
            pre.setString(7, ju.getEmail());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void update(Jugador ju)throws Exception
    {
        try 
        {
            this.conectar();
            sql="UPDATE public.jugador\n" 
            +"SET nombre=?, dui=?, posicion=?, pais=?, telefono=?, correo=?\n" 
            +"	WHERE idjugador=?";
            pre=this.getCon().prepareStatement(sql);
            pre.setString(1, ju.getNombre());
            pre.setString(2, ju.getDui());
            pre.setString(3, ju.getPosicion());
            pre.setString(4, ju.getPais());
            pre.setString(5, ju.getTelefono());
            pre.setString(6, ju.getEmail());
            pre.setInt(7, ju.getIdJugador());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void delete(Jugador ju)throws Exception
    {
        try 
        {
            this.conectar();
            sql="DELETE FROM public.jugador\n" +"WHERE idjugador=?";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, ju.getIdJugador());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public int contarJu(Object obj)throws Exception
    {
        int cont=0;
        try 
        {
            this.conectar();
            sql="select count(*) as cantidad from jugador";
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
