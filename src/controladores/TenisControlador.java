package controladores;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelos.MetodoPago;
import modelos.Pedido;
import modelos.Tenis;
import repositorio.MetodoPagoRepositorio;
import repositorio.PedidoRepositorio;
import repositorio.TenisRepositorio;
import tablemodels.TenisTableModel;
import utilidades.Sesion;
import vista.ComprarDialog;
import vista.TenisFormDialog;
import vista.TenisVista;

public class TenisControlador {
	
	private TenisVista vista;
    private TenisRepositorio repositorio;
    private TenisTableModel model;
    private String categoria;
	private JFrame parentFrame;

    public TenisControlador(TenisVista vista, String categoria, JFrame parentFrame) {
        this.vista = vista;
        this.categoria = categoria;
        this.repositorio = new TenisRepositorio();
        this.parentFrame = parentFrame;

        cargarTenis();
        RegistrarListeners();
    }

    private void cargarTenis() {
        List<Tenis> lista = repositorio.getByCategoria(categoria);
        model = new TenisTableModel(lista);
        vista.setTableModel(model);
        
        if (Sesion.getRole().equals("ADMIN")) {
            vista.getBotonAgregar().setVisible(true);
            vista.getBotonEliminar().setVisible(true);
        } else {
            vista.getBotonAgregar().setVisible(false);
            vista.getBotonEliminar().setVisible(false);
        }
    }

    private void RegistrarListeners() {
        vista.getBotonAgregar().addActionListener(e -> agregar());
        vista.getBotonEliminar().addActionListener(e -> eliminar());
        vista.getBotonComprar().addActionListener(e -> comprar());
    }

    private void agregar() {
    	TenisFormDialog form = new TenisFormDialog(parentFrame, null);
        form.setVisible(true);

        if (form.isGuardar()) {
            try {
                Tenis nuevo = form.getTenisFromForm();
                repositorio.save(nuevo);
                model.addRow(nuevo);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vista, "Error al guardar: " + ex.getMessage());
            }
        }
    	
    }

    private void eliminar() {
        int fila = vista.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(vista, "Selecciona un producto para eliminar");
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(vista,
            "¿Estás seguro de que quieres eliminar este producto?", "Alerta",
            JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            Tenis seleccionado = model.getTenisAt(fila);
            repositorio.eliminar(seleccionado.getIdTenis());
            model.removeRow(fila);
        }
    }

    private void comprar() {
        int fila = vista.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(vista, "Selecciona un producto para comprar");
            return;
        }
        
        Tenis seleccionado = model.getTenisAt(fila);
        if (seleccionado.getStock() <= 0) {
            JOptionPane.showMessageDialog(vista, "Este producto no tiene stock disponible");
            return;
        }
        
        MetodoPagoRepositorio metodoPagoRepo = new MetodoPagoRepositorio();
        List<MetodoPago> metodos = metodoPagoRepo.getByUsuario(Sesion.getCurrentUser().getId());
        
        if (metodos.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "No tienes un metodo de pago registrado");
            return;
        }
        
        ComprarDialog comprardialog = new ComprarDialog(parentFrame, seleccionado, metodos);
        comprardialog.setVisible(true);
        
        if (comprardialog.isConfirmar()) {
            MetodoPago metodoPago = metodos.get(comprardialog.getMetodoPagoSeleccionado());

            PedidoRepositorio pedidoRepo = new PedidoRepositorio();
            Pedido pedido = new Pedido(seleccionado.getPrecio(), Sesion.getCurrentUser().getId(), metodoPago.getId());
            int idPedido = pedidoRepo.save(pedido);

            pedidoRepo.saveDetalle(idPedido, seleccionado.getIdTenis(), 1, seleccionado.getPrecio());
            pedidoRepo.actualizarStock(seleccionado.getIdTenis(), seleccionado.getStock() - 1);

            seleccionado.setStock(seleccionado.getStock() - 1);
            model.fireTableDataChanged();

            JOptionPane.showMessageDialog(vista, "Compra realizada con exito!");
        }
   
    }
    
    public void cambiarCategoria(String categoria) {
        this.categoria = categoria;
        cargarTenis();
    }

}
