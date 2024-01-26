package controlador;

import excepciones.*;
import helpers.AvisosVentanas;
import juego.*;
import usuario.*;
import vistas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class VistasControlador implements ActionListener{
    
    private LoginVista login;
    private final RegistroVista registro = new RegistroVista(this);
    private final MenuVista menu = new MenuVista(this);
    private final PuntuacionesVista puntuaciones = new PuntuacionesVista(this);
    private UsuarioModelo modelo;
    private ArchivoUsuarios usuarios;
    private int ID;

    public void setLogin(LoginVista login) {
        
        this.login = login;  
        try {
            
            File archivoFile = new File(System.getProperty("user.dir") + File.separator + "puntajes.txt"); // Se verifica si el archivo ya existe
            
            if (!archivoFile.exists()) { //Si no existe entonces se crea
                archivoFile.createNewFile();
            }
            
            usuarios = new ArchivoUsuarios();
        } catch (IOException ex) {
            AvisosVentanas.error("Error al intentar acceder al archivo: ");
        }
        
    }

    public void setModelo(UsuarioModelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        try{ //Generalizamos el try-catch
            
            if(e.getSource() == login.btnIngresar ){ //Si se clickea el boton de login
                
                if( login.txtUsuario.getText().equals("Ingresa tu usuario") || login.txtPassword.getPassword().length == 0 ) //Si no se agrega informacion a los campos se envia un mensaje de error
                    throw new CampoVacioException("Ingresa informacion a los campos de usuario");
                
                ID = usuarios.buscarUsuario(login.txtUsuario.getText()); //Se busca a el usuario
                if(ID == -1) //Si el usuario no se encontro
                    throw new UsuarioNoExisteException();

                if ( !usuarios.acceder(ID, login.txtPassword.getPassword() ) )  // Si no se ingresa correctamente la contraseña se lanza un error
                    throw new PasswordIncorrectoException();
                
                // Si se ingresa correctamente la contraseña se despliega el menu
                AvisosVentanas.IngresoExitoso(); // Se le notifica al usuario su ingreso exitoso
                login.dispose(); // Se cierra la ventana del login
            
                menu.setVisible(true); // Se hace visible el menú

            }else if(e.getSource() == login.btnRegistro){
                    
                //Hacemos visible el registro
                registro.setVisible(true);

            }else if(e.getSource() == registro.btnRegistrarse){

                //Si no se escribio nada en los campos de registro
                if( registro.txtUsuario.getText().equals("Ej: ElPro1234") || registro.txtPassword.getText().equals("Ej: OmocatLLSPP") )
                    throw new CampoVacioException();
                
                //Se pasan los valores al modelo
                modelo.setUser(registro.txtUsuario.getText());
                modelo.setPassword(registro.txtPassword.getText());
                
                //Se valida si el usuario escrito ya existe o no
                if( usuarios.buscarUsuario( modelo.getUser() ) != -1) //Si el usuario ingresado ya existe en el archivo
                    throw new UsuarioExistenteException();
                
                //Se escribe en el archivo y se le notifica al usuario de su registro exitoso
                usuarios.escribirEnArchivo(modelo.getUser(), modelo.getPassword());
                AvisosVentanas.registroExitoso();
                
                //Se pone automaticamente la informacion escrita por el usuario en los campos de Iniciar Sesion
                login.txtUsuario.setText(modelo.getUser());
                login.txtPassword.setText(modelo.getPassword()); 
                
                //Se borra la informacion ingresada en el registro
                registro.txtUsuario.setText("");
                registro.txtPassword.setText("");
                registro.dispose(); //Se cierra la vista del registro

            }else if (e.getSource() == menu.btnJugar){
                
                Tetris tetris = new Tetris(this);
                menu.dispose();
                tetris.setVisible(true);
                tetris.blockgen();
 
            }else if (e.getSource() == menu.btnPuntuaciones){//Si se apreto el boton de puntuaciones
               
                String[] plPtn = usuarios.leerPuntuaciones(); //Se leen todas las puntuaciones
                
                for(int i = 0; i < 4; i++){
                    String[] datos = plPtn[i].split("_");
                    switch(i){
                        case 0:
                            puntuaciones.lbPlayer1.setText(datos[0]);
                            puntuaciones.lbPunt1.setText(datos[1]);
                            break;
                        case 1:
                            puntuaciones.lbPlayer2.setText(datos[0]);
                            puntuaciones.lbPunt2.setText(datos[1]);
                            break;
                        case 2:
                            puntuaciones.lbPlayer3.setText(datos[0]);
                            puntuaciones.lbPunt3.setText(datos[1]);
                            break;
                        case 3:
                            puntuaciones.lbPlayer4.setText(datos[0]);
                            puntuaciones.lbPunt4.setText(datos[1]);
                            break;
                    }
                }
                
                puntuaciones.setVisible(true);
                    
            }else{
                
                puntuaciones.cerrar();
                menu.setVisible(true);
                    
            }

        }catch(CampoVacioException | UsuarioNoExisteException | UsuarioExistenteException |PasswordIncorrectoException | IOException ex){ //Si se encuentra una Excepcion se encuentra y se cacha
            
            AvisosVentanas.error(ex.getMessage()); //Se manda una ventana a la pantalla con informacion de la excepcion
            
        }
        
    } 
    
}