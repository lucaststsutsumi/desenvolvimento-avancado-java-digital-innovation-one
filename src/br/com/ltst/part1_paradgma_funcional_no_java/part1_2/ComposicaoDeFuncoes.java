package br.com.ltst.part1_paradgma_funcional_no_java.part1_2;

import java.util.Arrays;

public class ComposicaoDeFuncoes {
    public static void main(String[] args) {
        int[] valores = {1, 2, 3, 4, 5};

        // funcional
        Arrays.stream(valores)
                .filter(numero -> numero % 2 == 0)
                .map(numero -> numero * 2)
                .forEach(numero -> System.out.println(numero));


        // imperativo

        for (int i = 0; i < valores.length; i++) {
            int valor = 0;
            if (valores[i] % 2 == 0) {
                valor = valores[i] * 2;
                if (valor != 0) {
                    System.out.println(valor);
                }
            }
        }
    }
}
