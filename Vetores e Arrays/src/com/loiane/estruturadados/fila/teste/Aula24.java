package com.loiane.estruturadados.fila.teste;

import com.loiane.estruturadados.fila.FilaComPrioridades;

public class Aula24 {
    
    public static void main(String[] args) {
        
        FilaComPrioridades<Paciente> fila = new FilaComPrioridades<>();

        fila.enfileira(new Paciente("A", 2));
        fila.enfileira(new Paciente("C", 1));
        fila.enfileira(new Paciente("B", 3));

        System.out.println(fila); // 1 2 3 e não 1 3 2
        System.out.println(fila.desenfileira());
        System.out.println(fila);
        System.out.println(fila.desenfileira());
        System.out.println(fila);
        System.out.println(fila.desenfileira());
        System.out.println(fila);
    }
}
