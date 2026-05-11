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
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import excepciones.UsuarioDuplicadoException;
import models.Usuario;

public class UsuarioRepositorio {
	
	private final String FILE = "." + File.separator + "data" + File.separator + "usuarios.json";
	private ObjectMapper mapper = new ObjectMapper()
	        .enable(SerializationFeature.INDENT_OUTPUT);
	
	public void save(Usuario usuario) throws IOException, UsuarioDuplicadoException {
		List<Usuario> usuarios = getUsuarios();
		
		for (Usuario u : usuarios) {
	        if (u.getCorreo().equals(usuario.getCorreo())) {
	            throw new UsuarioDuplicadoException("El correo " + usuario.getCorreo() + " ya esta registrado");
	        }
	    }
		
        usuarios.add(usuario);
        actualizarTodo(usuarios);
		
	}
	
	public List<Usuario> getUsuarios() throws IOException {
		
		File file = new File(FILE);
		
		file.getParentFile().mkdirs();
		
		if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }
		
        return mapper.readValue(
        		file, 
        		new TypeReference<List<Usuario>>() {}
        );
		
	}
	
	public void actualizarTodo(List<Usuario> usuarios) throws IOException {
		File file = new File(FILE);
		file.getParentFile().mkdir();
		
	    mapper.writeValue(file, usuarios);
	}

	public void eliminar(int index) throws IOException {
	    List<Usuario> usuarios = getUsuarios();
	    usuarios.remove(index);
	    actualizarTodo(usuarios);
	}

	public void actualizar(int index, Usuario actualizarUsuario) throws IOException {
	    List<Usuario> usuarios = getUsuarios();
	    usuarios.set(index, actualizarUsuario);
	    actualizarTodo(usuarios);
	}
	

}
