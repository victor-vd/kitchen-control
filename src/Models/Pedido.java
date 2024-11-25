package Models;

import java.util.List;

public class Pedido {
    // Atributos
    private final List<Item> itens;
    private String codigoPedido;
    private String idPedido;
    private String nomeCliente;
    private String statusPedido;
    private String observacao;
    private int tempoEstimado;
    private double somaTotal;
    private boolean paraLevar;

    public Pedido(String codigoPedido, String idPedido, String nomeCliente, String statusPedido, String observacao,
            int tempoEstimado, double somaTotal, boolean paraLevar, List<Item> itens) {
        this.itens = itens;
        this.codigoPedido = codigoPedido;
        this.idPedido = idPedido;
        this.nomeCliente = nomeCliente;
        this.statusPedido = statusPedido;
        this.observacao = "\n - " + observacao;
        this.tempoEstimado = tempoEstimado;
        this.somaTotal = somaTotal;
        this.paraLevar = paraLevar;
    }

    // Métodos
    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    public void setObservacao(String observacaoAdd) {
        this.observacao += "\n - " + observacaoAdd;
        System.out.println("Observação adicionada: " + observacaoAdd);
    }

    public String getObservacao(String observacao) {
        return observacao;
    }

    // Getters e setters (opcional, dependendo da necessidade)
    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
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
        return somaTotal;
    }

    public boolean getParaLevar() {
        return paraLevar;
    }

    public void setParaLevar(boolean paraLevar) {
        this.paraLevar = paraLevar;
    }
}