package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JFrame;

public class LoginView extends JPanel {
	
	Ventana ventana;

	public BufferedImage imagen;
	
	JTextField correoElectronico;
	JPasswordField contrasena;
	
	JLabel textoErrorCorreo;
	JLabel textoErrorContrasena;

    public LoginView(Ventana ventana) {
    	
    	this.ventana = ventana;
    	setBackground(new Color(245, 245, 245));  /*240, 248, 255 Azul claro*/   /*245, 245, 245 blanco*/ //30, 30, 30 negro
    	setLayout(new BorderLayout());
    	inicializarComponentes();
    	bordePanel();
    }
    
    
    public void inicializarComponentes() {

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBackground(new Color(245, 245, 245));
        
        JPanel panelCampos = new JPanel();
        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.Y_AXIS));
        panelCampos.setBackground(new Color(245, 245, 245));
        panelCampos.add(Box.createVerticalStrut(95));
        panelCampos.add(ingresarCorreo());
        panelCampos.add(Box.createVerticalStrut(20));
        panelCampos.add(ingresarContrasena());

        panelCentro.add(panelCampos, BorderLayout.CENTER);
        add(panelCentro, BorderLayout.CENTER);
        add(boton(), BorderLayout.SOUTH);
    }
    
    public JPanel boton() {
    	JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(245, 245, 245));
        
        JLabel lblRegistro = new JLabel("¿No tienes cuenta? \nCrea una ya mismo!");
        lblRegistro.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		lblRegistro.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblRegistro.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				abrirRegistro();
			}
			public void mouseEntered(MouseEvent e) {
				lblRegistro.setForeground(Color.GREEN);
			}
			public void mouseExited(MouseEvent e) {
				lblRegistro.setForeground(Color.BLACK);
			}
		});
		
		JPanel panelRegistro = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, -1));
		panelRegistro.setBackground(new Color(245, 245, 245));
		panelRegistro.add(lblRegistro);

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBoton.setBackground(new Color(245, 245, 245));
        
        JButton boton = new JButton("INGRESAR");
        boton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        boton.setPreferredSize(new Dimension(120, 40));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 45, 0));

        panel.add(panelBoton, BorderLayout.CENTER);
        
       /* JButton botonRegistro = new JButton("REGISTRATE");
        botonRegistro.setFont(new Font("Segoe UI", Font.BOLD, 12));
        botonRegistro.setPreferredSize(new Dimension(120, 40));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
        panel.add(panelBoton, BorderLayout.CENTER);
        panelBoton.add(botonRegistro);
        botonRegistro.addActionListener(e -> abrirRegistro()); */
        
        panelBoton.add(boton);
        boton.addActionListener(e -> alertaLogin());
        
        panel.add(panelBoton, BorderLayout.CENTER);
        panel.add(panelRegistro, BorderLayout.SOUTH);
        
        return panel;
    }
    
    public void alertaLogin() {
    		if(validacionLogin(correoElectronico.getText(), String.valueOf(contrasena.getPassword()))) {
    			JOptionPane.showMessageDialog(this, 
    					"Sesion Iniciada!", "Iniciar Sesion", JOptionPane.INFORMATION_MESSAGE);
    			
    			new VentanaPrincipal();
    			ventana.dispose();
    		}
    }
    
    public void abrirRegistro() {
    		new FormularioRegistro();
    		ventana.dispose();
    }
    
    public JPanel ingresarCorreo() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
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
        
        correoElectronico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					alertaLogin();
				}
			}
		});

        textoErrorCorreo = new JLabel();
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
        
        contrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					alertaLogin();
				}
			}
		});

        textoErrorContrasena = new JLabel();
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