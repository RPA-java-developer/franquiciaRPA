package com.api.rest.reactiva.franquiciaRPA.dto;

import com.api.rest.reactiva.franquiciaRPA.model.Sucursal;

import java.util.List;

public record FranquiciaResponse(
    String id,
    String nombre,
    List<Sucursal> listaSucursales
) {}
