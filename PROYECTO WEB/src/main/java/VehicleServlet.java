
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class VehicleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/prueba1";
    private static final String DATABASE_USER = "usuario";
    private static final String DATABASE_PASSWORD = "clave";

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String plate = request.getParameter("plate");
        String entryTime = request.getParameter("entryTime");
        String exitTime = request.getParameter("exitTime");
        String location = request.getParameter("location");
        String vehicleType = request.getParameter("vehicleType");

 
        if (plate.length() > 6) {
            response.getWriter().println("La placa del vehículo no debe superar los 6 caracteres.");
            return;
        }


        try {
            int entryTimeInt = Integer.parseInt(entryTime);
            int exitTimeInt = Integer.parseInt(exitTime);
        } catch (NumberFormatException e) {
            response.getWriter().println("Las horas de entrada y salida deben ser numéricas.");
            return;
        }


        crearVehiculo(plate, entryTime, exitTime, location, vehicleType);

     
        response.sendRedirect("adminPage.jsp");
    }

    private void crearVehiculo(String plate, String entryTime, String exitTime, String location, String vehicleType) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            String sql = "INSERT INTO carro (plate, entrytime, exittime, location, vehicletype) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, plate);
            stmt.setString(2, entryTime);
            stmt.setString(3, exitTime);
            stmt.setString(4, location);
            stmt.setString(5, vehicleType);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
