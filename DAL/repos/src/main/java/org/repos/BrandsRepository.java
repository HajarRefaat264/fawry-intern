package org.repos;

import org.common.DBConnectionManager;
import org.entities.Brands;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BrandsRepository {
    private DBConnectionManager connectionManager = new DBConnectionManager();

    public int insert(Brands brands) throws ClassNotFoundException, SQLException {

        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "INSERT INTO brands (name) "
                    + "VALUES ('" + brands.getBrand_name() + "')";
            //3- execute Query
            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);

            //4- fetch result
            return noOfRowsAffected;
            //5-close connection
            //Auto close with ty with resource
        }

    }
    public int update(Brands brands) throws ClassNotFoundException, SQLException {
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "UPDATE  brands SET "
                    + "name = '" + brands.getBrand_name()+ "', "

                    + "WHERE id = " + brands.getBrandId() + "";
            //3- execute Query
            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);

            //4- fetch result
            return noOfRowsAffected;
            //5-close connection
            //Auto close with ty with resource
        }
    }
    public Brands select(int id) throws ClassNotFoundException,SQLException{
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "SELECT * FROM  categories WHERE id = "+id+"";
            //3- execute Query
            ResultSet result = stmt.executeQuery(sqlQuery);

            //4- fetch result
            while (result.next()) {
                Brands brands=new Brands();
                brands.setBrandId(result.getInt("id"));
                brands.setBrand_name(result.getString("name"));
                return brands;
            }
            return null;
            //5-close connection
            //Auto close with ty with resource
        }
    }
    public List<Brands> selectAll() throws ClassNotFoundException,SQLException{
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "SELECT * FROM  brands";
            //3- execute Query
            ResultSet result = stmt.executeQuery(sqlQuery);

            List<Brands> allBrands = new ArrayList<>();
            //4- fetch result
            while (result.next()) {
                Brands brands=new Brands();
                brands.setBrandId(result.getInt("id"));
                brands.setBrand_name(result.getString("name"));

                allBrands.add(brands);
            }
            return allBrands;
            //5-close connection
            //Auto close with ty with resource
        }
    }

}
