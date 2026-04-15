package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private String correo;
	private String contrasena;
	private String direccion;
	private String fecha_Nacimiento;
	private String telefono;
	private String ciudadEstado;
	
	public Usuario() {
		
    }

	public Usuario(String correo, String contrasena) {
		this.correo = correo;
		this.contrasena = contrasena;
	}
	
	public Usuario(String nombre, String apellido, String correo, String contrasena, 
			String direccion, String fecha_Nacimiento, String telefono, String ciudadEstado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.ciudadEstado = ciudadEstado;
        this.direccion = direccion;
        this.fecha_Nacimiento = fecha_Nacimiento;
        this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(String fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCiudadEstado() {
		return ciudadEstado;
	}

	public void setCiudadEstado(String ciudadEstado) {
		this.ciudadEstado = ciudadEstado;
	}
	
	public String toString() {
	    return "Nombre: " + nombre + "\nApellido: " + apellido + "\nCorreo: " + correo 
	        + "\nContraseña: " + contrasena + "\nCiudad / Estado: " + ciudadEstado + "Direccion: " + direccion 
	        + "Fecha de Nacimiento: " + fecha_Nacimiento + "Telfono: " + telefono;
	}

	public String toCsv() {
		return nombre + "," + apellido + "," + correo + "," + contrasena + "," + ciudadEstado 
				+ "," + direccion + "," + fecha_Nacimiento + "," + telefono;
	}
	
	public static Usuario fromCsv(String userData) {
		String data[] = userData.split(",");
		
		String nombre = data[0];
		String apellido = data[1];
	    String correo = data[2];
	    String contrasena = data[3];
	    String ciudadEstado = data[4];
	    String direccion = data[5];
	    String fecha_Nacimiento = data[6];
	    String telefono = data[7];
	    
	    List<String> languages = new ArrayList<String>();
	    
	    if(data.length > 5) {
	    	languages = Arrays.asList(data[5].split("\\|"));
	    }
	    
	    return new Usuario(nombre, apellido, correo, contrasena, ciudadEstado, direccion, fecha_Nacimiento, telefono);
		
	}
	
	
	

}