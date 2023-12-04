package usuario;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUsuarios {
    private Path RUTA;

    public ArchivoUsuarios(Path ruta) {
        this.RUTA = ruta;
    }

    public ArchivoUsuarios() {
        this(Paths.get(System.getProperty("user.dir"), "puntajes.txt"));
    }

    public List<String> leerArchivo() throws IOException {
        return Files.readAllLines(RUTA); //Se retorna todo el archivo en un ArrayList
    }

    public void escribirEnArchivo(String user, String password) throws IOException {
        int ID = ID();  //Se recupera el ultimo valor del index que haya quedado en el archivo
        String elemento = ID + "_" + user + "_" + password + "_0"; //Guardamos el elemento con un token, en este caso el token es un _ (esto para imprimirlo en la GUI mas adelante)
        try (BufferedWriter escribir = Files.newBufferedWriter(RUTA, StandardOpenOption.APPEND)) { //Se escribe en el archivo, insertando nuevos datos y no sobreescribiendolos
            escribir.write(elemento);
            escribir.newLine();
        }
    }

    public int ID() throws IOException {
        List<String> lineas = leerArchivo(); //Se lee el archivo
        if (lineas.isEmpty()) {  //Si todavia no se ha puesto un elemento en el archivo el index empieza por default en 1
            return 1;
        }

        String ultimaLinea = lineas.get(lineas.size() - 1); //Se accede al ultimo elemento del archivo
        String[] cadena = ultimaLinea.split("_"); //Se divide el elemento con el uso del token "_"
        return Integer.parseInt(cadena[0]) + 1; //Se accede al primer campo del ultimo elemento, esto es, el ultimo valor de index que quedo en el archivo y se aumenta uno
    }

    public int buscarUsuario(String user) throws IOException {
        List<String> lineas = leerArchivo(); //Se lee el archivo

        if(lineas.isEmpty()) //Si todavia no se ha puesto un elemento en el archivo
            return -1;
        
        for (int i = 0; i < lineas.size(); i++) {
            String[] cadena = lineas.get(i).split("_");
            if (cadena[1].equals(user)) {
                return i;
            }
        }
        return -1; //Si no se pudo encontrar al usuario
    }

    public boolean acceder(int ID, char[] password) throws IOException {
        if (ID == -1) {
            return false;
        }

        List<String> lineas = leerArchivo();
        String[] cadena = lineas.get(ID).split("_");
        return cadena.length > 2 && cadena[2].equals(new String(password));
    }

    public void escribirPuntuaciones(String puntuacion){

        

    }

    public String[] leerPuntuaciones() throws IOException{

        List<String> archivo =  leerArchivo(); //Se lee el archivo
        List<String> puntuacionesArchivos = new ArrayList<>();
        List<String> puntuaciones = new ArrayList<>();
        String[] puntuacionesMaximas = new String[4];
        
        for(String linea : archivo){ //Se recorre el archivo leido y se utilizara solo el nombre y puntuacion de todos los usuarios
            String[] datos = linea.split("_");
            puntuacionesArchivos.add(datos[1] + "_" + datos[3]); //En el campo 1 se encuentra el nombre del usuario y en el campo 3 su puntuacion
        }
        
        for(int i = 0; i < puntuacionesArchivos.size(); i++){ //Se llena una lista con solo las puntuaciones
            String[] datos = puntuacionesArchivos.get(i).split("_");
            puntuaciones.add(datos[1]); 
        }

        for (int i = 0; i < 4; i++) {
            if (puntuaciones.isEmpty()){ //Si tras eliminar a los jugadores con mayor puntaje (4) la lista queda vacia se rompe el ciclo
                for(int i = puntuacionesMaximas.length; i < 4; i++){
                    
                }
                break;
            }
            int puntuacionMaxima = Integer.parseInt(puntuaciones.get(0)); //Se supone que el primer elemento es el mas grande
            int puntuacionMaximaIndex = 0; //Index del elemento mas grande
            for (int x = 0; x < puntuaciones.size(); x++) { //Se recorre la lista para encontrar el elemento mas grande 4 veces
                if ( Integer.parseInt( puntuaciones.get(x) ) > puntuacionMaxima ) {
                    puntuacionMaxima = Integer.parseInt(puntuaciones.get(x));
                    puntuacionMaximaIndex = x;
                }
            }
            puntuaciones.remove(puntuacionMaximaIndex); //Despues de haber encontrado el elemento mas grande se remueve de la lista
            puntuacionesMaximas[i] = puntuacionesArchivos.get(puntuacionMaximaIndex); //Se agrega a un arreglo el elemento que fue mas grande con el nombre del usuario (esto con el index)
        }
        
        return puntuacionesMaximas;
    }
}