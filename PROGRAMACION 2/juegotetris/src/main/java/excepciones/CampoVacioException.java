package excepciones;

public class CampoVacioException extends Exception{
    
    public CampoVacioException(String message){
        super(message);
    }
    public CampoVacioException(){
        super("Ingrese informacion en el campo dado");
    }
    
}