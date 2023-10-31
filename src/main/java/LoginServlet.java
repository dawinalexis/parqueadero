
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/prueba1";
    private static final String DATABASE_USER = "usuario";
    private static final String DATABASE_PASSWORD = "clave";

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("user");
        String clave = request.getParameter("password");

        if (validarUsuario(usuario, clave)) {
            HttpSession session = request.getSession();
            session.setAttribute("role", "admin"); 

            // Redirige a todos los usuarios a la página createVehicle.html
            response.sendRedirect("createVehicle.html"); 
        } else {
            // Si el usuario no es válido, redirige al usuario a la página de inicio de sesión con un mensaje de error
            response.sendRedirect("login.jsp?error=invalid_credentials");
        }
    }

    private boolean validarUsuario(String usuario, String clave) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            String sql = "SELECT * FROM usuarios WHERE usuario = ? AND clave = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, clave);

            rs = stmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

