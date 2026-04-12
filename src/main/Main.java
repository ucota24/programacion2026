package main;

import java.awt.Color;
import javax.swing.UIManager;
import views.Ventana;

public class Main {

    public static void main(String[] args) {
        
        FlatLightLaf.setup();
        UIManager.put("TextComponent.arc", 8);
        UIManager.put("Button.arc", 8);
        UIManager.put("Component.focusWidth", 1);
        UIManager.put("Component.innerFocusWidth", 0);
        UIManager.put("Component.focusColor", new Color(17, 17, 17));
        
		//UIManager.put(" ", AppFont.normal());

        
      //FormularioRegistro registro = new FormularioRegistro();
		
      		//MetodoPagoVentana metodoPago = new MetodoPagoVentana();
      		
      		//VentanaPrincipal main = new VentanaPrincipal();

        new Ventana();
    }
}