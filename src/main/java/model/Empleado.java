package model;

import java.io.Serializable;

public class Empleado implements Serializable {
    private int id;
    private String nombre;
    private String apellidos;
    private String correo;

    public Empleado(String nombre, String apellidos, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    public Empleado(int id, String nombre, String correo, String apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.apellidos = apellidos;
    }

    public Empleado() {
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void imprimirDatos(){
        System.out.println("id = " + id);
        System.out.println("nombre = " + nombre);
        System.out.println("apellidos = " + apellidos);
        System.out.println("correo = " + correo);
    }
}
