package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.MetodoPago;
import models.Tenis;

public class ComprarDialog extends JDialog {
	
	private JLabel lblTenis;
	private JLabel lblProducto;
    private JLabel lblPrecio;
    private JLabel lblCantidad;
    private JComboBox<String> cbMetodoPago;
    
    private JButton botonConfirmar;
    private JButton botonCancelar;
    
    private boolean confirmar = false;
    private List<MetodoPago> metodoPg;
    
    public ComprarDialog(JFrame parent, Tenis tenis, List<MetodoPago> metodos) {
        super(parent, true);
        this.metodoPg = metodos;
        setSize(300, 210);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
        setTitle("Confirmar Compra");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(249, 250, 251));

        add(crearInfoPanel(tenis), BorderLayout.CENTER);
        add(crearBotonPanel(), BorderLayout.SOUTH);
    }
  
    private JPanel crearInfoPanel(Tenis tenis) {
        JPanel panel = new JPanel(new GridLayout(4, 1, 0, 8));
        panel.setBackground(new Color(249, 250, 251));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JPanel panelTeni = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelTeni.setBackground(new Color(249, 250, 251));
        lblTenis = new JLabel("Teni: ");
        lblTenis.setFont(new Font("Arial", Font.BOLD, 12));
        
        lblProducto = new JLabel(tenis.getNombre() +  " - " + tenis.getMarca());
        lblProducto.setFont(new Font("Arial", Font.ITALIC, 14));
        lblProducto.setForeground(new Color(70, 130, 180));

        panelTeni.add(lblTenis);
        panelTeni.add(lblProducto);
        
        JPanel panelPrecio = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelPrecio.setBackground(new Color(249, 250, 251));
        lblPrecio = new JLabel("Precio: ");
        lblPrecio.setFont(new Font("Arial", Font.BOLD, 12));
        
        lblCantidad = new JLabel("$" + tenis.getPrecio());
        lblCantidad.setFont(new Font("Arial", Font.ITALIC, 14));
        lblCantidad.setForeground(new Color(0, 150, 0));
        
        panelPrecio.add(lblPrecio);
        panelPrecio.add(lblCantidad);
        
        
        JLabel lblMetodoPg = new JLabel("Metodo de pago:");
        lblMetodoPg.setFont(new Font("Arial", Font.BOLD, 12));
        
        cbMetodoPago = new JComboBox<>();
        for (MetodoPago m : metodoPg) {
            cbMetodoPago.addItem(m.getTipo() + " - " + m.getNombreTitular());
        }
        cbMetodoPago.setMaximumSize(new Dimension(Integer.MAX_VALUE, cbMetodoPago.getPreferredSize().height));

        panel.add(panelTeni);
        panel.add(panelPrecio);
        panel.add(lblMetodoPg);
        panel.add(cbMetodoPago);
        
        
        return panel;
    }
    
    private JPanel crearBotonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        botonConfirmar = new JButton("Confirmar");
        botonCancelar = new JButton("Cancelar");

        botonConfirmar.addActionListener(e -> {
            confirmar = true;
            dispose();
        });

        botonCancelar.addActionListener(e -> dispose());

        panel.add(botonCancelar);
        panel.add(botonConfirmar);

        return panel;
    }
    
    public boolean isConfirmar() {
        return confirmar;
    }

    public int getMetodoPagoSeleccionado() {
        return cbMetodoPago.getSelectedIndex();
    }
    
    
    
    
	
	

}
