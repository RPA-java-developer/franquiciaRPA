package com.api.rest.reactiva.franquiciaRPA.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "sucursal")
public class Sucursal {

    private String id;
    private String nombre;

    // Los productos se incrustan directamente en el documento de la sucursal
    private List<Producto> listaProductos;

    public Sucursal() {
    }

    public Sucursal(String nombre, List<Producto> listaProductos) {
        this.nombre = nombre;
        this.listaProductos = listaProductos;
    }

    public Sucursal(String id, String nombre, List<Producto> listaProductos) {
        this.id = id;
        this.nombre = nombre;
        this.listaProductos = listaProductos;
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

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sucursal sucursal = (Sucursal) o;
        return Objects.equals(id, sucursal.id) && Objects.equals(nombre, sucursal.nombre) && Objects.equals(listaProductos, sucursal.listaProductos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, listaProductos);
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", listaProductos=" + listaProductos +
                '}';
    }

}
