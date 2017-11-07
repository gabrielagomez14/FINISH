
package org.modelo;

/**
 * Nombre de la clase:Arbitro
 * Fecha:14/10/2017
 * version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class Arbitro 
{
    private  int idArbitro;
    private String nombre;
    private String apellido;
    private double sueldo;
    private String categoria;
    private String rolArbi;
    private int idEquipo;
    private String nombreEq;

    public Arbitro() {
    }

    public Arbitro(int idArbitro, String nombre, String apellido, double sueldo, String categoria, String rolArbi, int idEquipo, String nombreEq) {
        this.idArbitro = idArbitro;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.categoria = categoria;
        this.rolArbi = rolArbi;
        this.idEquipo = idEquipo;
        this.nombreEq = nombreEq;
    }

    public int getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(int idArbitro) {
        this.idArbitro = idArbitro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getRolArbi() {
        return rolArbi;
    }

    public void setRolArbi(String rolArbi) {
        this.rolArbi = rolArbi;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEq() {
        return nombreEq;
    }

    public void setNombreEq(String nombreEq) {
        this.nombreEq = nombreEq;
    }

    
    
}
