package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<MetodoPago> getByUsuario(int idUsuario) {
	    List<MetodoPago> lista = new ArrayList<>();
	    String sql = "SELECT * FROM metodo_pago WHERE idUsuario = ?";

	    try (Connection connection = DatabaseConnection.getConnection();
	        PreparedStatement pst = connection.prepareStatement(sql)) {
	    	pst.setInt(1, idUsuario);
	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	            MetodoPago metodopago = new MetodoPago();
	            metodopago.setId(rs.getInt("id"));
	            metodopago.setTipo(rs.getString("tipo"));
	            metodopago.setNombreTitular(rs.getString("nombreTitular"));
	            metodopago.setNumeroTarjeta(rs.getString("numeroTarjeta"));
	            metodopago.setFechaExpiracion(rs.getString("fechaExpiracion"));
	            metodopago.setCvv(rs.getString("cvv"));
	            metodopago.setIdUsuario(rs.getInt("idUsuario"));
	            lista.add(metodopago);
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return lista;
	}

}
