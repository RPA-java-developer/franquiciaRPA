package com.api.rest.reactiva.franquiciaRPA.dto;

import com.api.rest.reactiva.franquiciaRPA.model.Sucursal;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto implements Serializable {

    private String id;
    private String nombre;
    private Integer stock;
    private String sucursalId;

}
