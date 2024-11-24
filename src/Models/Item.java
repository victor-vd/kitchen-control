package Models;

import java.util.List;

public class Item {
    // Atributos comuns
    private String nomeItem;
    private float precoItem;
    private List<String> ingredientes;
    private List<String> opcoesEspeciais;
    private List<String> itensAdicionados;
    private List<String> itensRemovidos;
    private List<String> outrasObservacoes;

    // Construtor
    public Item(String nomeItem, float precoItem, List<String> ingredientes, List<String> opcoesEspeciais,
            List<String> itensAdicionados, List<String> itensRemovidos, List<String> outrasObservacoes) {
        this.nomeItem = nomeItem;
        this.precoItem = precoItem;
        this.ingredientes = ingredientes;
        this.opcoesEspeciais = opcoesEspeciais;
        this.itensAdicionados = itensAdicionados;
        this.itensRemovidos = itensRemovidos;
        this.outrasObservacoes = outrasObservacoes;
    }

    // Métodos comuns
    public void exibirDetalhes() {
        System.out.println("Nome do Item: " + nomeItem);
        System.out.println("Preço: R$ " + precoItem);
        System.out.println("Ingredientes: " + String.join(", ", ingredientes));
        System.out.println("Opções Especiais: " + String.join(", ", opcoesEspeciais));
        System.out.println("Itens Adicionados: " + String.join(", ", itensAdicionados));
        System.out.println("Itens Removidos: " + String.join(", ", itensRemovidos));
        System.out.println("Outras Observações: " + String.join(", ", outrasObservacoes));
    }

    public void modificarDetalhes(String novoNome, float novoPreco) {
        this.nomeItem = novoNome;
        this.precoItem = novoPreco;
        System.out.println("Detalhes do item atualizados.");
    }

    // Getters e Setters
    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public float getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(float precoItem) {
        this.precoItem = precoItem;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<String> getOpcoesEspeciais() {
        return opcoesEspeciais;
    }

    public void setOpcoesEspeciais(List<String> opcoesEspeciais) {
        this.opcoesEspeciais = opcoesEspeciais;
    }

    public List<String> getItensAdicionados() {
        return itensAdicionados;
    }

    public void setItensAdicionados(List<String> itensAdicionados) {
        this.itensAdicionados = itensAdicionados;
    }

    public List<String> getItensRemovidos() {
        return itensRemovidos;
    }

    public void setItensRemovidos(List<String> itensRemovidos) {
        this.itensRemovidos = itensRemovidos;
    }

    public List<String> getOutrasObservacoes() {
        return outrasObservacoes;
    }

    public void setOutrasObservacoes(List<String> outrasObservacoes) {
        this.outrasObservacoes = outrasObservacoes;
    }
}
