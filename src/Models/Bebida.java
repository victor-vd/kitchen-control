package Models;

import java.util.List;

public class Bebida extends Item {
    // Atributos específicos
    private String tamanhoMl;
    private boolean alcoolica;

    // Construtor
    public Bebida(String nomeItem, float precoItem, List<String> ingredientes, String tamanhoMl, boolean alcoolica) {
        super(nomeItem, precoItem, ingredientes);
        this.tamanhoMl = tamanhoMl;
        this.alcoolica = alcoolica;
    }

    // Métodos específicos
    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes(); // Exibe os detalhes comuns
        System.out.println("Tamanho (ml): " + tamanhoMl);
        System.out.println("Alcoólica: " + (alcoolica ? "Sim" : "Não"));
    }

    public void modificarDetalhes(String novoTamanho, boolean novaAlcoolica) {
        this.tamanhoMl = novoTamanho;
        this.alcoolica = novaAlcoolica;
        System.out.println("Detalhes específicos da bebida atualizados.");
    }

    // Getters e Setters específicos
    public String getTamanhoMl() {
        return tamanhoMl;
    }

    public void setTamanhoMl(String tamanhoMl) {
        this.tamanhoMl = tamanhoMl;
    }

    public boolean isAlcoolica() {
        return alcoolica;
    }

    public void setAlcoolica(boolean alcoolica) {
        this.alcoolica = alcoolica;
    }
}
