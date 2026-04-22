package controllers;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.Usuario;
import repositorio.UsuarioRepositorio;
import tablemodels.UsuarioTableModel;
import vista.UsuarioFormDialog;
import vista.UsuarioVista;

public class UsuarioController {
	
	private UsuarioVista vista;
	private UsuarioRepositorio repositorio;
	private UsuarioTableModel model;
	private JFrame parentFrame;
	
	public UsuarioController(UsuarioVista vista, JFrame parentFrame, UsuarioRepositorio repositorio, UsuarioTableModel model) {
		
		this.vista = vista;
		this.parentFrame = parentFrame;
		this.repositorio = repositorio;
		this.model = model;

		registrarListeners();
	}

	private void registrarListeners() {
		
		vista.getBotonAgregar().addActionListener(e -> agregar());
		vista.getBotonEditar().addActionListener(e -> editar());
		vista.getBotonEliminar().addActionListener(e -> eliminar());
	}

	private void agregar() {
		
		UsuarioFormDialog form = new UsuarioFormDialog(parentFrame, null);
		form.setVisible(true);
		
		if (form.isGuardar()) {
	        try {
	            Usuario nuevo = form.getUsuarioFromForm();
	            repositorio.save(nuevo);
	            model.setUsuarios(repositorio.getUsuarios());
	            
	        } catch (IOException ex) {
	            JOptionPane.showMessageDialog(vista, "Error al guardar" + ex.getMessage());
	        }
	    }
	}

	private void editar() {
		int fila = vista.getSelectedRow();

		if (fila < 0) {
			JOptionPane.showMessageDialog(vista, "Selecciona un usuario para editar");
			return;
		}

		Usuario seleccionado = model.getUsuarioAt(fila);
		UsuarioFormDialog form = new UsuarioFormDialog(parentFrame, seleccionado);
		form.setVisible(true);

		if (form.isGuardar()) {
	        try {
	            Usuario editado = form.getUsuarioFromForm();
	            repositorio.actualizar(fila, editado);
	            model.setUsuarios(repositorio.getUsuarios());
	            
	        } catch (IOException ex) {
	            JOptionPane.showMessageDialog(vista,"Error al editar" + ex.getMessage());
	        }
	    }
	}
	
	private void eliminar() {
		
    }

	
	
	
}
