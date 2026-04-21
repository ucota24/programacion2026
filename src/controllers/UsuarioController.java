package controllers;

import repositorio.UsuarioRepositorio;
import tablemodels.UsuarioTableModel;
import vista.UsuarioFormDialog;
import vista.UsuarioVista;

public class UsuarioController {
	
	private UsuarioVista vista;
	private UsuarioRepositorio repositorio;
	private UsuarioTableModel model;
	
	public UsuarioController(UsuarioVista vista) {
		this.vista = vista;
		repositorio = new UsuarioRepositorio();
		
		vista.getBotonAgregar().addActionListener(e -> {
			UsuarioFormDialog form = new UsuarioFormDialog(null, null);
			form.setVisible(true);
		});
	}

}
