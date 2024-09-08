package com.oucr202409018_java.oucr202409018_java.dtos.ProductsOUCR;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsOUCRModificar implements Serializable {

    private Integer id;

    private String NombreOUCR;

    private String DescripcionOUCR;

    private double PrecioOUCR;
}
