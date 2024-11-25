package application;

import Models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TextInterface implements  UserInterface{
    private final Scanner scan;
    private final UsuarioHandler userHandler;
    Cardapio cardapio = new Cardapio();

    public TextInterface(Scanner scan, UsuarioHandler userHandler) {
        this.scan = scan;
        this.userHandler = userHandler;
    }

    public void start() {
        System.out.println("Bem vindo ao Sistema de Restaurante Unificado!");
        while (!userHandler.hasActiveUser()) {
            System.out.println("Ações Disponíveis: \n");

            System.out.println("0 - Sair");
            System.out.println("1 - Login");

            switch (scan.nextInt()) {
                case 1:
                    login();

                    break;

                default:
                    break;
            }
        }
    }

    // public void registro() {
    // int escolha;
    // String nome;
    // String senha;
    // int cpf;
    // String email;

    // Usuario newUsuario;

    // System.out.println("Como gostaria de se registrar?");
    // System.out.println("0 - Voltar\n1 - Como Gerente" +
    // "\n2 - Como Cozinheiro" +
    // "\n3 - Como Garçom");

    // escolha = scan.nextInt();

    // System.out.println("Por favor, digite seu nome: ");
    // nome = scan.nextLine();
    // System.out.println("Digite seu email: ");
    // email = scan.nextLine();

    // System.out.println("Digite sua senha: ");
    // senha = scan.nextLine();

    // System.out.println("Digite seu CPF (Apenas números): ");
    // cpf = Integer.parseInt(scan.nextLine());

    // switch (escolha) {
    // case 1:
    // newUsuario = new Gerente(email, senha, nome, cpf, "BANANA");
    // break;

    // case 2:
    // newUsuario = new Cozinheiro(userHandler.getNumeroFuncionarios() + 1,
    // email,
    // senha,
    // nome,
    // cpf);
    // break;
    // case 3:
    // newUsuario = new Garcom(userHandler.getNumeroFuncionarios() + 1,
    // email, senha, nome, cpf, 0);
    // break;

    // }

    // }

    public void login() {
        System.out.println("Login");

        System.out.println("Digite seu email:");
        String email = scan.next();

        System.out.println("Digite sua senha:");
        String senha = scan.next();

        if (userHandler.login(email, senha)) {
            System.out.println("Usuário Encontrado");

        } else {
            System.out.println("Usuário Não Encontrado");
        }

    }

    public void menuGerente() {
        System.out.println("0 - Sair");
        System.out.println("1 - Gerenciar pratos");
        System.out.println("2 - Adicionar pedido");
        System.out.println("3 - Gerenciar Mesas");
        System.out.println("4 - Consultar cardápio");
        System.out.println("5 - Gerenciar Funcionários");

        switch (scan.nextInt()) {
            case 1:
                gerenciarPratos();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                gerenciarFuncionarios();
                break;

            default:
                break;

        }
    }

    public void menuGarcom() {
        System.out.println("0 - Sair");
        System.out.println("1 - Adicionar pedido");
        System.out.println("2 - Gerenciar Mesas");
        System.out.println("3 - Consultar cardápio");

        switch (scan.nextInt()) {
            case 1:
                break;

            default:
                break;

        }
    }

    public void menuCozinheiro() {
        System.out.println("0 - Sair");
        System.out.println("1 - Gerenciar pratos");
        System.out.println("2 - Selecionar pedido");
        System.out.println("3 - Modificar status do pedido");

        switch (scan.nextInt()) {
            case 1:
                gerenciarPratos();
                break;

            default:
                break;

        }
    }

    public void gerenciarFuncionarios() {
        // Lógica para gerenciar funcionários
        System.out.println("0 - Sair \n1 - Adicionar funcionário\n2 - Remover funcionário");

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
        System.out.println("1 - Gerenciar Comidas\n2 - Gerenciar Bebidas");

        switch (scan.nextInt()) {
            case 1:
                System.out.println("0 - Voltar\n1 - Adicionar Comidas\n2 - Remover Comidas");
                switch (scan.nextInt()) {
                    case 1:
                        System.out.print("Nome da comida: ");
                        String nomeItem = scan.nextLine();
                        System.out.println("\nPreço da comida: ");
                        float precoItem = scan.nextFloat();
                        System.out.println("\nPeso em gramas da comida: ");
                        int tamanhoGr = scan.nextInt();
                        System.out.println("\nNúmero de ingredientes: ");
                        int nIngredientes = scan.nextInt();

                        ArrayList<String> ingredientes = new ArrayList<String>();

                        for (int i = 0; i <= nIngredientes; i++) {
                            System.out.println("Digite o nome do ingrediente: ");
                            ingredientes.add(scan.nextLine());
                        }
                        cardapio.adicionarComida(new Comida(nomeItem, precoItem, ingredientes, tamanhoGr));

                        break;
                    case 2:

                        break;

                    default:
                        break;
                }
                break;

            case 2:
                System.out.println("0 - Sair\n1 - Adicionar Bebidas\n2 - Remover Bebidas");
                switch (scan.nextInt()) {
                    case 1:
                        System.out.print("Nome da bebida: ");
                        String nomeItem = scan.nextLine();
                        System.out.println("\nPreço da bebida: ");
                        float precoItem = scan.nextFloat();
                        System.out.println("\nPeso em gramas da bebida: ");
                        int tamanhoGr = scan.nextInt();
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

                        cardapio.adicionarBebida(new Bebida(nomeItem, precoItem, ingredientes, tamanhoGr, alcoolica));

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