package Models;

public class Mesa {
    // Attributes
    private int numeroMesa;
    private String idMesa;
    private double faturamentoMesa;
    private String garcomResponsavel;

    // Constructor
    public Mesa(int numeroMesa, String idMesa, double faturamentoMesa, String garcomResponsavel) {
        this.numeroMesa = numeroMesa;
        this.idMesa = idMesa;
        this.faturamentoMesa = faturamentoMesa;
        this.garcomResponsavel = garcomResponsavel;
    }

    // Getters and Setters
    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public String getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(String idMesa) {
        this.idMesa = idMesa;
    }

    public double getFaturamentoMesa() {
        return faturamentoMesa;
    }

    public void setFaturamentoMesa(double faturamentoMesa) {
        this.faturamentoMesa = faturamentoMesa;
    }

    public String getGarcomResponsavel() {
        return garcomResponsavel;
    }

    public void setGarcomResponsavel(String garcomResponsavel) {
        this.garcomResponsavel = garcomResponsavel;
    }

    // Methods
    public void alterarResponsavel(String novoGarcom) {
        this.garcomResponsavel = novoGarcom;
        System.out.println("Garçom responsável alterado para: " + novoGarcom);
    }

    public void adicionarPedido(double valorPedido) {
        this.faturamentoMesa += valorPedido;
        System.out.println("Pedido adicionado. Novo faturamento: " + this.faturamentoMesa);
    }
}
