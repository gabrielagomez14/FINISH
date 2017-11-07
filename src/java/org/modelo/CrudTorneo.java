
package org.modelo;

import java.util.*;
import java.sql.*;
import org.conexion.Conexion;

/**
 * Nombre de la clase:CrudTorneo
 * Fecha:17/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class CrudTorneo extends Conexion
{
    private PreparedStatement pre;
    private ResultSet res;
    private String sql;
    
    public List<Torneo>view()throws Exception
    {
        List<Torneo>ltor=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select * from torneo";
            pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Torneo tor=new Torneo();
                tor.setIdTorneo(res.getInt("idtorneo"));
                tor.setNombre(res.getString("nomtorneo"));
                tor.setUbicacion(res.getString("ubicacion"));
                tor.setCatEq(res.getInt("canteq"));
                tor.setCampeon(res.getString("campeon"));
                tor.setGoleador(res.getString("goleador"));
                tor.setSegLugar(res.getString("seglugar"));
                tor.setTerLugar(res.getString("terlugar"));
                tor.setCuarLugar(res.getString("cuarlugar"));
                tor.setFechaIni(res.getString("fechaini"));
                tor.setFechaF(res.getString("fechafin"));
                tor.setDescenso(res.getString("descenso"));
                tor.setIdEq(res.getInt("idequipo"));
                tor.setIdJugador(res.getInt("idjugador"));
                tor.setIdJornada(res.getInt("idjornada"));
                ltor.add(tor);
            }
            
        } catch (Exception e) 
        {
            throw e;
        }
        return ltor;
    }
    
    public void add(Torneo tor)throws Exception
    {
        try 
        {
            this.conectar();
            sql="INSERT INTO public.torneo(\n" 
            +"idtorneo, nomtorneo, ubicacion, canteq, campeon, goleador, seglugar, terlugar, cuarlugar, fechaini, fechafin, descenso, idequipo, idjugador, idjornada)\n" 
            +"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, tor.getIdTorneo());
            pre.setString(2, tor.getNombre());
            pre.setString(3, tor.getUbicacion());
            pre.setInt(4, tor.getCatEq());
            pre.setString(5, tor.getCampeon());
            pre.setString(6, tor.getGoleador());
            pre.setString(7, tor.getSegLugar());
            pre.setString(8, tor.getTerLugar());
            pre.setString(9, tor.getCuarLugar());
            pre.setString(10, tor.getFechaIni());
            pre.setString(11, tor.getFechaF());
            pre.setString(12, tor.getDescenso());
            pre.setInt(13, tor.getIdEq());
            pre.setInt(14, tor.getIdJugador());
            pre.setInt(15, tor.getIdJornada());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void update(Torneo tor)throws Exception
    {
        try 
        {
            this.conectar();
            sql="UPDATE public.torneo\n" 
            +"SET nomtorneo=?, ubicacion=?, canteq=?, campeon=?, goleador=?, seglugar=?, terlugar=?, cuarlugar=?, fechaini=?, fechafin=?, descenso=?, idequipo=?, idjugador=?, idjornada=?\n" 
            +"WHERE idtorneo=?"; 
            pre=this.getCon().prepareStatement(sql);
            pre.setString(1, tor.getNombre());
            pre.setString(2, tor.getUbicacion());
            pre.setInt(3, tor.getCatEq());
            pre.setString(4, tor.getCampeon());
            pre.setString(5, tor.getGoleador());
            pre.setString(6, tor.getSegLugar());
            pre.setString(7, tor.getTerLugar());
            pre.setString(8, tor.getCuarLugar());
            pre.setString(9, tor.getFechaIni());
            pre.setString(10, tor.getFechaF());
            pre.setString(11, tor.getDescenso());
            pre.setInt(12, tor.getIdEq());
            pre.setInt(13, tor.getIdJugador());
            pre.setInt(14, tor.getIdJornada());
            pre.setInt(15, tor.getIdTorneo());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void delete(Torneo tor)throws Exception
    {
        try 
        {
            this.conectar();
            sql="DELETE FROM public.torneo\n" 
            +"WHERE idtorneo=?";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, tor.getIdTorneo());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public int contar(Object obj)throws Exception
    {
        int cont=0;
        try 
        {
            this.conectar();
            sql="select count(*) as cantidad from torneo";
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
    
    /**
     *Select para mostrar los datos de tablas relacionadas
     * @return 
     * @throws java.lang.Exception
     */
    
    public List<Equipo>viewEquipo()throws Exception
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
    
    public List<Jugador>viewJugador()throws Exception
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
    public List<Jornada>viewJornada()throws Exception
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
    
    public List<Torneo>ltC()throws  Exception
    {
        List<Torneo>ltC=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select campeon from torneo;";
            pre=this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Torneo tor =new Torneo();
                tor.setCampeon(res.getString("campeon"));
                ltC.add(tor);
            }
        } catch (Exception e) 
        {
        }
        return ltC;
    }
    
    
    public List<Torneo>lt()throws  Exception
    {
        List<Torneo>ltC=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select goleador from torneo;";
            pre=this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Torneo tor =new Torneo();
                tor.setGoleador(res.getString("goleador"));
                ltC.add(tor);
            }
        } catch (Exception e) 
        {
        }
        return ltC;
    }
    
    public List<Torneo>ltS()throws  Exception
    {
        List<Torneo>ltS=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select seglugar from torneo;";
            pre=this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Torneo tor =new Torneo();
                tor.setSegLugar(res.getString("seglugar"));
                ltS.add(tor);
            }
        } catch (Exception e) 
        {
        }
        return ltS;
    }
public List<Torneo>ltT()throws  Exception
    {
        List<Torneo>ltt=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select cuarlugar from torneo;";
            pre=this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Torneo tor =new Torneo();
                tor.setGoleador(res.getString("cuarlugar"));
                ltt.add(tor);
            }
        } catch (Exception e) 
        {
        }
        return ltt;
    }


public List<Torneo>ltD()throws  Exception
    {
        List<Torneo>ltd=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select descenso from torneo;";
            pre=this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Torneo tor =new Torneo();
                tor.setGoleador(res.getString("descenso"));
                ltd.add(tor);
            }
        } catch (Exception e) 
        {
        }
        return ltd;
    }







}