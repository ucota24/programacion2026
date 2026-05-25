package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tablemodels.TenisTableModel;

public class TenisVista extends JPanel {
	
	private JTable tabla;
    private JButton botonAgregar;
    private JButton botonEliminar;
    private JButton botonComprar;

    public TenisVista() {
        setLayout(new BorderLayout());
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        tabla = new JTable();
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        botonAgregar = new JButton("Agregar");
        botonEliminar = new JButton("Eliminar");
        botonComprar = new JButton("Comprar");

        panelBotones.add(botonAgregar);
        panelBotones.add(botonEliminar);
        panelBotones.add(botonComprar);

        add(panelBotones, BorderLayout.NORTH);
    }

    public JTable getTabla() { 
    	return tabla; 
    	
    	}
    
    public JButton getBotonAgregar() {
    	return botonAgregar; 
    	}
    
    public JButton getBotonEliminar() {
    	return botonEliminar; 
    	}
    
    public JButton getBotonComprar() { 
    	return botonComprar; 
    	}
    

    public int getSelectedRow() {
        return tabla.getSelectedRow();
    }

    public void setTableModel(TenisTableModel model) {
        tabla.setModel(model);
    }

}
