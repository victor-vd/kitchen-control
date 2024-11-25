package Models;

import java.util.ArrayList;
import java.util.List;

public class Cozinheiro extends Funcionario {
    private final List<Pedido> pedidos;

    // Construtor
    public Cozinheiro(int idFuncionario, String nome, String email, String senha, int cpf) {
        super(idFuncionario, nome, email, senha, cpf);
        this.pedidos = new ArrayList<>();
    }

    public List<Pedido> getPedidosAtivos() {
        return pedidos;
    }

    public void adicionarPedidoAtivo(Pedido pedidosAtivo) {
        this.pedidos.add(pedidosAtivo);
    }
}
