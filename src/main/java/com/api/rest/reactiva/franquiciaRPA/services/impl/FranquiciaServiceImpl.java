package com.api.rest.reactiva.franquiciaRPA.services.impl;

import com.api.rest.reactiva.franquiciaRPA.dto.FranquiciaDto;
import com.api.rest.reactiva.franquiciaRPA.dto.FranquiciaResponse;
import com.api.rest.reactiva.franquiciaRPA.model.Franquicia;
import com.api.rest.reactiva.franquiciaRPA.repository.FranquiciaRepository;
import com.api.rest.reactiva.franquiciaRPA.repository.SucursalRepository;
import com.api.rest.reactiva.franquiciaRPA.services.FranquiciaService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;


@Service
public class FranquiciaServiceImpl implements FranquiciaService {


    @NonNull
    private final FranquiciaRepository franquiciaRepository;

    @NonNull
    private final SucursalRepository sucursalRepository;


    public FranquiciaServiceImpl(FranquiciaRepository franquiciaRepository, SucursalRepository sucursalRepository) {
        this.franquiciaRepository = franquiciaRepository;
        this.sucursalRepository = sucursalRepository;
    }






    // FETCH ONE-TO-MANY: Get a department and all its employees
    public Mono<Franquicia> obtenerFranquiciaConSucursales(String fanquiciaId) {
        return franquiciaRepository.findById(fanquiciaId)
                .flatMap(franquiciaRelacion -> sucursalRepository.findByFranquiciaId(franquiciaRelacion.getId())
                        .collectList()
                        .map(listaSucursales -> new Franquicia(franquiciaRelacion.getId(), franquiciaRelacion.getNombre(), listaSucursales))
                );
    }




    @Override
    public Flux<Franquicia> findAll() {

        return franquiciaRepository.findAll()
                .flatMap(franquicia ->
                        sucursalRepository.findByFranquiciaId(franquicia.getId())
                                .collectList()
                                .map(sucursales ->
                                        new Franquicia(
                                                franquicia.getId(),
                                                franquicia.getNombre(),
                                                sucursales
                                        )
                                )
                );
    }





    @Override
    public Mono<Franquicia> findById(String id) {
        return franquiciaRepository.findById(id);
    }

    @Override
    public Mono<Franquicia> save(Franquicia franquicia){
        if(Objects.nonNull(franquicia)){
            return franquiciaRepository.save(franquiciaMappingEntity(franquicia));
        }else{
            return null;
        }
    }


    @Override
    public Mono<Franquicia> update(Franquicia franquicia) {
        return this.franquiciaRepository.findById(franquicia.getId())
                .map(org -> franquiciaMappingEntity(franquicia))
                .flatMap(this.franquiciaRepository::save);
    }


    @Override
    public Mono<Void> deleteById(String id) {
        return franquiciaRepository.deleteById(id);
    }



    public Mono<Void> deleteFranquiciaCompleta(String franquiciaId) {

        return sucursalRepository.existeSucursalByFranquiciaId(franquiciaId)
                .flatMap(
                        tieneSucursales -> {
                            if (tieneSucursales ) {
                                return Mono.error(
                                        new IllegalStateException(
                                                "No se puede eliminar la franquicia porque tiene sucursales..."
                                        )
                                );
                            }
                            return franquiciaRepository.deleteById(franquiciaId);
                        }
                );
    }




    public static Franquicia franquiciaMappingEntity(Franquicia franquicia){
        Franquicia franquiciaOtra=new Franquicia();
        BeanUtils.copyProperties(franquicia, franquiciaOtra);
        return franquiciaOtra;
    }



}
