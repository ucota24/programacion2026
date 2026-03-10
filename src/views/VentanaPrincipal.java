package views;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {
	
	public VentanaPrincipal() {
		
		setSize(800,500);
		setTitle("SneakerShop");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image myIcon = tk.getImage("src/image/logoventana1.png");
		setIconImage(myIcon);
		
		setMenu();
		setVisible(true);
		
	}
	
	public void setMenu() {
		
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		
		JMenu hombre = new JMenu("Hombre");
		hombre.setMnemonic(KeyEvent.VK_H);
		mb.add(hombre);

		hombre.add(new JMenuItem("Ropa"));
		hombre.add(new JMenuItem("Tenis"));
		
		JMenu mujer = new JMenu("Mujer");
		mujer.setMnemonic(KeyEvent.VK_M);
		mb.add(mujer);

		mujer.add(new JMenuItem("Ropa"));
		mujer.add(new JMenuItem("Tenis"));
		
		mb.add(Box.createHorizontalGlue());
		
		JMenu cuenta = new JMenu("Mi Cuenta");
		mb.add(cuenta);

		cuenta.add(new JMenuItem("Perfil"));
		cuenta.add(new JMenuItem("Mis Pedidos"));
		cuenta.add(new JMenuItem("Metodo de Pago"));
		
		
}
	

	

}
