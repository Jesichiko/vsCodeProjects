package usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUsuarios { 
    private String ruta;
    private int actualID;
    
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
            if(cadena[1].equals(user)){ //=)     
                actualID = i;
                return actualID;
            }
        }
        return -1;
    }
    
    public boolean acceder(int ID, char[] password) throws IOException {
    if (ID == -1) 
        return false;

    ArrayList<String> lineas = leerArchivo(); // Se lee el archivo
    String c = lineas.get(ID);
    String[] cadena = c.split("_"); //Dividimos la informacion del usuario
    String passwordString = new String(password); // Convierte el char[] a String
    
    return cadena[2].equals(passwordString); //El metodo retorna true o false
    
    }
    
    public void escribirPuntuacion(int puntuacion) throws IOException{
        ArrayList<String> lineas = leerArchivo(); //Se lee el archivo
        
        String[] cadena = lineas.get(actualID).split("_");
        cadena[3] = String.valueOf(puntuacion);
        
        //Reemplaza la linea actualizada en la lista
        lineas.set(actualID, String.join("_", cadena));
        
        // Escribe todas las líneas actualizadas de vuelta al archivo
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(ruta))) {
            for (String linea : lineas) {
                escribir.write(linea);
                escribir.newLine();
            }
        }  
    }
    
    public String[] leerPuntuaciones() throws IOException{

        List<String> archivo =  leerArchivo(); //Se lee el archivo
        List<String> puntuacionesArchivos = new ArrayList<>();
        String[] puntuacionesMaximas = {"S/N_0", "S/N_0", "S/N_0", "S/N_0"}; //Puntuaciones por DEFAULT
        
        for(String linea : archivo){ //Se recorre el archivo leido y se saca solo el nombre y puntuacion de todos los usuarios
            String[] datos = linea.split("_");
            puntuacionesArchivos.add(datos[1] + "_" + datos[3]); //En el campo 1 se encuentra el nombre del usuario y en el campo 3 su puntuacion
        }
        
        List<String> puntuaciones = new ArrayList<>();
        for(int i = 0; i < puntuacionesArchivos.size(); i++){ //Se llena una lista con solo las puntuaciones
            String[] datos = puntuacionesArchivos.get(i).split("_");
            puntuaciones.add(datos[1]); 
        }
        
        for (int i = 0; i < 4; i++) {
            if (puntuaciones.isEmpty()) { //Si se eliminaron mas elementos de los que habia
                return puntuacionesMaximas;
            }
            int puntuacionMaxima = Integer.parseInt(puntuaciones.get(0)); //Se supone que el primer elemento de la lista es el mas grande
            int puntuacionMaximaIndex = 0; //Index del mayor elemento
            
            for (int x = 0; x < puntuaciones.size(); x++) {
                
                if (Integer.parseInt(puntuaciones.get(x)) > puntuacionMaxima) {
                    puntuacionMaxima = Integer.parseInt(puntuaciones.get(x));
                    puntuacionMaximaIndex = x;
                }
            }
            puntuaciones.remove(puntuacionMaximaIndex); //Se elimina el elemento mas grande la lista para busca el nuevo "mas grande"
            puntuacionesMaximas[i] = puntuacionesArchivos.get(puntuacionMaximaIndex); //Se agrega el elemento al arreglo
            puntuacionesArchivos.remove(puntuacionMaximaIndex);
        }

        return puntuacionesMaximas;
    }
    
}