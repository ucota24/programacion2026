package repositorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import config.DatabaseConnection;
import excepciones.UsuarioDuplicadoException;
import models.Usuario;

public class UsuarioRepositorio {
	
	public void save(Usuario usuario) throws IOException, UsuarioDuplicadoException {
		List<Usuario> usuarios = getUsuarios();
		
		for (Usuario u : usuarios) {
	        if (u.getCorreo().equals(usuario.getCorreo())) {
	            throw new UsuarioDuplicadoException("El correo " + usuario.getCorreo() + " ya esta registrado");
	        }
	    }
		
	    String sql = "INSERT INTO usuarios (nombre, apellido, correo, contrasena, ciudadEstado, direccion, "
	    		+ "fecha_nacimiento, telefono, rol) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    
	    try (Connection connection = DatabaseConnection.getConnection(); 
	    		PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	    	
	    	pst.setString(1, usuario.getNombre());
	    	pst.setString(2, usuario.getApellido());
	    	pst.setString(3, usuario.getCorreo());
	    	pst.setString(4, usuario.getContrasena());
	    	pst.setString(5, usuario.getCiudadEstado());
	    	pst.setString(6, usuario.getDireccion());
	    	pst.setString(7, usuario.getFecha_Nacimiento());
	    	pst.setString(8, usuario.getTelefono());
	    	pst.setString(9, usuario.getRol());
	    	pst.executeUpdate();
	    	
	    	ResultSet rs = pst.getGeneratedKeys();
	        if (rs.next()) {
	            usuario.setId(rs.getInt(1));
	        }
	    	
	        } catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	public List<Usuario> getUsuarios() throws IOException {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		 try (Connection connection = DatabaseConnection.getConnection();
				 Statement st = connection.createStatement();
				 ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
			    ) {
			        while (rs.next()) {
			        	Usuario usuario = new Usuario(
			        			rs.getInt("id"),
			        			rs.getString("nombre"),
			        			rs.getString("apellido"),
			        			rs.getString("correo"),
			        			rs.getString("direccion"),
			        			rs.getString("fecha_nacimiento"),
			        			rs.getString("telefono"),
			        			rs.getString("ciudadEstado"),
			        			rs.getString("rol"));
			        	usuarios.add(usuario);

			        }
			        
			    } catch (SQLException e) {
					e.printStackTrace();
				}
			    return usuarios;
			    
	}

	public boolean eliminar(int id) {
		
	    String sql = "DELETE FROM usuarios WHERE id = ?";
	    
	    try (Connection connection  = DatabaseConnection.getConnection();
	         PreparedStatement pst = connection .prepareStatement(sql)) {
	    	
	    	pst.setInt(1, id);
	        int affectedRows = pst.executeUpdate();
	        if (affectedRows > 0) {
	        	//System.out.println("Se elimino");
	        	return true;
	        }
	        
	    } catch (SQLException ex) {
	            ex.printStackTrace();    
	    }

	        return false;
	}

	public boolean actualizar(int index, Usuario actualizarUsuario) throws IOException {
	    
	    String sql = "UPDATE usuarios SET nombre=?, apellido=?, correo=?, ciudadEstado=?, direccion=?, fecha_nacimiento=?, "
	    		+ "telefono=?, rol=? WHERE id=?";
	    
	    try (Connection connection  = DatabaseConnection.getConnection();
	            PreparedStatement pst = connection .prepareStatement(sql)) {

	    	pst.setString(1, actualizarUsuario.getNombre());
	    	pst.setString(2, actualizarUsuario.getApellido());
	    	pst.setString(3, actualizarUsuario.getCorreo());
	    	pst.setString(4, actualizarUsuario.getCiudadEstado());
	    	pst.setString(5, actualizarUsuario.getDireccion());
	    	pst.setString(6, actualizarUsuario.getFecha_Nacimiento());
	    	pst.setString(7, actualizarUsuario.getTelefono());
	    	pst.setString(8, actualizarUsuario.getRol());
	    	pst.setInt(9, actualizarUsuario.getId());
	    	
	    	int affectedRows = pst.executeUpdate();
	    	
	    	if (affectedRows > 0) {
	    		
	    		return true;
	    	} 

	    } catch (SQLException ex) {
	    	ex.printStackTrace();
	    	
	    }
	    
	    return false;
	}

 
	
	

}
