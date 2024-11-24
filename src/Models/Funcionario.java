package Models;

public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String email;
    private int cpf;

    // Construtor
    public Funcionario(int idFuncionario, String nome, String email, int cpf) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    // Getters e Setters
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    // Métodos
    public void visualizarETA() {
        // Lógica para visualizar ETA (tempo estimado de entrega)
        System.out.println("Visualizando ETA...");
    }
}
