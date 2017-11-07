package org.modelo;

import java.sql.*;
import java.util.*;
import org.conexion.Conexion;

/**
 * Nombre de la clase:CrudDetalle Fecha:14/10/2017 
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class CrudDetalle extends Conexion {

    private PreparedStatement pre;
    private ResultSet res;
    private String sql;

    public List<DetallePartido> view() throws Exception {
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

    public void add(DetallePartido dp) throws Exception {
        try {
            this.conectar();
            sql = "INSERT INTO public.detalle(\n" 
            +"iddetalle, idjugador, mejorjugador, posicionbalon, goleador, numexpulsados, numamonestado, cantpenal, llegameta, corner)\n" 
            +"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, dp.getIdDetalle());
            pre.setInt(2, dp.getIdJugador());
            pre.setString(3, dp.getMejorJuga());
            pre.setString(4, dp.getPosesionBalon());
            pre.setString(5, dp.getGoleador());
            pre.setInt(6, dp.getNumExpul());
            pre.setInt(7, dp.getNumAmo());
            pre.setInt(8, dp.getCatPenal());
            pre.setInt(9, dp.getLlegaMeta());
            pre.setInt(10, dp.getCorner());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public void update(DetallePartido dp) throws Exception {
        try {
            this.conectar();
            sql = "UPDATE public.detalle\n" +
"	SET idjugador=?, mejorjugador=?, posicionbalon=?, goleador=?, numexpulsados=?, numamonestado=?, cantpenal=?, llegameta=?, corner=?\n" +
"	WHERE iddetalle=?";
            pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, dp.getIdJugador());
            pre.setString(2, dp.getMejorJuga());
            pre.setString(3, dp.getPosesionBalon());
            pre.setString(4, dp.getGoleador());
            pre.setInt(5, dp.getNumExpul());
            pre.setInt(6, dp.getNumAmo());
            pre.setInt(7, dp.getCatPenal());
            pre.setInt(8, dp.getLlegaMeta());
            pre.setInt(9, dp.getCorner());
            pre.setInt(10, dp.getIdDetalle());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public void delete(DetallePartido dp) throws Exception {
        try {
            this.conectar();
            sql = "DELETE FROM public.detalle\n" 
            +"WHERE iddetalle=?";
            pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, dp.getIdDetalle());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public int contarDeta(Object obj) throws Exception {
        int cont = 0;
        try {
            this.conectar();
            sql = "select count(*) as cantidad from detalle";
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

    public List<Jugador> viewJuga() throws Exception {
        List<Jugador> lju = new ArrayList<>();
        try {
            this.conectar();
            sql = "select * from jugador";
            pre = this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()) {
                Jugador ju = new Jugador();
                ju.setIdJugador(res.getInt("idjugador"));
                ju.setNombre(res.getString("nombre"));
                ju.setDui(res.getString("dui"));
                ju.setPosicion(res.getString("posicion"));
                ju.setPais(res.getString("pais"));
                ju.setTelefono(res.getString("telefono"));
                ju.setEmail(res.getString("correo"));
                lju.add(ju);
            }
        } catch (Exception e) {
            throw e;
        }
        return lju;
    }
}
