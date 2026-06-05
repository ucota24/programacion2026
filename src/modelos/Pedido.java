package modelos;

import java.sql.Date;

public class Pedido {
	
	private int idPedido;
    private Date fecha;
    private double total;
    private int idUsuario;
    private int idMetodoPago;
    
    public Pedido() {
    	
    }
    
    public Pedido(double total, int idUsuario, int idMetodoPago) {
        this.total = total;
        this.idUsuario = idUsuario;
        this.idMetodoPago = idMetodoPago;
    }

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdMetodoPago() {
		return idMetodoPago;
	}

	public void setIdMetodoPago(int idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}
    
    

}
