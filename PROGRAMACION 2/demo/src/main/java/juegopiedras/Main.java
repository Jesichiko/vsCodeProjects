package juegopiedras;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int piedrasIniciales = 21;
        System.out.println("Que empiece el juego!");
        player1(piedrasIniciales);
        
    }

    public static void player1(int piedrasTotales){
        
        piedrasTotales -= tomarPiedras("Jugador 1");
        if(piedrasTotales > 0){
            player2(piedrasTotales);
        }else
            System.out.println("Lo siento Jugador 1, haz perdido :c");


    }

    public static void player2(int piedrasTotales){

        piedrasTotales -= tomarPiedras("Jugador 2");
        if(piedrasTotales > 0){
            player1(piedrasTotales);
        }else
            System.out.println("Lo siento Jugador 1, haz perdido :c");

        
    }

    public static int tomarPiedras(String player){

        int piedrasTomadas = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("Turno del " +player+ " de tomar piedras, toma de 1 a 4 piedras");

        do{
            
            piedrasTomadas = in.nextInt();
            if(piedrasTomadas < 1 || piedrasTomadas > 4){
                System.out.println("Toma solo de 1 a 4 piedras, no mas");
                System.out.println("Vuelve a tomar piedras: ");
            }

        }while(piedrasTomadas < 1 || piedrasTomadas > 4);

        System.out.println("Piedras tomadas: " +piedrasTomadas);
        return piedrasTomadas;
    }

}