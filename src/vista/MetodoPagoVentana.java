package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import vista.LoginVentana;

public class MetodoPagoVentana extends JFrame {
	
	public JTextField campoNombreTarjeta;
	public JTextField campoNumeroTarjeta;
	public JTextField campoFechaExpiracion;
	public JTextField campoCVV;
	
	public JLabel lblErrorMetodoPago;
	public JLabel lblErrorNombreTarjeta;
	public JLabel lblErrorNumeroTarjeta;
	public JLabel lblErrorFechaExpiracion;
	public JLabel lblErrorCampoCVV;
	
	public JRadioButton rbMercadoPago;
	public JRadioButton rbMasterCard;
	public JRadioButton rbPayPal;
	public ButtonGroup grupoMetodo;
	
	private JButton botonAceptar;
    private JButton botonCancelar;

	public MetodoPagoVentana() {
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(true);
		setTitle("SneakerShop");
		setLocationRelativeTo(null);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Image myIcon = tk.getImage("src/image/logoventana1.png");
		setIconImage(myIcon);

		inicializarComponentes();
		asignarKeyListeners();
		new controladores.MetodoPagoController(this);
		setVisible(true);
	}
	
	public JTextField getCampoNombreTarjeta() {
		return campoNombreTarjeta;
	}

	public JTextField getCampoNumeroTarjeta() {
		return campoNumeroTarjeta;
	}

	public JTextField getCampoFechaExpiracion() {
		return campoFechaExpiracion;
	}

	public JTextField getCampoCVV() {
		return campoCVV;
	}

	public JButton getBotonAceptar() {
		return botonAceptar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	public void inicializarComponentes() {

		campoNombreTarjeta = new JTextField();
		campoNumeroTarjeta = new JTextField();
		campoFechaExpiracion = new JTextField();
		campoCVV = new JTextField();
		
		lblErrorNombreTarjeta = errorLabel();
		lblErrorNumeroTarjeta = errorLabel();
		lblErrorFechaExpiracion = errorLabel();
		lblErrorCampoCVV = errorLabel();
		lblErrorMetodoPago = errorLabel();
		
		grupoMetodo = new ButtonGroup();
		rbMasterCard = crearRadioButton("MasterCard");
		rbMercadoPago = crearRadioButton("MercadoPago");
		rbPayPal = crearRadioButton("PayPal");
		grupoMetodo.add(rbMasterCard);
		grupoMetodo.add(rbMercadoPago);
		grupoMetodo.add(rbPayPal);

		JPanel panelComponentes = new JPanel(new GridLayout(0, 1, 15, 10));
		panelComponentes.setBorder(BorderFactory.createEmptyBorder(0, 20, 40, 10));

		panelComponentes.add(encabezadoMP());
		panelComponentes.add(seleccionMetodo());

		panelComponentes.add(campo("Nombre en la tarjeta", campoNombreTarjeta, lblErrorNombreTarjeta));
		panelComponentes.add(campo("Numero de tarjeta", campoNumeroTarjeta, lblErrorNumeroTarjeta));
		panelComponentes.add(campo("Fecha de expiracion (MM/AA)", campoFechaExpiracion, lblErrorFechaExpiracion));
		panelComponentes.add(campo("CVV", campoCVV, lblErrorCampoCVV));

		JPanel boton = boton();
		add(boton, BorderLayout.SOUTH);

		JScrollPane scroll = new JScrollPane(panelComponentes);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBorder(null);
		add(scroll);
	}

	public JPanel encabezadoMP() {

		JPanel encabezadoMP = new JPanel();
		encabezadoMP.setLayout(new BoxLayout(encabezadoMP, BoxLayout.Y_AXIS));
		encabezadoMP.setBorder(BorderFactory.createEmptyBorder(15, 15, 12, 40));

		JLabel titulo = new JLabel("Metodo de pago");
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 23));
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		encabezadoMP.add(titulo);

		encabezadoMP.add(Box.createVerticalStrut(10));

		return encabezadoMP;
	}

	public JPanel seleccionMetodo() {

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel opcionesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
		opcionesPanel.add(rbMasterCard);
		opcionesPanel.add(rbMercadoPago);
		opcionesPanel.add(rbPayPal);
		opcionesPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(opcionesPanel);
		panel.add(lblErrorMetodoPago);

		return panel;
	}

	public JRadioButton crearRadioButton(String texto) {
		JRadioButton rb = new JRadioButton(texto);
		rb.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		return rb;
	}

	public JPanel campo(String labelText, JTextField field, JLabel errorLabel) {

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel lbl = new JLabel(labelText);
		lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl.setForeground(Color.BLACK);
		lbl.setAlignmentX(Component.LEFT_ALIGNMENT);

		field.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		field.setAlignmentX(Component.LEFT_ALIGNMENT);

		panel.add(lbl);
		panel.add(Box.createVerticalStrut(4));
		panel.add(field);
		panel.add(errorLabel);

		return panel;
	}

	public JPanel boton() {

		JPanel boton = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 10));
		boton.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));

		botonCancelar = new JButton("Cancelar");
		botonCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		botonCancelar.setPreferredSize(new Dimension(120, 40));

		botonAceptar = new JButton("Aceptar");
		botonAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		botonAceptar.setPreferredSize(new Dimension(120, 40));
		botonAceptar.setBackground(new Color(17,17,17));
		botonAceptar.setForeground(Color.WHITE);

		boton.add(botonCancelar);
		boton.add(botonAceptar);
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
		lblErrorMetodoPago.setText("");
        lblErrorNombreTarjeta.setText("");
        lblErrorNumeroTarjeta.setText("");
        lblErrorFechaExpiracion.setText("");
        lblErrorCampoCVV.setText("");
    }
	
	private void asignarKeyListeners() {
        for (JTextField campo : new JTextField[]{ campoNumeroTarjeta, campoCVV }) {
            campo.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyTyped(java.awt.event.KeyEvent e) {
                    if (!Character.isDigit(e.getKeyChar()))
                        e.consume();
                }
            });
        }
    }
	

	
	
	
	
	
}
