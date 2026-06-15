package com.api.rest.reactiva.franquiciaRPA.repository;

import com.api.rest.reactiva.franquiciaRPA.dto.ProductoSucursalFranquiciaDTO;
import reactor.core.publisher.Flux;

public interface SucursalProductoCustomRepository {

    Flux<ProductoSucursalFranquiciaDTO> findAllSucursalesOrderByStockDesc();

}
