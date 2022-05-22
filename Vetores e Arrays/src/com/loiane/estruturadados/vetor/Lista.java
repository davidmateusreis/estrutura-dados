package com.loiane.estruturadados.vetor;

import java.lang.reflect.Array;

public class Lista<T> {
        // ATRIBUTOS
        private T[] elementos;
        private int tamanho;
        // MÉTODO CONSTRUTOR
        public Lista(int capacidade) {
            this.elementos = (T[]) new Object[capacidade];
            this.tamanho = 0;
        }
        public Lista(int capacidade, Class<T> tipoClasse) {
            this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
            this.tamanho = 0;
        }
        public boolean adiciona(T elemento) { // ADICIONA ELEMENTO AO FINAL DO VETOR
            this.aumentaCapacidade();
            if (this.tamanho < this.elementos.length) {
                this.elementos[this.tamanho] = elemento;
                this.tamanho++;
                return true;
            }
            return false;  
        }
        public boolean adiciona(int posicao, T elemento) { // ADICIONA UM ELEMENTO EM QUALQUER POSIÇÃO QUE JÁ ESTEJA OCUPADA EM UM VETOR
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
                T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
                for (int i = 0; i < this.elementos.length; i++) {
                    elementosNovos[i] = this.elementos[i];
                }
                this.elementos = elementosNovos;
            }
        }
        public T busca(int posicao) { // OBTER ELEMENTO DE UMA POSIÇÃO NO VETOR
            if (!(posicao >= 0 && posicao < tamanho)) {
                throw new IllegalArgumentException("A posição é inválida!");
            }
            return this.elementos[posicao];
        }
        public boolean contem(T elemento) { // EXER 01
            return busca(elemento) >= 0;
        }
        public int busca(T elemento) { // VERIFICAR SE O ELEMENTO EXISTE NO VETOR COM BUSCA SEQUENCIAL
            for (int i = 0; i < this.tamanho; i++) {
                if (this.elementos[i].equals(elemento)) {
                    return i;
                }
            }
            return -1;
        }
        public int ultimoIndice(T elemento) { // EXER 02
            for (int i = this.tamanho-1; i >= 0; i--) {
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
        public void remove(T elemento) { // EXER 03
            int pos = busca(elemento);
            if (pos >= 0) {
                this.remove(pos);
            }
        }
        public T obtem(int posicao) { // EXER 04
            return busca(posicao);
        }
        public void limpar() { // EXER 05
            for (int i = 0; i < this.tamanho; i++) {
                this.elementos[i] = null;
            }
            this.tamanho = 0;
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
