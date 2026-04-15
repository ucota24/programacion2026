package controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import models.Usuario;
import repositorio.UsuarioRepositorio;
import vista.LoginVentana;
import vista.VentanaPrincipal;

public class PrincipalController {

	 private VentanaPrincipal vista;
	 
	 public PrincipalController(VentanaPrincipal view) {
	        this.vista = view;
	        registrarListeners();
	    }
	 
	 public void registrarListeners() {
	        vista.verUsuarios.addActionListener(e -> {
	            UsuarioRepositorio repositorio = new UsuarioRepositorio();
	            try {
	                List<Usuario> usuarios = repositorio.getUsers();
	                for (Usuario u : usuarios) {
	                    System.out.println(u);
	                    System.out.println("----------------");
	                }
	            } catch (Exception ex) {
	                JOptionPane.showMessageDialog(vista, ex.getMessage());
	            }
	        });
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
