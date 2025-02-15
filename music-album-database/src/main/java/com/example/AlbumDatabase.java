package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class AlbumDatabase {
    public static void main( String[] args ) {
        String url = "jdbc:mariadb://localhost:3306/albums";
        String user = "root";
        String password = "4PassS0";
        String query = "SELECT * FROM albums";
        
        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int year = resultSet.getInt("year");
                String artist = resultSet.getString("artist");
                
                System.out.println(id + " " + name + " " + year + " " + artist);
            }
                connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}