package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
    private JLabel lblPrecio;
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

        add(createInfoPanel(tenis), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }
  
    private JPanel createInfoPanel(Tenis tenis) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        lblTenis = new JLabel("Tenis: " + tenis.getNombre() + " - " + tenis.getMarca());
        lblPrecio = new JLabel("Precio: $" + tenis.getPrecio());
        
        cbMetodoPago = new JComboBox<>();
        for (MetodoPago m : metodoPg) {
            cbMetodoPago.addItem(m.getTipo() + " - " + m.getNombreTitular());
        }
        
        cbMetodoPago.setMaximumSize(new Dimension(Integer.MAX_VALUE, cbMetodoPago.getPreferredSize().height));


        panel.add(lblTenis);
        panel.add(lblPrecio);
        panel.add(new JLabel("Metodo de pago:"));
        panel.add(cbMetodoPago);

        return panel;
    }
    
    private JPanel createButtonPanel() {
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
