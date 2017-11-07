
package org.modelo;

/**
 * Nombre de la clase:DetallePartido
 * Fecha:14/10/2017
 * version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class DetallePartido 
{
    private int idDetalle;
    private int idJugador;
    private String mejorJuga;
    private String posesionBalon;
    private String goleador;
    private int numExpul;
    private int numAmo;
    private int catPenal;
    private int llegaMeta;
    private int corner;

    public DetallePartido() {
    }

    public DetallePartido(int idDetalle, int idJugador, String mejorJuga, String posesionBalon, String goleador, int numExpul, int numAmo, int catPenal, int llegaMeta, int corner) {
        this.idDetalle = idDetalle;
        this.idJugador = idJugador;
        this.mejorJuga = mejorJuga;
        this.posesionBalon = posesionBalon;
        this.goleador = goleador;
        this.numExpul = numExpul;
        this.numAmo = numAmo;
        this.catPenal = catPenal;
        this.llegaMeta = llegaMeta;
        this.corner = corner;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getMejorJuga() {
        return mejorJuga;
    }

    public void setMejorJuga(String mejorJuga) {
        this.mejorJuga = mejorJuga;
    }

    public String getPosesionBalon() {
        return posesionBalon;
    }

    public void setPosesionBalon(String posesionBalon) {
        this.posesionBalon = posesionBalon;
    }

    public String getGoleador() {
        return goleador;
    }

    public void setGoleador(String goleador) {
        this.goleador = goleador;
    }

    public int getNumExpul() {
        return numExpul;
    }

    public void setNumExpul(int numExpul) {
        this.numExpul = numExpul;
    }

    public int getNumAmo() {
        return numAmo;
    }

    public void setNumAmo(int numAmo) {
        this.numAmo = numAmo;
    }

    public int getCatPenal() {
        return catPenal;
    }

    public void setCatPenal(int catPenal) {
        this.catPenal = catPenal;
    }

    public int getLlegaMeta() {
        return llegaMeta;
    }

    public void setLlegaMeta(int llegaMeta) {
        this.llegaMeta = llegaMeta;
    }

    public int getCorner() {
        return corner;
    }

    public void setCorner(int corner) {
        this.corner = corner;
    }
    
    
    
}
