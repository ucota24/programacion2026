package views;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginWindow extends JFrame {
	
	public LoginWindow() {
		setSize(700,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100,100);
		setResizable(false);
		setTitle("Tienda de Tenis");
		setLocationRelativeTo(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image myIcon = tk.getImage("src/image/logoventana.png");
		setIconImage(myIcon);

		LoginView panelito = new LoginView();
		add(panelito);

		//FlowPanel flow = new FlowPanel();
		//add(flow);
		
		setVisible(true);
		
	}
	
	
	
	
	

}
