package vista;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

import vista.FormularioRegistro;

public class LoginVentana extends JFrame {
	
	private LoginVista loginVista;
	
	public LoginVentana() {
		setSize(450,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100,100);
		setResizable(true);
		setTitle("SneakerShop");
		setLocationRelativeTo(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image myIcon = tk.getImage("src/image/logoventana1.png");
		setIconImage(myIcon);

		loginVista = new LoginVista(this);
		add(loginVista);
		
		setVisible(true);
		
	}
	
	public LoginVista getLoginVista() {
		return loginVista;
	}
	
	
	
	
	

}
