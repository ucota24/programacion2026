package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PerfilVista extends JDialog {

	private JLabel lblNombre;
    private JLabel lblCorreo;
    private JLabel lblTelefono;
    private JLabel lblCiudad;
    private JLabel lblDireccion;
    private JLabel lblFechaNacimiento;
    private JLabel lblMetodoPago;
    private JLabel lblTitular;
    private JLabel lblNumero;
    
    public PerfilVista(JFrame parent) {
        super(parent, true);
        setTitle("Mi Perfil");
        setSize(400, 470);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);

        setLayout(new BorderLayout());
        add(crearPanel(), BorderLayout.CENTER);
    }
    
    private JPanel crearPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        lblNombre = new JLabel("-");
        lblCorreo = new JLabel("-");
        lblTelefono = new JLabel("-");
        lblCiudad = new JLabel("-");
        lblDireccion = new JLabel("-");
        lblFechaNacimiento = new JLabel("-");
        lblMetodoPago = new JLabel("-");
        lblTitular = new JLabel("-");
        lblNumero = new JLabel("-");

        JPanel seccionDatos = new JPanel(new GridLayout(4, 2,10, 10));
        seccionDatos.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220)),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        
        JLabel lblTituloDatos = new JLabel("Datos personales");
        lblTituloDatos.setFont(new Font("Arial", Font.BOLD, 14));
        seccionDatos.add(lblTituloDatos);
        seccionDatos.add(new JLabel());
        seccionDatos.add(fila("Nombre:", lblNombre));
        seccionDatos.add(fila("Correo electronico:", lblCorreo));
        seccionDatos.add(fila("Telefono:", lblTelefono));
        seccionDatos.add(fila("Ciudad / Estado:", lblCiudad));
        seccionDatos.add(fila("Dirección:", lblDireccion));
        seccionDatos.add(fila("Fecha de nacimiento:", lblFechaNacimiento));

        JPanel seccionPago = new JPanel(new GridLayout(4, 1, 0, 4));
        seccionPago.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220)),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        
        JLabel lblTituloPago = new JLabel("Metodo de pago");
        lblTituloPago.setFont(new Font("Arial", Font.BOLD, 14));
        seccionPago.add(lblTituloPago);
        seccionPago.add(fila("Titular:", lblTitular));
        seccionPago.add(fila("Tipo:", lblMetodoPago));
        seccionPago.add(fila("Numero de tarjeta:", lblNumero));

        panel.add(seccionDatos);
        panel.add(javax.swing.Box.createVerticalStrut(10));
        panel.add(seccionPago);

        return panel;
    }
    
    private JPanel fila(String etiqueta, JLabel valor) {
    	JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel lbl = new JLabel(etiqueta + " ");
        lbl.setFont(new Font("Arial", Font.BOLD, 12));
        valor.setFont(new Font("Arial", Font.PLAIN, 12));
        valor.setForeground(new Color(70, 130, 180));
        panel.add(lbl);
        panel.add(valor);
        return panel;
    }
    
    public void setNombre(String valor) { 
    	lblNombre.setText(valor); 
    }
    
    public void setCorreo(String valor) { 
    	lblCorreo.setText(valor); 
    }
    
    public void setTelefono(String valor) { 
    	lblTelefono.setText(valor); 
    }
    
    public void setCiudad(String valor) { 
    	lblCiudad.setText(valor); 
    }
    
    public void setDireccion(String valor) { 
    	lblDireccion.setText(valor); 
    }
    
    public void setFechaNacimiento(String valor) {
    	lblFechaNacimiento.setText(valor); 
    }
    
    public void setMetodoPago(String valor) { 
    	lblMetodoPago.setText(valor); 
    }
    
    public void setTitular(String valor) { 
    	lblTitular.setText(valor); 
    }
    
    public void setNumero(String valor) { 
    	lblNumero.setText(valor);
    }
    
    
    
    
    
}
    
    
    
    
    
    
	

