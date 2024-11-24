package Models;

import java.util.ArrayList;
import java.util.List;

public class Garcom extends Funcionario {
    private int mesasAtendidas;
    private final List<Pedido> pedidosAtivos;

    // Construtor
    public Garcom(int idFuncionario, String nome, String email, String senha, int cpf,
            int mesasAtendidas) {
        super(idFuncionario, nome, email, senha, cpf);
        this.mesasAtendidas = mesasAtendidas;
        this.pedidosAtivos = new ArrayList<>();
    }

    // Getters e Setters
    public int getMesasAtendidas() {
        return mesasAtendidas;
    }

    public void setMesasAtendidas(int mesasAtendidas) {
        this.mesasAtendidas = mesasAtendidas;
    }

    public List<Pedido> getPedidosAtivos() {
        return pedidosAtivos;
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

    public void consultarHistorico() {
        // Lógica para consultar histórico de pedidos
        System.out.println("Consultando histórico de pedidos...");
    }

    public void escolherPagamento() {
        // Lógica para escolher forma de pagamento
        System.out.println("Escolhendo forma de pagamento...");
    }
}
