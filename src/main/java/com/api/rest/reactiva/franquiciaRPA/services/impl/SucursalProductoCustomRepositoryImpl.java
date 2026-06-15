package com.api.rest.reactiva.franquiciaRPA.services.impl;


import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.Aggregation;

import com.api.rest.reactiva.franquiciaRPA.dto.ProductoSucursalFranquiciaDTO;
import com.api.rest.reactiva.franquiciaRPA.repository.SucursalProductoCustomRepository;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
//import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


public class SucursalProductoCustomRepositoryImpl implements SucursalProductoCustomRepository {


    private final ReactiveMongoTemplate mongoTemplate;

    public SucursalProductoCustomRepositoryImpl(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public Flux<ProductoSucursalFranquiciaDTO> findAllSucursalesOrderByStockDesc() {

        Aggregation aggregation = Aggregation.newAggregation(

                // Se crea un documento por producto
                Aggregation.unwind("productosX"),

                //Se ordena descendentemente por el valor del Stock
                Aggregation.sort(
                        Sort.Direction.DESC,
                        "procutosX.stock"
                ),

                // Se construye la lista DTO
                Aggregation.project()
                        .and("_id").as("sucursalId")
                        .and("sucursalNombre").as("sucursalNombre")
                        .and("productoId").as("productoId")
                        .and("productoNombre").as("productoNombre")
                        .and("procutosX.stock").as("productoStock")
        );

        return mongoTemplate.aggregate(
                aggregation,
                "books",
                ProductoSucursalFranquiciaDTO.class
        );
    }

}
