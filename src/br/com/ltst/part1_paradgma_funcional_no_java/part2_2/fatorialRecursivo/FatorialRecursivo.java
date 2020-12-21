package br.com.ltst.part1_paradgma_funcional_no_java.part2_2.fatorialRecursivo;

public class FatorialRecursivo {
    public static void main(String[] args) {

        System.out.println(fatorial(5.0));
    }
    public static Double fatorial(Double numero){
        if(numero== 1){
            return numero;
        }else{
            return numero * fatorial(numero-1);
        }

    }
}
