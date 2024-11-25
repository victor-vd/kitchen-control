package Models;

public class Usuario {
    // Atributos privados do usuário
    private String email;
    private String senha;
    private String nome;
    private int cpf;

    // Construtor da classe Usuario
    public Usuario(String email, String senha, String nome, int cpf) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
    }

    // Getters e setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCPF() {
        return cpf;
    }

    public void setCPF(int cpf) {
        this.cpf = cpf;
    }
}
