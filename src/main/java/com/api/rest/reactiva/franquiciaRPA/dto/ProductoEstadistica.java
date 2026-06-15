package com.api.rest.reactiva.franquiciaRPA.dto;

public record ProductoEstadistica(
    String id,
    String nombre,
    Integer stock,
    String sucursalId,
    double promedio,
    int totalStock
) {}
