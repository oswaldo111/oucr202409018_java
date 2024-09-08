package com.oucr202409018_java.oucr202409018_java.servicios.implementaciones;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oucr202409018_java.oucr202409018_java.dtos.ProductsOUCR.ProductsOUCRGuardar;
import com.oucr202409018_java.oucr202409018_java.dtos.ProductsOUCR.ProductsOUCRModificar;
import com.oucr202409018_java.oucr202409018_java.dtos.ProductsOUCR.ProductsOUCRSalida;
import com.oucr202409018_java.oucr202409018_java.modelos.ProductsOUCR;
import com.oucr202409018_java.oucr202409018_java.repositorios.ProductsOUCRRespository;
import com.oucr202409018_java.oucr202409018_java.servicios.interfaces.IProductsOUCRService;

import io.swagger.v3.oas.annotations.servers.Server;

import org.modelmapper.ModelMapper;
@Service
public class ProductsOUCRService implements IProductsOUCRService {


     @Autowired
    private ProductsOUCRRespository productsOUCRRespository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductsOUCRSalida> obtenerTodos() {
         List<ProductsOUCR> productos = productsOUCRRespository.findAll();

        return productos.stream()
                .map(producto -> modelMapper.map(producto, ProductsOUCRSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProductsOUCRSalida> obtenerTodosPaginados(Pageable pageable) {
   
         Page<ProductsOUCR> page = productsOUCRRespository.findAll(pageable);

        List<ProductsOUCRSalida> productosDto = page.stream()
                .map(producto -> modelMapper.map(producto, ProductsOUCRSalida.class))
                .collect(Collectors.toList());

        return new PageImpl<>(productosDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public ProductsOUCRSalida obtenerPorId(Integer id) {
        // TODO Auto-generated method stub
        return modelMapper.map(productsOUCRRespository.findById(id).get(), ProductsOUCRSalida.class);


    }

    @Override
    public ProductsOUCRSalida crear(ProductsOUCRGuardar productsOUCRGuardar) {
        // TODO Auto-generated method stub
       
       
        ProductsOUCR productsOUCR = productsOUCRRespository.save(modelMapper.map(productsOUCRGuardar, ProductsOUCR.class));
        return modelMapper.map(productsOUCR, ProductsOUCRSalida.class);
    }

    @Override
    public ProductsOUCRSalida editar(ProductsOUCRModificar productsOUCRModificar) {
        // TODO Auto-generated method stub

        ProductsOUCR producto = productsOUCRRespository.save(modelMapper.map(productsOUCRModificar, ProductsOUCR.class));
        return modelMapper.map(producto, ProductsOUCRSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        // TODO Auto-generated method stub
        productsOUCRRespository.deleteById(id);

    }

}
