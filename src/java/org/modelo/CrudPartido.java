package org.modelo;

import java.util.*;
import java.sql.*;
import org.conexion.Conexion;

/**
 * Nombre de la clase:CrudPartido
 * Fecha:17/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class CrudPartido extends Conexion {

    private PreparedStatement pre;
    private ResultSet res;
    private String sql;

    public List<Partido> view() throws Exception {
        List<Partido> lpar = new ArrayList<>();
        try {
            this.conectar();
            sql = "select * from partido";
            pre = this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()) {
                Partido par = new Partido();
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
                par.setIdjornada(res.getInt("idjornada"));
                par.setIdDetalle(res.getInt("iddetalle"));
                lpar.add(par);
            }
        } catch (Exception e) {
            throw e;
        }
        return lpar;
    }

    public void add(Partido par) throws Exception {
        try {
            this.conectar();
            sql = "INSERT INTO public.partido(\n" 
            +"idpartido, nombrepar, tipopartido, numgoles, fechapar, idequipo, eqvisitante, eqlocal, marcadorvisitante, marcadorlocal, idarbitro, idjornada, iddetalle)\n" 
            +"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, par.getIdPartido());
            pre.setString(2, par.getNombre());
            pre.setString(3, par.getTipoPartido());
            pre.setInt(4, par.getNumGoles());
            pre.setString(5, par.getFecha());
            pre.setInt(6, par.getIdEquipo());
            pre.setString(7, par.getEqVisitante());
            pre.setString(8, par.getEqLocal());
            pre.setInt(9, par.getMarcadorVisi());
            pre.setInt(10, par.getMarcadorLocal());
            pre.setInt(11, par.getIdArb());
            pre.setInt(12, par.getIdjornada());
            pre.setInt(13, par.getIdDetalle());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(Partido par) throws Exception {
        try {
            this.conectar();
            sql = "UPDATE public.partido\n" 
            +"SET nombrepar=?, tipopartido=?, numgoles=?, fechapar=?, idequipo=?, eqvisitante=?, eqlocal=?, marcadorvisitante=?, marcadorlocal=?, idarbitro=?, idjornada=?, iddetalle=?\n" 
            +"WHERE idpartido=?";
            pre = this.getCon().prepareStatement(sql);
            pre.setString(1, par.getNombre());
            pre.setString(2, par.getTipoPartido());
            pre.setInt(3, par.getNumGoles());
            pre.setString(4, par.getFecha());
            pre.setInt(5, par.getIdEquipo());
            pre.setString(6, par.getEqVisitante());
            pre.setString(7, par.getEqLocal());
            pre.setInt(8, par.getMarcadorVisi());
            pre.setInt(9, par.getMarcadorLocal());
            pre.setInt(10, par.getIdArb());
            pre.setInt(11, par.getIdjornada());
            pre.setInt(12, par.getIdDetalle());
            pre.setInt(13, par.getIdPartido());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(Partido par) throws Exception {
        try 
        {
            this.conectar();
            sql = "DELETE FROM public.partido\n" +"WHERE idpartido=?";
            pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, par.getIdPartido());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public int contar(Object obj) throws Exception {
        int con = 0;
        try {
            this.conectar();
            sql = "select count(*) as cantidad from partido";
            pre = this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            while (res.next()) {
                con = res.getInt("cantidad") + 1;
            }
        } catch (Exception e) {
            throw e;
        }
        return con;
    }

    /*
    *    Muestro de detalle
     */
    public List<Equipo> Visitante() throws Exception {
        List<Equipo> lVisitante = new ArrayList<>();
        try {
            this.conectar();
            sql = "select nombre from equipo where tipoequipo='Visitante'";
            pre = this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            while (res.next()) {
                Equipo par = new Equipo();
                par.setNombre(res.getString("nombre"));
                lVisitante.add(par);
            }
        } catch (Exception e) {
            throw e;
        }
        return lVisitante;
    }

    public List<Equipo> Local() throws Exception {
        List<Equipo> lLocal = new ArrayList<>();
        try {
            this.conectar();
            sql = "select nombre from equipo where tipoequipo='Local';";
            pre = this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            while (res.next()) {
                Equipo par = new Equipo();
                par.setNombre(res.getString("nombre"));
                lLocal.add(par);
            }
        } catch (Exception e) {
            throw e;
        }
        return lLocal;
    }

    public List<Equipo> mVisitante() throws Exception {
        List<Equipo> mVisi = new ArrayList<>();
        try {
            this.conectar();
            sql = "select cantgoles from equipo where tipoequipo='Visitante';";
            pre = this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            while (res.next()) {
                Equipo par = new Equipo();
                par.setCantGoles(res.getInt("cantgoles"));
                mVisi.add(par);
            }
        } catch (Exception e) {
            throw e;
        }
        return mVisi;
    }

    public List<Equipo> mLocal() throws Exception {
        List<Equipo> mLocal = new ArrayList<>();
        try {
            this.conectar();
            sql = "select cantgoles from equipo where tipoequipo='Local';";
            pre = this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            while (res.next()) {
                Equipo par = new Equipo();
                par.setCantGoles(res.getInt("cantgoles"));
                mLocal.add(par);
            }
        } catch (Exception e) {
            throw e;
        }
        return mLocal;
    }

    public List<Arbitro> viewarbi() throws Exception {
        List<Arbitro> lar = new ArrayList<>();
        try {
            this.conectar();
            sql = "select * from arbitro";
            pre = this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()) {
                Arbitro ar = new Arbitro();
                ar.setIdArbitro(res.getInt("idarbitro"));
                ar.setNombre(res.getString("nombre"));
                ar.setApellido(res.getString("apellido"));
                ar.setSueldo(res.getDouble("sueldo"));
                ar.setCategoria(res.getString("categoria"));
                ar.setRolArbi(res.getString("rol"));
                ar.setIdEquipo(res.getInt("idequipo"));
                lar.add(ar);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lar;
    }

    public List<DetallePartido> viewDet() throws Exception {
        List<DetallePartido> ldp = new ArrayList<>();
        try {
            this.conectar();
            sql = "select * from detalle";
            pre = this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()) {
                DetallePartido dp = new DetallePartido();
                dp.setIdDetalle(res.getInt("iddetalle"));
                dp.setIdJugador(res.getInt("idjugador"));
                dp.setMejorJuga(res.getString("mejorjugador"));
                dp.setPosesionBalon(res.getString("posicionbalon"));
                dp.setGoleador(res.getString("goleador"));
                dp.setNumExpul(res.getInt("numexpulsados"));
                dp.setNumAmo(res.getInt("numamonestado"));
                dp.setCatPenal(res.getInt("cantpenal"));
                dp.setLlegaMeta(res.getInt("llegameta"));
                dp.setCorner(res.getInt("corner"));
                ldp.add(dp);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return ldp;
    }

    public int contarEq(Object obj) throws Exception {
        int cont = 0;
        try {
            this.conectar();
            sql = "select count(*) as cantidad from equipo";
            pre = this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            while (res.next()) {
                cont = res.getInt("cantidad") + 1;
            }
        } catch (Exception e) {
            throw e;
        }
        return cont;
    }

    public List<Equipo> viewEq() throws Exception {
        List<Equipo> leq = new ArrayList<>();
        try {
            this.conectar();
            sql = "select * from equipo";
            pre = this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()) {
                Equipo eq = new Equipo();
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

        } catch (Exception e) {
            throw e;
        }
        return leq;

    }

    public List<Jornada>viewJ()throws Exception
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
    
    public List<Jornada>viewJ2()throws Exception
    {
        List<Jornada>ljr=new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select * from partido where eqvisitante";
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
    
}
