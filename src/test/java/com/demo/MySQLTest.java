package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/webnichetask?useSSL=false&serverTimezone=UTC";
        String user = "root";
       String password = "";  // Replace with actual password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

