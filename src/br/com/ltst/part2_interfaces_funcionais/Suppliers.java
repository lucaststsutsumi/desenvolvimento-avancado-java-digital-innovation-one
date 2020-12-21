package br.com.ltst.part2_interfaces_funcionais;

import java.util.function.Supplier;

public class Suppliers {
    public static void main(String[] args) {
        Supplier<Pessoa> supplier = () -> new Pessoa();
        Supplier<Pessoa> supplier2 = Pessoa::new;

        System.out.println(supplier.get());
        System.out.println(supplier2.get());
    }
}

class Pessoa {

    private String nome;
    private Integer idade;

    public Pessoa() {
        nome = "lucas";
        idade = 23;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}