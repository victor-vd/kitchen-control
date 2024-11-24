package application;

import java.util.Scanner;

public class TextInterface {
    private Scanner scan;
    private UsuarioHandler userHandler;

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

        System.out.println("Como gostaria de se registrar?");
        System.out.println("1 - Como Gerente" +
                "2 - Como Cozinheiro" +
                "3 - Como Garçom");

        escolha = scan.nextInt();

        switch (escolha) {
            case 1:

        }

    }

    public void login() {
        System.out.println("Login - \n\n");

        System.out.println("Digite seu e-mail e senha");
        String email = scan.nextLine();
        System.out.println("Digite seu senha");
        String senha = scan.nextLine();

        userHandler.login(email, senha);

    }

}
