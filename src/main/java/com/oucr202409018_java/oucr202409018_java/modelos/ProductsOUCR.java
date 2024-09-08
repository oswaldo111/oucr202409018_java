package com.oucr202409018_java.oucr202409018_java.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ProductsOUCR")
public class ProductsOUCR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String NombreOUCR;

    private String DescripcionOUCR;

    private double PrecioOUCR;
}
