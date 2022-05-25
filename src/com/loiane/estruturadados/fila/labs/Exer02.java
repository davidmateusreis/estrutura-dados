package com.loiane.estruturadados.fila.labs;

import com.loiane.estruturadados.fila.Fila;

public class Exer02 {
    
    public static void main(String[] args) {
        
        Fila<String> regular = new Fila<>();
        Fila<String> prioridade = new Fila<>();

        final int MAX_PRIORIDADE = 3;

        regular.enfileira("Pessoa1");
        regular.enfileira("Pessoa2");
        regular.enfileira("Pessoa3");
        prioridade.enfileira("Pessoa 1P");
        prioridade.enfileira("Pessoa 2P");
        prioridade.enfileira("Pessoa 3P");
        prioridade.enfileira("Pessoa 4P");
        prioridade.enfileira("Pessoa 5P");
        regular.enfileira("Pessoa4");
        regular.enfileira("Pessoa5");
        regular.enfileira("Pessoa6");
        regular.enfileira("Pessoa7");
        regular.enfileira("Pessoa8");

        while (!regular.estaVazia() || !prioridade.estaVazia()) {

            int cont = 0;

            while(!prioridade.estaVazia() && cont < MAX_PRIORIDADE) {
                atendePessoa(prioridade);
                cont++;
            }
            if (!regular.estaVazia()) {
               atendePessoa(regular);
            }
            if (prioridade.estaVazia()) {
                while (!regular.estaVazia()) {
                    atendePessoa(regular);
                }
            }
        }
    }
    public static void atendePessoa(Fila<String> fila) {
        String pessoaAtendida = fila.desenfileira();
        System.out.println(pessoaAtendida + " foi atendida.");
    }
}
