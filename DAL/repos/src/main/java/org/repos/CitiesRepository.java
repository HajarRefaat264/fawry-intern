package org.repos;

import org.common.DBConnectionManager;
import org.entities.Cities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CitiesRepository {
    private DBConnectionManager connectionManager = new DBConnectionManager();

    public int insert(Cities city) throws ClassNotFoundException, SQLException {

        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "INSERT INTO cities (name) "
                    + "VALUES ('" + city.getCity_name() + "')";
            //3- execute Query
            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);

            //4- fetch result
            return noOfRowsAffected;
            //5-close connection
            //Auto close with ty with resource
        }

    }
    public int update(Cities city) throws ClassNotFoundException, SQLException {
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "UPDATE  cities SET "
                    + "name = '" + city.getCity_name()+ "', "

                    + "WHERE id = " + city.getId() + "";
            //3- execute Query
            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);

            //4- fetch result
            return noOfRowsAffected;
            //5-close connection
            //Auto close with ty with resource
        }
    }
    public Cities select(int id) throws ClassNotFoundException,SQLException{
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "SELECT * FROM  cities WHERE id = "+id+"";
            //3- execute Query
            ResultSet result = stmt.executeQuery(sqlQuery);

            //4- fetch result
            while (result.next()) {
                Cities city=new Cities();
                city.setId(result.getInt("id"));
                city.setCity_name(result.getString("name"));
                return city;
            }
            return null;
            //5-close connection
            //Auto close with ty with resource
        }
    }
    public List<Cities> selectAll() throws ClassNotFoundException,SQLException{
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "SELECT * FROM  cities";
            //3- execute Query
            ResultSet result = stmt.executeQuery(sqlQuery);

            List<Cities> allCities = new ArrayList<>();
            //4- fetch result
            while (result.next()) {
                Cities city=new Cities();
                city.setId(result.getInt("id"));
                city.setCity_name(result.getString("name"));

                allCities.add(city);
            }
            return allCities;
            //5-close connection
            //Auto close with ty with resource
        }
    }
}
