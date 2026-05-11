package controladores;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import models.Usuario;
import repositorio.UsuarioRepositorio;
import tablemodels.UsuarioTableModel;
import utils.Configuracion;
import vista.LoginVentana;
import vista.VentanaPrincipal;

public class PrincipalController {

	private VentanaPrincipal vista;
	private UsuarioController uController;

	public PrincipalController(VentanaPrincipal vista) {
		this.vista = vista;
		
		loadWindowPreferences();
		registrarListeners();
	}

	public void registrarListeners() {

		vista.botonUsuarios.addActionListener(e -> verUsuarios());

		vista.botonInicio.addActionListener(e -> vista.mostrarVista(VentanaPrincipal.INICIO));
		
		vista.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            saveWindowPreferences();
	            handleClose();
	        }
	    });
		
	}

	private void verUsuarios() {

		UsuarioRepositorio repositorio = new UsuarioRepositorio();

		try {
			List<Usuario> usuarios = repositorio.getUsuarios();
			UsuarioTableModel model = new UsuarioTableModel(usuarios);
			vista.usuariosPanel.setTableModel(model);

			if (uController == null) {
				uController = new UsuarioController(vista.usuariosPanel, vista, repositorio, model);
			}

			vista.mostrarVista(VentanaPrincipal.USUARIOS);

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(vista, ex.getMessage());
		}
	}

	private void saveWindowPreferences() {
		
		Dimension size = vista.getSize();
		Point point = vista.getLocation();

		Configuracion.set("principal.window.width", String.valueOf(size.width));

		Configuracion.set("principal.window.height", String.valueOf(size.height));

		Configuracion.set("principal.window.x", String.valueOf(point.x));

		Configuracion.set("principal.window.y", String.valueOf(point.y));

	}

	private void loadWindowPreferences() {
		
		int width = Integer.parseInt(Configuracion.get("principal.window.width", "1200"));

		int height = Integer.parseInt(Configuracion.get("principal.window.height", "500"));

		String xValue = Configuracion.get("principal.window.x", "");

		String yValue = Configuracion.get("principal.window.y", "");

		if (!xValue.isBlank() && !yValue.isBlank()) {
			vista.setWindowLocation(Integer.parseInt(xValue), Integer.parseInt(yValue));
		} else {
			vista.setLocationRelativeTo(null);
		}

		vista.setWindowSize(width, height);
	}

	
	 public void handleClose() { 
		 
		 /*int opcion = JOptionPane.showConfirmDialog(vista, 
				 "¿Estás seguro de que quieres salir?", "Alerta", JOptionPane.YES_NO_OPTION);
		 
		 if (opcion == JOptionPane.YES_OPTION) { 
		 	new LoginController(new LoginVentana().getLoginVista()); */
		 	vista.dispose(); 
		 }
	 
	 
	 
	 
	 
	 
	 
}
	 
	 
	 
	 
	 
	 
	 
	 
	 

