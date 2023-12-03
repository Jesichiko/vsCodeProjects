package excepciones;

public class PasswordIncorrectoException extends Exception{

    public PasswordIncorrectoException(String message){
        super(message);
    }

    public PasswordIncorrectoException(){
        this("Error, la contraseña es distinta");
    }
    
}
