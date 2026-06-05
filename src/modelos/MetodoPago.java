package modelos;

public class MetodoPago {
	
	private int id;
    private String tipo;
    private String nombreTitular;
    private String numeroTarjeta;
    private String fechaExpiracion;
    private String cvv;
    private int idUsuario;
    
    public MetodoPago() {
    	
    }
    
    public MetodoPago(String tipo, String nombreTitular, String numeroTarjeta, String fechaExpiracion, String cvv, int idUsuario) {
    	this.tipo = tipo;
    	this.nombreTitular = nombreTitular;
    	this.numeroTarjeta = numeroTarjeta;
    	this.fechaExpiracion = fechaExpiracion;
    	this.cvv = cvv;
    	this.idUsuario = idUsuario;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(String fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
    
    

}
