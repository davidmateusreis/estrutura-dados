package com.loiane.estruturadados.pilha.labs;

import com.loiane.estruturadados.pilha.Pilha;

public class Exer05 {
    
    public static void main(String[] args) {
        
        imprimeResultado("ADA");
        imprimeResultado("ABCD");
        imprimeResultado("ABCCBA");
        imprimeResultado("Maria");
    }
    public static void imprimeResultado(String palavra) {
        System.out.println(palavra + " é palindromo? " + testaPalimdromo(palavra));
    }
    public static boolean testaPalimdromo(String palavra) {

        Pilha<Character> pilha = new Pilha<>();

        for (int i = 0; i < palavra.length(); i++) {
            pilha.empilha(palavra.charAt(i));
        }
        String palavraInversa = "";
        while (!pilha.estaVazia()) {
            palavraInversa += pilha.desempilha();
        }
        if (palavraInversa.equals(palavra)) {
            return true;
        }
        return false;
    }
}
