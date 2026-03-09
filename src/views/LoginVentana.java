package views;

import views.FormularioRegistro;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class LoginVentana extends JFrame {
	
	public LoginVentana() {
		setSize(600,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100,100);
		setResizable(true);
		setTitle("SneakerShop");
		setLocationRelativeTo(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image myIcon = tk.getImage("src/image/logoventana1.png");
		setIconImage(myIcon);

		LoginVista panelito = new LoginVista(this);
		add(panelito);
		
		setVisible(true);
		
	}
	
	
	
	
	

}
