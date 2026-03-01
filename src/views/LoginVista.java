package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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

public class LoginVista extends JPanel {
	
	private BufferedImage imagen;

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

        return panel;
    }
    
    public JPanel ingresarCorreo() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //panel.setOpaque(false);
        panel.setBackground(new Color(245, 245, 245));

        JLabel txtNombre = new JLabel("Correo electronico");
        txtNombre.setFont(new Font("Segoe UI", Font.BOLD, 18));
        txtNombre.setForeground(Color.BLACK);
        txtNombre.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(txtNombre);
        
        panel.add(Box.createVerticalStrut(5));

        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 15));
        textField.setMaximumSize(new Dimension(270, 35));
        textField.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(textField);

        JLabel textoError = new JLabel("Se requiere un correo para ingresar");
        textoError.setFont(new Font("Arial", Font.PLAIN + Font.ITALIC, 12));
        textoError.setForeground(Color.RED);
        textoError.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(textoError);

        return panel;
    }
    
    public JPanel ingresarContrasena() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //panel.setOpaque(false);
        panel.setBackground(new Color(245, 245, 245));

        JLabel txtcontrasena = new JLabel("Contraseña");
        txtcontrasena.setFont(new Font("Segoe UI", Font.BOLD, 18));
        txtcontrasena.setForeground(Color.BLACK);
        panel.add(Box.createVerticalStrut(5));


        txtcontrasena.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(txtcontrasena);
        
        panel.add(Box.createVerticalStrut(5));

        JPasswordField contrasena = new JPasswordField();
        contrasena.setFont(new Font("Arial", Font.PLAIN, 15));
        contrasena.setMaximumSize(new Dimension(270, 35));
        contrasena.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(contrasena);

        JLabel textoErrorContrasena = new JLabel("Se require una contraseña para ingresar");
        textoErrorContrasena.setFont(new Font("Arial", Font.PLAIN + Font.ITALIC, 12));
        textoErrorContrasena.setForeground(Color.RED);
        textoErrorContrasena.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(textoErrorContrasena);

        return panel;
    }
    
    public void bordePanel() {
    	
    	Border emptyBorder = BorderFactory.createEmptyBorder(10,10,10,10);
    	Border panelTitledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2),
    			"Bienvenid@!", TitledBorder.CENTER, TitledBorder.TOP, new Font ("Arial", Font.BOLD, 14), Color.BLACK);
    	
    	this.setBorder(BorderFactory.createCompoundBorder(emptyBorder, panelTitledBorder));
    }
    
    
    
}
