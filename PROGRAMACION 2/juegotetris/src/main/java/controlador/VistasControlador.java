package controlador;

import tetris.*;
import excepciones.*;
import helper.AvisosVentanas;
import login.*;
import menu.*;
import puntuaciones.PuntuacionesVista;
import usuario.*;
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
                if(login.txtUsuario.getText().equals("Ingresa tu usuario")){ //Si no se agrega informacion al campo se envia un mensaje de error
                    throw new CampoVacioException("Ingresa informacion al campo de usuario");
                }
                
                ID = usuarios.buscarUsuario(login.txtUsuario.getText()); //Se busca a el usuario
                if(ID == -1){ //Si no se encontro el usuario se retorna un -1
                    throw new UsuarioNoExisteException(); 
                }
                
                if( usuarios.acceder(ID, login.txtPassword.getPassword() ) ){//Si se ingresa correctamente se despliega el menu
                    
                    AvisosVentanas.IngresoExitoso(); //Se le notifica al usuario su registro exitoso
                    login.dispose(); //Se cierra la venta del login
                
                    //Se hace visibile el menu
                    menu.setVisible(true);
                    
                }else //Si no es la contraseña del usuario
                    throw new PasswordIncorrectoException();

            }else if(e.getSource() == login.btnRegistro){
                    
                //Hacemos visible el registro
                registro.setVisible(true);

            }else if(e.getSource() == registro.btnRegistrarse){

                //Si no se escribio nada en los campos de registro
                if(registro.txtUsuario.getText().equals("Ej: ElPro1234")|| registro.txtPassword.getText().equals("Ej: OmocatLLSPP") ){
                    throw new CampoVacioException();
                }
                
                //Se pasan los valores al modelo
                modelo.setUser(registro.txtUsuario.getText());
                modelo.setPassword(registro.txtPassword.getText());
                
                //Se valida si el usuario escrito ya existe o no
                if( usuarios.buscarUsuario( modelo.getUser() ) != -1){ //Si el usuario ingresado ya existe en el archivo
                    throw new UsuarioExistenteException();
                }else{
                    usuarios.escribirEnArchivo(modelo.getUser(), modelo.getPassword());
                    AvisosVentanas.registroExitoso();
                    
                    //Se pone automaticamente la informacion escrita por el usuario en los campos de Iniciar Sesion
                    login.txtUsuario.setText(modelo.getUser());
                    login.txtPassword.setText(modelo.getPassword());    
                    registro.dispose(); //Se cierra la vista del registro
                }

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