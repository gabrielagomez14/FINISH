
package org.modelo;

/**
 * Nombre de la clase:Jornada
 * Fecha:14/10/2017
 * version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class Jornada 
{
    private int idJornada;
    private int idEquipo;
    private String nombre;
    private int cantPar;
    private int victorias;
    private int empate;
    private int derrota;
    private int aFavor;
    private int encontra;
    private int diferencia;
    private int puntos;

    public Jornada() {
    }

    public Jornada(int idJornada, int idEquipo, String nombre, int cantPar, int victorias, int empate, int derrota, int aFavor, int encontra, int diferencia, int puntos) {
        this.idJornada = idJornada;
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.cantPar = cantPar;
        this.victorias = victorias;
        this.empate = empate;
        this.derrota = derrota;
        this.aFavor = aFavor;
        this.encontra = encontra;
        this.diferencia = diferencia;
        this.puntos = puntos;
    }

    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantPar() {
        return cantPar;
    }

    public void setCantPar(int cantPar) {
        this.cantPar = cantPar;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getEmpate() {
        return empate;
    }

    public void setEmpate(int empate) {
        this.empate = empate;
    }

    public int getDerrota() {
        return derrota;
    }

    public void setDerrota(int derrota) {
        this.derrota = derrota;
    }

    public int getaFavor() {
        return aFavor;
    }

    public void setaFavor(int aFavor) {
        this.aFavor = aFavor;
    }

    public int getEncontra() {
        return encontra;
    }

    public void setEncontra(int encontra) {
        this.encontra = encontra;
    }

    public int getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(int diferencia) {
        this.diferencia = diferencia;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
}
