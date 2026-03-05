package org.example.Productos;


public class Producto {
    private String id;
    private String nombre;
    private String categoria;
    private String marca;
    private double precio;
    private int stock;
    private int stock_minimo;
    private String ultima_actualizacion;
    private String proveedor;
    private String codigo_barras;
    private int garantia_meses;


    public Producto(String id, String nombre, String categoria, String marca, double precio, int stock, int stock_minimo, String ultima_actualizacion, String proveedor, String codigo_barras, int garantia_meses) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
        this.stock_minimo = stock_minimo;
        this.ultima_actualizacion = ultima_actualizacion;
        this.proveedor = proveedor;
        this.codigo_barras = codigo_barras;
        this.garantia_meses = garantia_meses;
    }

}
