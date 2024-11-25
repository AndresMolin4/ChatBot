package chatbotcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Interaccion extends Conexion {
    public static void guardar(String usuario, String recomendacion) {
        String query = "INSERT INTO historial (usuario, recomendacion) VALUES (?, ?)";

        try (Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, usuario);
            stmt.setString(2, recomendacion);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Registros insertados.");
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar la recomendación.");
            e.printStackTrace();
        }
    }

    public static void select() {
        String query = "SELECT * FROM historial";
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String usuario = resultSet.getString("usuario");
                String recomendacion = resultSet.getString("recomendacion");
                System.out
                        .println("ID: " + id + ", Ingreso: " + usuario + ", Historial recomendación: " + recomendacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void delete(int id) {
        String query = "DELETE FROM historial WHERE id = ?";
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            System.out.println("Historial eliminado correctamente: " + rowsDeleted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteAll() {
        String query = "DELETE FROM historial";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
    
            int rowsDeleted = preparedStatement.executeUpdate();
            System.out.println("Todos los registros fueron eliminados correctamente. Filas borradas: " + rowsDeleted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

}
