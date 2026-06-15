package com.api.rest.reactiva.franquiciaRPA.services;


import com.api.rest.reactiva.franquiciaRPA.dto.ProductoDto;
import com.api.rest.reactiva.franquiciaRPA.dto.SucursalDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {

    // Lista los productos por Sucursal
    Flux<ProductoDto> findAll();

    Mono<ProductoDto> save(Mono<ProductoDto> productoDtoMono);

    Mono<ProductoDto> update(Mono<ProductoDto> productoDtoMono, String id);

    Mono<Void> deleteById(String id);

}
