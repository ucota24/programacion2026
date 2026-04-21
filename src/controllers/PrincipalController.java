package controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import models.Usuario;
import repositorio.UsuarioRepositorio;
import tablemodels.UsuarioTableModel;
import vista.LoginVentana;
import vista.VentanaPrincipal;

public class PrincipalController {

	 private VentanaPrincipal vista;
	 
	 public PrincipalController(VentanaPrincipal vista) {
	        this.vista = vista;
	        registrarListeners();
	    }
	 
	 public void registrarListeners() {
	        
	        vista.botonUsuarios.addActionListener(e -> verUsuarios());
	        
	        vista.botonInicio.addActionListener(e -> vista.mostrarVista(VentanaPrincipal.INICIO));
	    }
	 
	 private void verUsuarios() {
		 
		 UsuarioController controller = new UsuarioController(vista.usuariosPanel);
		 
		 UsuarioRepositorio repositorio = new UsuarioRepositorio();
			
			try {
				List<Usuario> usuarios = repositorio.getUsuarios();
				
				UsuarioTableModel model = new UsuarioTableModel(usuarios);
				
				vista.usuariosPanel.setTableModel(model);
				
				vista.mostrarVista(VentanaPrincipal.USUARIOS);
				
			}catch (IOException ex) {
				JOptionPane.showMessageDialog(vista, ex.getMessage());
			}
	 }
	 
	 

	 /*public void handleClose() {
	        int opcion = JOptionPane.showConfirmDialog(vista, 
	            "¿Estás seguro de que quieres salir?", "Alerta", JOptionPane.YES_NO_OPTION);
	        
	        if (opcion == JOptionPane.YES_OPTION) {
	            new LoginController(new LoginVentana().getLoginVista());
	            vista.dispose();
	        }
	    }*/
	 
	 
}
