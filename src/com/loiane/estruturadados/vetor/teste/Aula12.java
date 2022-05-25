package com.loiane.estruturadados.vetor.teste;

import java.util.ArrayList;

public class Aula12 {
    
    public static void main(String[] args) {
        
        ArrayList<String> arraylList = new ArrayList<String>();

        arraylList.add("A");
        arraylList.add("C");

        System.out.println(arraylList);

        arraylList.add(1, "B");

        System.out.println(arraylList);

        boolean existe = arraylList.contains("A");
        if (existe) {
            System.out.println("Elemento existe no array");
        } else {
            System.out.println("Elemento não existe no array");
        }

        int pos = arraylList.indexOf("B");
        if (pos > -1) {
            System.out.println("Elemento existe no array " + pos);
        } else {
            System.out.println("Elemento não existe no array " + pos);
        }
        System.out.println(arraylList.get(2));

        arraylList.remove(0);
        arraylList.remove("B");

        System.out.println(arraylList);
        System.out.println(arraylList.size());


    }
}
