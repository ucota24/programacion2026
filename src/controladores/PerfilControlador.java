package controladores;

import java.util.List;

import javax.swing.JFrame;

import modelos.MetodoPago;
import modelos.Usuario;
import repositorio.MetodoPagoRepositorio;
import utilidades.Sesion;
import vista.PerfilVista;

public class PerfilControlador {
	
	private PerfilVista vista;
	
	public PerfilControlador(JFrame parent) {
        vista = new PerfilVista(parent);

        cargarDatos();

        vista.setVisible(true);
    }
	
	private void cargarDatos() {
        Usuario usuario = Sesion.getCurrentUser();

        vista.setNombre(usuario.getNombre() + " " + usuario.getApellido());
        vista.setCorreo(usuario.getCorreo());
        vista.setTelefono(usuario.getTelefono());
        vista.setCiudad(usuario.getCiudadEstado());
        vista.setDireccion(usuario.getDireccion());
        vista.setFechaNacimiento(usuario.getFecha_Nacimiento());

        MetodoPagoRepositorio repositorio = new MetodoPagoRepositorio();
        List<MetodoPago> metodos = repositorio.getByUsuario(usuario.getId());

        if (!metodos.isEmpty()) {
            MetodoPago metodoPago = metodos.get(0);
            vista.setMetodoPago(metodoPago.getTipo());
            vista.setTitular(metodoPago.getNombreTitular());
            String numero = metodoPago.getNumeroTarjeta();
            vista.setNumero("**** **** **** " + numero.substring(numero.length() - 4));
        } else {
            vista.setMetodoPago("Sin metodo registrado");
            vista.setTitular("-");
            vista.setNumero("-");
        }
    }
	
	

}
