package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class LoginView extends JPanel {
	
	public LoginView() {
		setBackground(new Color(240, 248, 255));     //245 245 220 beige claro  
		//setBackground(Color.GRAY);
		setLayout(null);
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		tituloPagina();
		boton();
		ingresarCorreo();
		ingresarContrasena();
		textoerrorInicioDeSesion();
		textoErrorContrasena();
		//imagenBoton();
		imagenPanel();
	}
	
	public void tituloPagina () {
		JLabel label = new JLabel ("Bienvenid@!");
		label.setFont(new Font("Arial" , Font.PLAIN,20));
		label.setBounds(290,-20,500,100);
		add(label);
	}
	
	public void boton() {
		JButton boton = new JButton("INGRESAR");
		boton.setBounds(265,490,150,50);
		//boton.setBackground(Color.lightGray);
		
		add(boton);
	}
	
	/*public void imagenBoton() {
		ImageIcon iconoOriginal = new ImageIcon("src/image/logoboton.png");

		Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

	    JButton boton = new JButton("INGRESAR", iconoEscalado);
	    boton.setBounds(265, 555, 150, 50);

		
		add(boton);
	}*/
	
	public void ingresarCorreo() {
		JLabel txtnombre = new JLabel ("Ingrese su correo electronico");
		txtnombre.setFont(new Font("Arial" , Font.PLAIN,20));
		txtnombre.setBounds(20,135,500,100);
		add(txtnombre);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("Arial" , Font.PLAIN,18));
		textField.setBounds(20,215,260,35);
		add(textField);
	}
	
	public void ingresarContrasena() {
		JLabel txtcontrasena = new JLabel ("Ingrese su contraseña");
		txtcontrasena.setFont(new Font("Arial", Font.PLAIN,20));
		txtcontrasena.setBounds(20,275,260,50);
		add(txtcontrasena);
		
		JPasswordField contrasena = new JPasswordField();
		contrasena.setFont(new Font("Arial", Font.PLAIN,18));
		contrasena.setBounds(20,330,260,35);
		add(contrasena);
	}
	
	public void textoerrorInicioDeSesion () {
		JLabel textoError = new JLabel ("Correo Incorrecto");
		textoError.setFont(new Font("Arial", Font.PLAIN,14));
		textoError.setBounds(20,220,500,100);
		textoError.setForeground(Color.RED);

		add(textoError);
	}
	
	public void textoErrorContrasena () {
		JLabel textoErrorContrasena = new JLabel("Contraseña Incorrecta");
		textoErrorContrasena.setFont(new Font("Arial", Font.PLAIN,14));
		textoErrorContrasena.setBounds(20,335,500,100);
		textoErrorContrasena.setForeground(Color.RED);
		add(textoErrorContrasena);
	}
	
	public void imagenPanel() {
	    ImageIcon iconoOriginal = new ImageIcon("src/image/logopanel.png");
	    
	    Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
	    ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
	    
	    JLabel labelImagen = new JLabel(iconoEscalado);
	    labelImagen.setBounds(400, 200, 250, 250);
	    add(labelImagen);
	}
	
}

	
	


