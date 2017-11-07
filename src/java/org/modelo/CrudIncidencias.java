
package org.modelo;

import java.util.*;
import java.sql.*;
import org.conexion.Conexion;

/**
 * Nombre de la clase:CrudInicidencias
 * Fecha:17/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class CrudIncidencias extends Conexion 
{
    private PreparedStatement pre;
    private ResultSet res;
    private String sql;
    
    public List<Incidencias>view()throws Exception
    {
        List<Incidencias>lsi=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select * from incidencias";
            pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Incidencias in=new Incidencias();
                in.setIdInci(res.getInt("idincidencias"));
                in.setTipo(res.getString("tipo"));
                in.setFecha(res.getString("fecha"));
                in.setMinuto(res.getString("minuto"));
                in.setTiempo(res.getString("tiempo"));
                in.setCantidad(res.getInt("cantidad"));
                in.setIdPartido(res.getInt("idpartido"));
                in.setIdJugador(res.getInt("idjugador"));
                lsi.add(in);
            }
        } catch (Exception e) 
        {
            throw e;
        }
        return lsi;
    }
    
    
    public void add(Incidencias in)throws Exception
    {
        try 
        {
            this.conectar();
            sql="INSERT INTO public.incidencias(\n" 
            +"idincidencias, tipo, fecha, minuto, tiempo, cantidad, idpartido, idjugador)\n" 
            +"VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, in.getIdInci());
            pre.setString(2, in.getTipo());
            pre.setString(3, in.getFecha());
            pre.setString(4, in.getMinuto());
            pre.setString(5, in.getTiempo());
            pre.setInt(6, in.getCantidad());
            pre.setInt(7, in.getIdPartido());
            pre.setInt(8, in.getIdJugador());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void update(Incidencias in)throws Exception
    {
        try 
        {
            this.conectar();
            sql="UPDATE public.incidencias\n"
            +"SET tipo=?, fecha=?, minuto=?, tiempo=?, cantidad=?, idpartido=?, idjugador=?\n"
            +"WHERE idincidencias=?";
            pre=this.getCon().prepareStatement(sql);
            pre.setString(1, in.getTipo());
            pre.setString(2, in.getFecha());
            pre.setString(3, in.getMinuto());
            pre.setString(4, in.getTiempo());
            pre.setInt(5, in.getCantidad());
            pre.setInt(6, in.getIdPartido());
            pre.setInt(7, in.getIdJugador());
            pre.setInt(8, in.getIdInci());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void delete(Incidencias in)throws Exception
    {
        try 
        {
            this.conectar();
            sql="DELETE FROM public.incidencias\n" 
            +"WHERE idincidencias=?";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, in.getIdInci());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public int contarI(Object obj)throws Exception
    {
        int con=0;
        try 
        {
            this.conectar();
            sql="select count(*) as cantidad from incidencias";
            pre=this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                con=res.getInt("cantidad")+1;
            }
        } catch (Exception e) 
        {
            throw e;
        }
        return con;
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
    
    public List<Partido>viewPar()throws Exception
   {
       List<Partido>lpar=new ArrayList<>();
       try 
       {
         this.conectar();
         sql="select * from partido";
         pre=this.getCon().prepareCall(sql);
         res=pre.executeQuery();
           while (res.next()) 
           {               
               Partido par=new Partido();
               par.setIdPartido(res.getInt("idpartido"));
               par.setNombre(res.getString("nombrepar"));
               par.setTipoPartido(res.getString("tipopartido"));
               par.setNumGoles(res.getInt("numgoles"));
               par.setFecha(res.getString("fechapar"));
               par.setIdEquipo(res.getInt("idequipo"));
               par.setEqVisitante(res.getString("eqvisitante"));
               par.setEqLocal(res.getString("eqlocal"));
               par.setMarcadorVisi(res.getInt("marcadorvisitante"));
               par.setMarcadorLocal(res.getInt("marcadorlocal"));
               par.setIdEquipo(res.getInt("idequipo"));
               par.setIdDetalle(res.getInt("iddetalle"));
               lpar.add(par);
           }
       } catch (Exception e) 
       {
           throw e;
       }
       return lpar;
   }
}
