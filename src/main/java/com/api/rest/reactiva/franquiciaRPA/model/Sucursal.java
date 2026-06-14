package com.api.rest.reactiva.franquiciaRPA.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;
import java.util.Objects;


@Data
@Document(collection = "sucursal")
public class Sucursal {

    @Id
    private String id;
    private String nombre;
    private String franquiciaId; //clave foranea


    // Los productos se agregan en la consulta utilizando esta referencia
    @DocumentReference(lookup = "{ 'sucurdalId': ?#{#self._id} }")
    private List<Producto> listaProductos;

    public Sucursal() {
    }

    public Sucursal(String nombre, String franquiciaId, List<Producto> listaProductos) {
        this.nombre = nombre;
        this.franquiciaId = franquiciaId;
        this.listaProductos = listaProductos;
    }

    public Sucursal(String id, List<Producto> listaProductos, String franquiciaId, String nombre) {
        this.id = id;
        this.listaProductos = listaProductos;
        this.franquiciaId = franquiciaId;
        this.nombre = nombre;
    }

    public String getFranquiciaId() {
        return franquiciaId;
    }

    public void setFranquiciaId(String franquiciaId) {
        this.franquiciaId = franquiciaId;
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
