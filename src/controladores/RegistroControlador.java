package controladores;

import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import excepciones.UsuarioDuplicadoException;
import modelos.Usuario;
import repositorio.UsuarioRepositorio;
import utilidades.PasswordUtils;
import utilidades.Sesion;
import vista.FormularioRegistro;
import vista.LoginVentana;
import vista.VentanaPrincipal;

public class RegistroControlador {
	
	private FormularioRegistro vista;

    public RegistroControlador(FormularioRegistro vista) {
        this.vista = vista;
        registrarListeners();
    }

    private void registrarListeners() {
    	vista.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
            	cerrarVentana();
            }
            @Override
            public void windowOpened(java.awt.event.WindowEvent e) {
                vista.campoNombre.requestFocusInWindow();
            }
        });

    	vista.getBotonRegistrar().addActionListener(e -> {
            if (validacionFormulario()) {
            	
            	Usuario usuario = new Usuario(
                        vista.campoNombre.getText().trim(),
                        vista.campoApellido.getText().trim(),
                        vista.campoCorreo.getText().trim(),
                        utilidades.PasswordUtils.hashPassword(String.valueOf(vista.campoContrasena.getPassword())),
                        vista.campoCiudadEstado.getText().trim(),
                        vista.campoDireccion.getText().trim(),
                        vista.campoFNacimiento.getText().trim(),
                        vista.campoTelefono.getText().trim(),
                        "USUARIO"
                    );
                UsuarioRepositorio repositorio = new UsuarioRepositorio();
                try {
                	repositorio.save(usuario);
                	Sesion.login(usuario);
                javax.swing.JOptionPane.showMessageDialog(vista,
                        "Has sido Registrado!", "Bienvenid@", JOptionPane.INFORMATION_MESSAGE);
                this.vista.dispose();
                
                VentanaPrincipal ventana = new VentanaPrincipal();
                if (Sesion.getRole().equals("ADMIN")) {
                	ventana.admUsuarios.setVisible(true);
                } else {
                	ventana.admUsuarios.setVisible(false);
                }
                new PrincipalControlador(ventana);
                
                } catch (UsuarioDuplicadoException ex) {
                    vista.lblErrorCorreo.setText("Este correo ya esta registrado");
                
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vista, 
                            "Error al guardar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    		
    		vista.getBotonCancelar().addActionListener(e -> regresar());
    		
    		vista.campoNombre.getDocument().addDocumentListener(new DocumentListener() {
    			@Override
    			public void removeUpdate(DocumentEvent e) {
    				validacionNombre();
    			}
    			@Override
    			public void insertUpdate(DocumentEvent e) {
    				validacionNombre();
    			}
    			@Override
    			public void changedUpdate(DocumentEvent e) {
    				validacionNombre();
    			}
    		});
    		vista.campoApellido.getDocument().addDocumentListener(new DocumentListener() {
    			@Override
    			public void insertUpdate(DocumentEvent e) {
    				validacionApellido();
    			}
    			@Override
    			public void removeUpdate(DocumentEvent e) {
    				validacionApellido();
    			}
    			@Override
    			public void changedUpdate(DocumentEvent e) {
    				validacionApellido();
    			}
    		});
    		vista.campoCorreo.getDocument().addDocumentListener(new DocumentListener() {
    			@Override
    			public void insertUpdate(DocumentEvent e) {
    				validacionCorreo();
    			}
    			@Override
    			public void removeUpdate(DocumentEvent e) {
    				validacionCorreo();
    			}
    			@Override
    			public void changedUpdate(DocumentEvent e) {
    				validacionCorreo();
    			}
    		});
    		vista.campoContrasena.getDocument().addDocumentListener(new DocumentListener() {
    		    @Override
    		    public void insertUpdate(DocumentEvent e) {
    		        validacionContrasena();
    		    }
    		    @Override
    		    public void removeUpdate(DocumentEvent e) {
    		        validacionContrasena();
    		    }
    		    @Override
    		    public void changedUpdate(DocumentEvent e) {
    		        validacionContrasena();
    		    }
    		});
    		vista.campoCiudadEstado.getDocument().addDocumentListener(new DocumentListener() {
    			@Override
    			public void insertUpdate(DocumentEvent e) {
    				validacionCiudadEstado();
    			}
    			@Override
    			public void removeUpdate(DocumentEvent e) {
    				validacionCiudadEstado();
    			}
    			@Override
    			public void changedUpdate(DocumentEvent e) {
    				validacionCiudadEstado();
    			}
    		});
    		vista.campoTelefono.getDocument().addDocumentListener(new DocumentListener() {
    			@Override
    			public void insertUpdate(DocumentEvent e) {
    				validacionTelefono();
    			}
    			@Override
    			public void removeUpdate(DocumentEvent e) {
    				validacionTelefono();
    			}
    			@Override
    			public void changedUpdate(DocumentEvent e) {
    				validacionTelefono();
    			}
    		});
    		vista.campoDireccion.getDocument().addDocumentListener(new DocumentListener() {
    			@Override
    			public void insertUpdate(DocumentEvent e) {
    				validacionDireccion();
    			}
    			@Override
    			public void removeUpdate(DocumentEvent e) {
    				validacionDireccion();
    			}
    			@Override
    			public void changedUpdate(DocumentEvent e) {
    				validacionDireccion();
    			}
    		});
    		vista.campoFNacimiento.getDocument().addDocumentListener(new DocumentListener() {
    			@Override
    			public void insertUpdate(DocumentEvent e) {
    				validacionFNacimiento();
    			}

    			@Override
    			public void removeUpdate(DocumentEvent e) {
    				validacionFNacimiento();				
    			}

    			@Override
    			public void changedUpdate(DocumentEvent e) {
    				validacionFNacimiento();				
    			}
    		});
    		
    		for (JTextField campo : new JTextField[]{vista.campoNombre, vista.campoApellido}) {
                campo.addKeyListener(new java.awt.event.KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (Character.isDigit(c) || (!Character.isAlphabetic(c) && c != ' '))
                            e.consume();
                        if (((JTextField) e.getSource()).getText().length() >= 20)
                            e.consume();
                    }
                });
            }
            
            for (JTextField campo : new JTextField[]{vista.campoTelefono, vista.campoFNacimiento}) {
                campo.addKeyListener(new java.awt.event.KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (!Character.isDigit(e.getKeyChar()))
                            e.consume();
                    }
                });
            }
            
            vista.campoFNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    String texto = vista.campoFNacimiento.getText();
                    if (!Character.isDigit(e.getKeyChar())) {
                        e.consume();
                        return;
                    }
                    if (texto.length() >= 10) {
                        e.consume();
                        return;
                    }
                    if (texto.length() == 2 || texto.length() == 5) {
                    	vista.campoFNacimiento.setText(texto + "/");
                    }
                }
            });
            
            vista.campoTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (vista.campoTelefono.getText().length() >= 10)
                        e.consume();
                }
            });
            
            vista.campoCiudadEstado.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (Character.isDigit(c) || (!Character.isAlphabetic(c) && c != ' '))
                        e.consume();
                    if (vista.campoCiudadEstado.getText().length() >= 40)
                        e.consume();
                }
            });
            
    }
    
    public boolean validacionFormulario() {
        vista.limpiarErrores();
        boolean validacion = true;
 
        if (!validacionNombre())       
        	validacion = false;
        
        if (!validacionApellido())     
        	validacion = false;
        
        if (!validacionCorreo())       
        	validacion = false;
        
        if (!validacionContrasena())   
        	validacion = false;
        
        if (!validacionCiudadEstado()) 
        	validacion = false;
        
        if (!validacionDireccion())    
        	validacion = false;
        
        if (!validacionFNacimiento())  
        	validacion = false;
        
        if (!validacionTelefono())     
        	validacion = false;
 
        return validacion;
    }
    
    public boolean validacionNombre() {
    	vista.lblErrorNombre.setText("");
		if (vista.campoNombre.getText().trim().isEmpty()) {
			vista.lblErrorNombre.setText("Este campo es OBLIGATORIO");
            return false;
		}
		if(vista.campoNombre.getText().trim().length() < 3) {
			vista.lblErrorNombre.setText("Minimo 3 caracteres");
			return false;
		}
		
		return true;
	}
	
	public boolean validacionApellido() {
		vista.lblErrorApellido.setText("");
		if (vista.campoApellido.getText().trim().isEmpty()) {
			vista.lblErrorApellido.setText("Este campo es OBLIGATORIO");
            return false;
		}
		if(vista.campoApellido.getText().trim().length() < 3) {
			vista.lblErrorApellido.setText("Minimo 3 caracteres");
			return false;
		}
		return true;
	}
	
	public boolean validacionCorreo() {
		vista.lblErrorCorreo.setText("");
		if (vista.campoCorreo.getText().trim().isEmpty()) {
			vista.lblErrorCorreo.setText("Este campo es OBLIGATORIO");
            return false;
		}
		if (!vista.campoCorreo.getText().contains("@")) {
			vista.lblErrorCorreo.setText("Correo inválido");
            return false;
		}
		return true;
	}
	
	public boolean validacionContrasena() {
		vista.lblErrorContrasena.setText("");
	    
	    String contrasena = String.valueOf(vista.campoContrasena.getPassword());
	    
	    if (contrasena.trim().isEmpty()) {
	    	vista.lblErrorContrasena.setText("Este campo es OBLIGATORIO");
	        return false;
	    }
	    
	    if (contrasena.trim().length() < 8) {
	    	vista.lblErrorContrasena.setText("Minimo 8 caracteres");
	        return false;
	    }
	    
	    return true;
	}
	
	public boolean validacionCiudadEstado() {
		vista.lblErrorCiudadEstado.setText("");
		if (vista.campoCiudadEstado.getText().trim().isEmpty()) {
			vista.lblErrorCiudadEstado.setText("Este campo es OBLIGATORIO");
            return false;
		}
		return true;
	}
	
	public boolean validacionTelefono() {
		vista.lblErrorTelefono.setText("");
	    String telefono = vista.campoTelefono.getText().trim();

		if (vista.campoTelefono.getText().trim().isEmpty()) {
			vista.lblErrorTelefono.setText("Este campo es OBLIGATORIO");
            return false;
		}
		
		if (telefono.length() < 10) {
	        vista.lblErrorTelefono.setText("Minimo 10 digitos");
	        return false;
	    }
	    
		return true;
	}
	
	public boolean validacionDireccion() {
		vista.lblErrorDireccion.setText("");
		String direccion = vista.campoDireccion.getText().trim();
		
		if (vista.campoDireccion.getText().trim().isEmpty()) {
			vista.lblErrorDireccion.setText("Este campo es OBLIGATORIO");
            return false;
		}
		
		if (direccion.length() < 10) {
	        vista.lblErrorDireccion.setText("Ingresa una direccion completa");
	        return false;
	    }
		return true;
	}
	
	public boolean validacionFNacimiento() {
		vista.lblErrorFNacimiento.setText("");
		 if (vista.campoFNacimiento.getText().trim().isEmpty()) {
			 vista.lblErrorFNacimiento.setText("Este campo es OBLIGATORIO");
	            return false;
	        }
	        return true;
	}
	
	private void cerrarVentana() {
        int opcion = JOptionPane.showConfirmDialog(vista,"¿Estas seguro de que quieres salir? \nSe perderan los datos!", "Alerta", 
        		JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            vista.dispose();
        }
    }
	
	private void regresar() {
        int opcion = JOptionPane.showConfirmDialog(vista, "¿Estas seguro de que quieres regresar? \nSe perderan los datos!");
        if (opcion == JOptionPane.YES_OPTION) {
            LoginVentana ventana = new LoginVentana();
            new LoginControlador(ventana.getLoginVista());
            vista.dispose();
        }
    }
        
    	
}
	