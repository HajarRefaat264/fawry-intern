package org.repos;

import org.common.DBConnectionManager;
import org.entities.Sizes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SizesRepository {
    private DBConnectionManager connectionManager = new DBConnectionManager();

    public int insert(Sizes size) throws ClassNotFoundException, SQLException {

        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "INSERT INTO sizes (name) "
                    + "VALUES ('" + size.getName() + "')";
            //3- execute Query
            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);

            //4- fetch result
            return noOfRowsAffected;
            //5-close connection
            //Auto close with ty with resource
        }

    }
    public int update(Sizes size) throws ClassNotFoundException, SQLException {
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "UPDATE sizes SET "
                    + "name = '" + size.getName()+ "', "
                    + "WHERE id = " + size.getId() + "";
            //3- execute Query
            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);

            //4- fetch result
            return noOfRowsAffected;
            //5-close connection
            //Auto close with ty with resource
        }
    }
    public Sizes select(int id) throws ClassNotFoundException,SQLException{
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "SELECT * FROM  sizes WHERE id = "+id+"";
            //3- execute Query
            ResultSet result = stmt.executeQuery(sqlQuery);

            //4- fetch result
            while (result.next()) {
                Sizes sizes=new Sizes();
                sizes.setId(result.getInt("id"));
                sizes.setName(result.getString("name"));

                return sizes;
            }
            return null;
            //5-close connection
            //Auto close with ty with resource
        }
    }
    public List<Sizes> selectAll() throws ClassNotFoundException,SQLException{
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "SELECT * FROM  sizes";
            //3- execute Query
            ResultSet result = stmt.executeQuery(sqlQuery);

            List<Sizes> allSizes= new ArrayList<>();
            //4- fetch result
            while (result.next()) {
                Sizes sizes=new Sizes();
                sizes.setId(result.getInt("id"));
                sizes.setName(result.getString("name"));
                allSizes.add(sizes);
            }
            return allSizes;
            //5-close connection
            //Auto close with ty with resource
        }
    }


}
