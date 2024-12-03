package com.ll;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Jdbc jdbc = new Jdbc("localhost", "root", "lldj123414", "jdbc_test_db");
        jdbc.setDevMode(true);
//        try {
//            // jdbc.run();
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
    }
}