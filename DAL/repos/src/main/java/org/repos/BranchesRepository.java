package org.repos;

import org.common.DBConnectionManager;
import org.entities.Branches;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BranchesRepository {
    private DBConnectionManager connectionManager = new DBConnectionManager();

    public int insert(Branches branches) throws ClassNotFoundException, SQLException {

        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "INSERT INTO branches (name , building , street_name , working_start , working_end ,telephone) "
                    + "VALUES ('" + branches.getBranch_name() + "','" + branches.getBuilding_number() + "','" + branches.getBranch_street_name() + "','" + branches.getBranch_working_start()+"','" + branches.getBranch_working_end()+"','" + branches.getBranch_telephone()+"')";
            //3- execute Query
            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);

            //4- fetch result
            return noOfRowsAffected;
            //5-close connection
            //Auto close with ty with resource
        }

    }
    public int update(Branches branches) throws ClassNotFoundException, SQLException {
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "UPDATE  branches SET "
                    + "name = '" + branches.getBranch_name()+ "', "
                    + "building = '" + branches.getBuilding_number()+ "' "
                    + " street_name = '" + branches.getBranch_street_name()+ "' "
                    + "working_start = '" + branches.getBranch_working_start()+ "' "
                    + "working_end = '" + branches.getBranch_working_end()+ "' "
                    + "telephone = '" + branches.getBranch_telephone()+ "' "
                    + "WHERE id = " + branches.getId()+ "";
            //3- execute Query
            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);

            //4- fetch result
            return noOfRowsAffected;
            //5-close connection
            //Auto close with ty with resource
        }
    }
    public Branches select(int id) throws ClassNotFoundException,SQLException{
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "SELECT * FROM branches WHERE id = "+id+"";
            //3- execute Query
            ResultSet result = stmt.executeQuery(sqlQuery);

            //4- fetch result
            while (result.next()) {
                Branches branches =new Branches();
                branches.setId(result.getInt("id"));
                branches.setBranch_name(result.getString("name"));
                branches.setBranch_street_name(result.getString("street_name"));
                branches.setBuilding_number(result.getString("building"));
                branches.setBranch_working_start(result.getDate("working_start"));
                branches.setBranch_working_end(result.getDate("working_end"));
                branches.setBranch_telephone(result.getString("telephone"));



                return branches;
            }
            return null;
            //5-close connection
            //Auto close with ty with resource
        }
    }
    public List<Branches> selectAll() throws ClassNotFoundException,SQLException{
        try (
                //1- connect
                Connection connection = connectionManager.connect();
                // 2 - prepare statement
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "SELECT * FROM  branches";
            //3- execute Query
            ResultSet result = stmt.executeQuery(sqlQuery);

            List<Branches> allBranches = new ArrayList<>();
            //4- fetch result
            while (result.next()) {
                Branches branches =new Branches();
                branches.setId(result.getInt("id"));
                branches.setBranch_name(result.getString("name"));
                branches.setBranch_street_name(result.getString("street_name"));
                branches.setBuilding_number(result.getString("building"));
                branches.setBranch_working_start(result.getDate("working_start"));
                branches.setBranch_working_end(result.getDate("working_end"));
                branches.setBranch_telephone(result.getString("telephone"));

                allBranches.add(branches);
            }
            return allBranches;
            //5-close connection
            //Auto close with ty with resource
        }
    }

}
