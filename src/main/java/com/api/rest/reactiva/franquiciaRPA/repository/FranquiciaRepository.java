package com.api.rest.reactiva.franquiciaRPA.repository;

import com.api.rest.reactiva.franquiciaRPA.model.Franquicia;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface FranquiciaRepository extends ReactiveMongoRepository<Franquicia,String> {

    //Mono<Franquicia> findFirstByNombre(String nombre);

    //Mono<Contacto> findAllByTelefonoOrNombre(String telefonoOrNombre);



}
