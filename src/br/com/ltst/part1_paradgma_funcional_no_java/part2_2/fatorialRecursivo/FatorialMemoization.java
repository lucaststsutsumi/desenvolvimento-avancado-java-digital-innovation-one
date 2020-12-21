package br.com.ltst.part1_paradgma_funcional_no_java.part2_2.fatorialRecursivo;

import java.util.HashMap;
import java.util.Map;

public class FatorialMemoization {

    static Map<Integer,Integer> MAPA_FATORIAL= new HashMap();


    public static void main(String[] args) {
        long I = System.nanoTime();
        System.out.println(fatorialComMemoization(15));
        long F = System.nanoTime();
        System.out.println("FATORIAL1 " + (F+I));

        I = System.nanoTime();
        F = System.nanoTime();
        System.out.println("FATORIAL2 " + (F+I));
    }
    public static Integer fatorialComMemoization(Integer value){
        if(value== 1){
            return value;
        }else {
            if (MAPA_FATORIAL.containsKey(value)){
                return MAPA_FATORIAL.get(value);
            } else{
                Integer resultado = value*fatorialComMemoization(value-1);
                return resultado;
            }
        }
    }
}
