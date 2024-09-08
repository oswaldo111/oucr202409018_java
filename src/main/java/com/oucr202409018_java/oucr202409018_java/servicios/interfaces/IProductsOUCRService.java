package com.oucr202409018_java.oucr202409018_java.servicios.interfaces;

import java.util.List;

import com.oucr202409018_java.oucr202409018_java.dtos.ProductsOUCR.ProductsOUCRGuardar;
import com.oucr202409018_java.oucr202409018_java.dtos.ProductsOUCR.ProductsOUCRModificar;
import com.oucr202409018_java.oucr202409018_java.dtos.ProductsOUCR.ProductsOUCRSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductsOUCRService {

    List<ProductsOUCRSalida> obtenerTodos();

    Page<ProductsOUCRSalida> obtenerTodosPaginados(Pageable pageable);

    ProductsOUCRSalida obtenerPorId(Integer id);

    ProductsOUCRSalida crear(ProductsOUCRGuardar productsOUCRGuardar);

    ProductsOUCRSalida editar(ProductsOUCRModificar productsOUCRModificar);

    void eliminarPorId(Integer id);
}
