package Models;

public class Funcionario extends Usuario {
    private int idFuncionario;

    // Construtor
    public Funcionario(int idFuncionario, String nome, String email, String senha, int cpf) {
        super(email, senha, nome, cpf);
        this.idFuncionario = idFuncionario;
    }

    // Getters e Setters
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
