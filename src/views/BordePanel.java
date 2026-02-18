package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class BordePanel extends JPanel {
	
	JPanel myPanel = new JPanel();
	
	public BordePanel () {
		borde()
		
	}
	
	public void borde() {
		Border emptyBorder = BorderFactory.createEmptyBorder(10,10,10,10);
		Border panelTiltleBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2), "Bienvenid@!", 
				TitledBorder.CENTER,TitledBorder.TOP,new Font("Arial", Font.BOLD,14),Color.BLACK);
		
		myPanel.setBorder(BorderFactory.createCompoundBorder(emptyBorder, panelTiltleBorder));
	}
	
	

}
