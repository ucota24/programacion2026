package controladores;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import modelos.MetodoPago;
import repositorio.MetodoPagoRepositorio;
import utilidades.Sesion;
import vista.MetodoPagoVentana;

public class MetodoPagoControlador {
	
    private MetodoPagoVentana vista;
    
    public MetodoPagoControlador(MetodoPagoVentana vista) {
        this.vista = vista;
        registrarListeners();
        
    }
    
    private void registrarListeners() {
    	 
        vista.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                cerrarVentana();
            }
        });
        
        vista.getBotonAceptar().addActionListener(e -> {
            if (validacionFormulario()) {
            	
            	String tipo = "";
                if (vista.rbMasterCard.isSelected()) tipo = "MasterCard";
                else if (vista.rbMercadoPago.isSelected()) tipo = "MercadoPago";
                else if (vista.rbPayPal.isSelected()) tipo = "PayPal";

                MetodoPago metodoPago = new MetodoPago(
                    tipo,
                    vista.campoNombreTarjeta.getText().trim(),
                    vista.campoNumeroTarjeta.getText().trim(),
                    vista.campoFechaExpiracion.getText().trim(),
                    vista.campoCVV.getText().trim(),
                    Sesion.getCurrentUser().getId()
                );

                MetodoPagoRepositorio repositorio = new MetodoPagoRepositorio();
                repositorio.save(metodoPago);
                
                JOptionPane.showMessageDialog(vista,
                        "Se ha registrado su metodo de pago!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                vista.dispose();
            }
        });
        
        for (JTextField campo : new JTextField[]{ vista.campoNumeroTarjeta, vista.campoCVV }) {
            campo.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyTyped(java.awt.event.KeyEvent e) {
                    if (!Character.isDigit(e.getKeyChar()))
                        e.consume();
                    
                    int limite;
                    if (campo == vista.campoNumeroTarjeta) {
                        limite = 16;
                    } else {
                        limite = 3;
                    }
                    
                    if (campo.getText().length() >= limite)
                        e.consume();
                }
            });
        }
        
        vista.campoFechaExpiracion.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                String texto = vista.campoFechaExpiracion.getText();
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                    return;
                }
                if (texto.length() >= 5) {
                    e.consume();
                    return;
                }
                if (texto.length() == 2) {
                	vista.campoFechaExpiracion.setText(texto + "/");
                }
            }
        });
        
        vista.getBotonCancelar().addActionListener(e -> cerrarVentana());
        
        vista.rbMasterCard.addActionListener(e -> vista.lblErrorMetodoPago.setText(""));
        vista.rbMercadoPago.addActionListener(e -> vista.lblErrorMetodoPago.setText(""));
        vista.rbPayPal.addActionListener(e -> vista.lblErrorMetodoPago.setText(""));
        
        vista.campoNombreTarjeta.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				validacionNombreTarjeta();
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				validacionNombreTarjeta();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				validacionNombreTarjeta();
			}
		});
		
        vista.campoNumeroTarjeta.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				validacionNumeroTarjeta();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				validacionNumeroTarjeta();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				validacionNumeroTarjeta();
			}
		});
		
        vista.campoFechaExpiracion.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				validacionFechaExpiracion();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				validacionFechaExpiracion();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				validacionFechaExpiracion();
			}
		});
		
        vista.campoCVV.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				validacionCVV();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				validacionCVV();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				validacionCVV();
			}
		});

    }
    
    public boolean validacionFormulario() {
		vista.limpiarErrores();
		boolean validacion = true;
		
		if (!validacionMetodoPago())
	        validacion = false;
		
		if(!validacionNombreTarjeta())
			validacion = false;
		
		if(!validacionNumeroTarjeta())
			validacion = false;
		
		if(!validacionFechaExpiracion())
			validacion = false;
		
		if(!validacionCVV())
			validacion = false;
		
		return validacion;
	}
    
    public boolean validacionMetodoPago() {
    	vista.lblErrorMetodoPago.setText("");
    	
        if (!vista.rbMasterCard.isSelected() && !vista.rbMercadoPago.isSelected() && !vista.rbPayPal.isSelected()) {
        	vista.lblErrorMetodoPago.setText("Debes seleccionar un metodo de pago");
        	
            return false;
        }
        return true;
    }
    
    public boolean validacionNombreTarjeta() {
    	vista.lblErrorNombreTarjeta.setText("");
    	
		if (vista.campoNombreTarjeta.getText().trim().isEmpty()) {
			vista.lblErrorNombreTarjeta.setText("Este campo es OBLIGATORIO");
            return false;
		}
		if(vista.campoNombreTarjeta.getText().trim().length() < 3) {
			vista.lblErrorNombreTarjeta.setText("Minimo 3 caracteres");
			return false;
		}
		
		return true;
	}
	
	public boolean validacionNumeroTarjeta() {
		vista.lblErrorNumeroTarjeta.setText("");
		
		if (vista.campoNumeroTarjeta.getText().trim().isEmpty()) {
			vista.lblErrorNumeroTarjeta.setText("Este campo es OBLIGATORIO");
            return false;
		}
		if(vista.campoNumeroTarjeta.getText().trim().length() < 16) {
			vista.lblErrorNumeroTarjeta.setText("Minimo 16 digitos");
			return false;
		}
		
		return true;
	}
	
	public boolean validacionFechaExpiracion() {
		vista.lblErrorFechaExpiracion.setText("");
		
		if (vista.campoFechaExpiracion.getText().trim().isEmpty()) {
			vista.lblErrorFechaExpiracion.setText("Este campo es OBLIGATORIO");
            return false;
		}
		if(vista.campoFechaExpiracion.getText().trim().length() < 3) {
			vista.lblErrorFechaExpiracion.setText("Minimo 4 digitos");
			return false;
		}
		
		return true;
	}
	
	public boolean validacionCVV() {
		vista.lblErrorCampoCVV.setText("");
		
		if (vista.campoCVV.getText().trim().isEmpty()) {
			vista.lblErrorCampoCVV.setText("Este campo es OBLIGATORIO");
            return false;
		}
		if(vista.campoCVV.getText().trim().length() > 3) {
			vista.lblErrorCampoCVV.setText("Maximo 3 caracteres");
			return false;
		}
		
		return true;
	}
	
	private void cerrarVentana() {
		
		int opcion = JOptionPane.showConfirmDialog(vista, "¿Estas seguro de que quieres salir? \nSe perderan los datos", "Allerta",
				JOptionPane.YES_NO_OPTION);
		
		if(opcion == JOptionPane.YES_OPTION) {
			vista.dispose();

		}		
	}
    
    
    
    
}
