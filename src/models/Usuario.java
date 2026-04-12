package models;

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
	
	
	

}