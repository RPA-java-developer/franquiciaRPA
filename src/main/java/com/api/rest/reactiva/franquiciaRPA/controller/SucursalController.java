package com.api.rest.reactiva.franquiciaRPA.controller;


import com.api.rest.reactiva.franquiciaRPA.dto.SucursalDto;
import com.api.rest.reactiva.franquiciaRPA.model.Franquicia;
import com.api.rest.reactiva.franquiciaRPA.model.Sucursal;
import com.api.rest.reactiva.franquiciaRPA.services.FranquiciaService;
import com.api.rest.reactiva.franquiciaRPA.services.SucursalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/v1/acc")
@RequiredArgsConstructor
@Slf4j
public class SucursalController {

    @Autowired
    private final SucursalService sucursalService;


    @GetMapping("/sucursales")
    public Flux<SucursalDto> listarSucursales() {
        Flux<SucursalDto> sucursalAll = sucursalService.findAll();
        return sucursalAll;
    }





    @PostMapping("/sucursales")
    public Mono<SucursalDto> guardarSucursal(@RequestBody Mono<SucursalDto> sucursalDtoMono) {
        return sucursalService.save(sucursalDtoMono);
    }



    // Actualizar Sucursal por Id
    @PutMapping("/sucursales/{id}")
    public Mono<SucursalDto> actualizarSucursal(@RequestBody Mono<SucursalDto> sucursalDtoMono, @PathVariable String id){
        return sucursalService.update(sucursalDtoMono, id);
    }




    // Delete Product using Id
    @DeleteMapping("/sucursales/{id}")
    public Mono<Void> borrarSucursal(@PathVariable String id){
        return sucursalService.deleteById(id);
    }



}
