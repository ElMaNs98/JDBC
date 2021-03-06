package com.marc.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDB {
	public static void main(String[] args) {
		Connection connection = null;
        String host="localhost";
        String port="5432";
        String db_name="postgres";
        String username="postgres";
        String password="admin";
        try {
        	        	
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
            
            if (connection != null) {
                System.out.println("Connection OK");
            } else {
                System.out.println("Connection Failed");
            }
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employee");
            
            while(rs.next()) {
            	System.out.println("------------");
            	String nom = rs.getString("name");
            	System.out.println(nom);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
