package excepciones;

public class UsuarioExistenteException extends Exception{

    public UsuarioExistenteException(String message){
        super(message);
    }

    public UsuarioExistenteException(){
        this("Error. Este usuario ya existe, intenta ingresar otro");
    }
    
}
