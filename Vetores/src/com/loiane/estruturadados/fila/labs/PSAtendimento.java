package com.loiane.estruturadados.fila.labs;

import com.loiane.estruturadados.fila.FilaComPrioridades;

public class PSAtendimento implements Runnable {

    private FilaComPrioridades<Pessoa> fila;

    public PSAtendimento(FilaComPrioridades<Pessoa> fila) {
        this.fila = fila;
    }
    @Override
    public void run() {    
       
        while (!fila.estaVazia()) {
            try {
                System.out.println(fila.desenfileira() + " foi atendida.");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Atendimento concluído!");
    }
}
