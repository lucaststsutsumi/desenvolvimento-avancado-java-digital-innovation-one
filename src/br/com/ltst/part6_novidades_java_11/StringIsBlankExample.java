package br.com.ltst.part6_novidades_java_11;

public class StringIsBlankExample {
    public static void main(String[] args) {
        // validar se string é vazia
        String espaco = "                           ";

        // forma velha
        System.out.println(isStringBlankAntesJava11(espaco));
    }

    public static boolean isStringBlankAntesJava11(String espaco) {
        return espaco == null || espaco.length() == 0 || espaco.chars().allMatch(c -> c == ' ');
    }

    public static boolean isStringBlankJava11(String espaco) {
        return espaco.isBlank();
    }
}
