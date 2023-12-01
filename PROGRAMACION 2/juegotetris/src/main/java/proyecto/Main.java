package proyecto;

import controlador.VistasControlador;
import login.LoginVista;
import usuario.UsuarioModelo;

public class Main {
    public static void main(String[] args) {
        
        VistasControlador controlador = new VistasControlador();
        
        UsuarioModelo modelo = new UsuarioModelo();
        controlador.setModelo(modelo);
        
        LoginVista login = new LoginVista(controlador);
        controlador.setLogin(login);
        
    }
}