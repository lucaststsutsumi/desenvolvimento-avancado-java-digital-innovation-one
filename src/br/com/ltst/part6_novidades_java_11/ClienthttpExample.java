package br.com.ltst.part6_novidades_java_11;

import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ClienthttpExample {
    static ExecutorService executorService = Executors.newFixedThreadPool(6, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            System.out.println("Nova Thread criada" + (thread.isDaemon() ? "daemon" : "") + "Thread group:: " + thread.getThreadGroup());
            return thread;
        }
    });

    public static void main(String[] args) {
        // connectAkamaiHttp1Cliente();
        connectAkamaiHttp2Cliente();
    }

    public static void connectAkamaiHttp1Cliente() {
        System.out.println("Running HTTP/1.1 example...");

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .proxy(ProxySelector.getDefault())
                .build();

        long start = System.currentTimeMillis();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                .build();

        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code :: " + response.statusCode());
            System.out.println("Headers :: " + response.headers());

            String responseBody = (String) response.body();

            System.out.println(responseBody);

            List<Future<?>> futures = new ArrayList<>();

            responseBody
                    .lines()
                    .filter(l -> l.trim().startsWith("<img height"))
                    .map(l -> l.substring(l.indexOf("src='") + 5, l.indexOf("'/>")))
                    .forEach(image -> {

                        Future<?> imgFuture = executorService.submit(() -> {

                            HttpRequest httpRequest = HttpRequest.newBuilder()
                                    .uri(URI.create("https://http2.akamai.com" + image))
                                    .build();

                            try {
                                HttpResponse httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                                System.out.println("Imagem carregada :: " + image + ", status code" + httpResponse.statusCode());
                            } catch (IOException | InterruptedException e) {
                                System.out.println("mensagem de erro durante requisição para recuperar imagem " + image);
                            }

                        });


                        futures.add(imgFuture);
                        System.out.println("Submitido um futuro para :: " + imgFuture);
                    });

            futures.forEach(f -> {
                try {
                    f.get();
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Error ao esperar carregar imagem do futuro");
                }
            });

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        long end = System.currentTimeMillis();

        System.out.println("Tempo de carregamento total " + (end - start));
    }

    public static void connectAkamaiHttp2Cliente() {
        System.out.println("Running HTTP/2 example...");

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .proxy(ProxySelector.getDefault())
                .build();

        long start = System.currentTimeMillis();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                .build();

        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code :: " + response.statusCode());
            System.out.println("Headers :: " + response.headers());

            String responseBody = (String) response.body();

            System.out.println(responseBody);

            List<Future<?>> futures = new ArrayList<>();

            responseBody
                    .lines()
                    .filter(l -> l.trim().startsWith("<img height"))
                    .map(l -> l.substring(l.indexOf("src='") + 5, l.indexOf("'/>")))
                    .forEach(image -> {

                        Future<?> imgFuture = executorService.submit(() -> {

                            HttpRequest httpRequest = HttpRequest.newBuilder()
                                    .uri(URI.create("https://http2.akamai.com" + image))
                                    .build();

                            try {
                                HttpResponse httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                                System.out.println("Imagem carregada :: " + image + ", status code" + httpResponse.statusCode());
                            } catch (IOException | InterruptedException e) {
                                System.out.println("mensagem de erro durante requisição para recuperar imagem " + image);
                            }

                        });


                        futures.add(imgFuture);
                        System.out.println("Submitido um futuro para :: " + imgFuture);
                    });

            futures.forEach(f -> {
                try {
                    f.get();
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Error ao esperar carregar imagem do futuro");
                }
            });

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        long end = System.currentTimeMillis();

        System.out.println("Tempo de carregamento total " + (end - start));
    }

    // forma nova: a partir do JAVA 11
    public static void connectionAndPrintingJava11() {
        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .GET()
                    .uri(URI.create("https://docs.oracle.com/javase/10/language/")).build();

            HttpClient client = HttpClient.newHttpClient();

            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code :: " + response.statusCode());
            System.out.println("Headers :: " + response.headers());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // forma basica : versão JAVA 10 para baixo
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

}
