package com.api.rest.reactiva.franquiciaRPA.services.impl;


import com.api.rest.reactiva.franquiciaRPA.dto.ProductoDto;
import com.api.rest.reactiva.franquiciaRPA.dto.SucursalDto;
import com.api.rest.reactiva.franquiciaRPA.model.Producto;
import com.api.rest.reactiva.franquiciaRPA.repository.ProductoRepository;
import com.api.rest.reactiva.franquiciaRPA.repository.SucursalRepository;
import com.api.rest.reactiva.franquiciaRPA.services.ProductoService;
import com.api.rest.reactiva.franquiciaRPA.utils.ProductoUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {


    @NonNull
    private ProductoRepository productoRepository;




    @Override
    public Flux<ProductoDto> findAll() {
        return productoRepository.findAll().map(ProductoUtils::entityToDto);
    }

    @Override
    public Mono<ProductoDto> save(Mono<ProductoDto> productoDtoMono) {
        return productoDtoMono.map(ProductoUtils::dtoToEntity)
                .flatMap(productoRepository::insert)
                .map(ProductoUtils::entityToDto);

    }

    @Override
    public Mono<ProductoDto> update(Mono<ProductoDto> productoDtoMono, String id) {
        return productoRepository.findById(id)
                .flatMap(producutoActualizar -> productoDtoMono.map(ProductoUtils::dtoToEntity)
                                .doOnNext(productoActualizado -> productoActualizado.setId(id)))
                                .flatMap(productoRepository::save)
                                .map(ProductoUtils::entityToDto);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return productoRepository.deleteById(id);
    }


}
