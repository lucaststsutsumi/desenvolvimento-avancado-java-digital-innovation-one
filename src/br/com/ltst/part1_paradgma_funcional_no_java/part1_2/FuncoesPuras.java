package br.com.ltst.part1_paradgma_funcional_no_java.part1_2;

import java.util.function.BiPredicate;

public class FuncoesPuras {

    public static void main(String[] args) {
        BiPredicate<Integer,Integer> verificarSeEMaior=
                (parametro,valorComparacao) ->parametro>valorComparacao;

        System.out.println(verificarSeEMaior.test(13,12));
        System.out.println(verificarSeEMaior.test(13,12));

    }
}
