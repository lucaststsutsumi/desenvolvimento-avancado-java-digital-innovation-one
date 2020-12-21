package br.com.ltst.part1_paradgma_funcional_no_java.part2_2;

public class FuncaoComLambda {
    public static void main(String[] args) {
        Funcao2 colocarPrefixoSenhorNaString = valor->"Sr. " + valor;
        System.out.println(colocarPrefixoSenhorNaString.gerarPrefixoSenhor("Akina"));
    }
}
