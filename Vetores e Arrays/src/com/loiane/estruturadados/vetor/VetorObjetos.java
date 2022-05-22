package com.loiane.estruturadados.vetor;

public class VetorObjetos {
    // ATRIBUTOS
    private Object[] elementos;
    private int tamanho;
    // MÉTODO CONSTRUTOR
    public VetorObjetos(int capacidade) {
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }
    public boolean adiciona(Object elemento) { // ADICIONA ELEMENTO AO FINAL DO VETOR
        this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;  
    }
    public boolean adiciona(int posicao, Object elemento) { // ADICIONA UM ELEMENTO EM QUALQUER POSIÇÃO QUE JÁ ESTEJA OCUPADA EM UM VETOR
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("A posição é inválida!");
        }
        this.aumentaCapacidade();
        // Mover todos os elementos
        for (int i = this.tamanho-1; i >= posicao; i--) {
            this.elementos[i+1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;

        return true;
    }
    private void aumentaCapacidade() { // ADICIONA MAIS CAPACIDADE AO UM VETOR  
        if (this.tamanho == this.elementos.length) {
            Object[] elementosNovos = new Object[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }
    public Object busca(int posicao) { // OBTER ELEMENTO DE UMA POSIÇÃO NO VETOR
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("A posição é inválida!");
        }
        return this.elementos[posicao];
    }
    public int busca(Object elemento) { // VERIFICAR SE O ELEMENTO EXISTE NO VETOR COM BUSCA SEQUENCIAL
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }
    public void remove(int posicao) { // REMOVER ELEMENTO DE QUALQUER POSIÇÃO DO VETOR
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("A posição é inválida!");
        }
        for (int i = posicao; i < this.tamanho-1; i++) {
            this.elementos[i] = this.elementos[i+1];
        }
        this.tamanho--;
    }
    public int tamanho() { // VERIFICAR A QUANTIDADE DE ELEMENTOS DO VETOR
        return this.tamanho;
    }
    @Override
    public String toString() { // IMPRIMIR ELEMENTOS DO VETOR

        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.tamanho-1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }
        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho-1]);
        }
        s.append("]");
        return s.toString();
    } 
}
