package main;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import views.MiPanel;

public class Ventana extends JFrame {
	
	public Ventana() {
		setSize(700,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100,100);
		setResizable(false);
		setTitle("Tienda de Tenis");
		setLocationRelativeTo(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image myIcon = tk.getImage("src/image/logoteniventana.jpg");
		setIconImage(myIcon);
		
		MiPanel panelito= new MiPanel();
		
		add(panelito);
		
		setVisible(true);
		
	}
	
	
	
	
	

}
