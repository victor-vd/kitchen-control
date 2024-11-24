package Models;

public class Gerente extends Usuario {
    private String identificacao;

    // Construtor
    public Gerente(String email, String senha, String nome, int cpf,  String identificacao) {
        super(email, senha, nome, cpf);
        this.identificacao = identificacao;
    }



    // Getters e Setters



    public String getIdGerencia() {
        return identificacao;
    }

    public void setIdGerencia(String identificacao) {
        this.identificacao = identificacao;
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
