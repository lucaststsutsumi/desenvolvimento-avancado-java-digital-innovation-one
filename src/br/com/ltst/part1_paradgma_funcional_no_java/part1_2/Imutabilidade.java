package br.com.ltst.part1_paradgma_funcional_no_java.part1_2;

import java.util.function.UnaryOperator;

public class Imutabilidade {
    public static void main(String[] args) {
        int valor = 10;
        UnaryOperator<Integer> retornarDobro=
                (parametro) ->parametro*2;

        System.out.println(retornarDobro.apply(valor)); // retorna o dobro do valor
        System.out.println(valor); //valor não sera alterado

    }
}
