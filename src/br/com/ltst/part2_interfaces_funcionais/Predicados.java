package br.com.ltst.part2_interfaces_funcionais;

import java.util.function.Predicate;

public class Predicados {
    public static void main(String[] args) {
        Predicate<String> estaVazio = valor ->valor.isEmpty();
        Predicate<String> estaVazio2 = String::isEmpty;
        System.out.println(estaVazio.test(""));
        System.out.println(estaVazio.test("2000"));
    }
}
