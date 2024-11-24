package application;

import Models.*;

import java.util.ArrayList;
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
                newUsuario = new Cozinheiro(userHandler.getNumeroFuncionarios() + 1,
                        email,
                        senha,
                        nome,
                        cpf);
                break;
            case 3:
                newUsuario = new Garcom(userHandler.getNumeroFuncionarios() + 1,
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

        if (!userHandler.login(email, senha)) {
            System.out.println("Usuário Não Encontrado");
        }

    }

    public void gerenciarFuncionarios() {
        // Lógica para gerenciar funcionários
        System.out.println("1 - Adicionar funcionário\n2 - Remover funcionário");

        switch (scan.nextInt()) {
            case 1:
                System.out.print("Digite o nome do funcionário: ");
                String nomeFuncionario = scan.nextLine();
                System.out.print("\nDigite o CPF do funcionário: ");
                int cpfFuncionario = scan.nextInt();
                System.out.print("\nDigite o email do funcionário: ");
                String emailFuncionario = scan.nextLine();
                System.out.print("\nDigite a senha de acesso do funcionário: ");
                String senhaFuncionario = scan.nextLine();

                userHandler.adicionarUsuario(
                        new Usuario(nomeFuncionario, emailFuncionario, senhaFuncionario, cpfFuncionario));
                break;

            case 2:
                System.out.print("Digite o CPF do funcionário a ser removido: \n");

                userHandler.removerUsuario(scan.nextInt());
                break;

            default:
                break;
        }
    }

    public void gerenciarPratos() {
        // Lógica para gerenciar pratos
        System.out.println("1 - Gerenciar Comidas\n 2 - Gerenciar Bebidas");

        switch (scan.nextInt()) {
            case 1:
                System.out.println("1 - Adicionar Comidas\n 2 - Remover Comidas");
                switch (scan.nextInt()) {
                    case 1:
                        System.out.print("Nome da comida: ");
                        String nomeItem = scan.nextLine();
                        System.out.println("\nPreço da comida: ");
                        float precoItem = scan.nextFloat();
                        System.out.println("\nPeso em gramas da comida: ");
                        String tamanhoGr = scan.nextLine();
                        System.out.println("\nNúmero de ingredientes: ");
                        int nIngredientes = scan.nextInt();

                        ArrayList<String> ingredientes = new ArrayList<String>();

                        for (int i = 0; i <= nIngredientes; i++) {
                            System.out.println("Digite o nome do ingrediente: ");
                            ingredientes.add(scan.nextLine());
                        }

                        new Comida(nomeItem, precoItem, ingredientes, tamanhoGr);

                        break;
                    case 2:

                        break;

                    default:
                        break;
                }
                break;

            case 2:
                System.out.println("1 - Adicionar Bebidas\n 2 - Remover Bebidas");
                switch (scan.nextInt()) {
                    case 1:
                        System.out.print("Nome da bebida: ");
                        String nomeItem = scan.nextLine();
                        System.out.println("\nPreço da bebida: ");
                        float precoItem = scan.nextFloat();
                        System.out.println("\nPeso em gramas da bebida: ");
                        String tamanhoGr = scan.nextLine();
                        System.out.println("\nA bebida é alcoólica? [1 - Sim] [2 - Não]");
                        int nAlcoolica = scan.nextInt();
                        boolean alcoolica = false;

                        if (nAlcoolica == 1) {
                            alcoolica = true;
                        } else {
                            alcoolica = false;
                        }

                        System.out.println("\nNúmero de ingredientes: ");
                        int nIngredientes = scan.nextInt();

                        ArrayList<String> ingredientes = new ArrayList<String>();

                        for (int i = 0; i <= nIngredientes; i++) {
                            System.out.println("Digite o nome do ingrediente: ");
                            ingredientes.add(scan.nextLine());
                        }

                        new Bebida(nomeItem, precoItem, ingredientes, tamanhoGr, alcoolica);

                        break;
                    case 2:

                        break;

                    default:
                        break;
                }
                break;

            default:
                break;
        }
    }
}