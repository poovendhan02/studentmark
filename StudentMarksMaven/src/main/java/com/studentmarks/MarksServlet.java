package com.studentmarks;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;

@WebServlet("/calculate")
public class MarksServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://db01.dbhost.dev:5051/db_457d83t66";
    private static final String DB_USER = "user_457d83t66";
    private static final String DB_PASSWORD = System.getenv("STUDENT_DB_PASSWORD");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        if (name == null || name.trim().isEmpty() || name.trim().length() > 100) {
            showError(request, response, "Please enter a valid student name."); return;
        }
        int a, b, c;
        try {
            a = parseMark(request.getParameter("subject1"));
            b = parseMark(request.getParameter("subject2"));
            c = parseMark(request.getParameter("subject3"));
        } catch (IllegalArgumentException ex) {
            showError(request, response, "Marks must be whole numbers from 0 to 100."); return;
        }
        int total = a + b + c;
        BigDecimal avg = BigDecimal.valueOf(total).divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP);
        String grade = avg.compareTo(BigDecimal.valueOf(90)) >= 0 ? "A"
                : avg.compareTo(BigDecimal.valueOf(75)) >= 0 ? "B"
                : avg.compareTo(BigDecimal.valueOf(60)) >= 0 ? "C"
                : avg.compareTo(BigDecimal.valueOf(40)) >= 0 ? "D" : "Fail";
        try {
            save(name.trim(), a, b, c, total, avg, grade);
        } catch (SQLException ex) {
            getServletContext().log("Database save failed", ex);
            showError(request, response, "Could not save result. Check database access, password, and table."); return;
        }
        request.setAttribute("studentName", name.trim());
        request.setAttribute("mark1", a); request.setAttribute("mark2", b);
        request.setAttribute("mark3", c); request.setAttribute("total", total);
        request.setAttribute("average", avg.toPlainString()); request.setAttribute("grade", grade);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    private int parseMark(String s) {
        if (s == null || !s.trim().matches("\\\\d{1,3}")) throw new IllegalArgumentException();
        int n = Integer.parseInt(s.trim());
        if (n < 0 || n > 100) throw new IllegalArgumentException();
        return n;
    }

    private void save(String name, int a, int b, int c, int total, BigDecimal avg, String grade)
            throws SQLException {
        if (DB_PASSWORD == null || DB_PASSWORD.isEmpty()) throw new SQLException("Set STUDENT_DB_PASSWORD.");
        String sql = "INSERT INTO student_results (student_name, subject1, subject2, subject3, total, average, grade) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, name); ps.setInt(2, a); ps.setInt(3, b); ps.setInt(4, c);
                ps.setInt(5, total); ps.setBigDecimal(6, avg); ps.setString(7, grade);
                ps.executeUpdate();
            }
        } catch (ClassNotFoundException ex) { throw new SQLException("MySQL JDBC driver missing", ex); }
    }

    private void showError(HttpServletRequest req, HttpServletResponse resp, String message)
            throws ServletException, IOException {
        req.setAttribute("errorMessage", message);
        req.getRequestDispatcher("/error.jsp").forward(req, resp);
    }
}
