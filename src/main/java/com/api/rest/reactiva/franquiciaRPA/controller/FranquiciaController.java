package com.api.rest.reactiva.franquiciaRPA.controller;


import com.api.rest.reactiva.franquiciaRPA.dto.FranquiciaDto;
import com.api.rest.reactiva.franquiciaRPA.model.Franquicia;
import com.api.rest.reactiva.franquiciaRPA.repository.FranquiciaRepository;
import com.api.rest.reactiva.franquiciaRPA.services.FranquiciaService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/api/v1/acc")
@RequiredArgsConstructor
@Slf4j
public class FranquiciaController {




    private final FranquiciaService franquiciaService;


    @GetMapping("/franquicias")
    public Flux<Franquicia> listarFranquicias() {
        Flux<Franquicia> franquiciaAll = franquiciaService.findAll();
        return franquiciaAll;
    }


    @GetMapping(value = "/franquicias/{id}")
    public Mono<ResponseEntity<Franquicia>> obtenerContactoPorID(@PathVariable String id) {
        return franquiciaService.findById(id)
                .map(fraquiciaXid -> new ResponseEntity<>(fraquiciaXid, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/franquicias")
    public Mono<ResponseEntity<Franquicia>> guardarFranquicia(@RequestBody Franquicia franquicia) {
        return franquiciaService.save(franquicia)
                .map(franquiciaGuardada -> new ResponseEntity<>(franquiciaGuardada, HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(franquicia, HttpStatus.NOT_ACCEPTABLE));
    }



    @PutMapping("/franquicias/{id}")
    public Mono<ResponseEntity<Franquicia>> update(@RequestBody Franquicia franquicia, @PathVariable String id) {
        return franquiciaService.update(franquicia)
                .map(franquiciaActualizada -> new ResponseEntity<>(franquiciaActualizada, HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(franquicia, HttpStatus.NOT_ACCEPTABLE));

    }


    @DeleteMapping(value = "/franquicias/{id}")
    public Mono<Void> eliminarFranquicia(@PathVariable String id) {
        return franquiciaService.deleteById(id);
    }


}
