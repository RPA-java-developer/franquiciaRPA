package com.api.rest.reactiva.franquiciaRPA.repository;


import com.api.rest.reactiva.franquiciaRPA.model.Producto;
import com.api.rest.reactiva.franquiciaRPA.model.Sucursal;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductoRepository extends ReactiveMongoRepository<Producto,String> {

    Flux<Producto> findBySucursalId(String sucursalId);

    @Query(value = "{ 'sucursalId': ?0 }", exists = true)
    Mono<Boolean> existeProductoBySucursalId(String sucursalId);

    //Mono<Long> cantidadProductosBySucursalId(String sucursalId);

}
