package com.api.rest.reactiva.franquiciaRPA.services;


import com.api.rest.reactiva.franquiciaRPA.dto.FranquiciaDto;
import com.api.rest.reactiva.franquiciaRPA.dto.FranquiciaResponse;
import com.api.rest.reactiva.franquiciaRPA.model.Franquicia;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface FranquiciaService {

        Mono<Franquicia> save(Franquicia franquicia);

        Mono<Franquicia> findById(String id);



        Mono<Franquicia> obtenerFranquiciaConSucursales(String franquiciaId);


        Flux<Franquicia> findAll();




        Mono<Franquicia> update(Franquicia franquicia);

        Mono<Void> deleteById(String id);

        Mono<Void> deleteFranquiciaCompleta(String id);
}