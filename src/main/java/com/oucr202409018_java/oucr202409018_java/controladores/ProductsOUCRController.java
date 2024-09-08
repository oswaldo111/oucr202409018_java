package com.oucr202409018_java.oucr202409018_java.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.oucr202409018_java.oucr202409018_java.dtos.ProductsOUCR.ProductsOUCRGuardar;
import com.oucr202409018_java.oucr202409018_java.dtos.ProductsOUCR.ProductsOUCRModificar;
import com.oucr202409018_java.oucr202409018_java.dtos.ProductsOUCR.ProductsOUCRSalida;
import com.oucr202409018_java.oucr202409018_java.servicios.implementaciones.ProductsOUCRService;

@RestController
@RequestMapping("/api/product")
public class ProductsOUCRController {

      @Autowired
    private ProductsOUCRService productsOUCRService;

     @GetMapping
    public ResponseEntity<Page<ProductsOUCRSalida>> mostrarTodosPaginados(Pageable pageable){
        Page<ProductsOUCRSalida> productos = productsOUCRService.obtenerTodosPaginados(pageable);
        if(productos.hasContent()){
            return ResponseEntity.ok(productos);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ProductsOUCRSalida>> mostrarTodos(){
        List<ProductsOUCRSalida> productos = productsOUCRService.obtenerTodos();


        if(!productos.isEmpty()){
            return ResponseEntity.ok(productos);
        }

        return ResponseEntity.notFound().build();
    }

        @GetMapping("/{id}")
    public ResponseEntity<ProductsOUCRSalida> buscarPorId(@PathVariable Integer id){
        ProductsOUCRSalida producto = productsOUCRService.obtenerPorId(id);

        if(producto != null){
            return ResponseEntity.ok(producto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProductsOUCRSalida> crear(@RequestBody ProductsOUCRGuardar productsOUCRGuardar){
        ProductsOUCRSalida producto = productsOUCRService.crear(productsOUCRGuardar);
        return ResponseEntity.ok(producto);
    }

     @PutMapping("/{id}")
    public ResponseEntity<ProductsOUCRSalida> editar(@PathVariable Integer id, @RequestBody ProductsOUCRModificar productsOUCRModificar){
        ProductsOUCRSalida producto = productsOUCRService.editar(productsOUCRModificar);
        return ResponseEntity.ok(producto);
    }

       @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        productsOUCRService.eliminarPorId(id);
        return ResponseEntity.ok("producto eliminado correctamente");
    }
}
