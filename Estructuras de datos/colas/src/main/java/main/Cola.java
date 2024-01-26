package main;

public class Cola {

    private int datos[];
    private int frente, fondo, tam;

    Cola(int tam){
        this.tam = tam;
        datos = new int[tam];
        frente = fondo = 0;
    }

    Cola(){
        this(5);
    }

    public void enqueue(int data){
        if(isFull()){
            System.out.println("No se pueden ingresar mas datos, la cola ya esta llena");
            return;
        }
        datos[fondo++ % tam] = data;
    }

    public int dequeue(){
        if(isEmpty())
            return -1; 
        return datos[frente ++ % tam];
    }

    public boolean isEmpty(){
        return frente == fondo;
    }

    public boolean isFull(){
        return frente == (fondo + 1 % tam);
    }

}