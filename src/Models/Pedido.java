package Models;

import application.Listaveis;

import java.util.List;

/**
 * A classe Pedido representa um pedido realizado por um cliente.
 * Implementa a interface Listaveis.
 */

public class Pedido implements Listaveis {
    // Atributos
    private final List<Item> itens;
    private String idPedido;
    private String nomeCliente;
    private String statusPedido;
    private String observacao;
    private int tempoEstimado;
    private double somaPedido;
    private boolean paraLevar;

    // Construtor da classe Pedido.
    public Pedido(String idPedido, String nomeCliente, String statusPedido,
            int tempoEstimado, boolean paraLevar, List<Item> itens) {
        this.itens = itens;
        this.idPedido = idPedido;
        this.nomeCliente = nomeCliente;
        this.statusPedido = statusPedido;
        this.observacao = "\n - " + observacao;
        this.tempoEstimado = tempoEstimado;
        this.paraLevar = paraLevar;
        this.somaPedido = getSomaPedido();
    }

    // Métodos

    // Adiciona um item ao pedido e atualiza a soma total.
    public void adicionarItem(Item item) {
        this.itens.add(item);
        this.somaPedido = getSomaPedido();
    }

    // Calcula a soma total do pedido.
    public double getSomaPedido() {
        double soma = 0;
        for (Item item : itens) {
            soma += item.getPrecoItem();
        }
        return soma;
    }

    // Getters e setters
    public void setObservacao(String observacaoAdd) {
        this.observacao += " - " + observacaoAdd + "\n";
        System.out.println("Observação adicionada: " + observacaoAdd);
    }

    public String getObservacao(String observacao) {
        return observacao;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public int getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(int tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public Double getSomaTotal() {
        return somaPedido;
    }

    public boolean getParaLevar() {
        return paraLevar;
    }

    public void setParaLevar(boolean paraLevar) {
        this.paraLevar = paraLevar;
    }

    // Exibe os detalhes do pedido de forma tabulada.
    @Override
    public void exibirTabulado() {
        System.out.printf("Id Pedido: %s%n", getIdPedido());
        System.out.printf("| %-12s | %-12s | %-12s | %-12s |%n", "Tipo de Item", "Nome", "Preço", "Peso");
        for (Item item : itens) {
            String tipoItem = item instanceof Bebida ? "Bebida" : item instanceof Comida ? "Comida" : "Outro";
            System.out.printf("| %-12s | %-12s | %-12.2f | %-12s |%n", tipoItem, item.getNomeItem(),
                    item.getPrecoItem(), item.getTamanho());
        }
    }
}