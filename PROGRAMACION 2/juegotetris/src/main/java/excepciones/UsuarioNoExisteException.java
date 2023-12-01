package excepciones;

public class UsuarioNoExisteException extends Exception{

    public UsuarioNoExisteException(String message){
        super(message);
    }
    public UsuarioNoExisteException(){
        super("El usuario ingresado no existe, verifica el nombre");
    }
    
}
