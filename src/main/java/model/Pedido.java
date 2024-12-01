package model;

import java.io.Serializable;

public class Pedido implements Serializable {
    private int id;
    private int id_producto;
    private String descripcion;
    private float precio_total;

    public Pedido(String descripcion, float precio_total, int id_producto) {
        this.descripcion = descripcion;
        this.precio_total = precio_total;
        this.id_producto = id_producto;
    }

    public Pedido(int id, int id_producto, String descripcion, float precio_total) {
        this.id = id;
        this.id_producto = id_producto;
        this.descripcion = descripcion;
        this.precio_total = precio_total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio_total(float precio_total) {
        this.precio_total = precio_total;
    }

    public int getId() {
        return id;
    }

    public int getId_producto() {
        return id_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio_total() {
        return precio_total;
    }

    public void imprimirDatos(){
        System.out.println("id = " + id);
        System.out.println("id_producto = " + id_producto);
        System.out.println("descripcion = " + descripcion);
        System.out.println("precio_total = " + precio_total);
    }
}
