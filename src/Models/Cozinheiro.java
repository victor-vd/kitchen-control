package Models;

public class Cozinheiro extends Funcionario {
    private String[] pedidosAtivos;

    // Construtor
    public Cozinheiro(int idFuncionario, String nome, String email, String senha, int cpf, String[] pedidosAtivos) {
        super(idFuncionario, nome, email, senha, cpf);
        this.pedidosAtivos = pedidosAtivos;
    }

    // Getters e Setters
    public String[] getPedidosAtivos() {
        return pedidosAtivos;
    }

    public void setPedidosAtivos(String[] pedidosAtivos) {
        this.pedidosAtivos = pedidosAtivos;
    }

    // Métodos
    public void gerenciarPratos() {
        // Lógica para gerenciar pratos
        System.out.println("Gerenciando pratos...");
    }

    public void selecionarCozinheiro() {
        // Lógica para selecionar cozinheiro
        System.out.println("Selecionando cozinheiro...");
    }

    public void exibirReceita() {
        // Lógica para exibir receita
        System.out.println("Exibindo receita...");
    }
}
