package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MiPanel extends JPanel {
	
	public MiPanel() {
		setBackground(new Color(245, 245, 220));
		setLayout(null);
		
		tituloPagina();
		boton();
		ingresarCorreo();
		ingresarContrasena();
				
	}
	
	public void tituloPagina () {
		JLabel label = new JLabel ("Iniciar Sesion");
		label.setFont(new Font("Arial" , Font.PLAIN,20));
		label.setBounds(280,5,500,100);
		add(label);
	}
	
	public void boton() {
		JButton boton = new JButton("INGRESAR");
		boton.setBounds(265,555,150,50);
		//boton.setBackground(Color.lightGray);
		
		add(boton);
	}
	
	public void ingresarCorreo() {
		JLabel txtnombre = new JLabel ("Ingrese su correo electronico");
		txtnombre.setFont(new Font("Arial" , Font.PLAIN,20));
		txtnombre.setBounds(205,170,500,100);
		add(txtnombre);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("Arial" , Font.PLAIN,18));
		textField.setBounds(205,245,260,35);
		add(textField);
	}
	
	public void ingresarContrasena() {
		JLabel txtcontrasena = new JLabel ("Ingrese su contraseña");
		txtcontrasena.setFont(new Font("Arial", Font.PLAIN,20));
		txtcontrasena.setBounds(230,300,260,50);
		add(txtcontrasena);
		
		JPasswordField contrasena = new JPasswordField();
		contrasena.setFont(new Font("Arial", Font.PLAIN,18));
		contrasena.setBounds(205,350,260,35);
		add(contrasena);
	}
	
	

}
