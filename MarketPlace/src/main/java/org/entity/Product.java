package org.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.EnumMap;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private Long id;
    private static Long lastId=0l;
    private String name;
    private String barcode;
    private Category category;
    private Double price;
    private int amount;

    {
        lastId++;
        id=lastId;
    }

}
