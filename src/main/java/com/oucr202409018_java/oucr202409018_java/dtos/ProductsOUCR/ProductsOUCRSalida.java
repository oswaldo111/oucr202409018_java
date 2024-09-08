package com.oucr202409018_java.oucr202409018_java.dtos.ProductsOUCR;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductsOUCRSalida implements Serializable {
    private Integer id;

    private String NombreOUCR;

    private String DescripcionOUCR;

    private double PrecioOUCR;
}
