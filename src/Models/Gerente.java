package Models;

import java.util.ArrayList;
import java.util.Scanner;
import application.UsuarioHandler;;

public class Gerente extends Usuario {
    Scanner sc = new Scanner(System.in);
    UsuarioHandler usuarioHandler = new UsuarioHandler();
    private String identificacao;

    // Construtor
    public Gerente(String email, String senha, String nome, int cpf, String identificacao) {
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

    }

}