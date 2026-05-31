package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.DatabaseConnection;
import models.Pedido;

public class PedidoRepositorio {
	
	public int save(Pedido pedido) {
        String sql = "INSERT INTO pedido (total, idUsuario, idMetodoPago) VALUES (?, ?, ?)";
        
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        	
        	pst.setDouble(1, pedido.getTotal());
        	pst.setInt(2, pedido.getIdUsuario());
        	pst.setInt(3, pedido.getIdMetodoPago());
            pst.executeUpdate();
            
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
            	return rs.getInt(1);
            	}

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return -1;
        }
	
	public void saveDetalle(int idPedido, int idTenis, int cantidad, double precioUnitario) {
        String sql = "INSERT INTO pedido_producto (idPedido, idTenis, cantidad, precio) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPedido);
            stmt.setInt(2, idTenis);
            stmt.setInt(3, cantidad);
            stmt.setDouble(4, precioUnitario);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
	public void actualizarStock(int idTenis, int nuevoStock) {
        String sql = "UPDATE tenis SET stock = ? WHERE idTenis = ?";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nuevoStock);
            stmt.setInt(2, idTenis);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
	

}
