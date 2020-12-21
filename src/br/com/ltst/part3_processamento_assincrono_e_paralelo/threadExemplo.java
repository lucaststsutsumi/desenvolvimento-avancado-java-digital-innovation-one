package br.com.ltst.part3_processamento_assincrono_e_paralelo;

public class threadExemplo {

    public static void main(String[] args) {
        GeradorPdf geradorPdf = new GeradorPdf();
        BarraCarregamento barraCarregamento = new BarraCarregamento(geradorPdf);
        geradorPdf.start();
        barraCarregamento.start();
    }
}

class GeradorPdf extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("inicio gerador PDF");

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fim gerador PDF");
    }
}

class BarraCarregamento extends Thread {

    private final Thread geradorPdf;

    public BarraCarregamento(Thread geradorPdf) {
        this.geradorPdf = geradorPdf;
    }

    @Override
    public void run() {
        while (true) {
            try {

                Thread.sleep(500);
                if (!geradorPdf.isAlive()){
                    break;
                }
                System.out.println("Loading...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}