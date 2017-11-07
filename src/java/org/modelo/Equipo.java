
package org.modelo;

/**
 * Nombre de la clase:Equipo
 * Fecha:14/10/2017
 * version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class Equipo 
{
    private int idEq;
    private String nombre;
    private int numJugadores;
    private int numAmonestado;
    private String email;
    private String direccion;
    private String tipoEq;
    private String telefono;
    private int cantGoles;
    private int idEntrenador;
    private int idJugador;
    private int puntaje;

    public Equipo() {
    }

    public Equipo(int idEq, String nombre, int numJugadores, int numAmonestado, String email, String direccion, String tipoEq, String telefono, int cantGoles, int idEntrenador, int idJugador, int puntaje) {
        this.idEq = idEq;
        this.nombre = nombre;
        this.numJugadores = numJugadores;
        this.numAmonestado = numAmonestado;
        this.email = email;
        this.direccion = direccion;
        this.tipoEq = tipoEq;
        this.telefono = telefono;
        this.cantGoles = cantGoles;
        this.idEntrenador = idEntrenador;
        this.idJugador = idJugador;
        this.puntaje = puntaje;
    }

    public int getIdEq() {
        return idEq;
    }

    public void setIdEq(int idEq) {
        this.idEq = idEq;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public int getNumAmonestado() {
        return numAmonestado;
    }

    public void setNumAmonestado(int numAmonestado) {
        this.numAmonestado = numAmonestado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoEq() {
        return tipoEq;
    }

    public void setTipoEq(String tipoEq) {
        this.tipoEq = tipoEq;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCantGoles() {
        return cantGoles;
    }

    public void setCantGoles(int cantGoles) {
        this.cantGoles = cantGoles;
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    
}
