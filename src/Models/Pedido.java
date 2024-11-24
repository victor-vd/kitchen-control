package Models;

public class Pedido {
    // Atributos
    private String codigoPedido;
    private String idPedido;
    private String nomeCliente;
    private String statusPedido;
    private int tempoEstimado;
    private float taxaServico;
    private double somaTotal;
    private boolean paraLevar;

    // Métodos
    public void adicionarItem(String item, double valor, String tipo) {
        this.somaTotal += valor;
    }

    public void adicionarObs(String observacao) {
        System.out.println("Observação adicionada: " + observacao);
    }

    public void encerrarPedido() {
        System.out.println("Pedido encerrado.");
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

    public float getTaxaServico() {
        return taxaServico;
    }

    public void setTaxaServico(float taxaServico) {
        this.taxaServico = taxaServico;
    }

    public Double getSomaTotal() {
        return somaTotal;
    }

    public boolean isParaLevar() {
        return paraLevar;
    }

    public void setParaLevar(boolean paraLevar) {
        this.paraLevar = paraLevar;
    }
}