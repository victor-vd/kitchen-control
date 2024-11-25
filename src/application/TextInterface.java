package application;

import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextInterface {
    private final Scanner scan;
    private final UsuarioHandler userHandler;
    private final Cardapio cardapio = new Cardapio();
    private final List<Mesa> mesas = new ArrayList<>();

    public TextInterface(Scanner scan, UsuarioHandler userHandler) {
        this.scan = scan;
        this.userHandler = userHandler;
        inicializarMesas();
    }

    private void inicializarMesas() {
        mesas.add(new Mesa("d1"));
        mesas.add(new Mesa("d2"));
        mesas.add(new Mesa("d3"));
        mesas.add(new Mesa("d4"));
        mesas.add(new Mesa("d5"));
        mesas.add(new Mesa("d6"));
        mesas.add(new Mesa("f1"));
        mesas.add(new Mesa("f2"));
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
        System.out.println("2 - Gerenciar Mesas");
        System.out.println("3 - Consultar cardápio");
        System.out.println("4 - Gerenciar Funcionários");

        switch (scan.nextInt()) {
            case 1:
                gerenciarPratos();
                break;
            case 2:

                System.out.println("Digite o id da mesa que você deseja gerenciar:");
                String mesaId = scan.next();
                Mesa mesaSelecionada = null;
                for (Mesa mesa : mesas) {
                    if (mesa.getIdMesa().equals(mesaId)) {
                        mesaSelecionada = mesa;
                        break;
                    }
                }
                if (mesaSelecionada != null) {

                    System.out.println("1 - Adicionar pedido");
                    System.out.println("2 - Desocupar mesa");

                    switch (scan.nextInt()) {
                        case 1:

                            adicionarPedido(mesaSelecionada);
                            break;
                        case 2:
                            mesaSelecionada.desocuparMesa();
                            break;

                        default:
                            break;
                    }

                } else {
                    System.out.println("Mesa não encontrada.");
                }

                break;
            case 3:
                cardapio.listarCardapio();
                break;
            case 4:
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

    public void adicionarPedido(Mesa mesaSelecionada) {
        System.out.print("Digite o código do pedido: ");
        String codigoPedido = scan.next();
        System.out.print("Digite o ID do pedido: ");
        String idPedido = scan.next();
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scan.next();
        System.out.print("Digite o status do pedido: ");
        String statusPedido = scan.next();
        System.out.print("Digite a observação: ");
        String observacao = scan.next();
        System.out.print("Digite o tempo estimado (em minutos): ");
        int tempoEstimado = scan.nextInt();
        System.out.print("Digite a soma total: ");
        double somaTotal = scan.nextDouble();
        System.out.print("O pedido é para levar? [true/false]: ");
        boolean paraLevar = scan.nextBoolean();

        List<Item> itens;
        itens = new ArrayList<>();
        System.out.print("Digite o número de itens: ");
        int numeroItens = scan.nextInt();

        for (int i = 0; i < numeroItens; i++) {
            System.out.print("Digite o nome do item: ");
            String nomeItem = scan.next();
            System.out.print("Digite o preço do item: ");
            float precoItem = scan.nextFloat();
            System.out.print("Digite o número de ingredientes: ");
            int numeroIngredientes = scan.nextInt();
            List<String> ingredientes = new ArrayList<>();
            for (int j = 0; j < numeroIngredientes; j++) {
                System.out.print("Digite o nome do ingrediente: ");
                ingredientes.add(scan.next());
            }
            itens.add(new Item(nomeItem, precoItem, ingredientes));
        }

        mesaSelecionada.adicionarPedido(new Pedido(codigoPedido, idPedido, nomeCliente, statusPedido,
                observacao, tempoEstimado, somaTotal, paraLevar, itens));
    }
}