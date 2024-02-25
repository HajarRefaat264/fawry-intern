package org.repos;

import org.common.DBConnectionManager;
import org.entities.ProductSizes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductSizesRepository {
    private DBConnectionManager connectionManager = new DBConnectionManager();

    public int insert(ProductSizes productSize) throws ClassNotFoundException, SQLException {

        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "INSERT INTO productsizes (quantity , price) "
                    + "VALUES ('" + productSize.getQuantity() + "','" + productSize.getPrice() + "')";
            //3- execute Query
            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);

            //4- fetch result
            return noOfRowsAffected;
            //5-close connection
            //Auto close with ty with resource
        }

    }
    public int update(ProductSizes productSizes) throws ClassNotFoundException, SQLException {
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "UPDATE  productsizes SET "
                    + "quantity= '" + productSizes.getQuantity()+ "', "
                    + "price = '" + productSizes.getPrice()+ "' "
                    + "WHERE id = " + productSizes.getId() + "";
            //3- execute Query
            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);

            //4- fetch result
            return noOfRowsAffected;
            //5-close connection
            //Auto close with ty with resource
        }
    }
    public ProductSizes select(int id) throws ClassNotFoundException,SQLException{
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "SELECT * FROM  productsizes WHERE id = "+id+"";
            //3- execute Query
            ResultSet result = stmt.executeQuery(sqlQuery);

            //4- fetch result
            while (result.next()) {
                ProductSizes productSizes=new ProductSizes();
                productSizes.setId(result.getInt("id"));
                productSizes.setQuantity(result.getInt("quantity"));
                productSizes.setPrice(result.getDouble("price"));
                return productSizes;
            }
            return null;
            //5-close connection
            //Auto close with ty with resource
        }
    }
    public List<ProductSizes> selectAll() throws ClassNotFoundException,SQLException{
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "SELECT * FROM  productsizes";
            //3- execute Query
            ResultSet result = stmt.executeQuery(sqlQuery);

            List<ProductSizes> allProductSizes = new ArrayList<>();
            //4- fetch result
            while (result.next()) {
                ProductSizes productSizes=new ProductSizes();
                productSizes.setId(result.getInt("id"));
                productSizes.setQuantity(result.getInt("quantity"));
                productSizes.setPrice(result.getDouble("price"));
                allProductSizes.add(productSizes);
            }
            return allProductSizes;
            //5-close connection
            //Auto close with ty with resource
        }
    }

}
