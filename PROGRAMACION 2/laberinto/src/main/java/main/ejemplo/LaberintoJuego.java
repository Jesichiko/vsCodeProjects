package main.ejemplo;

public class LaberintoJuego {
    public static void main(String[] args) {
        
        boolean resultadoBusqueda = false;
        String[][] matriz = {
            {"0", "X", "X", "S", "0"},
            {"0", "0", "0", "X", "0"},
            {"X", "0", "X", "X", "0"},
            {"X", "0", "0", "0", "0"},
            {"0", "0", "X", "0", "X"}
        };

        resultadoBusqueda = Laberinto(matriz, 0, 0);
        if(resultadoBusqueda == true){
            System.out.println("Se encontro la salida del laberinto! :)");
        }else{
            System.out.println("No se encontro la salida del laberinto :c");
        }

    }

    public static boolean Laberinto(String matriz[][], int fila, int columna){
        
        int filasMatriz = matriz.length;
        int columnasMatriz = matriz[0].length; //Da cuantas filas hay en la columna

        if (fila < 0 || fila >= filasMatriz || columna < 0 || columna >= columnasMatriz) { //Si ya se llego a los limites de la matriz (ya se pasaron)

            return false;

        }else if(matriz[fila][columna].equals("S")){ //Si se encontro la salida, caso positivo

            imprimirLaberinto(matriz);
            return true;

        }else if(matriz[fila][columna].equals("0")){ //Si encontro camino no recorrido

            matriz[fila][columna] = "/"; //Se marca la casilla como una ya intentada
            imprimirLaberinto(matriz);
            
            // Intenta moverse en todas las direcciones (arriba, abajo, izquierda, derecha)
            if (Laberinto(matriz, fila - 1, columna) ||
                Laberinto(matriz, fila + 1, columna) ||
                Laberinto(matriz, fila, columna - 1) ||
                Laberinto(matriz, fila, columna + 1)) { //Si es que se pudo mover y encontro el final retorna true
                return true;
            }

            // Si no se puede escapar desde la posición actual, marcar como no intentada
            matriz[fila][columna] = "O";

            // Imprimir el laberinto después de retroceder
            imprimirLaberinto(matriz);

        }

        return false;

    }

    public static void imprimirLaberinto(String matriz[][]){

        for(String[] fila: matriz){
            for(String pos : fila){
                System.out.print(pos + " ");
            }
            System.out.println(); //Imprime un espacio por cada fila
        }   
            
        System.out.println();
    }

}