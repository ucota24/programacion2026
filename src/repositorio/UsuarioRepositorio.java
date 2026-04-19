package repositorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import models.Usuario;

public class UsuarioRepositorio {
	
	private final String FILE = "src/files/usuario.csv";
	
	public void save(Usuario usuario) throws IOException {
		
		try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE, true), StandardCharsets.UTF_8))) {
			writer.write(usuario.toCsv());
			writer.newLine();
		}
		
	}
	
	public List<Usuario> getUsuarios() throws IOException {
		
		List<Usuario> users = new ArrayList<Usuario>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
			String line;
			
			while((line = reader.readLine()) != null) {
				Usuario usuario = Usuario.fromCsv(line);
				users.add(usuario);
			}
		}
		
		return users;
		
	}

}
