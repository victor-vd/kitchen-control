package Models;

public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String email;
    private int cpf;
    private String endereco;
    private float comissao;
    private float desconto;
    private int errosCometidos;

    // Construtor
    public Funcionario(int idFuncionario, String nome, String email, int cpf, String endereco,
            float comissao, float desconto, int errosCometidos) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
        this.comissao = comissao;
        this.desconto = desconto;
        this.errosCometidos = errosCometidos;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public int getErrosCometidos() {
        return errosCometidos;
    }

    public void setErrosCometidos(int errosCometidos) {
        this.errosCometidos = errosCometidos;
    }

    // Métodos
    public void visualizarETA() {
        // Lógica para visualizar ETA (tempo estimado de entrega)
        System.out.println("Visualizando ETA...");
    }
}
