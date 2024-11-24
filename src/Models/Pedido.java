package Models;

public class Pedido {
    // Atributos
    private String codigoPedido;
    private String idPedido;
    private String nomeCliente;
    private String preparadoPor;
    private String statusPedido;
    private int tempoEstimado;
    private float somaComidas;
    private float somaBebidas;
    private float taxaServico;
    private float impostos;
    private float somaTotal;
    private String modoPagamento;
    private boolean paraLevar;

    // Métodos
    public void escolherPagamento(String modoPagamento) {
        this.modoPagamento = modoPagamento;
    }

    public void adicionarItem(String item, float valor, String tipo) {
        if (tipo.equalsIgnoreCase("comida")) {
            somaComidas += valor;
        } else if (tipo.equalsIgnoreCase("bebida")) {
            somaBebidas += valor;
        }
        calcularSomaTotal();
    }

    public void adicionarObs(String observacao) {
        System.out.println("Observação adicionada: " + observacao);
    }

    public void encerrarPedido() {
        calcularImpostos();
        calcularSomaTotal();
        System.out.println("Pedido encerrado.");
    }

    // Métodos auxiliares
    private void calcularImpostos() {
        this.impostos = (somaComidas + somaBebidas) * 0.1f; // Exemplo: 10% de impostos
    }

    private void calcularSomaTotal() {
        this.somaTotal = somaComidas + somaBebidas + taxaServico + impostos;
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

    public String getPreparadoPor() {
        return preparadoPor;
    }

    public void setPreparadoPor(String preparadoPor) {
        this.preparadoPor = preparadoPor;
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

    public float getSomaComidas() {
        return somaComidas;
    }

    public void setSomaComidas(float somaComidas) {
        this.somaComidas = somaComidas;
    }

    public float getSomaBebidas() {
        return somaBebidas;
    }

    public void setSomaBebidas(float somaBebidas) {
        this.somaBebidas = somaBebidas;
    }

    public float getTaxaServico() {
        return taxaServico;
    }

    public void setTaxaServico(float taxaServico) {
        this.taxaServico = taxaServico;
    }

    public float getImpostos() {
        return impostos;
    }

    public float getSomaTotal() {
        return somaTotal;
    }

    public String getModoPagamento() {
        return modoPagamento;
    }

    public boolean isParaLevar() {
        return paraLevar;
    }

    public void setParaLevar(boolean paraLevar) {
        this.paraLevar = paraLevar;
    }
}