package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MiPanel extends JPanel {
	
	public MiPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JButton boton = new JButton("Mi boton");
		add(boton);
		
		JLabel label = new JLabel ("Inicia Sesion");
		label.setFont(new Font("Arial" , Font.PLAIN,20));
		label.setBounds(180,40,500,100);
		add(label);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("Arial" , Font.PLAIN,30));
		textField.setBounds(10,100,200,50);
		add(textField);
		
		
		
		//setBackground(new Color(210, 165, 35));
		
	}
	
	
	
	

}
