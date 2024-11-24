package Models;

public class Funcionario extends Usuario {
    private int idFuncionario;

    // Construtor
    public Funcionario(int idFuncionario, String nome, String email, String senha, int cpf) {
        super(nome, email, senha, cpf);
        this.idFuncionario = idFuncionario;
    }

    // Getters e Setters
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    // Métodos
    public void visualizarETA() {
        // Lógica para visualizar ETA (tempo estimado de entrega)
        System.out.println("Visualizando ETA...");
    }
}
