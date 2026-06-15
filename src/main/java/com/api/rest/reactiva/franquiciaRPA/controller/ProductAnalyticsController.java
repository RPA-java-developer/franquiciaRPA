package com.api.rest.reactiva.franquiciaRPA.controller;

import com.api.rest.reactiva.franquiciaRPA.dto.ProductoEstadistica;
import com.api.rest.reactiva.franquiciaRPA.services.ProductAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/analytics")
public class ProductAnalyticsController {


    @Autowired
    private ProductAnalyticsService analyticsService;

    @GetMapping(value = "/productos", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<ProductoEstadistica> getCategoryStats(@RequestParam(defaultValue = "0") double minPrice) {
        return analyticsService.getStatsByMinPrice(minPrice);
    }



}
