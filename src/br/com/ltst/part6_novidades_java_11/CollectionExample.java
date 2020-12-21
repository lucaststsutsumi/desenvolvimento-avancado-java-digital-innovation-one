package br.com.ltst.part6_novidades_java_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionExample {
    public static void main(String[] args) {
        // antes do Java 11
        Collection<String> nomes = Arrays.asList("Lucas", "Akina", "Toshie", "Ana", "Agostinho");
        // depois do Java 11
        Collection<String> nomesComJava11 = List.of("Lucas", "Akina", "Toshie", "Ana", "Agostinho");

        System.out.println(nomes);
    }
}
