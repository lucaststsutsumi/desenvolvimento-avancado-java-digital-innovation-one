package br.com.ltst.part2_interfaces_funcionais;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {
    public static void main(String[] args) {
        String[] nomes = {"Lucas", "Toshiaki", "Silva", "Tsutsumi"};
        Integer[] numeros = {1, 2, 3, 4, 5};
        imprimirNomesFiltrados(nomes);
        imprimirTodosNomes(nomes);
    }

    public static void imprimirNomesFiltrados(String... nomes) {
        String nomesParaImprimir = "";
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].equals("Lucas")) {
                nomesParaImprimir = nomes[i];
            }
        }

        System.out.println("Nomes do for " + nomesParaImprimir);


        String nomesResultados = Stream.of(nomes).filter(e -> e.equals("Lucas"))
                .collect(Collectors.joining());

        System.out.println("Nomes do STREAM " + nomesResultados);
    }

    public static void imprimirTodosNomes(String... nomes) {
        for (String nome : nomes) {
            System.out.println("Imprimido pelo for " + nome);
        }
        Stream.of(nomes).forEach(nome -> System.out.println("Imprimido pelo STREAM " + nome));
    }

    public static void imprimirODobroDeCadaItemDaLista(Integer... numeros) {
        for (Integer numero : numeros) {
            System.out.println("Imprimido pelo for " + (numero*2));
        }
        Stream.of(numeros).map(numero -> numero*2).forEach(System.out::println);

    }
}
