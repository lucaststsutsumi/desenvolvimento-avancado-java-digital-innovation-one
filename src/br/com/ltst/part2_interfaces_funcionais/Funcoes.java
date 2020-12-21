package br.com.ltst.part2_interfaces_funcionais;

import java.util.function.Function;

public class Funcoes {
    public static void main(String[] args) {
        Function<String,String> retornaNomeAoContrario = text -> new StringBuilder(text).reverse().toString();
        System.out.println(retornaNomeAoContrario.apply("Toshiaki"));
    }
}
