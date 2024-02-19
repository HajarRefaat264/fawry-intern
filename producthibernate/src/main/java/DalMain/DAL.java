package DalMain;

import entity.ProductEntity;
import repos.ProductRepository;

import java.util.List;

public class DAL {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();

        // Add a new Product
//        ProductEntity newProduct1 = new ProductEntity("Product A", 200);
//        productRepository.saveProduct(newProduct1);
//        productRepository.addProduct(newProduct1);
//        ProductEntity newProduct2 = new ProductEntity("Product B", 170.50);
//        productRepository.saveProduct(newProduct2);
//        productRepository.addProduct(newProduct2);
//        ProductEntity newProduct3 = new ProductEntity("Product C", 130.2);
//        productRepository.saveProduct(newProduct3);
//        productRepository.addProduct(newProduct3);
//        ProductEntity newProduct4 = new ProductEntity("Product D", 253.9);
//        productRepository.saveProduct(newProduct4);
//        productRepository.addProduct(newProduct4);
//        ProductEntity newProduct5 = new ProductEntity("Product E", 250);
//        productRepository.saveProduct(newProduct5);
//        productRepository.addProduct(newProduct5);
        //productRepository.deleteProduct(1);
        List<ProductEntity> allProducts = productRepository.findProducts();
        for (ProductEntity product : allProducts) {
            System.out.println("product Id: " + product.getId() +
                    ", Name: " + product.getName() +
                    ", Price: " + product.getPrice());
        }
    }
}
