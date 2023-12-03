package excepciones;

public class ArchivoVacio extends Exception{

    public ArchivoVacio(String message){
        super(message);
    }

    public ArchivoVacio(){
        this("Error, el archivo de Puntajes esta vacio");
    }
    
}
