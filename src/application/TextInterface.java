package application;

import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextInterface implements UserInterface {
    private final Scanner scan;
    private final UsuarioHandler userHandler;
    private final Cardapio cardapio = new Cardapio();
    private final List<Mesa> mesas = new ArrayList<>();
    private boolean menu;

    public TextInterface(Scanner scan, UsuarioHandler userHandler) {
        this.scan = scan;
        this.userHandler = userHandler;
        this.menu = true;
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
        System.out.println("\nBem vindo ao Sistema de Restaurante Unificado!");

        while (!userHandler.hasActiveUser()) {
            System.out.println("\nAções Disponíveis: \n");

            System.out.println("\n0 - Sair");
            System.out.println("\n1 - Login");

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
        System.out.println("\nLogin");

        System.out.println("\nDigite seu email:");
        String email = scan.next();

        System.out.println("\nDigite sua senha:");
        String senha = scan.next();

        if (userHandler.login(email, senha)) {
            System.out.println("\nUsuário Encontrado");

            if (userHandler.getUsuarioAtual() instanceof Cozinheiro) {
                menuCozinheiro();
            } else if (userHandler.getUsuarioAtual() instanceof Gerente) {
                menuGerente();
            } else if (userHandler.getUsuarioAtual() instanceof Garcom) {
                menuGarcom();
            }
        } else {
            System.out.println("\nUsuário Não Encontrado");
        }
    }

    public void menuGarcom() {
        while (menu) {
            System.out.println("\n0 - Sair");
            System.out.println("\n1 - Gerenciar Mesas");
            System.out.println("\n2 - Consultar cardápio");

            switch (scan.nextInt()) {
                case 0:
                    menu = false;
                    break;
                case 1:
                    scan.nextLine(); // Consumir a nova linha pendente
                    gerenciarMesa();
                    break;
                case 2:
                    scan.nextLine(); // Consumir a nova linha pendente
                    cardapio.listarCardapio();
                    break;

                default:
                    break;
            }
        }
    }

    public void menuCozinheiro() {
        while (menu) {
            System.out.println("\n0 - Sair");
            System.out.println("\n1 - Gerenciar pratos");
            System.out.println("\n2 - Gerenciar pedido");

            switch (scan.nextInt()) {
                case 0:
                    menu = false;
                    break;
                case 1:
                    scan.nextLine(); // Consumir a nova linha pendente
                    gerenciarPratos();
                    break;
                case 2:
                    scan.nextLine(); // Consumir a nova linha pendente
                    gerenciarPedidos();
                    break;

                default:
                    break;
            }
        }
    }

    public void menuGerente() {
        while (menu) {
            System.out.println("\n0 - Sair");
            System.out.println("\n1 - Gerenciar pratos");
            System.out.println("\n2 - Gerenciar Mesas");
            System.out.println("\n3 - Consultar cardápio");
            System.out.println("\n4 - Gerenciar Funcionários");

            switch (scan.nextInt()) {
                case 0:
                    menu = false;
                    break;
                case 1:
                    scan.nextLine(); // Consumir a nova linha pendente
                    gerenciarPratos();
                    break;
                case 2:
                    scan.nextLine(); // Consumir a nova linha pendente
                    gerenciarMesa();
                    break;
                case 3:
                    scan.nextLine(); // Consumir a nova linha pendente
                    cardapio.listarCardapio();
                    break;
                case 4:
                    scan.nextLine(); // Consumir a nova linha pendente
                    gerenciarFuncionarios();
                    break;

                default:
                    break;
            }
        }
    }

    public void gerenciarFuncionarios() {
        // Lógica para gerenciar funcionários
        System.out.println("\n0 - Sair \n1 - Adicionar funcionário\n2 - Remover funcionário");

        switch (scan.nextInt()) {
            case 1:
                scan.nextLine(); // Consumir a nova linha pendente
                System.out.print("\nDigite o nome do funcionário: ");
                String nomeFuncionario = scan.nextLine();
                System.out.print("\n\nDigite o CPF do funcionário: ");
                int cpfFuncionario = Integer.parseInt(scan.nextLine());
                System.out.print("\n\nDigite o email do funcionário: ");
                String emailFuncionario = scan.nextLine();
                System.out.print("\n\nDigite a senha de acesso do funcionário: ");
                String senhaFuncionario = scan.nextLine();

                userHandler.adicionarUsuario(
                        new Usuario(nomeFuncionario, emailFuncionario, senhaFuncionario, cpfFuncionario));
                break;

            case 2:
                scan.nextLine(); // Consumir a nova linha pendente
                System.out.print("\nDigite o CPF do funcionário a ser removido: \n");

                userHandler.removerUsuario(Integer.parseInt(scan.nextLine()));
                break;

            default:
                break;
        }
    }

    public void gerenciarPratos() {
        // Lógica para gerenciar pratos
        System.out.println("\n1 - Gerenciar Comidas\n2 - Gerenciar Bebidas");

        switch (scan.nextInt()) {
            case 1:
                scan.nextLine(); // Consumir a nova linha pendente
                System.out.println("\n0 - Voltar\n1 - Adicionar Comidas\n2 - Remover Comidas");
                switch (scan.nextInt()) {
                    case 1:
                        scan.nextLine(); // Consumir a nova linha pendente
                        System.out.print("\nNome da comida: ");
                        String nomeItem = scan.nextLine();
                        System.out.println("\n\nPreço da comida: ");
                        float precoItem = Float.parseFloat(scan.nextLine());
                        System.out.println("\n\nPeso em gramas da comida: ");
                        int tamanhoGr = Integer.parseInt(scan.nextLine());
                        System.out.println("\n\nNúmero de ingredientes: ");
                        int nIngredientes = Integer.parseInt(scan.nextLine());

                        ArrayList<String> ingredientes = new ArrayList<String>();

                        for (int i = 0; i < nIngredientes; i++) {
                            System.out.println("\nDigite o nome do ingrediente: ");
                            ingredientes.add(scan.nextLine());
                        }
                        cardapio.adicionarComida(new Comida(nomeItem, precoItem, ingredientes, tamanhoGr));

                        break;
                    case 2:
                        scan.nextLine(); // Consumir a nova linha pendente
                        System.out.println("\nDigite o nome da comida a ser removida: ");

                        boolean removed = cardapio.removerItemPorNome(scan.next());
                        if (removed) {
                            System.out.println("\nComida removida com sucesso.");
                        } else {
                            System.out.println("\nComida não encontrada.");
                        }
                        break;

                    default:
                        break;
                }
                break;
            case 2:
                scan.nextLine(); // Consumir a nova linha pendente
                System.out.println("\n0 - Sair\n1 - Adicionar Bebidas\n2 - Remover Bebidas");
                switch (scan.nextInt()) {
                    case 1:
                        scan.nextLine(); // Consumir a nova linha pendente
                        System.out.print("\nNome da bebida: ");
                        String nomeItem = scan.nextLine();
                        System.out.println("\n\nPreço da bebida: ");
                        float precoItem = Float.parseFloat(scan.nextLine());
                        System.out.println("\n\nPeso em gramas da bebida: ");
                        int tamanhoGr = Integer.parseInt(scan.nextLine());
                        System.out.println("\n\nA bebida é alcoólica? [1 - Sim] [2 - Não]");
                        int nAlcoolica = Integer.parseInt(scan.nextLine());
                        boolean alcoolica = nAlcoolica == 1;

                        System.out.println("\n\nNúmero de ingredientes: ");
                        int nIngredientes = Integer.parseInt(scan.nextLine());

                        ArrayList<String> ingredientes = new ArrayList<String>();

                        for (int i = 0; i < nIngredientes; i++) {
                            System.out.println("\nDigite o nome do ingrediente: ");
                            ingredientes.add(scan.nextLine());
                        }
                        cardapio.adicionarBebida(new Bebida(nomeItem, precoItem, ingredientes, tamanhoGr, alcoolica));

                        break;
                    case 2:
                        scan.nextLine(); // Consumir a nova linha pendente
                        System.out.println("\nDigite o nome da bebida a ser removida: ");

                        boolean removedBebida = cardapio.removerItemPorNome(scan.next());
                        if (removedBebida) {
                            System.out.println("\nBebida removida com sucesso.");
                        } else {
                            System.out.println("\nBebida não encontrada.");
                        }
                        break;

                    default:
                        break;
                }
                break;

            default:
                break;
        }
    }

    public void gerenciarMesa() {
        System.out.println("\nDigite o id da mesa que você deseja gerenciar:");
        String mesaId = scan.next();
        Mesa mesaSelecionada = null;
        for (Mesa mesa : mesas) {
            if (mesa.getIdMesa().equals(mesaId)) {
                mesaSelecionada = mesa;
                break;
            }
        }
        if (mesaSelecionada != null) {

            System.out.println("\n1 - Adicionar pedido");
            System.out.println("\n2 - Desocupar mesa");

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
            System.out.println("\nMesa não encontrada.");
        }
    }

    public void gerenciarPedidos() {
        System.out.println("\n0 - Sair");
        System.out.println("\n1 - Listar pedidos");
        System.out.println("\n2 - Atualizar status do pedido");
        System.out.println("\n3 - Remover pedido");

        switch (scan.nextInt()) {
            case 1:
                listarPedidos();
                break;
            case 2:
                atualizarStatusPedido();
                break;
            case 3:
                removerPedido();
                break;
            default:
                break;
        }
    }

    private void listarPedidos() {
        for (Mesa mesa : mesas) {
            for (Pedido pedido : mesa.getPedidos()) {
                System.out.println(pedido);
            }
        }
    }

    private void atualizarStatusPedido() {
        System.out.print("\nDigite o ID do pedido: ");
        String idPedido = scan.next();
        System.out.print("\nDigite o novo status do pedido [1: Espera] [2: Preparando] [3: Pronto]: ");
        int statusEscolha = Integer.parseInt(scan.nextLine());
        String novoStatus = (statusEscolha == 3 ? "Pronto" : statusEscolha == 2 ? "Preparando" : "Espera");

        for (Mesa mesa : mesas) {
            for (Pedido pedido : mesa.getPedidos()) {
                if (pedido.getIdPedido().equals(idPedido)) {
                    pedido.setStatusPedido(novoStatus);
                    System.out.println("\nStatus atualizado com sucesso.");
                    return;
                }
            }
        }
        System.out.println("\nPedido não encontrado.");
    }

    private void removerPedido() {
        System.out.print("\nDigite o ID do pedido: ");
        String idPedido = scan.next();

        for (Mesa mesa : mesas) {
            if (mesa.removerPedido(idPedido)) {
                System.out.println("\nPedido removido com sucesso.");
                return;
            }
        }
        System.out.println("\nPedido não encontrado.");
    }

    public void adicionarPedido(Mesa mesaSelecionada) {
        System.out.print("\nDigite o ID do pedido: ");
        String idPedido = scan.next();
        System.out.print("\nDigite o nome do cliente: ");
        String nomeCliente = scan.next();
        System.out.print("\nDigite o status do pedido: ");
        String statusPedido = scan.next();
        System.out.print("\nDigite a observação: ");
        String observacao = scan.next();
        System.out.print("\nDigite o tempo estimado (em minutos): ");
        int tempoEstimado = Integer.parseInt(scan.nextLine());
        System.out.print("\nDigite a soma total: ");
        double somaTotal = scan.nextDouble();
        System.out.print("\nO pedido é para levar? [true/false]: ");
        boolean paraLevar = scan.nextBoolean();

        List<Item> itens;
        itens = new ArrayList<>();
        System.out.print("\nDigite o número de itens: ");
        int numeroItens = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numeroItens; i++) {
            System.out.print("\nDigite o nome do item: ");
            String nomeItem = scan.next();
            System.out.print("\nDigite o preço do item: ");
            float precoItem = Float.parseFloat(scan.nextLine());
            System.out.print("\nDigite o número de ingredientes: ");
            int numeroIngredientes = Integer.parseInt(scan.nextLine());
            List<String> ingredientes = new ArrayList<>();
            for (int j = 0; j < numeroIngredientes; j++) {
                System.out.print("\nDigite o nome do ingrediente: ");
                ingredientes.add(scan.next());
            }
            itens.add(new Item(nomeItem, precoItem, ingredientes));
        }

        mesaSelecionada.adicionarPedido(new Pedido(idPedido, nomeCliente, statusPedido,
                observacao, tempoEstimado, somaTotal, paraLevar, itens));
    }
}