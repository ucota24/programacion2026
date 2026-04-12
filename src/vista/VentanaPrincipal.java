package vista;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

public class VentanaPrincipal extends JFrame {
	
	public VentanaPrincipal() {
		
		setSize(800,500);
		setTitle("                                                                                                     "
				+ "SneakerShop");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image myIcon = tk.getImage("src/image/logoventana1.png");
		setIconImage(myIcon);
		
		FlatLightLaf.setup();
		UIManager.put("TitlePane.menuBarEmbedded", false); 
		
		setMenu();
		setVisible(true);
		
	}
	
	public void setMenu() {
		
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		
		JMenu hombre = new JMenu("Hombre");
		hombre.setMnemonic(KeyEvent.VK_H);
		mb.add(hombre);

		hombre.add(new JMenuItem("Tenis"));
		hombre.add(new JMenuItem("Ropa"));
		
		JMenu mujer = new JMenu("Mujer");
		mujer.setMnemonic(KeyEvent.VK_M);
		mb.add(mujer);

		mujer.add(new JMenuItem("Tenis"));
		mujer.add(new JMenuItem("Ropa"));
		
		JMenu ninos = new JMenu("Niños");
		ninos.setMnemonic(KeyEvent.VK_N);
		mb.add(ninos);

		ninos.add(new JMenuItem("Tenis"));
		ninos.add(new JMenuItem("Ropa"));
		
		mb.add(Box.createHorizontalGlue());
		
		JMenu cuenta = new JMenu("Mi Cuenta");
		mb.add(cuenta);

		cuenta.add(new JMenuItem("Perfil"));
		cuenta.add(new JMenuItem("Mis Pedidos"));
		
		JMenuItem metodoPago = new JMenuItem("Metodo de Pago");
		metodoPago.addActionListener(e -> {
		    new MetodoPagoVentana();
		});
		cuenta.add(metodoPago);
		
}
	

	

}
