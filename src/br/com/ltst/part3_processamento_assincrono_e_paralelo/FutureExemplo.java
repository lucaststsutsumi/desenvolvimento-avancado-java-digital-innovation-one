package br.com.ltst.part3_processamento_assincrono_e_paralelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FutureExemplo {
    private static final ExecutorService pessoaParaExecutarAtividade = Executors.newFixedThreadPool(3);
    // pessoaParaExecutarAtividade.execute(atividade::realizar); -> faz o mesmo que o submit mas retorna void

    public static void main(String[] args) throws InterruptedException {
        Casa casa = new Casa(new Quarto());
        List<Future<String>> futuros =
                new CopyOnWriteArrayList(
                        casa.obterAfazeresDeCasa()
                                .stream()
                                .map(atividade -> pessoaParaExecutarAtividade.submit(atividade::realizar))
                                .collect(Collectors.toList())
                );



        while (true) {
            int numeroDeAtividadesNaoFinalizadas = 0;

            for (Future futuro : futuros) {

                if (futuro.isDone()) {

                    try {
                        System.out.println("Parabens voce terminou de " + futuro.get());
                        futuros.remove(futuro);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                } else {
                    numeroDeAtividadesNaoFinalizadas++;
                }
            }

            if (futuros.stream().allMatch(Future::isDone)){break;}

            System.out.println("Numero de atividades não finalizadas: " + numeroDeAtividadesNaoFinalizadas);
            Thread.sleep(500);
        }


        pessoaParaExecutarAtividade.shutdown();
    }
}

class Casa {
    List<Comodo> comodos;

    public Casa(Comodo... comodos) {
        this.comodos = Arrays.asList(comodos);
    }

    public List<Atividade> obterAfazeresDeCasa() {
        return comodos.stream().map(Comodo::obterAfazeresDoComodo)
                .reduce(new ArrayList<>(), (retorno, atividades) -> {
                    retorno.addAll(atividades);
                    return retorno;
                });
    }
}

interface Atividade {
    String realizar();
}

abstract class Comodo {
    abstract List<Atividade> obterAfazeresDoComodo();
}

class Quarto extends Comodo {

    @Override
    List<Atividade> obterAfazeresDoComodo() {
        return Arrays.asList(
                this::arrumarGuardaRoupa,
                this::varrerQuarto,
                this::arrumarCama);
    }

    private String arrumarGuardaRoupa() {
        try {
            Thread.sleep(3000);
            String guardaRoupa = "arrumar guarda roupa";
            System.out.println(guardaRoupa);
            return guardaRoupa;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String varrerQuarto() {
        try {
            Thread.sleep(1000);
            String varrerQuarto = "varrer quarto";
            System.out.println(varrerQuarto);
            return varrerQuarto;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String arrumarCama() {
        try {
            Thread.sleep(3000);

            String arrumarCama = "arrumar cama";
            System.out.println(arrumarCama);
            return arrumarCama;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}


