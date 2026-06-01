package controladores;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import excepciones.InvalidPasswordException;
import excepciones.InvalidUserException;
import models.Usuario;
import repositorio.LoginRepositorio;
import utils.Sesion;
import vista.FormularioRegistro;
import vista.LoginVista;
import vista.VentanaPrincipal;

public class LoginController {
	
	private LoginVista vista;
	private LoginRepositorio loginRepositorio;
	
	public LoginController(LoginVista vista) {
		this.vista = vista;
		this.loginRepositorio = new LoginRepositorio();
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
		vista.reinicioMensajeError();
		
		String correo = vista.getCorreo();
        String contrasena = vista.getContrasena();
        
        if (correo.trim().isEmpty()) {
            vista.mostrarErrorCorreo("El correo electronico es OBLIGATORIO");
            return;
        }

        if (contrasena.trim().isEmpty()) {
            vista.mostrarErrorContrasena("La contraseña es OBLIGATORIA");
            return;
        }

        Usuario usuario = loginRepositorio.login(correo, contrasena);

        if (usuario == null) {
            vista.mostrarErrorContrasena("Datos ingresados incorrectos");
            return;
        }
        
        Sesion.login(usuario);

        if (Sesion.getRole().equals("ADMIN")) {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.admUsuarios.setVisible(true);
            new PrincipalController(ventana);
        } else {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.admUsuarios.setVisible(false);
            new PrincipalController(ventana);
        }
        
        vista.getLoginVentana().dispose();
        
    }

    private void abrirRegistro() {
        new FormularioRegistro();
        vista.getLoginVentana().dispose();
    }

}
