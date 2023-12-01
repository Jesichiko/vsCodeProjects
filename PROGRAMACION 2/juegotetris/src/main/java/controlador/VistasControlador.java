package controlador;

import tetris.*;
import excepciones.*;
import helper.AvisosVentanas;
import login.*;
import menu.*;
import usuario.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class VistasControlador implements ActionListener{
    
    LoginVista login;
    RegistroVista registro;
    MenuVista menu;
    UsuarioModelo modelo;
    ArchivoUsuarios usuarios;
    int ID;
    String user;

    public void setLogin(LoginVista login) {
        
        this.login = login;  
        try {
            
            File archivoFile = new File(System.getProperty("user.dir") + File.separator + "puntajes.sex"); // Se verifica si el archivo ya existe
            
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
            
            if(e.getSource() == login.btnIngresar){ //Si se clickea el boton de login
                
                user = login.txtUsuario.getText();
                if(user.equals("Ingresa tu usuario")){ //Si no se agrega informacion al campo se envia un mensaje de error
                    throw new CampoVacioException("Ingresa informacion al campo de usuario");
                }
                
                ID = usuarios.buscarUsuario(user); //Se busca a el usuario
                if(ID == -1){ //Si no se encontro el usuario se retorna un -1
                    throw new UsuarioNoExisteException(); 
                }
                
                if( usuarios.acceder(ID, Arrays.toString(login.txtContraseña.getPassword()) )){//Si se ingresa correctamente se despliega el menu
                    
                    AvisosVentanas.IngresoExitoso(); //Se le notifica al usuario su registro exitoso
                    login.dispose(); //Se cierra la venta del login
                    
                    menu = new MenuVista(this); //Creamos un nuevo panel de registro con esta misma clase como controlador
                    menu.setVisible(true); //Se hace visible el panel del menu
                    
                }else //Si no es la contraseña del usuario
                    AvisosVentanas.error("Error, " +user+ "tu contraseña es distinta");
                
            }else if(e.getSource() == login.btnRegistro){
                
                registro = new RegistroVista(this); //Creamos un nuevo panel de registro con esta misma clase como controlador
                registro.setVisible(true);
                
            }else if(e.getSource() == registro.btnRegistrarse){
                
                user=registro.txtUsuario.getText();
                if(user.equals("Ej: ElPro1234")||registro.txtContraseña.getText().equals("Ej: OmocatLLSPP")){
                    throw new CampoVacioException();
                }
                
                if(usuarios.buscarUsuario(user)!=-1){
                     AvisosVentanas.error(" Este usuario ya existe, intenta ingresar");
                }else{
                    usuarios.escribirEnArchivo(user,registro.txtContraseña.getText());
                     AvisosVentanas.registroExitoso();
                }
                login.txtUsuario.setText(user);
                login.txtContraseña.setText(registro.txtContraseña.getText());
                registro.dispose(); //Se cierra la vista del registro
                
            }else if (e.getSource() == menu.btnJugar){
            
                menu.dispose();
                Tetris tetris = new Tetris();
                tetris.blockgen();
            
            }else{ //Boton de puntuaciones
                    //Abrir las puntuaciones
            }
            
        }catch(CampoVacioException | UsuarioNoExisteException | IOException ex){ //Si se encuentra una Excepcion se encuentra y se cacha
            AvisosVentanas.error(ex.getMessage()); //Se manda una ventana a la pantalla con informacion de la excepcion
        }
        
    } 
}