package com.api.rest.reactiva.franquiciaRPA.dto;

import com.api.rest.reactiva.franquiciaRPA.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class SucursalDto {

    private String id;
    private String nombre;
    private String franquiciaId;
    private List<Producto> listaProductos;

}
