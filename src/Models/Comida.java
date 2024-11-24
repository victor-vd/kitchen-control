package Models;

import java.util.List;

public class Comida extends Item {
    // Atributos específicos
    private String tamanhoGr;
    private String receita;

    // Construtor
    public Comida(String nomeItem, float precoItem, List<String> ingredientes, String tamanhoGr, String receita,
            List<String> opcoesEspeciais, List<String> itensAdicionados, List<String> itensRemovidos,
            List<String> outrasObservacoes) {
        super(nomeItem, precoItem, ingredientes, opcoesEspeciais, itensAdicionados, itensRemovidos, outrasObservacoes);
        this.tamanhoGr = tamanhoGr;
        this.receita = receita;
    }

    // Métodos específicos
    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes(); // Exibe os detalhes comuns
        System.out.println("Tamanho (g): " + tamanhoGr);
        System.out.println("Receita: " + receita);
    }

    public void modificarDetalhes(String novoTamanho, String novaReceita) {
        this.tamanhoGr = novoTamanho;
        this.receita = novaReceita;
        System.out.println("Detalhes específicos da comida atualizados.");
    }

    // Getters e Setters específicos
    public String getTamanhoGr() {
        return tamanhoGr;
    }

    public void setTamanhoGr(String tamanhoGr) {
        this.tamanhoGr = tamanhoGr;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }
}
