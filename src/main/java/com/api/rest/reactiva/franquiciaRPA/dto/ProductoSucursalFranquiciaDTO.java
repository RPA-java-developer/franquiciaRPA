package com.api.rest.reactiva.franquiciaRPA.dto;

public record ProductoSucursalFranquiciaDTO (
        String franquiciaId,
        String franquiciaNombre,
        String sucursalId,
        String sucursalNombre,
        String productoId,
        String productoNombre,
        Integer productoStock) {
}
