<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>

<%
    String DATABASE_URL = "jdbc:mysql://localhost:3306/prueba1";
    String DATABASE_USER = "usuario";
    String DATABASE_PASSWORD = "clave";
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        stmt = conn.createStatement();
        String sql = "SELECT * FROM carro";
        rs = stmt.executeQuery(sql);
%>

<table border="1">
    <tr>
        <th>ID Carro</th>
        <th>Plate</th>
        <th>Entry Time</th>
        <th>Exit Time</th>
        <th>Location</th>
        <th>Vehicle Type</th>
    </tr>

<%
        while (rs.next()) {
%>

    <tr>
        <td><%= rs.getInt("idcarro") %></td>
        <td><%= rs.getString("plate") %></td>
        <td><%= rs.getString("entrytime") %></td>
        <td><%= rs.getString("exittime") %></td>
        <td><%= rs.getString("location") %></td>
        <td><%= rs.getString("vehicletype") %></td>
    </tr>

<%
        }
%>

</table>

<%
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
        if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
        if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
    }
%>
