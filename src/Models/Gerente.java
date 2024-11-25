package Models;

import java.util.Scanner;

public class Gerente extends Usuario {
    Scanner sc = new Scanner(System.in);
    private String identificacao;

    // Construtor
    public Gerente(String email, String senha, String nome, int cpf, String identificacao) {
        super(email, senha, nome, cpf);
        this.identificacao = identificacao;
    }

    // Métodos
    public void gerenciarFuncionarios() {

    }

    // Getters e Setters
    public String getIdGerencia() {
        return identificacao;
    }

    public void setIdGerencia(String identificacao) {
        this.identificacao = identificacao;
    }

}