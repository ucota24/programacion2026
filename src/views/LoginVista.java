package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LoginVista extends JPanel {
	
	public BufferedImage imagen;
	JTextField correoElectronico;
	JPasswordField contrasena;
	
	JLabel textoErrorCorreo;
	JLabel textoErrorContrasena;

    public LoginVista() {
    setBackground(new Color(245, 245, 245));  /*240, 248, 255 Azul claro*/   /*245, 245, 245 blanco*/ //30, 30, 30 negro
    	setLayout(new BorderLayout());
    	//fondoLogin();
    inicializarComponentes();
    bordePanel();
    }
    
     /* public void fondoLogin () {
    	try {
            imagen = ImageIO.read(new File("src/image/fondologin.jpg"));
        } catch (IOException e) {
            System.out.println("No se encontró la imagen.");
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (imagen != null) {
            g2.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        }
    } */
    
    
    public void inicializarComponentes() {
        //add(tituloPagina(), BorderLayout.NORTH);

        JPanel panelCentro = new JPanel(new BorderLayout());
        //panelCentro.setOpaque(false);
        panelCentro.setBackground(new Color(245, 245, 245));
        //panelCentro.add(imagenPanel(),BorderLayout.EAST);
        
        JPanel panelCampos = new JPanel();
        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.Y_AXIS));
        //panelCampos.setOpaque(false);
        panelCampos.setBackground(new Color(245, 245, 245));
        panelCampos.add(Box.createVerticalStrut(95));
        panelCampos.add(ingresarCorreo());
        panelCampos.add(Box.createVerticalStrut(10));
        panelCampos.add(ingresarContrasena());

        panelCentro.add(panelCampos, BorderLayout.CENTER);
        add(panelCentro, BorderLayout.CENTER);
        add(boton(), BorderLayout.SOUTH);
    }
    
    public JPanel boton() {
    	JPanel panel = new JPanel(new BorderLayout());
    	//panel.setOpaque(false);
        panel.setBackground(new Color(245, 245, 245));

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //panelBoton.setOpaque(false);
        panelBoton.setBackground(new Color(245, 245, 245));
        JButton boton = new JButton("INGRESAR");
        boton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        boton.setPreferredSize(new Dimension(120, 40));
        panelBoton.add(boton);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));

        panel.add(panelBoton, BorderLayout.CENTER);

        /*boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Se inicio sesion", 
						"Sesion Iniciada", JOptionPane.INFORMATION_MESSAGE);
			}
		});*/
        
        boton.addActionListener(e -> alertaLogin());
        
        return panel;
    }
    
    public void alertaLogin() {
    		if(validacionLogin(correoElectronico.getText(), String.valueOf(contrasena.getPassword()))) {
    			JOptionPane.showMessageDialog(this, 
    					"Se inicio Sesion", "Sesion Iniciada", JOptionPane.INFORMATION_MESSAGE);
    		}
    	
    }
    
    public JPanel ingresarCorreo() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //panel.setOpaque(false);
        panel.setBackground(new Color(245, 245, 245));

        JLabel textoCorreo = new JLabel("Correo electronico");
        textoCorreo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        textoCorreo.setForeground(Color.BLACK);
        textoCorreo.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(textoCorreo);
        
        panel.add(Box.createVerticalStrut(5));

        correoElectronico = new JTextField();
        correoElectronico.setFont(new Font("Arial", Font.PLAIN, 15));
        correoElectronico.setMaximumSize(new Dimension(270, 35));
        correoElectronico.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(correoElectronico);

        textoErrorCorreo = new JLabel("");
        textoErrorCorreo.setFont(new Font("Arial", Font.PLAIN + Font.ITALIC, 12));
        textoErrorCorreo.setForeground(Color.RED);
        textoErrorCorreo.setAlignmentX(CENTER_ALIGNMENT);
        textoErrorCorreo.setVisible(false);
        panel.add(textoErrorCorreo);

        return panel;
    }
    
    public JPanel ingresarContrasena() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //panel.setOpaque(false);
        panel.setBackground(new Color(245, 245, 245));

        JLabel textoContrasena = new JLabel("Contraseña");
        textoContrasena.setFont(new Font("Segoe UI", Font.BOLD, 18));
        textoContrasena.setForeground(Color.BLACK);
        panel.add(Box.createVerticalStrut(5));


        textoContrasena.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(textoContrasena);
        
        panel.add(Box.createVerticalStrut(5));

        contrasena = new JPasswordField();
        contrasena.setFont(new Font("Arial", Font.PLAIN, 15));
        contrasena.setMaximumSize(new Dimension(270, 35));
        contrasena.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(contrasena);

        textoErrorContrasena = new JLabel("");
        textoErrorContrasena.setFont(new Font("Arial", Font.PLAIN + Font.ITALIC, 12));
        textoErrorContrasena.setForeground(Color.RED);
        textoErrorContrasena.setAlignmentX(CENTER_ALIGNMENT);
        textoErrorContrasena.setVisible(false);
        panel.add(textoErrorContrasena);

        return panel;
    }
    
    public void mostrarErrorCorreo(String message) {
		textoErrorCorreo.setText(message);
		textoErrorCorreo.setVisible(true);
		
    }
    
    public void mostrarErrorContrasena(String message) {
		textoErrorContrasena.setText(message);    	
		textoErrorContrasena.setVisible(true);
	
    }

    public void reinicioMensajeError() {
		textoErrorCorreo.setText("");
		textoErrorContrasena.setText("");
    }

    public boolean validacionLogin(String email, String password) {
		reinicioMensajeError();
	
		if (email.trim().isEmpty()) {
			mostrarErrorCorreo("El correo electronico es OBLIGATORIO");
			return false;
		}
	
		if (password.trim().isEmpty()) {
			mostrarErrorContrasena("La contraseña es OBLIGATORIA");
			return false;
		}
		
		return true;
    }
    
    public void bordePanel() {
    	
    		Border emptyBorder = BorderFactory.createEmptyBorder(10,10,10,10);
    		Border panelTitledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2),
    			"Bienvenid@!", TitledBorder.CENTER, TitledBorder.TOP, new Font ("Arial", Font.BOLD, 14), Color.BLACK);
    	
    			this.setBorder(BorderFactory.createCompoundBorder(emptyBorder, panelTitledBorder));
    	}
    
    
    
}
