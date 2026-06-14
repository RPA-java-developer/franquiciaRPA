package com.api.rest.reactiva.franquiciaRPA.utils;


import com.api.rest.reactiva.franquiciaRPA.dto.SucursalDto;
import com.api.rest.reactiva.franquiciaRPA.model.Sucursal;
import org.springframework.beans.BeanUtils;

// Clase para convertir Sucursal a SucursalDto y viceversa
public class SucursalUtils {

    // Convertir Sucursal entity a SucursalDto
    public static SucursalDto entityToDto(Sucursal sucursal) {
        SucursalDto sucursalDto = new SucursalDto();
        BeanUtils.copyProperties(sucursal, sucursalDto);
        return sucursalDto;
    }

    // Convertir SucursalDto a Sucursal entity
    public static Sucursal dtoToEntity(SucursalDto sucursalDto) {
        Sucursal sucursal = new Sucursal();
        BeanUtils.copyProperties(sucursalDto, sucursal);
        return sucursal;
    }


}
