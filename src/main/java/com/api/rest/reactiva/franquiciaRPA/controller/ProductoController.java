package com.api.rest.reactiva.franquiciaRPA.controller;


import com.api.rest.reactiva.franquiciaRPA.dto.ProductoDto;
import com.api.rest.reactiva.franquiciaRPA.dto.SucursalDto;
import com.api.rest.reactiva.franquiciaRPA.services.ProductoService;
import com.api.rest.reactiva.franquiciaRPA.services.SucursalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/v1/acc")
@RequiredArgsConstructor
@Slf4j
public class ProductoController {


    @Autowired
    private final ProductoService productoService;


    @GetMapping("/productos")
    public Flux<ProductoDto> listarProductos() {
        Flux<ProductoDto> productosAll = productoService.findAll();
        return productosAll;
    }



    @PostMapping("/productos")
    public Mono<ProductoDto> guardarProducto(@RequestBody Mono<ProductoDto> productoDtoMono) {
        return productoService.save(productoDtoMono);
    }


    // Actualizar Sucursal por Id
    @PutMapping("/productos/{id}")
    public Mono<ProductoDto> actualizarSucursal(@RequestBody Mono<ProductoDto> productoDtoMono, @PathVariable String id){
        return productoService.update(productoDtoMono, id);
    }



    // Delete Product por Id
    @DeleteMapping("/productos/{id}")
    public Mono<Void> borrarProducto(@PathVariable String id){
        return productoService.deleteById(id);
    }

}
