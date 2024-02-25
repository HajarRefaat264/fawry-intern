package org.entities;

import lombok.Data;

@Data
public class Products {
    Integer product_id;
    Category category_id;
    Brands brand_id;
    String product_name;
    String product_description;
    public int getCat_id(){
        return category_id.id;

    }
    public int getBrands_id(){
        return brand_id.BrandId;

    }
    public void setCat_id(int cat){
        this.category_id.id=cat;
    }
    public void setBrands_id(int id){
       brand_id.BrandId=id;
    }
}
