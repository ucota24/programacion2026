package controladores;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.Usuario;
import repositorio.UsuarioRepositorio;
import servicios.ExportarPDF;
import tablemodels.UsuarioTableModel;
import vista.UsuarioFormDialog;
import vista.UsuarioVista;
import excepciones.UsuarioDuplicadoException;


public class UsuarioController {
	
	private UsuarioVista vista;
	private UsuarioRepositorio repositorio;
	private UsuarioTableModel model;
	private JFrame parentFrame;
	private ExportarPDF exportarPDF;
	
	public UsuarioController(UsuarioVista vista, JFrame parentFrame, UsuarioRepositorio repositorio, UsuarioTableModel model) {
		
		this.vista = vista;
		this.parentFrame = parentFrame;
		this.repositorio = repositorio;
		this.model = model;
		this.exportarPDF = new ExportarPDF();

		registrarListeners();
	}

	private void registrarListeners() {
		
		vista.getBotonAgregar().addActionListener(e -> agregar());
		vista.getBotonEditar().addActionListener(e -> editar());
		vista.getBotonEliminar().addActionListener(e -> eliminar());
		vista.getBotonPDF().addActionListener(e -> generarPdf());
	}

	private void agregar() {
		
		UsuarioFormDialog form = new UsuarioFormDialog(parentFrame, null);
		form.setVisible(true);
		
		if (form.isGuardar()) {
	        try {
	            Usuario nuevo = form.getUsuarioFromForm();
	            repositorio.save(nuevo);
	            model.setUsuarios(repositorio.getUsuarios());
	            
	        } catch (UsuarioDuplicadoException ex) {
	            JOptionPane.showMessageDialog(vista, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	            
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
	            editado.setId(seleccionado.getId());
	            repositorio.actualizar(seleccionado.getId(), editado);
	            model.setUsuarios(repositorio.getUsuarios());
	            
	        } catch (IOException ex) {
	            JOptionPane.showMessageDialog(vista,"Error al editar" + ex.getMessage());
	        }
	    }
	}
	
	private void eliminar() {
		
	    int fila = vista.getSelectedRow();

	    if (fila < 0) {
	        JOptionPane.showMessageDialog(vista, "Selecciona un usuario para eliminar");
	        return;
	    }

	    int confirmar = JOptionPane.showConfirmDialog(vista,
	        "¿Estás seguro de que quieres eliminar este usuario?", "Alerta", JOptionPane.YES_NO_OPTION);

	    if (confirmar == JOptionPane.YES_OPTION) {
	        try {
	            repositorio.eliminar(model.getUsuarioAt(fila).getId());
	            model.setUsuarios(repositorio.getUsuarios());
	        } catch (IOException ex) {
	            JOptionPane.showMessageDialog(vista, "Error al eliminar" + ex.getMessage());
	        }
	    }
	}

	private void generarPdf() {
	    File file = vista.selectPdfFile();

	    if (file == null) {
	        return;
	    }

	    try {
	        exportarPDF.exportarUsuarios(repositorio.getUsuarios(), file);
	        if (Desktop.isDesktopSupported()) {
	            Desktop.getDesktop().open(file);
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(vista, "Error al exportar");
	    }
	    
	}
	
}


