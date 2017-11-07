
package org.modelo;

import java.sql.*;
import java.util.*;
import org.conexion.Conexion;

/**
 * Nombre de la clase:CrudEntrenador
 * Fecha:14/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class CrudEntrenador extends Conexion
{
    private PreparedStatement pre;
    private ResultSet res;
    private String sql;
    public List<Entrenador>view() throws Exception
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
    
    public void add(Entrenador en)throws Exception
    {
        try 
        {
            this.conectar();
            sql="INSERT INTO public.entrenador(\n" 
            +"identrenador, nombre, apellido, genero, edad, telefeno, correoe, idequipo)\n" 
            +"	VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, en.getIdEntre());
            pre.setString(2, en.getNombre());
            pre.setString(3, en.getApellido());
            pre.setString(4, en.getGenero());
             pre.setInt(5, en.getEdad());
            pre.setString(6, en.getTelefono());
            pre.setString(7, en.getCorreo());
            pre.setInt(8, en.getIdEqu());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    public void update(Entrenador en)throws Exception
    {
        try 
        {
            this.conectar();
            sql="UPDATE public.entrenador\n" 
            +"SET nombre=?, apellido=?, genero=?, edad=?, telefeno=?, correoe=?, idequipo=?\n"
            +"WHERE identrenador=?";
            pre=this.getCon().prepareStatement(sql);
            pre.setString(1, en.getNombre());
            pre.setString(2, en.getApellido());
            pre.setString(3, en.getGenero());
            pre.setInt(4, en.getEdad());
            pre.setString(5, en.getTelefono());
            pre.setString(6, en.getCorreo());
            pre.setInt(7, en.getIdEqu());
            pre.setInt(8, en.getIdEntre());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void delete(Entrenador en)throws Exception
    {
        try 
        {
            this.conectar();
            sql="DELETE FROM public.entrenador\n" +
"	WHERE identrenador=?;";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, en.getIdEntre());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    
    public List<Equipo>vieweq()throws Exception
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
                eq.setPuntaje(res.getInt("puntaje"));
                eq.setIdEntrenador(res.getInt("identrenador"));
                eq.setIdJugador(res.getInt("idjugador"));
                leq.add(eq);
            }
            
        } catch (Exception e) 
        {
            throw e;
        }
        return leq;
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
    
    public int contarEq(Object obj)throws Exception
    {
        int cont=0;
        try 
        {
            this.conectar();
            sql="select count(*) as cant from equipo";
            pre=this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                cont=res.getInt("cant")+1;
            }
        } catch (Exception e) 
        {
            throw e;
        }
        return cont;
    }
    
    
}
