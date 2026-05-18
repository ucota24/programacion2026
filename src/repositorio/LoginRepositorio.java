package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DatabaseConnection;
import models.Usuario;
import utils.PasswordUtils;

public class LoginRepositorio {
	
	public Usuario login(String correo, String contrasena) {

        String sql = "SELECT id, correo, contrasena, nombre, rol, FROM usuarios WHERE correo = ? " /*AND contrasena = ?"*/;

        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setString(1, correo);
            //stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashGuardado = rs.getString("contrasena");

                if (PasswordUtils.checkPassword(contrasena, hashGuardado)) {
                	Usuario usuario = new Usuario();
                	usuario.setId(rs.getInt("id"));
                	usuario.setCorreo(rs.getString("correo"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setRol(rs.getString("rol"));


                return usuario;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
        
	}
	
}


