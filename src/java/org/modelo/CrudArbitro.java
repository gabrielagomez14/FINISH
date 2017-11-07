
package org.modelo;

import java.util.*;
import java.sql.*;
import org.conexion.Conexion;

/**
 * Nombre de la clase:CrudArbitro
 * Fecha:14/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class CrudArbitro extends Conexion
{
    private PreparedStatement pre;
    private ResultSet res;
    private String sql;
    public List<Arbitro>view()throws Exception
    {
        List<Arbitro>lar=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select * from arbitro";
            pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Arbitro ar= new Arbitro();
                ar.setIdArbitro(res.getInt("idarbitro"));
                ar.setNombre(res.getString("nombre"));
                ar.setApellido(res.getString("apellido"));
                ar.setSueldo(res.getDouble("sueldo"));
                ar.setCategoria(res.getString("categoria"));
                ar.setRolArbi(res.getString("rol"));        
                ar.setIdEquipo(res.getInt("idequipo"));

                
                lar.add(ar);
            }
            
        } catch (Exception e) 
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return lar;
    }
    
    public void add(Arbitro ar)throws Exception
    {
        try 
        {
           this.conectar();
           sql="INSERT INTO public.arbitro(\n" 
            +"idarbitro, nombre, apellido, sueldo, categoria, rol, idequipo)\n" 
            +"VALUES (?, ?, ?, ?, ?, ?, ?);";
           pre=this.getCon().prepareStatement(sql);
           pre.setInt(1, ar.getIdArbitro());
           pre.setString(2, ar.getNombre());
           pre.setString(3, ar.getApellido());
           pre.setDouble(4, ar.getSueldo());
           pre.setString(5, ar.getCategoria());
           pre.setString(6, ar.getRolArbi());
           pre.setInt(7, ar.getIdEquipo());
           pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    
    public void update(Arbitro ar)throws Exception
    {
        try 
        {
            this.conectar();
            sql="UPDATE public.arbitro\n" 
            +"SET nombre=?, apellido=?, sueldo=?, categoria=?, rol=?, idequipo=?\n" 
            +"WHERE idarbitro=?";
            pre=this.getCon().prepareStatement(sql);
            pre.setString(1, ar.getNombre());
            pre.setString(2, ar.getApellido());
            pre.setDouble(3, ar.getSueldo());
            pre.setString(4, ar.getCategoria());
            pre.setString(5, ar.getRolArbi());
            pre.setInt(6, ar.getIdEquipo());
            pre.setInt(7, ar.getIdArbitro());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    
    public void delete(Arbitro ar)throws Exception
    {
        try 
        {
            this.conectar();
            sql="DELETE FROM public.arbitro\n"
            +"	WHERE idarbitro=?";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, ar.getIdArbitro());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            throw e;
        }
    }
    
    public int contar(Object obj) throws Exception
    {
        int cont=0;
        try 
        {
            this.conectar();
            sql="select count(*) as cantidad from arbitro";
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
    
    public List<Equipo>viewName()throws Exception
    {
        List<Equipo>listName= new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select nombre from equipo";
            pre=this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Equipo eq= new Equipo();
                eq.setNombre(res.getString("nombre"));
                listName.add(eq);
            }
        } catch (Exception e) 
        {
            throw e;
        }
        return listName;
    }
}
