package com.ll;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_test_db";
        String username = "test";
        String password = "1234";
        String sql = "SELECT * FROM employees WHERE id >= 5";

        try {
            // 드라이버 명시적 로드 (최신 버전에서는 선택사항)
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(url, username, password);
                 Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                // 메타데이터를 이용한 동적 열 처리
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                // 헤더 출력
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-15s", metaData.getColumnName(i));
                }
                System.out.println();

                // 데이터 출력
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%-15s", rs.getString(i));
                    }
                    System.out.println();
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }
}