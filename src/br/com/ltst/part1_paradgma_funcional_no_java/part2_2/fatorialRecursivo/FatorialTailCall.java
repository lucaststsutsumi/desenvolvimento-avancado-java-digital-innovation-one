package br.com.ltst.part1_paradgma_funcional_no_java.part2_2.fatorialRecursivo;

public class FatorialTailCall {
    public static void main(String[] args) {
        System.out.println(fatorialComTailCall(1.0,5.0));
    }
    public static Double fatorialComTailCall(Double valor,Double numero){
        if(numero== 0){
            return valor;
        }
        return  fatorialComTailCall(valor*numero,numero-1);
    }
}
