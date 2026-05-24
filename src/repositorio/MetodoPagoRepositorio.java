package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.DatabaseConnection;
import models.MetodoPago;

public class MetodoPagoRepositorio {
	
	public void save(MetodoPago metodoPago) {
        String sql = "INSERT INTO metodo_pago (tipo, nombreTitular, numeroTarjeta, fechaExpiracion, cvv, idUsuario) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, metodoPago.getTipo());
            stmt.setString(2, metodoPago.getNombreTitular());
            stmt.setString(3, metodoPago.getNumeroTarjeta());
            stmt.setString(4, metodoPago.getFechaExpiracion());
            stmt.setString(5, metodoPago.getCvv());
            stmt.setInt(6, metodoPago.getIdUsuario());
            stmt.executeUpdate();
            //System.out.println("Metodo de pago guardado");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
