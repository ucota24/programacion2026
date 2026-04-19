package vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tablemodels.UsuarioTableModel;

public class UsuarioVista extends JPanel{
	
	private JTable table;
	
	public UsuarioVista() {
		setLayout(new BorderLayout());
		table = new JTable();
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void setTableModel(UsuarioTableModel model) {
		table.setModel(model);
	}
	
	public JTable getTable() {
		return table;
	}

}
