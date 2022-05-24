package com.loiane.estruturadados.fila.labs;

import java.util.Random;

import com.loiane.estruturadados.fila.FilaComPrioridades;

public class PSNovosPacientes implements Runnable {

    private FilaComPrioridades<Pessoa> fila;
    private int cont = 7;
    private Random prioridade = new Random();

    public PSNovosPacientes(FilaComPrioridades<Pessoa> fila) {
        this.fila = fila;
    }
    @Override
    public void run() {
         
        for (int i = 0; i < 8; i++) {
            try {
                Thread.sleep(8000);
                Pessoa p = new Pessoa("" + cont, prioridade.nextInt(3));
                fila.enfileira(p);
                cont++;
                System.out.println(p + " foi enfileirada.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
