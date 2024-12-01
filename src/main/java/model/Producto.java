package model;

import java.io.Serializable;

public class Producto implements Serializable {
    private int id;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private float precio;

    public void imprimirDatos(){
        System.out.println("id = " + id);
        System.out.println("nombre = " + nombre);
        System.out.println("descripcion = " + descripcion);
        System.out.println("cantidad = " + cantidad);
        System.out.println("precio = " + precio);
    }

    public Producto(int id, String nombre, String descripcion, int cantidad, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}


