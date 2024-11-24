package Models;

public class Gerente {
    private String emailGerencia;
    private String idGerencia;
    private String senhaGerencia;

    // Construtor
    public Gerente(String emailGerencia, String idGerencia, String senhaGerencia) {
        this.emailGerencia = emailGerencia;
        this.idGerencia = idGerencia;
        this.senhaGerencia = senhaGerencia;
    }

    // Getters e Setters
    public String getEmailGerencia() {
        return emailGerencia;
    }

    public void setEmailGerencia(String emailGerencia) {
        this.emailGerencia = emailGerencia;
    }

    public String getIdGerencia() {
        return idGerencia;
    }

    public void setIdGerencia(String idGerencia) {
        this.idGerencia = idGerencia;
    }

    public String getSenhaGerencia() {
        return senhaGerencia;
    }

    public void setSenhaGerencia(String senhaGerencia) {
        this.senhaGerencia = senhaGerencia;
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
