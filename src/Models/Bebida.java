package Models;

import java.util.List;

public class Bebida extends Item {
    // Atributos específicos
    private int tamanhoMl;
    private boolean alcoolica;

    // Construtor
    public Bebida(String nomeItem, float precoItem, List<String> ingredientes, int tamanhoMl, boolean alcoolica) {
        super(nomeItem, precoItem, ingredientes);
        this.tamanhoMl = tamanhoMl;
        this.alcoolica = alcoolica;
    }

    // Métodos
    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes(); // Exibe os detalhes comuns
        System.out.println("Tamanho (ml): " + tamanhoMl);
        System.out.println("Alcoólica: " + (alcoolica ? "Sim" : "Não"));
    }

    public void modificarDetalhes(int novoTamanho, boolean novaAlcoolica) {
        this.tamanhoMl = novoTamanho;
        this.alcoolica = novaAlcoolica;
        System.out.println("Detalhes específicos da bebida atualizados.");
    }

    // Getters e Setters
    public int getTamanho() {
        return tamanhoMl;
    }

    public void setTamanho(int tamanhoMl) {
        this.tamanhoMl = tamanhoMl;
    }

    public boolean isAlcoolica() {
        return alcoolica;
    }

    public void setAlcoolica(boolean alcoolica) {
        this.alcoolica = alcoolica;
    }
}
