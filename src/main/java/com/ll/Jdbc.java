package com.ll;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jdbc {
    private static final Logger LOGGER = Logger.getLogger(Jdbc.class.getName());

    // 필드로 JDBC 연결 정보와 쿼리 정의
    private final String url;
    private final String username;
    private final String password;
    // private String sql;
    private boolean devMode;

    public Jdbc(String host, String username, String password, String database) {
        url = "jdbc:mysql://" + host + ":3306/" + database;
        this.username = username;
        this.password = password;
    }

    public void setDevMode(boolean devMode) {
        this.devMode = devMode;
        initLogger();
    }

    private void initLogger() {
        if (devMode) {
            LOGGER.setLevel(Level.FINE);
            LOGGER.info("Developer mode enabled. Detailed logs will be shown.");
        } else {
            LOGGER.setLevel(Level.INFO);
        }
    }

    // JDBC 실행 메서드 //  throws ClassNotFoundException, SQLException
    public void run(String sql) {
        // JDBC 드라이버 로드
        // Class.forName("com.mysql.cj.jdbc.Driver");
        LOGGER.fine("Parsing SQL: " + sql);
        String sqlType = getSqlType(sql);

        switch (sqlType) {
            case "SELECT" -> System.out.println("SELECT");
            case "INSERT" -> System.out.println("INSERT");
            case "UPDATE" -> System.out.println("UPDATE");
            case "DELETE" -> System.out.println("DELETE");
            default -> LOGGER.warning("Unsupported SQL type or complex query: " + sqlType);
        }
    }

    private String getSqlType(String sql) {
        String[] words = sql.trim().toUpperCase().split("\\s+");
        return words.length > 0 ? words[0] : "UNKNOWN";
    }


//        try (Connection con = DriverManager.getConnection(url, username, password);
//             Statement stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//             printResultSet(rs);
//
//        } catch (SQLException e) {
//            System.err.println("데이터베이스 오류: " + e.getMessage());
//            throw e;
//        }
//    }

//    // ResultSet 데이터를 출력하는 메서드
//    private void printResultSet(ResultSet rs) throws SQLException {
//        ResultSetMetaData metaData = rs.getMetaData();
//        int columnCount = metaData.getColumnCount();
//
//        // 테이블 헤더 출력
//        System.out.println("데이터베이스 결과:");
//        for (int i = 1; i <= columnCount; i++) {
//            System.out.printf("%-15s", metaData.getColumnName(i));
//        }
//        System.out.println();
//
//        // 테이블 데이터 출력
//        while (rs.next()) {
//            for (int i = 1; i <= columnCount; i++) {
//                System.out.printf("%-15s", rs.getString(i));
//            }
//            System.out.println();
//        }
//    } // end of printResultSet
}

