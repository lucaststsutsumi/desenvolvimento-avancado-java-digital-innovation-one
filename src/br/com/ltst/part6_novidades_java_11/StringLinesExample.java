package br.com.ltst.part6_novidades_java_11;

import java.util.stream.Collectors;

public class StringLinesExample {
    public static void main(String[] args) {
        // antes era necessário descobrir em qual linha esta a string que se deseja extrair
        String html = "<html>\n<head>\n</head>\n<body>\n</body>\n</html>";
        // System.out.println(html);

        // no java 11 podemos usar o Stream .lines()
        System.out.println(html.lines().filter(s -> s.contains("head")).collect(Collectors.joining()));
    }
}
