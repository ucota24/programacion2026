package views;

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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import views.LoginVentana;

public class FormularioRegistro extends JFrame {
	
	public JTextField campoNombre;
	public JTextField campoApellido;
	public JTextField campoCorreo;
	public JTextField campoCiudadEstado;
	public JTextField campoDireccion;
	public JTextField campoFNacimiento;
	public JTextField campoTelefono;
	
	public JLabel lblErrorNombre;
	public JLabel lblErrorApellido;
	public JLabel lblErrorCorreo;
	public JLabel lblErrorCiudadEstado;
	public JLabel lblErrorDireccion;
	public JLabel lblErrorFNacimiento;
	public JLabel lblErrorTelefono;

	public FormularioRegistro() {
		setSize(600,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100,100);
		setResizable(true);
		setTitle("SneakerShop");
		setLocationRelativeTo(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image myIcon = tk.getImage("src/image/logoventana1.png");
		setIconImage(myIcon);
		
		inicializarComponentes();
		
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		
		JPanel encabezadoForm = encabezadoForm();
		add(encabezadoForm, BorderLayout.NORTH);
		
		campoNombre = new JTextField();
		campoApellido = new JTextField();
		campoCiudadEstado = new JTextField();
		campoCorreo = new JTextField();
		campoDireccion = new JTextField();
		campoFNacimiento = new JTextField();
		campoTelefono = new JTextField();
		
		lblErrorApellido = errorLabel();
		lblErrorCiudadEstado = errorLabel();
		lblErrorCorreo = errorLabel();
		lblErrorNombre = errorLabel();
		lblErrorFNacimiento = errorLabel();
		lblErrorTelefono = errorLabel();
		lblErrorDireccion = errorLabel();
		
		assignListeners();

		JPanel panelComponentes = new JPanel(new GridLayout(0,2,15,10));
		panelComponentes.setBorder(BorderFactory.createEmptyBorder(10,20, 40, 20));
		
		panelComponentes.add(campo("Nombre(s)", campoNombre, lblErrorNombre));
	    panelComponentes.add(campo("Apellido(s)", campoApellido, lblErrorApellido));
	    panelComponentes.add(campo("Correo Electronico", campoCorreo, lblErrorCorreo));
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

        JButton cancelar = new JButton("Cancelar");
        cancelar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cancelar.setPreferredSize(new Dimension(120, 40)); 
        		
        cancelar.addActionListener(e -> {
			
			int option = JOptionPane.showConfirmDialog(this, 
					"¿Estas seguro de que quieres regresar? \nSe perderan los datos!");
			
			if(option == JOptionPane.YES_OPTION) {
				new LoginVentana();
				dispose();
			}
		});

        JButton registrar = new JButton("Aceptar");
        registrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        registrar.setPreferredSize(new Dimension(120, 40));
        registrar.setBackground(Color.GRAY);
        registrar.setForeground(Color.WHITE);
        
        registrar.addActionListener(e -> {
        	if (validacionFormulario()) {
        		javax.swing.JOptionPane.showMessageDialog(this, 
        				"Has sido Registrado!", "Bienvenid@", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        		}
        });
        boton.add(cancelar);
        boton.add(registrar);
        return boton;
    }
	
	public JLabel errorLabel() {
		JLabel label = new JLabel();
		label.setFont(new Font("Arial",Font.ITALIC, 12));
		label.setForeground(Color.RED);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setText("");
	return label;
	
	}
	
	public void limpiarErrores() {
		lblErrorNombre.setText("");
        lblErrorApellido.setText("");
        lblErrorCorreo.setText("");
        lblErrorCiudadEstado.setText("");
        lblErrorDireccion.setText("");
        lblErrorFNacimiento.setText("");
        lblErrorTelefono.setText("");
	}
	
	public void assignListeners() {
		campoNombre.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				validacionNombre();
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				validacionNombre();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				validacionNombre();
			}
		});
		
		campoApellido.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				validacionApellido();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				validacionApellido();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				validacionApellido();
			}
		});
		
		campoCorreo.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				validacionCorreo();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				validacionCorreo();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				validacionCorreo();
			}
		});
		
		campoCiudadEstado.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				validacionCiudadEstado();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				validacionCiudadEstado();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				validacionCiudadEstado();
			}
		});
		
		campoTelefono.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				validacionTelefono();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				validacionTelefono();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				validacionTelefono();
			}
		});
		campoDireccion.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				validacionDireccion();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				validacionDireccion();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				validacionDireccion();
			}
		});
		
		campoFNacimiento.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validacionFNacimiento();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validacionFNacimiento();				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validacionFNacimiento();				
			}
		});
	}
	
	public boolean validacionFormulario() {
		limpiarErrores();
		boolean validacion = true;
		
		if(!validacionNombre())
			validacion = false;
		
		if(!validacionApellido())
			validacion = false;
		
		if(!validacionCorreo())
			validacion = false;
		
		if(!validacionCiudadEstado())
			validacion = false;
		
		if(!validacionTelefono())
			validacion = false;
		
		if(!validacionDireccion())
			validacion = false;
		
		if(!validacionFNacimiento())
			validacion = false;
		
		if (validacion) {
			JOptionPane.showMessageDialog(this, "Registro exitoso");
		}
		return true;
	}
	
	public boolean validacionNombre() {
		lblErrorNombre.setText("");
		if (campoNombre.getText().trim().isEmpty()) {
            lblErrorNombre.setText("Este campo es OBLIGATORIO");
            return false;
		}
		if(campoNombre.getText().trim().length() < 3) {
			lblErrorNombre.setText("Minimo 3 caracteres");
			return false;
		}
		
		return true;
	}
	
	public boolean validacionApellido() {
		lblErrorApellido.setText("");
		if (campoApellido.getText().trim().isEmpty()) {
            lblErrorApellido.setText("Este campo es OBLIGATORIO");
            return false;
		}
		if(campoApellido.getText().trim().length() < 3) {
			lblErrorApellido.setText("Minimo 3 caracteres");
			return false;
		}
		return true;
	}
	
	public boolean validacionCorreo() {
		lblErrorCorreo.setText("");
		if (campoCorreo.getText().trim().isEmpty()) {
            lblErrorCorreo.setText("Este campo es OBLIGATORIO");
            return false;
		}
		if (!campoCorreo.getText().contains("@")) {
            lblErrorCorreo.setText("Correo inválido");
            return false;
		}
		return true;
	}
	
	public boolean validacionCiudadEstado() {
		lblErrorCiudadEstado.setText("");
		if (campoCiudadEstado.getText().trim().isEmpty()) {
            lblErrorCiudadEstado.setText("Este campo es OBLIGATORIO");
            return false;
		}
		return true;
	}
	
	public boolean validacionTelefono() {
		lblErrorTelefono.setText("");
		if (campoTelefono.getText().trim().isEmpty()) {
            lblErrorTelefono.setText("Este campo es OBLIGATORIO");
            return false;
		}
		return true;
	}
	
	public boolean validacionDireccion() {
		if (campoDireccion.getText().trim().isEmpty()) {
            lblErrorDireccion.setText("Este campo es OBLIGATORIO");
            return false;
		}
		return true;
	}
	
	public boolean validacionFNacimiento() {
		 if (campoFNacimiento.getText().trim().isEmpty()) {
	            lblErrorFNacimiento.setText("Este campo es OBLIGATORIO");
	            return false;
	        }
	        return true;
	}
	
	

}