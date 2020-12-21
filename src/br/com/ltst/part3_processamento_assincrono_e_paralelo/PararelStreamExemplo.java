package br.com.ltst.part3_processamento_assincrono_e_paralelo;

import java.util.stream.IntStream;

public class PararelStreamExemplo {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        IntStream.range(1, 100000).forEach((num) -> fatorial(num));// Serial
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução serial:: " + (fim-inicio));

        System.currentTimeMillis();
        IntStream.range(1, 100000).parallel().forEach((num) -> fatorial(num));// Parallel
        System.currentTimeMillis();
        System.out.println("Tempo de execução Parallel :: " + (fim-inicio));
    }

    public static long fatorial(int numero) {
        int fat = 1;

        for (int i = 2; i <= numero; i++) {
            fat *= i;
        }
        return fat;
    }
}
