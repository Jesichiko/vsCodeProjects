package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String entrada;
        int valor, valorV, valorN;

        System.out.println("Ingresa una cadena de numeros");
        entrada = in.nextLine();
        Cola cola = new Cola(entrada.length());
        Cola colaN = new Cola(entrada.length());
        
        System.out.println("Escribe el numero que quieres reemplazar");
        valorV = in.nextInt();
        System.out.println("Escribe el valor por el que lo quieres reemplazar");
        valorN = in.nextInt();
        in.close();
        for(int i = 0; i < entrada.length(); i++)
            cola.enqueue(Integer.parseInt(String.valueOf(entrada.charAt(i))));
        while (!cola.isEmpty()) {
            valor = cola.dequeue();
            if(valor == valorV)
                valor = valorN;
            colaN.enqueue(valor);
        }

        System.out.println("La cola resultante es:");
        while(!colaN.isEmpty()){
            System.out.println(colaN.dequeue());
        }
    }
}