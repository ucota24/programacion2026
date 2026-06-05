package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import tablemodels.TenisTableModel;
import utilidades.AppFont;

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
		styleTable();
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        botonAgregar = new JButton("Agregar");
        botonEliminar = new JButton("Eliminar");
        botonComprar = new JButton("Comprar");

        panelBotones.add(botonAgregar);
        panelBotones.add(botonEliminar);
        panelBotones.add(botonComprar);

        add(panelBotones, BorderLayout.SOUTH);
    }
    
    public void styleTable() {
    	
    	tabla.setRowHeight(35);
    	tabla.setShowGrid(true);
    	tabla.setGridColor(Color.BLACK);
    	tabla.setBackground(Color.WHITE);
    	tabla.setForeground(Color.BLACK);
    	tabla.setFont(AppFont.normal());
    	
    	tabla.setSelectionBackground(new Color(210, 210, 210));
    	tabla.setSelectionForeground(Color.BLACK);
    	
    	tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	
    	JTableHeader header = tabla.getTableHeader();
    	header.setBackground(new Color(241, 239, 232));
    	header.setForeground(new Color(44, 44, 42));
    	header.setFont(AppFont.normal());
    	header.setPreferredSize(new Dimension(0, 40));
    	header.setReorderingAllowed(false);
    
    	tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
    		@Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
 
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
 
                if (!isSelected) {
                    if (row % 2 == 0) {
                        c.setBackground(new Color(249, 250, 251));
                    } else {
                        c.setBackground(new Color(249, 250, 251));
                    }
                    c.setForeground(Color.BLACK);
                }
 
                return c;
            }
        });
    		
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
