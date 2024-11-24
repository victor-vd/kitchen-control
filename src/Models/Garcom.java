package Models;

public class Garcom extends Funcionario {
    private int mesasAtendidas;
    private String[] pedidosAtivos;

    // Construtor
    public Garcom(int idFuncionario, String nome, String email, int cpf,
            int mesasAtendidas, String[] pedidosAtivos) {
        super(idFuncionario, nome, email, cpf);
        this.mesasAtendidas = mesasAtendidas;
        this.pedidosAtivos = pedidosAtivos;
    }

    // Getters e Setters
    public int getMesasAtendidas() {
        return mesasAtendidas;
    }

    public void setMesasAtendidas(int mesasAtendidas) {
        this.mesasAtendidas = mesasAtendidas;
    }

    public String[] getPedidosAtivos() {
        return pedidosAtivos;
    }

    public void setPedidosAtivos(String[] pedidosAtivos) {
        this.pedidosAtivos = pedidosAtivos;
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
