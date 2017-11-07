
package org.modelo;

/**
 * Nombre de la clase:Incidencias
 * Fecha:14/10/2017
 * version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class Incidencias 
{
    private int idInci;
    private String tipo;
    private String fecha;
    private String minuto;
    private String tiempo;
    private int cantidad;
    private int idPartido;
    private int idJugador;

    public Incidencias() {
    }

    public Incidencias(int idInci, String tipo, String fecha, String minuto, String tiempo, int cantidad, int idPartido, int idJugador) {
        this.idInci = idInci;
        this.tipo = tipo;
        this.fecha = fecha;
        this.minuto = minuto;
        this.tiempo = tiempo;
        this.cantidad = cantidad;
        this.idPartido = idPartido;
        this.idJugador = idJugador;
    }

    public int getIdInci() {
        return idInci;
    }

    public void setIdInci(int idInci) {
        this.idInci = idInci;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    
}
