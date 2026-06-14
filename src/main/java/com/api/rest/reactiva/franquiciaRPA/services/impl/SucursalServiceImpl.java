package com.api.rest.reactiva.franquiciaRPA.services.impl;


import com.api.rest.reactiva.franquiciaRPA.dto.SucursalDto;
import com.api.rest.reactiva.franquiciaRPA.repository.FranquiciaRepository;
import com.api.rest.reactiva.franquiciaRPA.repository.SucursalRepository;
import com.api.rest.reactiva.franquiciaRPA.services.FranquiciaService;
import com.api.rest.reactiva.franquiciaRPA.services.SucursalService;
import com.api.rest.reactiva.franquiciaRPA.utils.SucursalUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class SucursalServiceImpl implements SucursalService {

    @NonNull
    private SucursalRepository sucursalRepository;


    // Get all products
    @Override
    public Flux<SucursalDto> findAll(){
        return sucursalRepository.findAll().map(SucursalUtils::entityToDto);
    }


    // Crea una Sucursal
    @Override
    public Mono<SucursalDto> save(Mono<SucursalDto> sucursalDtoMono){
        return  sucursalDtoMono.map(SucursalUtils::dtoToEntity)
                .flatMap(sucursalRepository::insert)
                .map(SucursalUtils::entityToDto);
    }

    // Actualizar Sucursal
    @Override
    public Mono<SucursalDto> update(Mono<SucursalDto> sucursalDtoMono, String id){
        return sucursalRepository.findById(id)
                .flatMap(p -> sucursalDtoMono.map(SucursalUtils::dtoToEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(sucursalRepository::save)
                .map(SucursalUtils::entityToDto);
    }

    // Borrar una Sucursal
    @Override
    public Mono<Void> deleteById(String id){
        return sucursalRepository.deleteById(id);
    }


}
