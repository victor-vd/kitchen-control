package application;

import Models.Cozinheiro;
import Models.Garcom;
import Models.Gerente;
import Models.Usuario;

import java.util.Scanner;

public class TextInterface {
    private final Scanner scan;
    private final UsuarioHandler userHandler;

    public TextInterface(Scanner scan, UsuarioHandler userHandler) {
        this.scan = scan;
        this.userHandler = userHandler;
    }

    public void start() {
        System.out.println("Bem vindo ao Sistema de Restaurante Unificado!");
        while (!userHandler.hasActiveUser()) {
            System.out.println("Ações Disponíveis: \n");

            System.out.println("Registrar-se");
            System.out.println("Login");
        }
    }

    public void registro() {
        int escolha;
        String nome;
        String senha;
        int cpf;
        String email;

        Usuario newUsuario;


        System.out.println("Como gostaria de se registrar?");
        System.out.println("1 - Como Gerente" +
                "2 - Como Cozinheiro" +
                "3 - Como Garçom");

        escolha = scan.nextInt();

        System.out.println("Por favor, digite seu nome: ");
        nome = scan.nextLine();
        System.out.println("Digite seu email: ");
        email = scan.nextLine();

        System.out.println("Digite sua senha: ");
        senha = scan.nextLine();

        System.out.println("Digite seu CPF (Apenas números): ");
        cpf = Integer.parseInt(scan.nextLine());


        switch (escolha) {
            case 1:
                newUsuario = new Gerente(email, senha, nome, cpf, "BANANA");
                break;

            case 2:
                newUsuario = new Cozinheiro(userHandler.getNumeroFuncionarios()+1,
                        email,
                        senha,
                        nome,
                        cpf);
                break;
            case 3:
                newUsuario = new Garcom(userHandler.getNumeroFuncionarios()+1,
                        email, senha, nome, cpf, 0);
                break;

        }

    }

    public void login() {
        System.out.println("Login - \n\n");

        System.out.println("Digite seu e-mail e senha");
        String email = scan.nextLine();
        System.out.println("Digite seu senha");
        String senha = scan.nextLine();

        if(!userHandler.login(email, senha)){
            System.out.println("Usuário Não Encontrado");
        }

    }

}
