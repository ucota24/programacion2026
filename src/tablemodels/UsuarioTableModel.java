package tablemodels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import models.Usuario;

public class UsuarioTableModel extends AbstractTableModel{
	
	private List <Usuario> usuarios;
	
	private final String[] columns = {
			"Nombre", "Apellido", "Correo Electronico", "Ciudad / Estado", "Direccion", "Fecha de Nacimiento", "Telefono"
		};
	
	public UsuarioTableModel(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@Override
	public int getRowCount() {
		return usuarios.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Usuario usuario = usuarios.get(rowIndex);
		
		switch(columnIndex) {
		case 0:
			return usuario.getNombre();
		case 1:
			return usuario.getApellido();
		case 2:
			return usuario.getCorreo();
		case 3:
			return usuario.getCiudadEstado();
		case 4:
			return usuario.getDireccion();
		case 5:
			return usuario.getFecha_Nacimiento();
		case 6:
			return usuario.getTelefono();
		}
		
		return null;
		
	}

}
