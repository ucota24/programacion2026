package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

public class VentanaPrincipal extends JFrame {
	
	public static final String INICIO = "INICIO";
	public static final String USUARIOS = "USUARIOS";
	
	public JMenuItem verUsuarios;
	
	public JButton botonUsuarios;
	public JButton botonInicio;
	public UsuarioVista usuariosPanel;
	
	private CardLayout cardLayout;
	private JPanel container;
	
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
		
		crearNavbar();
		crearVistas();
		
	}
	
	public void crearNavbar() {
		JPanel navbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		botonInicio = new JButton("Inicio");
		botonUsuarios = new JButton("Usuarios");
		
		navbar.add(botonInicio);
		navbar.add(botonUsuarios);
		
		add(navbar, BorderLayout.NORTH);
	}
	
	private void crearVistas() {
		cardLayout = new CardLayout();
		container = new JPanel(cardLayout);
		
		JPanel inicioPanel = new JPanel();
		inicioPanel.add(new JLabel("Bienvenido al Sistema"));
		
		usuariosPanel = new UsuarioVista();
		
		container.add(inicioPanel, INICIO);
		container.add(usuariosPanel, USUARIOS);
		
		add(container, BorderLayout.CENTER);
		
	}
	
	public void mostrarVista(String vista) {
		cardLayout.show(container, vista);
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
