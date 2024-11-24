package Models;

import java.util.List;

public class Comida extends Item {
    // Atributos específicos
    private String tamanhoGr;

    // Construtor
    public Comida(String nomeItem, float precoItem, List<String> ingredientes, String tamanhoGr) {
        super(nomeItem, precoItem, ingredientes);
        this.tamanhoGr = tamanhoGr;
    }

    // Métodos específicos
    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes(); // Exibe os detalhes comuns
        System.out.println("Tamanho (g): " + tamanhoGr);
    }

    public void modificarDetalhes(String novoTamanho) {
        this.tamanhoGr = novoTamanho;
        System.out.println("Detalhes específicos da comida atualizados.");
    }

    // Getters e Setters específicos
    public String getTamanhoGr() {
        return tamanhoGr;
    }

    public void setTamanhoGr(String tamanhoGr) {
        this.tamanhoGr = tamanhoGr;
    }
}
