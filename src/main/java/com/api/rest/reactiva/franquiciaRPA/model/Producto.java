package com.api.rest.reactiva.franquiciaRPA.model;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "producto")
public class Producto {

    private String id;
    private String nombre;
    private Integer stock;
    private String sucurdalId;


    public Producto() {
    }


    public Producto(String nombre, Integer stock, String sucurdalId) {
        this.nombre = nombre;
        this.stock = stock;
        this.sucurdalId = sucurdalId;
    }

    public Producto(String id, String nombre, Integer stock, String sucurdalId) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.sucurdalId = sucurdalId;
    }

    public String getSucurdalId() {
        return sucurdalId;
    }

    public void setSucurdalId(String sucurdalId) {
        this.sucurdalId = sucurdalId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id) && Objects.equals(nombre, producto.nombre) && Objects.equals(stock, producto.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, stock);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                '}';
    }

}
