package main;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	public Ventana() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100,100);
		setResizable(false);
		setTitle("Mi ventana 2.0");
		setLocationRelativeTo(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image myIcon = tk.getImage("src/image/icono.jpg");
		setIconImage(myIcon);
		
		MiPanel panelito= new MiPanel();
		
		add(panelito);
		
		setVisible(true);
		
	}
	
	
	
	
	

}
