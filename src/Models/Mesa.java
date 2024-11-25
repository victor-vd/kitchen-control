package Models;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    // Attributes
    private String idMesa;
    private String garcomResponsavel;
    private List<Pedido> pedidos;

    // Constructor
    public Mesa(String idMesa) {
        this.idMesa = idMesa;
        this.pedidos = new ArrayList<>();
    }

    // Methods
    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido adicionado.");
    }

    public void desocuparMesa() {
        this.garcomResponsavel = "";
        this.pedidos.removeAll(pedidos);
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