package main;

import java.awt.Color;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

import controladores.LoginController;
import controladores.MetodoPagoController;
import controladores.PrincipalController;
import models.Usuario;
import utils.GestorTema;
import utils.Sesion;
import vista.FormularioRegistro;
import vista.LoginVentana;
import vista.LoginVista;
import vista.MetodoPagoVentana;
import vista.VentanaPrincipal;

public class Main {

    public static void main(String[] args) {
        
        //FlatLightLaf.setup();
        GestorTema.applySavedTheme();
        UIManager.put("TextComponent.arc", 8); // bordes redondeados en los campos
        UIManager.put("Button.arc", 8); // bordes redondeados en los botones
        UIManager.put("Component.focusWidth", 1);
        UIManager.put("Component.innerFocusWidth", 0);
        UIManager.put("Component.focusColor", new Color(17, 17, 17));  //color del borde del campo
        
		//UIManager.put(" ", AppFont.normal());
        
        /*LoginVentana ventanita = new LoginVentana();
		new LoginController(ventanita.getLoginVista());*/
        
        //FormularioRegistro registro = new FormularioRegistro();
		
      	//MetodoPagoVentana metodoPago = new MetodoPagoVentana();
      		
        
        Usuario usuarioPrueba = new Usuario();
        usuarioPrueba.setId(1);
        usuarioPrueba.setNombre("pepe");
        usuarioPrueba.setCorreo("pepexd@gmail.com");
        usuarioPrueba.setRol("ADMIN");
        Sesion.login(usuarioPrueba);
        
        VentanaPrincipal main = new VentanaPrincipal();
        new PrincipalController(main);

    }

}