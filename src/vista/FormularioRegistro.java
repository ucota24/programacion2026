package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controllers.RegistroController;
import vista.LoginVentana;

public class FormularioRegistro extends JFrame {
	
	public JTextField campoNombre;
	public JTextField campoApellido;
	public JTextField campoCorreo;
	public JPasswordField campoContrasena;
	public JTextField campoCiudadEstado;
	public JTextField campoDireccion;
	public JTextField campoFNacimiento;
	public JTextField campoTelefono;
	
	public JLabel lblErrorNombre;
	public JLabel lblErrorApellido;
	public JLabel lblErrorCorreo;
	public JLabel lblErrorContrasena;
	public JLabel lblErrorCiudadEstado;
	public JLabel lblErrorDireccion;
	public JLabel lblErrorFNacimiento;
	public JLabel lblErrorTelefono;
	
	private JButton botonRegistrar;
	private JButton botonCancelar;

	public FormularioRegistro() {
		setSize(600,500);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocation(100,100);
		setResizable(true);
		setTitle("SneakerShop");
		setLocationRelativeTo(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image myIcon = tk.getImage("src/image/logoventana1.png");
		setIconImage(myIcon);
		
		inicializarComponentes();
		new RegistroController(this);
		
		setVisible(true);
	}
	
	public JTextField getCampoNombre() {
		return campoNombre;
	}

	public JTextField getCampoApellido() {
		return campoApellido;
	}

	public JTextField getCampoCorreo() {
		return campoCorreo;
	}
	
	public JPasswordField getCampoContrasena() {
		return campoContrasena;
	}

	public JTextField getCampoCiudadEstado() {
		return campoCiudadEstado;
	}

	public JTextField getCampoDireccion() {
		return campoDireccion;
	}

	public JTextField getCampoFNacimiento() {
		return campoFNacimiento;
	}
	
	public JTextField getCampoTelefono() {
		return campoTelefono;
	}
	
	public JButton getBotonRegistrar() {
		return botonRegistrar;
	}
	
	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	public void inicializarComponentes() {
		JPanel encabezadoForm = encabezadoForm();
		add(encabezadoForm, BorderLayout.NORTH);
		
		campoNombre = new JTextField();
		campoApellido = new JTextField();
		campoCiudadEstado = new JTextField();
		campoCorreo = new JTextField();
		campoContrasena = new JPasswordField();
		campoDireccion = new JTextField();
		campoFNacimiento = new JTextField();
		campoTelefono = new JTextField();
		
		lblErrorApellido = errorLabel();
		lblErrorCiudadEstado = errorLabel();
		lblErrorCorreo = errorLabel();
		lblErrorContrasena = errorLabel();
		lblErrorNombre = errorLabel();
		lblErrorFNacimiento = errorLabel();
		lblErrorTelefono = errorLabel();
		lblErrorDireccion = errorLabel();
		
		asignarFocusListeners();
        asignarKeyListeners();
				
		JPanel panelComponentes = new JPanel(new GridLayout(0, 2, 15, 6));
		panelComponentes.setBorder(BorderFactory.createEmptyBorder(10, 20, 40, 20));
		
		panelComponentes.add(campo("Nombre(s)", campoNombre, lblErrorNombre));
	    panelComponentes.add(campo("Apellido(s)", campoApellido, lblErrorApellido));
	    panelComponentes.add(campo("Correo Electronico", campoCorreo, lblErrorCorreo));
	    panelComponentes.add(campo("Contraseña", campoContrasena, lblErrorContrasena));
	    panelComponentes.add(campo("Ciudad / Estado", campoCiudadEstado, lblErrorCiudadEstado));
        panelComponentes.add(campo("Direccion", campoDireccion, lblErrorDireccion));
	    panelComponentes.add(campo("Fecha de Nacimiento", campoFNacimiento, lblErrorFNacimiento));
	    panelComponentes.add(campo("Telefono", campoTelefono, lblErrorTelefono));
	    
	    JPanel boton = boton();
	    add(boton, BorderLayout.SOUTH );

		JScrollPane scroll = new JScrollPane(panelComponentes);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBorder(null);
		add(scroll);
	}
	
	public JPanel campo (String labelText, JComponent field, JLabel errorLabel) {
		
	    JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

	    JLabel lbl = new JLabel(labelText);
	    lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
	    lbl.setForeground(Color.BLACK);
	    lbl.setAlignmentX(Component.LEFT_ALIGNMENT);

	    field.setFont(new Font("Segoe UI", Font.PLAIN, 13));
	    field.setAlignmentX(Component.LEFT_ALIGNMENT);
	    field.setPreferredSize(new Dimension(250,35));
	    field.setMinimumSize(new Dimension(250, 35));
	    errorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

	    panel.add(lbl);
	    panel.add(Box.createVerticalStrut(4));
	    panel.add(field);
	    panel.add(errorLabel);

	    return panel;
	}
	
	public JPanel encabezadoForm() {
		
		JPanel encabezadoForm = new JPanel();
		encabezadoForm.setLayout(new BoxLayout(encabezadoForm, BoxLayout.Y_AXIS));
		encabezadoForm.setBorder(BorderFactory.createEmptyBorder(10,15,12,40));
		
		JLabel titulo = new JLabel("Registro de Usuario");
		titulo.setFont(new Font("Arial", Font.BOLD, 23));
		titulo.setAlignmentX(Component.LEFT_ALIGNMENT);
		encabezadoForm.add(titulo);	
		
		encabezadoForm.add(Box.createVerticalStrut(3));
		
		JLabel subtitulo = new JLabel (" Completa lo siguiente para unirte a nuestra tienda!");
		subtitulo.setFont(new Font ("Arial", Font.PLAIN, 12));
		subtitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
		encabezadoForm.add(subtitulo);
		
		return encabezadoForm;
	}
	
	public JPanel boton() {
        JPanel boton = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 10));
        boton.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));

        botonCancelar = new JButton("Cancelar");
        botonCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        botonCancelar.setPreferredSize(new Dimension(120, 40)); 
        		
        botonRegistrar = new JButton("Aceptar");
        botonRegistrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        botonRegistrar.setPreferredSize(new Dimension(120, 40));
        botonRegistrar.setBackground(new Color(17, 17, 17));
        botonRegistrar.setForeground(Color.WHITE);
        
        boton.add(botonCancelar);
        boton.add(botonRegistrar);
        return boton;
    }
	
	public JLabel errorLabel() {
		JLabel label = new JLabel(" ");
		label.setFont(new Font("Arial",Font.ITALIC, 12));
		label.setForeground(Color.RED);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setPreferredSize(new Dimension(200, 15));
		return label;
	}
	
	public void limpiarErrores() {
        lblErrorNombre.setText("");
        lblErrorApellido.setText("");
        lblErrorCorreo.setText("");
        lblErrorContrasena.setText("");
        lblErrorCiudadEstado.setText("");
        lblErrorDireccion.setText("");
        lblErrorFNacimiento.setText("");
        lblErrorTelefono.setText("");
    }
	
	private void asignarFocusListeners() {
        JTextField[] campos = {
            campoNombre, campoApellido, campoCorreo,
            campoCiudadEstado, campoDireccion, campoFNacimiento, campoTelefono
        };
        for (JTextField campo : campos) {
            campo.addFocusListener(new FocusAdapter() {
                @Override public void focusGained(FocusEvent e) { 
                	((JTextField) e.getSource()).setForeground(Color.BLACK); 
                	}
                @Override public void focusLost(FocusEvent e) { 
                	((JTextField) e.getSource()).setForeground(Color.GRAY); 
                	}
            });
        }
        campoContrasena.addFocusListener(new FocusAdapter() {
            @Override public void focusGained(FocusEvent e) { 
            	campoContrasena.setForeground(Color.BLACK); 
            	}
            @Override public void focusLost(FocusEvent e) { 
            	campoContrasena.setForeground(Color.GRAY); 
            }
        });
    }
 
    private void asignarKeyListeners() {
        for (JTextField campo : new JTextField[]{campoNombre, campoApellido}) {
            campo.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (Character.isDigit(c) || (!Character.isAlphabetic(c) && c != ' '))
                        e.consume();
                    if (((JTextField) e.getSource()).getText().length() >= 20)
                        e.consume();
                }
            });
        }
    }
	
	
}