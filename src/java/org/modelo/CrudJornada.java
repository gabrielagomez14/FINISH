
package org.modelo;

import java.util.*;
import java.sql.*;
import org.conexion.Conexion;

/**
 * Nombre de la clase:CrudJornada
 * Fecha:17/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class CrudJornada extends Conexion
{
    private PreparedStatement pre;
    private ResultSet res;
    private String sql;
    
    public List<Jornada>view()throws Exception
    {
        List<Jornada>ljr=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select * from jornada";
            pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Jornada jor=new Jornada();
                jor.setIdJornada(res.getInt("idjornada"));
                jor.setIdEquipo(res.getInt("idequipo"));
                jor.setNombre(res.getString("nombre"));
                jor.setCantPar(res.getInt("catpartidos"));
                jor.setVictorias(res.getInt("victorias"));
                jor.setEmpate(res.getInt("empate"));
                jor.setDerrota(res.getInt("derrotas"));
                jor.setaFavor(res.getInt("afavor"));
                jor.setEncontra(res.getInt("encontra"));
                jor.setDiferencia(res.getInt("diferencia"));
                jor.setPuntos(res.getInt("puntos"));
                ljr.add(jor);
            }
        } catch (Exception e) 
        {
            throw e;
        }
        return ljr;
    }
    
    public void add(Jornada jor)throws Exception
    {
        try 
        {
            this.conectar();
            sql="INSERT INTO public.jornada(\n" 
            +"idjornada, idequipo, nombre, catpartidos, victorias, empate, derrotas, afavor, encontra, diferencia, puntos)\n" 
            +"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, jor.getIdJornada());
            pre.setInt(2, jor.getIdEquipo());
            pre.setString(3, jor.getNombre());
            pre.setInt(4, jor.getCantPar());
            pre.setInt(5, jor.getVictorias());
            pre.setInt(6, jor.getEmpate());
            pre.setInt(7, jor.getDerrota());
            pre.setInt(8, jor.getaFavor());
            pre.setInt(9, jor.getEncontra());
            pre.setInt(10, jor.getDiferencia());
            pre.setInt(11, jor.getPuntos());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void update(Jornada jor)throws Exception
    {
        try 
        {
           this.conectar();
           sql="UPDATE public.jornada\n" +
"	SET idequipo=?, nombre=?, catpartidos=?, victorias=?, empate=?, derrotas=?, afavor=?, encontra=?, diferencia=?, puntos=?\n" +
"	WHERE idjornada=?";
            pre=this.getCon().prepareStatement(sql); 
            pre.setInt(1, jor.getIdEquipo());
            pre.setString(2, jor.getNombre());
            pre.setInt(3, jor.getCantPar());
            pre.setInt(4, jor.getVictorias());
            pre.setInt(5, jor.getEmpate());
            pre.setInt(6, jor.getDerrota());
            pre.setInt(7, jor.getaFavor());
            pre.setInt(8, jor.getEncontra());
            pre.setInt(9, jor.getDiferencia());
            pre.setInt(10, jor.getPuntos());
            pre.setInt(11, jor.getIdJornada());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void delete(Jornada jor)throws Exception
    {
        try 
        {
            this.conectar();
            sql="DELETE FROM public.jornada\n" 
                +"WHERE idjornada=?";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, jor.getIdJornada());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public int ContarJor(Object obj)throws Exception
    {
        int cont=0;
        try 
        {
            this.conectar();
            sql="select count(*) as cantidad from jornada";
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
    
    public List<Equipo>viewEq()throws Exception
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
    //:D
    
    public List<Jornada>viewJA()throws Exception
    {
        List<Jornada>ljA=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select * from jornada where nombre='Jornada A'";
            pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Jornada jor=new Jornada();
                jor.setIdJornada(res.getInt("idjornada"));
                jor.setIdEquipo(res.getInt("idequipo"));
                jor.setNombre(res.getString("nombre"));
                jor.setCantPar(res.getInt("catpartidos"));
                jor.setVictorias(res.getInt("victorias"));
                jor.setEmpate(res.getInt("empate"));
                jor.setDerrota(res.getInt("derrotas"));
                jor.setaFavor(res.getInt("afavor"));
                jor.setEncontra(res.getInt("encontra"));
                jor.setDiferencia(res.getInt("diferencia"));
                jor.setPuntos(res.getInt("puntos"));
                ljA.add(jor);
            }
        } catch (Exception e) 
        {
            throw e;
        }
        return ljA;
    }
    
    public List<Jornada>viewJB()throws Exception
    {
        List<Jornada>ljA=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select * from jornada where nombre='Jornada B'";
            pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Jornada jor=new Jornada();
                jor.setIdJornada(res.getInt("idjornada"));
                jor.setIdEquipo(res.getInt("idequipo"));
                jor.setNombre(res.getString("nombre"));
                jor.setCantPar(res.getInt("catpartidos"));
                jor.setVictorias(res.getInt("victorias"));
                jor.setEmpate(res.getInt("empate"));
                jor.setDerrota(res.getInt("derrotas"));
                jor.setaFavor(res.getInt("afavor"));
                jor.setEncontra(res.getInt("encontra"));
                jor.setDiferencia(res.getInt("diferencia"));
                jor.setPuntos(res.getInt("puntos"));
                ljA.add(jor);
            }
        } catch (Exception e) 
        {
            throw e;
        }
        return ljA;
    }
    
    public List<Jornada>viewJC()throws Exception
    {
        List<Jornada>ljA=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select * from jornada where nombre='Jornada C'";
            pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Jornada jor=new Jornada();
                jor.setIdJornada(res.getInt("idjornada"));
                jor.setIdEquipo(res.getInt("idequipo"));
                jor.setNombre(res.getString("nombre"));
                jor.setCantPar(res.getInt("catpartidos"));
                jor.setVictorias(res.getInt("victorias"));
                jor.setEmpate(res.getInt("empate"));
                jor.setDerrota(res.getInt("derrotas"));
                jor.setaFavor(res.getInt("afavor"));
                jor.setEncontra(res.getInt("encontra"));
                jor.setDiferencia(res.getInt("diferencia"));
                jor.setPuntos(res.getInt("puntos"));
                ljA.add(jor);
            }
        } catch (Exception e) 
        {
            throw e;
        }
        return ljA;
    }
    public List<Jornada>viewJD()throws Exception
    {
        List<Jornada>ljA=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select * from jornada where nombre='Jornada D'";
            pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Jornada jor=new Jornada();
                jor.setIdJornada(res.getInt("idjornada"));
                jor.setIdEquipo(res.getInt("idequipo"));
                jor.setNombre(res.getString("nombre"));
                jor.setCantPar(res.getInt("catpartidos"));
                jor.setVictorias(res.getInt("victorias"));
                jor.setEmpate(res.getInt("empate"));
                jor.setDerrota(res.getInt("derrotas"));
                jor.setaFavor(res.getInt("afavor"));
                jor.setEncontra(res.getInt("encontra"));
                jor.setDiferencia(res.getInt("diferencia"));
                jor.setPuntos(res.getInt("puntos"));
                ljA.add(jor);
            }
        } catch (Exception e) 
        {
            throw e;
        }
        return ljA;
    }
    
    
    public List<Equipo>n()throws Exception
    {
        List<Equipo>n= new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select nombre fron equipo";
            pre=this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while (true) 
            {                
                Equipo q= new Equipo();
                q.setNombre(res.getString("nombre"));
                n.add(q);
            }
        } catch (Exception e) {
        }
        return n;
    }
    
    
}
