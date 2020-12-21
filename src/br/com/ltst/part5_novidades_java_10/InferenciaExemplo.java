package br.com.ltst.part5_novidades_java_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class InferenciaExemplo {

    public static void main(String[] args) {
        printarNomeCompleto("Lucas", "Tsutsumi");
    }

    public static void connectionAndPrintingJavaOracle() {
        URL url = null;
        try {
            url = new URL("https://docs.oracle.com/javase/10/language/");
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void connectionAndPrintingUsingInference() throws IOException {

        var url = new URL("https://docs.oracle.com/javase/10/language/");
        var urlConnection = url.openConnection();


        try (var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printarNomeCompleto(String nome, String sobrenome) {
        var nomeCompleto = String.format("%s %s", nome, sobrenome);
        System.out.println(nomeCompleto);
    }

    public static void printarSoma(int a, int b) {
        var sum = a + b;
        System.out.println(sum);
    }
}

