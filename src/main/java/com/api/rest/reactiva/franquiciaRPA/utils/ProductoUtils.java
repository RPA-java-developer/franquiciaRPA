package com.api.rest.reactiva.franquiciaRPA.utils;

import com.api.rest.reactiva.franquiciaRPA.dto.ProductoDto;
import com.api.rest.reactiva.franquiciaRPA.dto.SucursalDto;
import com.api.rest.reactiva.franquiciaRPA.model.Producto;
import com.api.rest.reactiva.franquiciaRPA.model.Sucursal;
import org.springframework.beans.BeanUtils;

public class ProductoUtils {

    // Convertir Sucursal entity a SucursalDto
    public static ProductoDto entityToDto(Producto producto) {
        ProductoDto productoDto = new ProductoDto();
        BeanUtils.copyProperties(producto, productoDto);
        return productoDto;
    }

    // Convertir SucursalDto a Sucursal entity
    public static Producto dtoToEntity(ProductoDto productoDto) {
        Producto producto = new Producto();
        BeanUtils.copyProperties(productoDto, producto);
        return producto;
    }

}
