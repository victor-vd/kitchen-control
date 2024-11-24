package Models;

public class Mesa {
    // Attributes
    private int numeroMesa;
    private String idMesa;
    private String garcomResponsavel;

    // Constructor
    public Mesa(int numeroMesa, String idMesa, String garcomResponsavel) {
        this.numeroMesa = numeroMesa;
        this.idMesa = idMesa;
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

    public String getGarcomResponsavel() {
        return garcomResponsavel;
    }

    // Methods
    public void setGarcomResponsavel(String garcomResponsavel) {
        this.garcomResponsavel = garcomResponsavel;
        System.out.println("Garçom responsável: " + garcomResponsavel);
    }

    public void adicionarPedido(double valorPedido) {
        System.out.println("Pedido adicionado.");
    }
}
