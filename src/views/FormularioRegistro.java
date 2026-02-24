package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import views.LoginWindow;

public class FormularioRegistro extends JFrame {
	
	public FormularioRegistro() {
		setSize(600,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100,100);
		setResizable(true);
		setTitle("Registro");
		setLocationRelativeTo(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image myIcon = tk.getImage("src/image/logoventana.png");
		setIconImage(myIcon);
		
		inicializarComponentes();
		
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		
		JLabel tituloRegistro = new JLabel("Datos Usuarios");
		tituloRegistro.setFont(new Font("Arial", Font.PLAIN, 20));
		add(tituloRegistro, BorderLayout.NORTH);
		tituloRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		JPanel panelComponentes = new JPanel();
		panelComponentes.setLayout(new BoxLayout(panelComponentes, BoxLayout.Y_AXIS));
		panelComponentes.setBorder(BorderFactory.createEmptyBorder(25,15,15,15));
		
		for (int i = 0; i < 20; i++ ) {
			JLabel textoCampo = new JLabel("Campo " + i);
			panelComponentes.add(textoCampo);
			
			JTextField texto = new JTextField(20);
			panelComponentes.add(texto);
		}
		
		JScrollPane scroll = new JScrollPane(panelComponentes);
		scroll.setHorizontalScrollBar(null);
		add(scroll);
		
		
	}
	
	

}
