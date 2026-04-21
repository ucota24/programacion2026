package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tablemodels.UsuarioTableModel;

public class UsuarioVista extends JPanel{
	
	private JTable table;
	private JButton botonEditar;
	private JButton botonAgregar;
	private JButton botonEliminar;
	
	public UsuarioVista() {
		setLayout(new BorderLayout());
		table = new JTable();
		
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.LEFT));

        botonAgregar = new JButton("Agregar");
        botonEditar = new JButton("Editar");
        botonEliminar = new JButton("Eliminar");

        panelButtons.add(botonAgregar);
        panelButtons.add(botonEditar);
        panelButtons.add(botonEliminar);
        
        add(panelButtons, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

	}
	
	public void setTableModel(UsuarioTableModel model) {
		table.setModel(model);
	}
	
	public JTable getTable() {
		return table;
	}
	
	public JButton getBotonAgregar() {
        return botonAgregar;
    }

    public JButton getBotonEditar() {
        return botonEditar;
    }

    public JButton getBotonEliminar() {
        return botonEliminar;
    }
	
    public int getSelectedRow() {
    	return table.getSelectedRow();
    }
	
	

}
