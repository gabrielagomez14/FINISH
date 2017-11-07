
package org.modelo;

/**
 * Nombre de la clase:Jugador
 * Fecha:14/10/2017
 * version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class Jugador 
{
    private int idJugador;
    private String nombre;
    private String dui;
    private String posicion;
    private String pais;
    private String telefono;
    private String email;

    public Jugador() {
    }

    public Jugador(int idJugador, String nombre, String dui, String posicion, String pais, String telefono, String email) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.dui = dui;
        this.posicion = posicion;
        this.pais = pais;
        this.telefono = telefono;
        this.email = email;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    
    
}
