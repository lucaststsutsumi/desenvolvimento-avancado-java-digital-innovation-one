package br.com.ltst.part1_paradgma_funcional_no_java.part2_2;

public class ExemploInterfaceFuncao {
    public static void main(String[] args) {
        Funcao1 gerarN = valor-> Integer.parseInt(valor);
    }
}

@FunctionalInterface
interface Funcao1{
    Integer gerarNumero(String valor);
    default String gerarPrefixoSenhor(String valor){
        return  "Sr. " + valor;
    };
}

@FunctionalInterface
interface Funcao2{
    String gerarPrefixoSenhor(String valor);
}