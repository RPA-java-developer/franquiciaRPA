package com.api.rest.reactiva.franquiciaRPA.services;


import com.api.rest.reactiva.franquiciaRPA.dto.ProductoEstadistica;
import com.api.rest.reactiva.franquiciaRPA.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
public class ProductAnalyticsService {



    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;


    public ProductAnalyticsService(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }



    public Flux<Producto> getProductsOrderedByPriceDesc() {
        // 1. Build the aggregation pipeline
        Aggregation aggregation = newAggregation(
                sort(Sort.Direction.DESC, "stock")
        );

        // 2. Execute it reactively using Flux
        return reactiveMongoTemplate.aggregate(aggregation, "producto", Producto.class);
    }



    public Flux<Producto> getProductsMayor(String id) {
        // 1. Build the aggregation pipeline
        Aggregation aggregation = newAggregation(
                // Etapa 1: Filtrar productos con precio mayor al mínimo ($match)
                match(Criteria.where("sucursalId").is(id)),

                sort(Sort.Direction.DESC, "stock"),

                limit(1)
        );

        // 2. Execute it reactively using Flux
        return reactiveMongoTemplate.aggregate(aggregation, "producto", Producto.class);
    }




    /*
    public Flux<ProductoEstadistica> getStatsByMinPrice(double minPrice) {

        // 1. Definir la canalización de agregación
        Aggregation aggregation = newAggregation(
                // Etapa 1: Filtrar productos con precio mayor al mínimo ($match)
                match(Criteria.where("stock").gt(minPrice)),

                // Etapa 2: Agrupar por categoría y realizar operaciones ($group)

                group("sucursalId")
                        .avg("stock").as("promedio")
                        .sum("stock").as("totalStock"),


                // Etapa 3: Proyectar y renombrar campos si es necesario ($project)
                project("promedio", "totalStock")
                        .and("_id").as("id")
                        .and("nombre").as("nombre")
                );

        // 2. Ejecutar de forma no bloqueante con ReactiveMongoTemplate
        return reactiveMongoTemplate.aggregate(
                aggregation,
                "producto",          // Nombre de la colección de origen
                ProductoEstadistica.class  // Clase del DTO de destino
        );

    }
    */





}
