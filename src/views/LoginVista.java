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

import exceptions.InvalidPasswordException;
import exceptions.InvalidUserException;
import utils.PlaceholderPasswordField;
import utils.PlaceholderTextField;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class LoginVista extends JPanel {
	
	LoginVentana loginVentana;
	public BufferedImage imagen;
	JTextField correoElectronico;
	JPasswordField contrasena;
	JLabel textoErrorCorreo;
	JLabel textoErrorContrasena;

    public LoginVista(LoginVentana loginVentana) {
    	
    	this.loginVentana = loginVentana;
    	setBackground(new Color(249, 250, 251));  /*240, 248, 255 Azul claro*/  //30, 30, 30 negro
    	setLayout(new BorderLayout());
    	inicializarComponentes();
    	bordePanel();
    }
    
    
    public void inicializarComponentes() {

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBackground(new Color(249, 250, 251));
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.Y_AXIS));
        panelTitulo.setBackground(new Color(249, 250, 251));
        panelTitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

        JLabel titulo = new JLabel("SneakerShop");
        titulo.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
        titulo.setAlignmentX(CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("Bienvenid@");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitulo.setForeground(new Color(107, 114, 128));
        subtitulo.setAlignmentX(CENTER_ALIGNMENT);

        panelTitulo.add(titulo);
        panelTitulo.add(Box.createVerticalStrut(4));
        panelTitulo.add(subtitulo);

        panelCentro.add(panelTitulo, BorderLayout.NORTH);
        
        JPanel panelCampos = new JPanel();
        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.Y_AXIS));
        panelCampos.setBackground(new Color(249, 250, 251));
        panelCampos.setMaximumSize(new Dimension(270, Integer.MAX_VALUE));
        panelCampos.setAlignmentX(CENTER_ALIGNMENT);
        panelCampos.add(Box.createVerticalStrut(45));
        panelCampos.add(ingresarCorreo());
        panelCampos.add(Box.createVerticalStrut(15));
        panelCampos.add(ingresarContrasena());
        
        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        wrapper.setBackground(new Color(249, 250, 251));
        wrapper.add(panelCampos);

        panelCentro.add(wrapper, BorderLayout.CENTER);
        add(panelCentro, BorderLayout.CENTER);
        add(boton(), BorderLayout.SOUTH);
    }
    
    public JPanel boton() {
    	JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(249, 250, 251));
        
        JLabel lblRegistro = new JLabel("¿No tienes cuenta? \nCrea una ya mismo!");
        lblRegistro.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		lblRegistro.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblRegistro.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				abrirRegistro();
			}
			public void mouseEntered(MouseEvent e) {
				lblRegistro.setForeground(new Color(107, 114, 128));
			}
			public void mouseExited(MouseEvent e) {
				lblRegistro.setForeground(new Color(17, 17, 17));
			}
		});
		
		JPanel panelRegistro = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, -1));
		panelRegistro.setBackground(new Color(249, 250, 251));
		panelRegistro.add(lblRegistro);

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 25));
        panelBoton.setBackground(new Color(249, 250, 251));
        
        JButton boton = new JButton("INGRESAR");
        boton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        boton.setPreferredSize(new Dimension(170, 40));
        boton.setBackground(new Color(17, 17, 17));
        boton.setForeground(Color.WHITE);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);

        panel.add(panelBoton, BorderLayout.CENTER);
        
        panelBoton.add(boton);
        boton.addActionListener(e -> alertaLogin());
        
        panel.add(panelBoton, BorderLayout.CENTER);
        panel.add(panelRegistro, BorderLayout.SOUTH);
        
        return panel;
    }
    
    public void alertaLogin() {
    	
    	try {
    		if(validacionLogin(correoElectronico.getText(), String.valueOf(contrasena.getPassword()))) {
    			JOptionPane.showMessageDialog(this, 
    					"Sesion Iniciada!", "Iniciar Sesion", JOptionPane.INFORMATION_MESSAGE);
    			
    			new VentanaPrincipal();
    			loginVentana.dispose();
    		}
    } catch (InvalidUserException ex) {
    			mostrarErrorCorreo(ex.getMessage());
    			
    		} catch (InvalidPasswordException ex) {
    			mostrarErrorContrasena(ex.getMessage());
    		}
    }
    
    public void abrirRegistro() {
    		new FormularioRegistro();
    		loginVentana.dispose();
    }
    
    public JPanel ingresarCorreo() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(249, 250, 251));
        panel.setPreferredSize(new Dimension(270, 80));
        panel.setMaximumSize(new Dimension(270, 80));
        
        ImageIcon iconoOriginal = new ImageIcon("src/image/imagenIconoCorreo.png");
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        JLabel iconoCorreo = new JLabel(new ImageIcon(imagenEscalada));
        iconoCorreo.setAlignmentX(LEFT_ALIGNMENT);
        panel.add(iconoCorreo);
        
        panel.add(Box.createVerticalStrut(5));

        correoElectronico = new PlaceholderTextField("usuario@correo.com");
        correoElectronico.setFont(new Font("Calibri", Font.PLAIN, 15));
        correoElectronico.setMaximumSize(new Dimension(270, 35));
        correoElectronico.setPreferredSize(new Dimension(270, 35));
        correoElectronico.setAlignmentX(LEFT_ALIGNMENT);
        panel.add(correoElectronico);
        
        correoElectronico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					alertaLogin();
				}
			}
		});

        panel.add(Box.createVerticalStrut(2));
        textoErrorCorreo = new JLabel(" ");
        textoErrorCorreo.setFont(new Font("Calibri", Font.PLAIN + Font.ITALIC, 12));
        textoErrorCorreo.setForeground(Color.RED);
        textoErrorCorreo.setAlignmentX(LEFT_ALIGNMENT);
        //textoErrorCorreo.setVisible(false);
        panel.add(textoErrorCorreo);

        return panel;
    }
    
    public JPanel ingresarContrasena() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(249, 250, 251));
        panel.setPreferredSize(new Dimension(270, 80));
        panel.setMaximumSize(new Dimension(270, 80));

        ImageIcon iconoOriginal = new ImageIcon("src/image/imagenCandado.png");
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        JLabel iconoContrasena = new JLabel(new ImageIcon(imagenEscalada));
        iconoContrasena.setAlignmentX(LEFT_ALIGNMENT);
        panel.add(iconoContrasena);
        
        panel.add(Box.createVerticalStrut(5));

        contrasena = new PlaceholderPasswordField("Contraseña");
        contrasena.setFont(new Font("Arial", Font.PLAIN, 15));
        contrasena.setMaximumSize(new Dimension(270, 35));
        contrasena.setPreferredSize(new Dimension(270, 35));
        contrasena.setAlignmentX(LEFT_ALIGNMENT);
        panel.add(contrasena);
        
        contrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					alertaLogin();
				}
			}
		});
        
        panel.add(Box.createVerticalStrut(2));
        textoErrorContrasena = new JLabel(" ");
        textoErrorContrasena.setFont(new Font("Calibri", Font.PLAIN + Font.ITALIC, 12));
        textoErrorContrasena.setForeground(Color.RED);
        textoErrorContrasena.setAlignmentX(LEFT_ALIGNMENT);
        //textoErrorContrasena.setVisible(false);
        panel.add(textoErrorContrasena);

        return panel;
    }
    
    public void mostrarErrorCorreo(String message) {
		textoErrorCorreo.setText(message);
		//textoErrorCorreo.setVisible(true);
    }
    
    public void mostrarErrorContrasena(String message) {
		textoErrorContrasena.setText(message);    	
		//textoErrorContrasena.setVisible(true);
    }

    public void reinicioMensajeError() {
		textoErrorCorreo.setText(" ");
		textoErrorContrasena.setText(" ");
    }

    public boolean validacionLogin(String email, String password) throws InvalidUserException, InvalidPasswordException {
		reinicioMensajeError();

		if (email.trim().isEmpty()) {
			mostrarErrorCorreo("El correo electronico es OBLIGATORIO");
			return false;
		}
		if (!email.trim().isEmpty() && !email.trim().equals("ucota@gmail.com")) {
			throw new InvalidUserException("El correo electronico no coincide");
		}	
		if (password.trim().isEmpty()) {
			mostrarErrorContrasena("La contraseña es OBLIGATORIA");
			return false;
		}
		if (!password.trim().isEmpty() && !password.trim().equals("1234")) {
			throw new InvalidPasswordException("La contraseña no coincide");
		}
		return true;
    }
    
    public void bordePanel() {
        this.setBorder(BorderFactory.createEmptyBorder(24, 28, 24, 28));
    }
    
    
    
}
