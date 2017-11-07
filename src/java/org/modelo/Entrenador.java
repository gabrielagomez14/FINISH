
package org.modelo;

/**
 * Nombre de la clase:Entrenador
 * Fecha:14/10/2017
 * version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class Entrenador 
{
    private int idEntre;
    private String nombre;
    private String apellido;
    private String genero;
    private int edad;
    private String telefono;
    private String correo;
    private int idEqu;

    public Entrenador() {
    }

    public Entrenador(int idEntre, String nombre, String apellido, String genero, int edad, String telefono, String correo, int idEqu) {
        this.idEntre = idEntre;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        this.idEqu = idEqu;
    }

    public int getIdEntre() {
        return idEntre;
    }

    public void setIdEntre(int idEntre) {
        this.idEntre = idEntre;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdEqu() {
        return idEqu;
    }

    public void setIdEqu(int idEqu) {
        this.idEqu = idEqu;
    }

    
}
