
package org.modelo;
/**
 * Nombre de la clase:Partido
 * Fecha:14/10/2017
 * version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class Partido 
{
    private int idPartido;
    private String nombre;
    private String tipoPartido;
    private int numGoles;
    private String fecha;
    private int idEquipo;
    private String eqVisitante;
    private String eqLocal;
    private int marcadorVisi;
    private int marcadorLocal;
    private int idArb;
    private int idjornada;
    private int idDetalle;

    public Partido() {
    }

    public Partido(int idPartido, String nombre, String tipoPartido, int numGoles, String fecha, int idEquipo, String eqVisitante, String eqLocal, int marcadorVisi, int marcadorLocal, int idArb, int idjornada, int idDetalle) {
        this.idPartido = idPartido;
        this.nombre = nombre;
        this.tipoPartido = tipoPartido;
        this.numGoles = numGoles;
        this.fecha = fecha;
        this.idEquipo = idEquipo;
        this.eqVisitante = eqVisitante;
        this.eqLocal = eqLocal;
        this.marcadorVisi = marcadorVisi;
        this.marcadorLocal = marcadorLocal;
        this.idArb = idArb;
        this.idjornada = idjornada;
        this.idDetalle = idDetalle;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoPartido() {
        return tipoPartido;
    }

    public void setTipoPartido(String tipoPartido) {
        this.tipoPartido = tipoPartido;
    }

    public int getNumGoles() {
        return numGoles;
    }

    public void setNumGoles(int numGoles) {
        this.numGoles = numGoles;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getEqVisitante() {
        return eqVisitante;
    }

    public void setEqVisitante(String eqVisitante) {
        this.eqVisitante = eqVisitante;
    }

    public String getEqLocal() {
        return eqLocal;
    }

    public void setEqLocal(String eqLocal) {
        this.eqLocal = eqLocal;
    }

    public int getMarcadorVisi() {
        return marcadorVisi;
    }

    public void setMarcadorVisi(int marcadorVisi) {
        this.marcadorVisi = marcadorVisi;
    }

    public int getMarcadorLocal() {
        return marcadorLocal;
    }

    public void setMarcadorLocal(int marcadorLocal) {
        this.marcadorLocal = marcadorLocal;
    }

    public int getIdArb() {
        return idArb;
    }

    public void setIdArb(int idArb) {
        this.idArb = idArb;
    }

    public int getIdjornada() {
        return idjornada;
    }

    public void setIdjornada(int idjornada) {
        this.idjornada = idjornada;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    
}
