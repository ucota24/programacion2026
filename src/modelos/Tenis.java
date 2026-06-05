package modelos;

public class Tenis {
	
	private int idTenis;
    private String nombre;
    private String marca;
    private double precio;
    private double talla;
    private String color;
    private int stock;
    private String categoria;
    private String tipo;
	
	public Tenis() {
		
	}
	
	public Tenis(String nombre, String marca, double precio, double talla, 
            String color, int stock, String categoria, String tipo) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.talla = talla;
        this.color = color;
        this.stock = stock;
        this.categoria = categoria;
        this.tipo = tipo;
    }

	public int getIdTenis() {
		return idTenis;
	}

	public void setIdTenis(int idTenis) {
		this.idTenis = idTenis;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getTalla() {
		return talla;
	}

	public void setTalla(double talla) {
		this.talla = talla;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
