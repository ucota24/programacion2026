package main;

import views.FormularioRegistro;
import views.LoginVentana;
import views.LoginVista;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class Main {

	public static void main(String[] args) {
		
		FlatLightLaf.setup();
		
		//UIManager.put(" ", AppFont.normal());

		LoginVentana ventanita = new LoginVentana();
		
		//FormularioRegistro registro = new FormularioRegistro();

		
	}

}
