package com.api.rest.reactiva.franquiciaRPA.repository;


import com.api.rest.reactiva.franquiciaRPA.dto.ProductoSucursalFranquiciaDTO;
import com.api.rest.reactiva.franquiciaRPA.model.Sucursal;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface SucursalRepository extends ReactiveMongoRepository<Sucursal,String> {

    Flux<Sucursal> findByFranquiciaId(String franquiciaId);

    @Query(value = "{ 'franquiciaId': ?0 }", exists = true)
    Mono<Boolean> existeSucursalByFranquiciaId(String franquiciaId);

    //Mono<Long> cantidadSucursalesByFranquiciaId(String franquiciaId);



}
