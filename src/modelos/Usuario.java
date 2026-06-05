package modelos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Usuario {
	
	private String rol;
	private int id;
	private String nombre;
	private String apellido;
	private String correo;
	private String contrasena;
	private String direccion;
	private String fecha_nacimiento;
	private String telefono;
	private String ciudadEstado;
	
	public Usuario() {
		
    }

	public Usuario(int id,String correo, String contrasena) {
		this.id = id;
		this.correo = correo;
		this.contrasena = contrasena;
	}
	
	public Usuario(String nombre, String apellido, String correo, String contrasena, 
			String ciudadEstado, String direccion, String fecha_nacimiento, String telefono, String rol) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.ciudadEstado = ciudadEstado;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.rol = rol;
	}
	
	public Usuario(int id, String nombre, String apellido, String correo,String direccion, String fecha_nacimiento, String telefono, 
	        String ciudadEstado, String rol) {
	    this.id = id;
	    this.nombre = nombre;
	    this.apellido = apellido;
	    this.correo = correo;
	    this.direccion = direccion;
	    this.fecha_nacimiento = fecha_nacimiento;
	    this.telefono = telefono;
	    this.ciudadEstado = ciudadEstado;
	    this.rol = rol;
	}
	
	public String getRol() {
	    return rol;
	}

	public void setRol(String rol) {
	    this.rol = rol;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return fecha_nacimiento;
	}

	public void setFecha_Nacimiento(String fecha_Nacimiento) {
		this.fecha_nacimiento = fecha_Nacimiento;
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
	        + "\nCiudad / Estado: " + ciudadEstado + "Direccion: " + direccion 
	        + "Fecha de Nacimiento: " + fecha_nacimiento + "Telfono: " + telefono;
	}

	/*public String toCsv() {
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
	    
	    
	    return new Usuario(nombre, apellido, correo, contrasena, ciudadEstado, direccion, fecha_Nacimiento, telefono);
		
	}*/
	
	
	

}