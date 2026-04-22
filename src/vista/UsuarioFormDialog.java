package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import models.Usuario;

public class UsuarioFormDialog extends JDialog {
	
	private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCorreo;
    private JPasswordField txtContrasena;
    private JTextField txtCiudadEstado;
    private JTextField txtDireccion;
    private JTextField txtFechaNacimiento;
    private JTextField txtTelefono;

    public JButton botonGuardar;
    public JButton botonCancelar;

    private Usuario usuario;
    
    private boolean guardar = false;
    
    public UsuarioFormDialog(JFrame parent, Usuario usuario) {
    	
    	super(parent, true);
    	this.usuario = usuario;
    	
    	setSize(400, 550);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        add(createTitlePanel(), BorderLayout.NORTH);
        add(createFormPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
        
        
        if (usuario != null) {
            txtNombre.setText(usuario.getNombre());
            txtApellido.setText(usuario.getApellido());
            txtCorreo.setText(usuario.getCorreo());
            txtContrasena.setText(usuario.getContrasena());
            txtCiudadEstado.setText(usuario.getCiudadEstado());
            txtDireccion.setText(usuario.getDireccion());
            txtFechaNacimiento.setText(usuario.getFecha_Nacimiento());
            txtTelefono.setText(usuario.getTelefono());
        }
    }
    
    public JPanel createTitlePanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Formulario de Usuario"));
        return panel;
    }
    
    public JPanel createButtonPanel() {

        JPanel panel = new JPanel();

        botonGuardar = new JButton("Guardar");
        botonCancelar = new JButton("Cancelar");

        panel.add(botonGuardar);
        panel.add(botonCancelar);
        
        botonGuardar.addActionListener(e -> {
            guardar = true;
            dispose();
        });
        
        botonCancelar.addActionListener(e -> dispose());
        
        return panel;
    }
    
    public JScrollPane createFormPanel() {
    	
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtCorreo = new JTextField();
        txtContrasena = new JPasswordField();
        txtCiudadEstado = new JTextField();
        txtDireccion = new JTextField();
        txtFechaNacimiento = new JTextField();
        txtTelefono = new JTextField();

        panel.add(createField("Nombre:", txtNombre));
        panel.add(createField("Apellido:", txtApellido));
        panel.add(createField("Correo Electronico:", txtCorreo));
        panel.add(createField("Contraseña:", txtContrasena));
        panel.add(createField("Ciudad / Estado:", txtCiudadEstado));
        panel.add(createField("Direccion:", txtDireccion));
        panel.add(createField("Fecha Nacimiento:", txtFechaNacimiento));
        panel.add(createField("Telefono:", txtTelefono));

        JScrollPane scroll = new JScrollPane(panel);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(14);
        return scroll;
    }
    
    public JPanel createField(String labelText, Component field) {
    	
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label = new JLabel(labelText);
        label.setMaximumSize(new Dimension(Integer.MAX_VALUE, label.getPreferredSize().height));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (field instanceof JTextField) {
            ((JTextField) field).setMaximumSize(
                new Dimension(Integer.MAX_VALUE, field.getPreferredSize().height));
        }

        panel.add(label);
        panel.add(field);
        return panel;
        
    }
    
    public Usuario getUsuarioFromForm() {
        return new Usuario(txtNombre.getText(),
        		txtApellido.getText(),
        		txtCorreo.getText(),
        		new String(txtContrasena.getPassword()),
        		txtCiudadEstado.getText(),
        		txtDireccion.getText(),
        		txtFechaNacimiento.getText(),
        		txtTelefono.getText());
    }
    
    public boolean isGuardar() {
        return guardar;
    }
	
	

    

    
    
}
