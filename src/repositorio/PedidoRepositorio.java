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

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql)) {
        	pst.setInt(1, idPedido);
        	pst.setInt(2, idTenis);
        	pst.setInt(3, cantidad);
        	pst.setDouble(4, precioUnitario);
        	pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
	public void actualizarStock(int idTenis, int nuevoStock) {
        String sql = "UPDATE tenis SET stock = ? WHERE idTenis = ?";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql)) {
        	pst.setInt(1, nuevoStock);
        	pst.setInt(2, idTenis);
        	pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
	public boolean tienePedidos(int idUsuario) {
	    String sql = "SELECT COUNT(*) FROM pedido WHERE idUsuario = ?";
	    try (Connection connection = DatabaseConnection.getConnection();
	         PreparedStatement pst = connection.prepareStatement(sql)) {
	    	pst.setInt(1, idUsuario);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            return rs.getInt(1) > 0;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
	
	

}
