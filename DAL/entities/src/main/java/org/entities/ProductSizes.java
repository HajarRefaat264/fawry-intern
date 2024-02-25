package org.entities;

import lombok.Data;

@Data
public class ProductSizes {
    Integer id;
    Products product_id;
    Sizes size_id;
    int quantity;
    double price;
}
