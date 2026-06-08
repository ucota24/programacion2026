package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import utilidades.GestorTema;

public class VentanaPrincipal extends JFrame {
	
	public static final String INICIO = "INICIO";
	public static final String USUARIOS = "USUARIOS";
	public static final String TENIS = "TENIS";
	
	public JMenuItem verUsuarios;
	public JMenuItem hombreTenis;
	public JMenuItem mujerTenis;
	public JMenuItem ninosTenis;
	public JMenuItem admUsuarios;
	public JMenuItem perfil;
	public JMenuItem cerrarSesion;

	
	public JButton botonUsuarios;
	public JButton botonInicio;
	public UsuarioVista usuariosPanel;
	public TenisVista tenisPanel;
	
	private CardLayout cardLayout;
	private JPanel container;
	
	public VentanaPrincipal() {
		
		setSize(1200,500);
		setTitle("SneakerShop");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image myIcon = tk.getImage("src/image/logoventana1.png");
		setIconImage(myIcon);
		
		//FlatLightLaf.setup();
		UIManager.put("TitlePane.menuBarEmbedded", false); 
		
		setMenu();
		setVisible(true);
		
		crearNavbar();
		crearVistas();
		
	}
	
	public void crearNavbar() {
		JPanel navbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		//botonInicio = new JButton("Inicio");
		//botonUsuarios = new JButton("Usuarios");
		
		//navbar.add(botonInicio);
		//navbar.add(botonUsuarios);
		
		add(navbar, BorderLayout.NORTH);
	}
	
	private void crearVistas() {
		cardLayout = new CardLayout();
		container = new JPanel(cardLayout);
		
		JPanel inicioPanel = new JPanel(new BorderLayout());
		ImageIcon imagen = new ImageIcon("src/image/logoVentanaP.png");
		Image imagenEscalada = imagen.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH);
		JLabel lblImagen = new JLabel(new ImageIcon(imagenEscalada), JLabel.CENTER);
		inicioPanel.add(lblImagen, BorderLayout.CENTER);
		
		usuariosPanel = new UsuarioVista();
		tenisPanel = new TenisVista();
		
		container.add(inicioPanel, INICIO);
		container.add(usuariosPanel, USUARIOS);
		container.add(tenisPanel, TENIS);
		
		add(container, BorderLayout.CENTER);
		
	}
	
	public void mostrarVista(String vista) {
		cardLayout.show(container, vista);
	}
	
	public void setMenu() {
		
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		
		JMenu ajustes = new JMenu("Ajustes");
		mb.add(ajustes);
		
		JMenuItem tamanio = new JMenuItem("Ventana original");
		tamanio.addActionListener(e -> {
		    setSize(1200, 500);
		    setLocationRelativeTo(null);
		});
		ajustes.add(tamanio);
		
		JMenuItem inicio = new JMenuItem("Inicio");
		inicio.addActionListener(e -> mostrarVista(INICIO));
		mb.add(inicio);
		
		JMenu hombre = new JMenu("Hombre");
		hombre.setMnemonic(KeyEvent.VK_H);
		mb.add(hombre);
		hombreTenis = new JMenuItem("Ver catalogo");
		hombre.add(hombreTenis);
		
		JMenu mujer = new JMenu("Mujer");
		mujer.setMnemonic(KeyEvent.VK_M);
		mb.add(mujer);
		mujerTenis = new JMenuItem("Ver catalogo");
		mujer.add(mujerTenis);
		
		JMenu ninos = new JMenu("Niños");
		ninos.setMnemonic(KeyEvent.VK_N);
		mb.add(ninos);
		ninosTenis = new JMenuItem("Ver catalogo");
		ninos.add(ninosTenis);
		
		mb.add(Box.createHorizontalGlue());
		
		JMenu cuenta = new JMenu("Mi Cuenta");
		mb.add(cuenta);
		
		perfil = new JMenuItem("Perfil");
		cuenta.add(perfil);
		//cuenta.add(new JMenuItem("Mis Pedidos"));
		
		JMenuItem metodoPago = new JMenuItem("Metodo de Pago");
		metodoPago.addActionListener(e -> {
		    new MetodoPagoVentana();
		});
		cuenta.add(metodoPago);
		
		JMenu tema = new JMenu("Cambiar tema");
		JMenuItem temaClaro = new JMenuItem("Claro");
		temaClaro.addActionListener(e -> {
		    GestorTema.apply("light");
		});
		
		JMenuItem temaOscuro = new JMenuItem("Oscuro");
		temaOscuro.addActionListener(e -> {
		    GestorTema.apply("dark");
		});
		
		cerrarSesion = new JMenuItem("Cerrar Sesion");
		
		admUsuarios = new JMenuItem("Usuarios");

		tema.add(temaClaro);
		tema.add(temaOscuro);
		ajustes.add(tema);
		cuenta.add(admUsuarios);
		cuenta.add(cerrarSesion);
		
	}
	
	public void setWindowSize(int width, int height) {
		setSize(width, height);
	}
	
	public void setWindowLocation(int x, int y) {
		setLocation(x, y);
	}

	
	
	
	
	
	
	
	

}
