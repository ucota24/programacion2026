package controllers;

import exceptions.InvalidUserException;
import javax.swing.JOptionPane;
import models.Usuario;
import views.FormularioRegistro;
import views.LoginView;
import views.Ventana;

public class RegistroController {

    private FormularioRegistro vista;

    public RegistroController(FormularioRegistro vista) {
        this.vista = vista;
        registrarListeners();
    }

    private void registrarListeners() {
        vista.btnRegistrar.addActionListener(e -> handleRegistro());
        vista.btnCancelar.addActionListener(e -> handleCancelar());
    }

    private void handleRegistro() {
        Usuario usuario = new Usuario(
            vista.getNombre(),
            vista.getApellido(),
            vista.getCorreo(),
            vista.getContrasena(),
            vista.getDireccion(),
            vista.getFNacimiento(),
            vista.getTelefono(),
            vista.getCiudadEstado()
        );

        try {
            if (validarFormulario(usuario)) {
                JOptionPane.showMessageDialog(vista.getVentana(),
                    "¡Registro exitoso!\nBienvenid@, " + usuario.getNombre(),
                    "Registro", JOptionPane.INFORMATION_MESSAGE);
                new Ventana();
                vista.dispose();
            }
        } catch (InvalidUserException ex) {
            vista.mostrarErrorCorreo(ex.getMessage());
        }
    }

    private boolean validarFormulario(Usuario usuario) throws InvalidUserException {
        vista.reinicioMensajeError();
        boolean valido = true;

        if (usuario.getNombre().trim().isEmpty()) {
            vista.mostrarErrorNombre("Este campo es OBLIGATORIO");
            valido = false;
        } else if (usuario.getNombre().trim().length() < 3) {
            vista.mostrarErrorNombre("Mínimo 3 caracteres");
            valido = false;
        }

        if (usuario.getApellido().trim().isEmpty()) {
            vista.mostrarErrorApellido("Este campo es OBLIGATORIO");
            valido = false;
        } else if (usuario.getApellido().trim().length() < 3) {
            vista.mostrarErrorApellido("Mínimo 3 caracteres");
            valido = false;
        }

        if (usuario.getCorreo().trim().isEmpty()) {
            vista.mostrarErrorCorreo("Este campo es OBLIGATORIO");
            valido = false;
        } else if (!usuario.getCorreo().contains("@")) {
            throw new InvalidUserException("Correo inválido");
        }

        if (usuario.getContrasena().trim().isEmpty()) {
            vista.mostrarErrorContrasena("Este campo es OBLIGATORIO");
            valido = false;
        } else if (usuario.getContrasena().trim().length() < 8) {
            vista.mostrarErrorContrasena("Mínimo 8 caracteres");
            valido = false;
        }

        if (usuario.getCiudadEstado().trim().isEmpty()) {
            vista.mostrarErrorCiudad("Este campo es OBLIGATORIO");
            valido = false;
        }

        if (usuario.getDireccion().trim().isEmpty()) {
            vista.mostrarErrorDireccion("Este campo es OBLIGATORIO");
            valido = false;
        }

        if (usuario.getFecha_Nacimiento().trim().isEmpty()) {
            vista.mostrarErrorFecha("Este campo es OBLIGATORIO");
            valido = false;
        }

        if (usuario.getTelefono().trim().isEmpty()) {
            vista.mostrarErrorTelefono("Este campo es OBLIGATORIO");
            valido = false;
        }

        return valido;
    }

    private void handleCancelar() {
        int op = JOptionPane.showConfirmDialog(vista.getVentana(),
            "¿Estas seguro de que quieres regresar?\nSe perderan los datos");
        if (op == JOptionPane.YES_OPTION) {
        	new Ventana();
            vista.dispose();
        }
    }
}