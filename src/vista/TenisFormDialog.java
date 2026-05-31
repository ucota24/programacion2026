package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import models.Tenis;

public class TenisFormDialog extends JDialog {
	
	private JTextField txtNombre;
    private JTextField txtMarca;
    private JTextField txtPrecio;
    private JTextField txtTalla;
    private JTextField txtColor;
    private JTextField txtStock;
    private JComboBox<String> cbCategoria;
    private JComboBox<String> cbTipo;
    
    
    public JButton botonGuardar;
    public JButton botonCancelar;
    
    private Tenis tenis;
    
    private boolean guardar = false;
    
    public TenisFormDialog(JFrame parent, Tenis tenis) {
        super(parent, true);
        this.tenis = tenis;

        setSize(400, 550);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        add(createTitlePanel(), BorderLayout.NORTH);
        add(createFormPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);

        if (tenis != null) {
            txtNombre.setText(tenis.getNombre());
            txtMarca.setText(tenis.getMarca());
            txtPrecio.setText(String.valueOf(tenis.getPrecio()));
            txtTalla.setText(String.valueOf(tenis.getTalla()));
            txtColor.setText(tenis.getColor());
            txtStock.setText(String.valueOf(tenis.getStock()));
            cbCategoria.setSelectedItem(tenis.getCategoria());
            cbTipo.setSelectedItem(tenis.getTipo());
        }
    }
    
    public JPanel createTitlePanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Formulario de Tenis"));
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
        txtMarca = new JTextField();
        txtPrecio = new JTextField();
        txtTalla = new JTextField();
        txtColor = new JTextField();
        txtStock = new JTextField();
        cbCategoria = new JComboBox<>(new String[] {
        		"Hombre", "Mujer", "Niños", "Unisex"
        		});
        
        cbTipo = new JComboBox<>(new String[] {
        		"Tenis", "Botas", "Sandalias", "Accesorios", "Ropa"
        		});

        panel.add(createField("Nombre:", txtNombre));
        panel.add(createField("Marca:", txtMarca));
        panel.add(createField("Precio:", txtPrecio));
        panel.add(createField("Talla:", txtTalla));
        panel.add(createField("Color:", txtColor));
        panel.add(createField("Stock:", txtStock));
        panel.add(createFieldCombo("Categoria:", cbCategoria));
        panel.add(createFieldCombo("Tipo:", cbTipo));

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
    
    public JPanel createFieldCombo(String labelText, JComboBox<String> combo) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label = new JLabel(labelText);
        label.setMaximumSize(new Dimension(Integer.MAX_VALUE, label.getPreferredSize().height));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        combo.setMaximumSize(new Dimension(Integer.MAX_VALUE, combo.getPreferredSize().height));

        panel.add(label);
        panel.add(combo);
        return panel;
    }
    
    public Tenis getTenisFromForm() {
        Tenis tenis = new Tenis();
        tenis.setNombre(txtNombre.getText().trim());
        tenis.setMarca(txtMarca.getText().trim());
        tenis.setPrecio(Double.parseDouble(txtPrecio.getText().trim()));
        tenis.setTalla(Double.parseDouble(txtTalla.getText().trim()));
        tenis.setColor(txtColor.getText().trim());
        tenis.setStock(Integer.parseInt(txtStock.getText().trim()));
        tenis.setCategoria((String) cbCategoria.getSelectedItem());
        tenis.setTipo((String) cbTipo.getSelectedItem());
        return tenis;
    }
    
    public boolean isGuardar() {
        return guardar;
    }
    
    

	
	
	

}
