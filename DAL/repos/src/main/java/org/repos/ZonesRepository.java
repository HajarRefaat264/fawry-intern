package org.repos;

import org.common.*;
import org.entities.Zones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ZonesRepository {
    private DBConnectionManager connectionManager = new DBConnectionManager();

    public int insert(Zones zone) throws ClassNotFoundException, SQLException {

        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "INSERT INTO zones (name) "
                    + "VALUES ('" + zone.getZone_name()  + "')";
            //3- execute Query
            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);

            //4- fetch result
            return noOfRowsAffected;
            //5-close connection
            //Auto close with ty with resource
        }

    }
    public int update(Zones zone) throws ClassNotFoundException, SQLException {
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "UPDATE zones SET "
                    + "name = '" + zone.getZone_name()+ "', "
                    + "WHERE id = " + zone.getZone_id() + "";
            //3- execute Query
            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);

            //4- fetch result
            return noOfRowsAffected;
            //5-close connection
            //Auto close with ty with resource
        }
    }
    public Zones select(int id) throws ClassNotFoundException,SQLException{
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "SELECT * FROM  zones WHERE id = "+id+"";
            //3- execute Query
            ResultSet result = stmt.executeQuery(sqlQuery);

            //4- fetch result
            while (result.next()) {
                Zones zone=new Zones();
                zone.setZone_id(result.getInt("id"));
                zone.setZone_name(result.getString("name"));

                return zone;
            }
            return null;
            //5-close connection
            //Auto close with ty with resource
        }
    }
    public List<Zones> selectAll() throws ClassNotFoundException,SQLException{
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "SELECT * FROM  zones";
            //3- execute Query
            ResultSet result = stmt.executeQuery(sqlQuery);

            List<Zones> allZones= new ArrayList<>();
            //4- fetch result
            while (result.next()) {
                Zones zone=new Zones();
                zone.setZone_id(result.getInt("id"));
                zone.setZone_name(result.getString("name"));
                allZones.add(zone);
            }
            return allZones;
            //5-close connection
            //Auto close with ty with resource
        }
    }

}
