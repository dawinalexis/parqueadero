
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    public static void main(String[] args) {
  
        String url = "jdbc:mysql://localhost:3306/prueba1?useSSL=false&serverTimezone=UTC";
        String usuario = "root";
        String contraseña = "dawin123";

        Connection conexión = null;

        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");

      
            conexión = DriverManager.getConnection(url, usuario, contraseña);

       

            System.out.println("Conexión exitosa a la base de datos MySQL.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
        } finally {
            try {
                if (conexión != null) {
                    conexión.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}