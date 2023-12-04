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
    private RegistroVista registro = new RegistroVista(this);
    private MenuVista menu = new MenuVista(this);
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
                registro.dispose(); //Se cierra la vista del registro

            }else if (e.getSource() == menu.btnJugar){
        
                menu.dispose();
                Tetris tetris = new Tetris();
                tetris.blockgen();
            
            }else{  //Si se apreto el boton de puntuaciones
                 
                    
            }

        }catch(CampoVacioException | UsuarioNoExisteException | UsuarioExistenteException |PasswordIncorrectoException | IOException ex){ //Si se encuentra una Excepcion se encuentra y se cacha
            
            AvisosVentanas.error(ex.getMessage()); //Se manda una ventana a la pantalla con informacion de la excepcion
            
        }
        
    } 
    
}