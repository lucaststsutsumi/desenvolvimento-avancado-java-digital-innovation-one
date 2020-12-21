package br.com.ltst.part6_novidades_java_11;

public class StringRepeat {

    public static void main(String[] args) {
        // Escrever o nome 10 em uma string e concatenar ela
        String nome = "Lucas";

        System.out.println(repetirNomeXVezesAntesJava11(nome));
        System.out.println(repetirNomeXVezesDepoisJava11(nome));
    }

    public static String repetirNomeXVezesDepoisJava11(String nome) {
        return nome.repeat(10);
    }

    public static String repetirNomeXVezesAntesJava11(String nome) {
        String aux = "";

        for (int i = 0; i < 10; i++) {
            aux += nome;
        }
        return aux;
    }
}
