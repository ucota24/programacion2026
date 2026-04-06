package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import views.LoginVentana;

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
import javax.swing.border.TitledBorder;

public class MetodoPagoVentana extends JFrame {
	
	public JTextField campoNombreTarjeta;
	public JTextField campoNumeroTarjeta;
	public JTextField campoFechaExpiracion;
	public JTextField campoCVV;

	public JRadioButton rbMercadoPago;
	public JRadioButton rbMasterCard;
	public JRadioButton rbPayPal;
	public ButtonGroup grupoMetodo;

	public MetodoPagoVentana() {
		setSize(400, 480);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		JPanel encabezadoForm = encabezadoMP();
		add(encabezadoForm, BorderLayout.NORTH);

		campoNombreTarjeta   = new JTextField();
		campoNumeroTarjeta   = new JTextField();
		campoFechaExpiracion = new JTextField();
		campoCVV             = new JTextField();

		grupoMetodo = new ButtonGroup();
		rbMasterCard = crearRadioButton("MasterCard");
		rbMercadoPago  = crearRadioButton("MercadoPago");
		rbPayPal  = crearRadioButton("PayPal");
		grupoMetodo.add(rbMasterCard);
		grupoMetodo.add(rbMercadoPago);
		grupoMetodo.add(rbPayPal);

		JPanel panelComponentes = new JPanel(new GridLayout(0, 1, 15, 10));
		panelComponentes.setBorder(BorderFactory.createEmptyBorder(10, 20, 40, 10));

		panelComponentes.add(seleccionMetodo());

		panelComponentes.add(campo("Nombre en la tarjeta", campoNombreTarjeta));
		panelComponentes.add(campo("Numero de tarjeta", campoNumeroTarjeta));
		panelComponentes.add(campo("Fecha de expiracion (MM/AA)", campoFechaExpiracion));
		panelComponentes.add(campo("CVV", campoCVV));

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
		encabezadoMP.setBorder(BorderFactory.createEmptyBorder(10, 15, 12, 40));

		JLabel titulo = new JLabel("Metodo de Pago");
		titulo.setFont(new Font("Arial", Font.BOLD, 23));
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		encabezadoMP.add(titulo);

		encabezadoMP.add(Box.createVerticalStrut(15));

		return encabezadoMP;
	}

	public JPanel seleccionMetodo() {

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel lbl = new JLabel("                              Selecciona un metodo");
		lbl.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(lbl);
		panel.add(Box.createVerticalStrut(8));

		JPanel opcionesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
		opcionesPanel.add(rbMasterCard);
		opcionesPanel.add(rbMercadoPago);
		opcionesPanel.add(rbPayPal);
		opcionesPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(opcionesPanel);

		return panel;
	}

	public JRadioButton crearRadioButton(String texto) {
		JRadioButton rb = new JRadioButton(texto);
		rb.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		return rb;
	}

	public JPanel campo(String labelText, JTextField field) {

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

		return panel;
	}

	public JPanel boton() {

		JPanel boton = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 10));
		boton.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));

		JButton cancelar = new JButton("Cancelar");
		cancelar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cancelar.setPreferredSize(new Dimension(120, 40));
		cancelar.addActionListener(e -> {
			int opcion = JOptionPane.showConfirmDialog(this,
				"¿Estas seguro de que quieres cancelar?");
			if (opcion == JOptionPane.YES_OPTION) {
				dispose();
			}
		});

		JButton pagar = new JButton("Aceptar");
		pagar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		pagar.setPreferredSize(new Dimension(120, 40));
		pagar.setBackground(Color.GRAY);
		pagar.setForeground(Color.WHITE);

		boton.add(cancelar);
		boton.add(pagar);
		return boton;
	}
}
