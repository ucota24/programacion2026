package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseConnection;
import modelos.Tenis;

public class TenisRepositorio {
	
	public List<Tenis> getByCategoria(String categoria) {
        List<Tenis> lista = new ArrayList<>();
        String sql = "SELECT * FROM tenis WHERE categoria = ?";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql)) {
        	pst.setString(1, categoria);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Tenis t = new Tenis();
                t.setIdTenis(rs.getInt("idTenis"));
                t.setNombre(rs.getString("nombre"));
                t.setMarca(rs.getString("marca"));
                t.setPrecio(rs.getDouble("precio"));
                t.setTalla(rs.getDouble("talla"));
                t.setColor(rs.getString("color"));
                t.setStock(rs.getInt("stock"));
                t.setCategoria(rs.getString("categoria"));
                t.setTipo(rs.getString("tipo"));
                lista.add(t);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

	public int save(Tenis tenis) {
	    String sql = "INSERT INTO tenis (nombre, marca, precio, talla, color, stock, categoria, tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection connection = DatabaseConnection.getConnection();
	         PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        pst.setString(1, tenis.getNombre());
	        pst.setString(2, tenis.getMarca());
	        pst.setDouble(3, tenis.getPrecio());
	        pst.setDouble(4, tenis.getTalla());
	        pst.setString(5, tenis.getColor());
	        pst.setInt(6, tenis.getStock());
	        pst.setString(7, tenis.getCategoria());
	        pst.setString(8, tenis.getTipo());
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

    public void eliminar(int id) {
        String sql = "DELETE FROM tenis WHERE idTenis = ?";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql)) {
        	
        	pst.setInt(1, id);
        	pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
