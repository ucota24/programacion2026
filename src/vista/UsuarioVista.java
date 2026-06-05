package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import tablemodels.UsuarioTableModel;
import utilidades.AppFont;

public class UsuarioVista extends JPanel{
	
	private JTable table;
	private JButton botonEditar;
	private JButton botonAgregar;
	private JButton botonEliminar;
	private JButton botonPDF;
	
	public UsuarioVista() {
		setLayout(new BorderLayout());
		table = new JTable();
		styleTable();
		
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        botonAgregar = new JButton("Agregar");
        botonEditar = new JButton("Editar");
        botonEliminar = new JButton("Eliminar");
        botonPDF = new JButton("Exportar PDF");

        panelButtons.add(botonAgregar);
        panelButtons.add(botonEditar);
        panelButtons.add(botonEliminar);
        panelButtons.add(botonPDF);
        
        add(panelButtons, BorderLayout.SOUTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

	}
	
	public void styleTable() {
		 
        table.setRowHeight(35);
        table.setShowGrid(true);
        table.setGridColor(new Color(230, 230, 230));
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setFont(AppFont.normal());
 
        table.setSelectionBackground(new Color(52, 152, 200));
        table.setSelectionForeground(Color.WHITE);
 
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(44, 111, 80));
        header.setForeground(Color.WHITE);
        header.setFont(AppFont.normal());
        header.setPreferredSize(new Dimension(0, 40));
        header.setReorderingAllowed(false);
 
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
 
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
 
                if (!isSelected) {
                    if (row % 2 == 0) {
                        c.setBackground(Color.WHITE);
                    } else {
                        c.setBackground(new Color(220, 220, 220));
                    }
                    c.setForeground(Color.BLACK);
                }
 
                return c;
            }
        });
    }
	
	public void setTableModel(UsuarioTableModel model) {
		table.setModel(model);
		
		if (table.getColumnCount() >= 1) {
            table.getColumnModel().getColumn(0).setPreferredWidth(80);
        }
        if (table.getColumnCount() >= 2) {
            table.getColumnModel().getColumn(1).setPreferredWidth(80);
        }
        if (table.getColumnCount() >= 3) {
            table.getColumnModel().getColumn(2).setPreferredWidth(150);
        }
 
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.LEFT);
        if (table.getColumnCount() >= 1) {
            table.getColumnModel().getColumn(0).setCellRenderer(center);
        }
        
	}
	
	public File selectPdfFile() {
	    String path = System.getProperty("user.home");
	    JFileChooser chooser = new JFileChooser(path);

	    chooser.setSelectedFile(new File("reporte-usuarios.pdf"));

	    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Documentos PDF", "pdf");
	    chooser.addChoosableFileFilter(filter);
	    chooser.setFileFilter(filter);

	    int option = chooser.showDialog(this, "Exportar PDF de usuarios");

	    if (option != JFileChooser.APPROVE_OPTION) {
	        return null;
	    }

	    File file = chooser.getSelectedFile();

	    if (!file.getName().toLowerCase().endsWith(".pdf")) {
	        file = new File(file.getAbsolutePath() + ".pdf");
	    }

	    return file;
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
    
    public JButton getBotonPDF() {
        return botonPDF;
    }
	
    public int getSelectedRow() {
    	return table.getSelectedRow();
    }
    
    
	
	

}
