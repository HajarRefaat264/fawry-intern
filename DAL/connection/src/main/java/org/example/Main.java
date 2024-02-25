package org.example;

import org.entities.Brands;
import org.entities.Category;
import org.entities.Products;
import org.repos.BrandsRepository;
import org.repos.CategoriesRepository;
import org.repos.ProductsRepository;

import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CategoriesRepository categoriesRepository=new CategoriesRepository();
        Category newCategory=new Category();
        newCategory.setDescription("my laptop is very suitable for web applications");
        newCategory.setName("laptop 72");
        newCategory.setId(14);

        categoriesRepository.insert(newCategory);
        //brands
        BrandsRepository brandsRepository=new BrandsRepository();
        Brands brands=new Brands();
        brands.setBrand_name("lenovo-78");
        brands.setBrandId(14);
        brandsRepository.insert(brands);
        //products
       ProductsRepository productsRepository=new ProductsRepository();
        Products newProduct=new Products();
        newProduct.setBrands_id(brands.getBrandId());
        newProduct.setCat_id(newCategory.getId());
        newProduct.setProduct_description("my laptop is very suitable for web applications");
        newProduct.setProduct_name("laptop-59");

        productsRepository.insert(newProduct);
    }
    }