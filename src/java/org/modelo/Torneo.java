
package org.modelo;

/**
 * Nombre de la clase:Torneo
 * Fecha:14/10/2017
 * version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class Torneo 
{
    private int idTorneo;
    private String nombre;
    private String ubicacion;
    private int catEq;
    private String campeon;
    private String goleador;
    private String segLugar;
    private String terLugar;
    private String cuarLugar;
    private String fechaIni;
    private String fechaF;
    private String descenso;
    private int idEq;
    private int idJugador;
    private int idJornada;

    public Torneo() {
    }

    public Torneo(int idTorneo, String nombre, String ubicacion, int catEq, String campeon, String goleador, String segLugar, String terLugar, String cuarLugar, String fechaIni, String fechaF, String descenso, int idEq, int idJugador, int idJornada) {
        this.idTorneo = idTorneo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.catEq = catEq;
        this.campeon = campeon;
        this.goleador = goleador;
        this.segLugar = segLugar;
        this.terLugar = terLugar;
        this.cuarLugar = cuarLugar;
        this.fechaIni = fechaIni;
        this.fechaF = fechaF;
        this.descenso = descenso;
        this.idEq = idEq;
        this.idJugador = idJugador;
        this.idJornada = idJornada;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCatEq() {
        return catEq;
    }

    public void setCatEq(int catEq) {
        this.catEq = catEq;
    }

    public String getCampeon() {
        return campeon;
    }

    public void setCampeon(String campeon) {
        this.campeon = campeon;
    }

    public String getGoleador() {
        return goleador;
    }

    public void setGoleador(String goleador) {
        this.goleador = goleador;
    }

    public String getSegLugar() {
        return segLugar;
    }

    public void setSegLugar(String segLugar) {
        this.segLugar = segLugar;
    }

    public String getTerLugar() {
        return terLugar;
    }

    public void setTerLugar(String terLugar) {
        this.terLugar = terLugar;
    }

    public String getCuarLugar() {
        return cuarLugar;
    }

    public void setCuarLugar(String cuarLugar) {
        this.cuarLugar = cuarLugar;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getFechaF() {
        return fechaF;
    }

    public void setFechaF(String fechaF) {
        this.fechaF = fechaF;
    }

    public String getDescenso() {
        return descenso;
    }

    public void setDescenso(String descenso) {
        this.descenso = descenso;
    }

    public int getIdEq() {
        return idEq;
    }

    public void setIdEq(int idEq) {
        this.idEq = idEq;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    

}
