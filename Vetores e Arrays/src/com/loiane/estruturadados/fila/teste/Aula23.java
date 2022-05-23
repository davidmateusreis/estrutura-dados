package com.loiane.estruturadados.fila.teste;

import java.util.LinkedList;
import java.util.Queue;

public class Aula23 {
    
    public static void main(String[] args) {
        
        Queue<Integer> fila = new LinkedList<>();

        fila.add(1);
        fila.add(2);

        System.out.println(fila);
        System.out.println(fila.peek()); // ESPIAR
        System.out.println(fila.remove()); // DEQUEUE / DESENFILEIRAR
        System.out.println(fila);
    }
}
