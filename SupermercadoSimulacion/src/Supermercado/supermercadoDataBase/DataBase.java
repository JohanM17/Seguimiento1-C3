package supermercadoDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {
    private static final String URL = "jdbc:mysql://localhost:3306/supermercado";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void guardarVenta(String nombreCaja, double total) {
        String query = "INSERT INTO ventas (caja, total) VALUES (?, ?)";

        try (Connection connection = conectar();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, nombreCaja);
            ps.setDouble(2, total);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
