package com.ll;

import com.ll.entity.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class MainTest{
    private static Jdbc jdbc;

    @BeforeAll
    public static void setUp() {
        jdbc = new Jdbc("localhost", "root", "lldj123414", "jdbc_test_db");
        jdbc.setDevMode(true);
    }

    @Test
    @DisplayName("코드 판별 테스트")
    void queryPasingTest() {
        String select = "SELECT * FROM employee WHERE department = 'Sales' ORDER BY hire_date DESC";
        String update = "UPDATE employee SET salary = salary * 1.1 WHERE performance_rating >= 4";
        String delete = "DELETE FROM employee WHERE last_name = 'Smith' AND hire_date < '2020-01-01'";
        String insert = "INSERT INTO employee (first_name, last_name, department, salary) VALUES ('John', 'Doe', 'IT', 60000)";

        jdbc.run(select);
        jdbc.run(update);
        jdbc.run(delete);
        jdbc.run(insert);
    }

    // CREATE 메서드 테스트
//    @Test
//    void testCreateEmployee() {
//        Employee employee = new Employee(
//                "John", "Doe", "john.doe@example.com",
//                "IT", Date.valueOf("2024-01-01"), 75000.00
//        );
//
//        int generatedId = createEmployee(employee);
//
//        assertTrue(generatedId > 0, "Employee should be created with a valid ID");
//    }
//
//    // READ 메서드 테스트
//    @Test
//    void testFindEmployeeById() {
//        Employee employee = findEmployeeById(1);
//
//        assertNotNull(employee, "Employee should be found");
//        assertEquals("John", employee.getFirstName());
//    }
//
//    // UPDATE 메서드 테스트
//    @Test
//    void testUpdateEmployee() {
//        Employee employee = findEmployeeById(1);
//        employee.setSalary(80000.00);
//
//        boolean updated = updateEmployee(employee);
//
//        assertTrue(updated, "Employee should be updated successfully");
//    }
//
//    // DELETE 메서드 테스트
//    @Test
//    void testDeleteEmployee() {
//        boolean deleted = deleteEmployee(1);
//
//        assertTrue(deleted, "Employee should be deleted successfully");
//    }

}