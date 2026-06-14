package com.api.rest.reactiva.franquiciaRPA.services;

import com.api.rest.reactiva.franquiciaRPA.dto.SucursalDto;
import com.api.rest.reactiva.franquiciaRPA.model.Franquicia;
import com.api.rest.reactiva.franquiciaRPA.model.Sucursal;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface SucursalService {



    // Lista las Sucursales
    Flux<SucursalDto> findAll();

    Mono<SucursalDto> save(Mono<SucursalDto> sucursalDtoMono);

    Mono<SucursalDto> update(Mono<SucursalDto> sucursalDtoMono, String id);


    Mono<Void> deleteById(String id);

}
