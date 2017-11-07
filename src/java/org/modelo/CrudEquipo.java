
package org.modelo;

import java.sql.*;
import java.util.*;
import org.conexion.Conexion;

/**
 * Nombre de la clase:CrudEquipo
 * fecha:17/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class CrudEquipo extends Conexion
{
    private PreparedStatement pre;
    private ResultSet res;
    private String sql;
    public List<Equipo>view()throws Exception
    {
        List<Equipo>leq=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select * from equipo";
            pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Equipo eq=new Equipo();
                eq.setIdEq(res.getInt("idequipo"));
                eq.setNombre(res.getString("nombre"));
                eq.setNumJugadores(res.getInt("numjugadores"));
                eq.setNumAmonestado(res.getInt("numamonestados"));
                eq.setEmail(res.getString("correo"));
                eq.setDireccion(res.getString("direccion"));
                eq.setTipoEq(res.getString("tipoequipo"));
                eq.setTelefono(res.getString("telefono"));
                eq.setCantGoles(res.getInt("cantgoles"));
                eq.setIdEntrenador(res.getInt("identrenador"));
                eq.setIdJugador(res.getInt("idjugador"));
                eq.setPuntaje(res.getInt("puntaje"));
                leq.add(eq);
            }
            
        } catch (Exception e) 
        {
            throw e;
        }
        return leq;
    }
    
    public void add(Equipo eq)throws Exception
    {
        try 
        {
            this.conectar();
            sql="INSERT INTO public.equipo(\n" 
            +"idequipo, nombre, numjugadores, numamonestados, correo, direccion, tipoequipo, telefono, cantgoles, identrenador, idjugador, puntaje)\n"
            +"	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, eq.getIdEq());
            pre.setString(2, eq.getNombre());
            pre.setInt(3, eq.getNumJugadores());
            pre.setInt(4, eq.getNumAmonestado());
            pre.setString(5, eq.getEmail());
            pre.setString(6, eq.getDireccion());
            pre.setString(7, eq.getTipoEq());
            pre.setString(8, eq.getTelefono());
            pre.setInt(9, eq.getCantGoles());
            pre.setInt(10, eq.getIdEntrenador());
            pre.setInt(11, eq.getIdJugador());
            pre.setInt(12, eq.getPuntaje());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void udpate(Equipo eq)throws Exception
    {
        try 
        {
            this.conectar();
            sql="UPDATE public.equipo\n" 
            +"SET nombre=?, numjugadores=?, numamonestados=?, correo=?, direccion=?, tipoequipo=?, telefono=?, cantgoles=?, identrenador=?, idjugador=?, puntaje=?\n" 
            +"WHERE idequipo=?";
            pre=this.getCon().prepareStatement(sql);
            pre.setString(1, eq.getNombre());
            pre.setInt(2, eq.getNumJugadores());
            pre.setInt(3, eq.getNumAmonestado());
            pre.setString(4, eq.getEmail());
            pre.setString(5, eq.getDireccion());
            pre.setString(6, eq.getTipoEq());
            pre.setString(7, eq.getTelefono());
            pre.setInt(8, eq.getCantGoles());
            pre.setInt(9, eq.getIdEntrenador());
            pre.setInt(10, eq.getIdJugador());
            pre.setInt(11, eq.getPuntaje());
            pre.setInt(12, eq.getIdEq());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void delete(Equipo eq)throws Exception
    {
        try 
        {
            this.conectar();
            sql="DELETE FROM public.equipo WHERE idequipo=?";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, eq.getIdEq());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public int contarEq(Object obj)throws Exception
    {
        int cont=0;
        try 
        {
            this.conectar();
            sql="select count(*) as cantidad from equipo";
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
    
    
    public List<Entrenador>viewEn() throws Exception
    {
        List<Entrenador>len=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select * from entrenador";
            pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Entrenador en=new Entrenador();
                en.setIdEntre(res.getInt("idEntrenador"));
                en.setNombre(res.getString("nombre"));
                en.setApellido(res.getString("apellido"));
                en.setGenero(res.getString("genero"));
                en.setEdad(res.getInt("edad"));
                en.setTelefono(res.getString("telefeno"));
                en.setCorreo(res.getString("correoe"));
                en.setIdEqu(res.getInt("idequipo"));
                len.add(en);
            }
        } catch (Exception e) 
        {
            throw e;
        }
        return len;
    }

    public int contarEn(Object obj) throws Exception
    {
        int cont=0;
        try 
        {
            this.conectar();
            sql="select count(*) as cantidad from entrenador";
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
    
     public List<Jugador>viewJuga()throws Exception
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
    
}
