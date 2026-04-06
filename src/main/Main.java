package main;

import views.FormularioRegistro;
import views.LoginVentana;
import views.LoginVista;
import views.VentanaPrincipal;
import views.FormularioRegistro;
import views.MetodoPagoVentana;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class Main {

	public static void main(String[] args) {
		
		FlatLightLaf.setup();
		UIManager.put("TextComponent.arc", 8); // bordes redondeados en los campos
		UIManager.put("Button.arc", 8); // bordes redondeados en los botones
		UIManager.put("Component.focusWidth", 1);
		UIManager.put("Component.innerFocusWidth", 0);
		
		//UIManager.put(" ", AppFont.normal());

		LoginVentana ventanita = new LoginVentana();
		
		//FormularioRegistro registro = new FormularioRegistro();
		
		//MetodoPagoVentana metodoPago = new MetodoPagoVentana();
		
		//VentanaPrincipal main = new VentanaPrincipal();
		
		
		
		
	}

}
