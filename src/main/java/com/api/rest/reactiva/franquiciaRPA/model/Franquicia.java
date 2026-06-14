package com.api.rest.reactiva.franquiciaRPA.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Document(collection = "franquicia")
public  @Data class Franquicia implements Serializable {

    private String id;
    private String nombre;

    // Los productos se incrustan directamente en el documento de la sucursal
    private List<Sucursal> listaSucursales;

    public Franquicia() {
    }

    public Franquicia(String nombre, List<Sucursal> listaSucursales) {
        this.nombre = nombre;
        this.listaSucursales = listaSucursales;
    }

    public Franquicia(String id, String nombre, List<Sucursal> listaSucursales) {
        this.id = id;
        this.nombre = nombre;
        this.listaSucursales = listaSucursales;
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

    public List<Sucursal> getListaSucursales() {
        return listaSucursales;
    }

    public void setListaSucursales(List<Sucursal> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Franquicia that = (Franquicia) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(listaSucursales, that.listaSucursales);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, listaSucursales);
    }

    @Override
    public String toString() {
        return "Franquicia{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", listaSucursales=" + listaSucursales +
                '}';
    }


}
