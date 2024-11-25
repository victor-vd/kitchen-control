package Models;

import java.util.ArrayList;
import java.util.List;

public class Garcom extends Funcionario {
    private final List<Pedido> pedidosAtivos;

    // Construtor
    public Garcom(int idFuncionario, String nome, String email, String senha, int cpf) {
        super(idFuncionario, nome, email, senha, cpf);
        this.pedidosAtivos = new ArrayList<>();
    }

    // Métodos
    public void gerenciarMesas() {
        // Lógica para gerenciar mesas
        System.out.println("Gerenciando mesas...");
    }

    public void consultarCardapio() {
        // Lógica para consultar cardápio
        System.out.println("Consultando cardápio...");
    }

    // Getters e Setters

    public List<Pedido> getPedidosAtivos() {
        return pedidosAtivos;
    }
}
