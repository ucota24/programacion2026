package controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import exceptions.InvalidPasswordException;
import exceptions.InvalidUserException;
import models.Usuario;
import vista.FormularioRegistro;
import vista.LoginVista;
import vista.VentanaPrincipal;

public class LoginController {
	
	private LoginVista vista;
	
	public LoginController(LoginVista vista) {
		this.vista = vista;
		registrarListeners();
	}
	
	private void registrarListeners() {

        vista.getLblRegistro().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            		abrirRegistro();
            }
        });
        
		vista.getBotonIngresar().addActionListener(e -> alertaLogin());

        KeyAdapter enterListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    alertaLogin();
                }
            }
        };

        vista.getCampoCorreoElectronico().addKeyListener(enterListener);
        vista.getCampoContrasena().addKeyListener(enterListener);
    }
	
	private void alertaLogin() {
        Usuario usuario = new Usuario(vista.getCorreo(),vista.getContrasena()
        );

        try {
    			if(validacionLogin(usuario)) {
    				JOptionPane.showMessageDialog(vista.getLoginVentana(), 
        					"Sesion Iniciada!", "Iniciar Sesion", JOptionPane.INFORMATION_MESSAGE);
    				
                new VentanaPrincipal();
                vista.getLoginVentana().dispose();
            }
        } catch (InvalidUserException ex) {
        		vista.mostrarErrorCorreo(ex.getMessage());

		} catch (InvalidPasswordException ex) {
			vista.mostrarErrorContrasena(ex.getMessage());
        }
    }
	
	private boolean validacionLogin(Usuario usuario)
            throws InvalidUserException, InvalidPasswordException {

		vista.reinicioMensajeError();
        boolean valido = true;

        if (usuario.getCorreo().trim().isEmpty()) {
        		vista.mostrarErrorCorreo("El correo electronico es OBLIGATORIO");
            return false;
        }

        if (!usuario.getCorreo().trim().isEmpty() && !usuario.getCorreo().equals("ucota@gmail.com")) {
            throw new InvalidUserException("El correo no coincide");
        }
        
        if (usuario.getContrasena().trim().isEmpty()) {
            vista.mostrarErrorContrasena("La contraseña es OBLIGATORIA");
            return false;
        }

        if (!usuario.getContrasena().trim().isEmpty() && !usuario.getContrasena().equals("1234")) {
            throw new InvalidPasswordException("La contraseña no coincide");
        }

        return valido;
    }

    private void abrirRegistro() {
        new FormularioRegistro();
        vista.getLoginVentana().dispose();
    }

}
