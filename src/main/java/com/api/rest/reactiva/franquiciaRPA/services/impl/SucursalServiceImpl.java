package com.api.rest.reactiva.franquiciaRPA.services.impl;


import com.api.rest.reactiva.franquiciaRPA.dto.ProductoSucursalFranquiciaDTO;
import com.api.rest.reactiva.franquiciaRPA.dto.SucursalDto;
import com.api.rest.reactiva.franquiciaRPA.repository.FranquiciaRepository;
import com.api.rest.reactiva.franquiciaRPA.repository.ProductoRepository;
import com.api.rest.reactiva.franquiciaRPA.repository.SucursalRepository;
import com.api.rest.reactiva.franquiciaRPA.services.FranquiciaService;
import com.api.rest.reactiva.franquiciaRPA.services.SucursalService;
import com.api.rest.reactiva.franquiciaRPA.utils.SucursalUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class SucursalServiceImpl implements SucursalService {

    @NonNull
    private SucursalRepository sucursalRepository;

    @NonNull
    private ProductoRepository productoRepository;



    public SucursalServiceImpl(SucursalRepository sucursalRepository, ProductoRepository productoRepository) {
        this.sucursalRepository = sucursalRepository;
        this.productoRepository = productoRepository;
    }


    // Get all products
    @Override
    public Flux<SucursalDto> findAll(){

        return sucursalRepository.findAll()
                .flatMap(sucursalConProductos ->
                        productoRepository.findBySucursalId(sucursalConProductos.getId())
                                .collectList()
                                .map(productos ->
                                        new SucursalDto(
                                                sucursalConProductos.getId(),
                                                sucursalConProductos.getNombre(),
                                                sucursalConProductos.getFranquiciaId(),
                                                productos
                                        )
                                )
                );
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
