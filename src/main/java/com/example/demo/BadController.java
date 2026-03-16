package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;

@RestController
public class BadController {

    // 1. 보안 취약점: SQL Injection 위험 (사용자 입력을 쿼리에 직접 결합)
    @GetMapping("/user")
    public String getUser(@RequestParam String id) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "admin", "p@ssword123"); // 하드코딩된 비번
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM users WHERE id = '" + id + "'"; // 위험한 방식
        ResultSet rs = stmt.executeQuery(query);
        return "User found";
    }

    // 2. Code Smell: 비어있는 catch 블록 (에러를 무시함)
    @GetMapping("/test")
    public void doSomething() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            // 아무것도 안 함 (SonarCloud가 매우 싫어함)
        }
    }
}