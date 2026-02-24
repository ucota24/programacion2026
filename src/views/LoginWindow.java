package views;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class LoginWindow extends JFrame {
	
	public LoginWindow() {
		setSize(600,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100,100);
		setResizable(true);
		setTitle("SneakersShop");
		setLocationRelativeTo(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image myIcon = tk.getImage("src/image/logoventana.png");
		setIconImage(myIcon);

		LoginView panelito = new LoginView();
		add(panelito);
		
		setVisible(true);
		
	}
	
	
	
	
	

}
