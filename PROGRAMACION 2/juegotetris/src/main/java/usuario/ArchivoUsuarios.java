package usuario;

import java.io.*;
import java.util.ArrayList;

public class ArchivoUsuarios {
    
    String ruta;
    
    public ArchivoUsuarios(String ruta){
        this.ruta=ruta;
    }
    
    public ArchivoUsuarios(){
        this(System.getProperty("user.dir") + File.separator + "puntajes.txt");
    }
    
    public ArrayList<String> leerArchivo() throws IOException{ 
        ArrayList<String> lineas = new ArrayList<>();
        String linea;
        try (BufferedReader leer = new BufferedReader(new FileReader(ruta))) {
            while ((linea = leer.readLine()) != null) { //Se lee cada linea hastta que llegue a la ultima
                lineas.add(linea);
            }
        }
        return lineas;
        
    }
    
    public void escribirEnArchivo(String user, String password) throws IOException{ 
        int ID;
        ID = ID(); //Se recupera el ultimo valor del index que haya quedado en el archivo
        String elemento = ID + "_" + user +  "_"  + password +  "_"  + 0 + "\n"; //Guardamos el elemento con un token, en este caso el token es un _ (esto para imprimirlo en la GUI mas adelante)
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(ruta, true))) { //Se pone en true la posibilidad de agregar mas elementos de los que estan en archivo, esto para no sobreescribir la informacion
            escribir.write(elemento);
        }
        
    }
    
    public int ID() throws IOException{ 
        ArrayList<String> lineas = leerArchivo(); //Se lee el archivo
        String c;
        String[] cadena;
        int i;    
        
        if(lineas.isEmpty()){ //Si todavia no se ha puesto un elemento en el archivo el index empieza por default en 1
            return 1;
        }
        c = lineas.get(lineas.size()-1 ); //Se accede al ultimo elemento del archivo
        cadena = c.split("_"); //Se divide el elemento con el uso del token "_"
        i = Integer.parseInt(cadena[0]); //Se accede al primer campo del ultimo elemento, esto es, el ultimo valor de index que quedo en el archivo
        return ++i;
    }
    
    public int buscarUsuario(String user) throws IOException{ 
        ArrayList<String> lineas = leerArchivo(); //Se lee el archivo
        String c;
        String[] cadena;
        int i;    
        
        if(lineas.isEmpty()){ //Si todavia no se ha puesto un elemento en el archivo, con 0 indicamos que no existe ningun usuario
            return -1;
        }
        for(i=0;i<lineas.size();i++){
            c = lineas.get(i);
            cadena = c.split("_");
            if(cadena[1].equals(user)){
                return i;
            }
        }
        return -1;
    }
    
    public boolean acceder (int ID,String password)throws IOException{
        if(ID==-1){
            return false;
        }
        ArrayList<String> lineas = leerArchivo(); //Se lee el archivo
        String c = lineas.get(ID);
        String[] cadena = c.split("_");
        if(cadena[2].equals(password)){
            return true;
        }
        return false;
    }
     
}