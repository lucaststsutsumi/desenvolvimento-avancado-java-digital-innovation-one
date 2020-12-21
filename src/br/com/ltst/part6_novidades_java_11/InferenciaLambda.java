package br.com.ltst.part6_novidades_java_11;

import java.util.function.Function;

public class InferenciaLambda {

    public static void main(String[] args) {
        Function<Integer, Double> divisaoPor2 = (var numero) -> (double) (numero / 2);
        System.out.println(divisaoPor2.apply(10));
    }
}
