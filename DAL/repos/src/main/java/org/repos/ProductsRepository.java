package org.repos;

import org.common.DBConnectionManager;
import org.entities.Products;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductsRepository {


    private DBConnectionManager connectionManager = new DBConnectionManager();

    public int insert(Products product) throws ClassNotFoundException, SQLException {

        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "INSERT INTO products (name , description ,category_id,brand_id) "
                    + "VALUES ('" + product.getProduct_name() + "','" + product.getProduct_description() +"','" + product.getCat_id()+"','" + product.getBrands_id()+ "')";
            //3- execute Query
            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);

            //4- fetch result
            return noOfRowsAffected;
            //5-close connection
            //Auto close with ty with resource
        }

    }
    public int update(Products product) throws ClassNotFoundException, SQLException {
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "UPDATE  products SET "
                    + "name = '" + product.getProduct_name()+ "', "
                    + "description = '" + product.getProduct_description()+ "' "
                    + "WHERE id = " + product.getProduct_id() + "";
            //3- execute Query
            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);

            //4- fetch result
            return noOfRowsAffected;
            //5-close connection
            //Auto close with ty with resource
        }
    }
    public Products select(int id) throws ClassNotFoundException,SQLException{
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "SELECT * FROM  products WHERE id = "+id+"";
            //3- execute Query
            ResultSet result = stmt.executeQuery(sqlQuery);

            //4- fetch result
            while (result.next()) {
                Products product= new Products();
                product.setProduct_id(result.getInt("id"));
                product.setProduct_name(result.getString("name"));
                product.setProduct_description(result.getString("description"));
                return product;
            }
            return null;
            //5-close connection
            //Auto close with ty with resource
        }
    }
    public List<Products> selectAll() throws ClassNotFoundException,SQLException{
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "SELECT * FROM  products";
            //3- execute Query
            ResultSet result = stmt.executeQuery(sqlQuery);

            List<Products> allProducts = new ArrayList<>();
            //4- fetch result
            while (result.next()) {
                Products product=new Products();
                product.setProduct_id(result.getInt("id"));
                product.setProduct_name(result.getString("name"));
                product.setProduct_description(result.getString("description"));
                allProducts.add(product);
            }
            return allProducts;
            //5-close connection
            //Auto close with ty with resource
        }
    }






















}
