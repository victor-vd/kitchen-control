package Models;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    // Attributes
    private String idMesa;
    private String garcomResponsavel;
    private double somaTotal;
    private List<Pedido> pedidos;

    // Constructor
    public Mesa(String idMesa) {
        this.idMesa = idMesa;
        this.pedidos = new ArrayList<>();
    }

    // Métodos
    public double getSomaTotal() {
        double soma = 0;
        for (Pedido pedido : pedidos) {
            soma += pedido.getSomaPedido();
        }
        return soma;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido adicionado.");
        this.somaTotal = getSomaTotal();
    }

    public void desocuparMesa() {
        this.garcomResponsavel = "";
        this.pedidos.removeAll(pedidos);
    }

    public boolean removerPedido(String idPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido().equals(idPedido)) {
                pedidos.remove(pedido);
                System.out.println("Pedido removido.");
                return true;
            }
        }
        System.out.println("Pedido não encontrado.");
        return false;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    // Getters and Setters
    public String getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(String idMesa) {
        this.idMesa = idMesa;
    }

    public String getGarcomResponsavel() {
        return garcomResponsavel;
    }

    public void setGarcomResponsavel(String garcomResponsavel) {
        this.garcomResponsavel = garcomResponsavel;
        System.out.println("Garçom responsável: " + garcomResponsavel);
    }
}