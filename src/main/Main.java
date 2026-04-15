package main;

import java.awt.Color;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

import controllers.LoginController;
import vista.FormularioRegistro;
import vista.LoginVentana;
import vista.LoginVista;
import vista.MetodoPagoVentana;
import vista.VentanaPrincipal;

public class Main {

    public static void main(String[] args) {
        
        FlatLightLaf.setup();
        UIManager.put("TextComponent.arc", 8);
        UIManager.put("Button.arc", 8);
        UIManager.put("Component.focusWidth", 1);
        UIManager.put("Component.innerFocusWidth", 0);
        UIManager.put("Component.focusColor", new Color(17, 17, 17));
        
		//UIManager.put(" ", AppFont.normal());
        
        LoginVentana ventanita = new LoginVentana();
		new LoginController(ventanita.getLoginVista());
        
        //FormularioRegistro registro = new FormularioRegistro();
		
      	//MetodoPagoVentana metodoPago = new MetodoPagoVentana();
      		
      	//VentanaPrincipal main = new VentanaPrincipal();

    }
}