
package org.modelo;

/**
 * Nombre de la clase:Usuarios
 * Fecha:13/10/2017
 * Version:1.0
 * Copyright:UEFA
 * @author Ale Gomez
 */
public class Usuarios 
{
    private int id;
    private String nombre;
    private String apellido;
    private String username;
    private String clave;
    private int nivel;

    public Usuarios() {
    }

    public Usuarios(int id, String nombre, String apellido, String username, String clave, int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.clave = clave;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    
}
