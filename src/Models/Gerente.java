package Models;

public class Gerente {
    private String email;
    private String identificacao;
    private String senha;

    // Construtor
    public Gerente(String email, String identificacao, String senha) {
        this.email = email;
        this.identificacao = identificacao;
        this.senha = senha;
    }

    // Getters e Setters
    public String getEmailGerencia() {
        return email;
    }

    public void setEmailGerencia(String email) {
        this.email = email;
    }

    public String getIdGerencia() {
        return identificacao;
    }

    public void setIdGerencia(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getSenhaGerencia() {
        return senha;
    }

    public void setSenhaGerencia(String senha) {
        this.senha = senha;
    }

    // Métodos
    public void gerenciarFuncionarios() {
        // Lógica para gerenciar funcionários
        System.out.println("Gerenciando funcionários...");
    }

    public void gerenciarPratos() {
        // Lógica para gerenciar pratos
        System.out.println("Gerenciando pratos...");
    }

    public void gerarComissao() {
        // Lógica para gerar comissão
        System.out.println("Gerando comissão...");
    }

    public void gerarFaturamentoAnual() {
        // Lógica para gerar faturamento anual
        System.out.println("Gerando faturamento anual...");
    }

    public void gerarFaturamentoMensal() {
        // Lógica para gerar faturamento mensal
        System.out.println("Gerando faturamento mensal...");
    }

    public void gerarFaturamentoTrimestral() {
        // Lógica para gerar faturamento trimestral
        System.out.println("Gerando faturamento trimestral...");
    }
}
