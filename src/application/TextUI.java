package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.*;

public class TextUI implements UserInterface {
    private final Scanner scan;
    private final UsuarioHandler userHandler;
    private final Cardapio cardapio = new Cardapio();
    private final List<Mesa> mesas = new ArrayList<>();
    private boolean menu;

    public TextUI(Scanner scan, UsuarioHandler userHandler) {
        this.scan = scan;
        this.userHandler = userHandler;
        this.menu = true;
        inicializarMesas();
        System.out.println();
    }

    private void inicializarMesas() {
        // Inicializa as mesas
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
        // Exibe mensagem de boas-vindas
        System.out.println("Bem vindo ao Sistema de Restaurante Unificado!\n");

        // Loop até que um usuário esteja ativo
        while (!userHandler.hasActiveUser()) {
            System.out.println("Ações Disponíveis:");

            System.out.println("\n0 - Sair");
            System.out.println("1 - Login\n");

            // Lê a opção do usuário
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
        // Solicita e lê o email e senha do usuário
        System.out.println("Login\n");

        System.out.println("Digite seu email:\n");
        String email = scan.next();

        System.out.println("Digite sua senha:\n");
        String senha = scan.next();

        // Verifica as credenciais do usuário
        if (userHandler.login(email, senha)) {
            System.out.println("Usuário Encontrado\n");

            // Direciona para o menu apropriado com base no tipo de usuário
            if (userHandler.getUsuarioAtual() instanceof Cozinheiro) {
                menuCozinheiro();
            } else if (userHandler.getUsuarioAtual() instanceof Gerente) {
                menuGerente();
            } else if (userHandler.getUsuarioAtual() instanceof Garcom) {
                menuGarcom();
            }
        } else {
            System.out.println("Usuário Não Encontrado\n");
        }
    }

    public void menuGarcom() {
        // Exibe o menu do garçom
        while (menu) {
            System.out.println("\n0 - Sair");
            System.out.println("1 - Gerenciar Mesas");
            System.out.println("2 - Consultar cardápio\n");

            // Lê a opção do garçom
            switch (scan.nextInt()) {
                case 0:
                    menu = false;
                    break;
                case 1:
                    scan.nextLine();
                    gerenciarMesa();
                    break;
                case 2:
                    scan.nextLine();
                    cardapio.exibirTabulado();
                    break;

                default:
                    break;
            }
        }
    }

    public void menuCozinheiro() {
        // Exibe o menu do cozinheiro
        while (menu) {
            System.out.println("0 - Sair");
            System.out.println("1 - Gerenciar pratos");
            System.out.println("2 - Gerenciar pedido\n");

            // Lê a opção do cozinheiro
            switch (scan.nextInt()) {
                case 0:
                    menu = false;
                    break;
                case 1:
                    scan.nextLine();
                    gerenciarPratos();
                    break;
                case 2:
                    scan.nextLine();
                    gerenciarPedidos();
                    break;

                default:
                    break;
            }
        }
    }

    public void menuGerente() {
        // Exibe o menu do gerente
        while (menu) {
            System.out.println("\n0 - Sair");
            System.out.println("1 - Gerenciar pratos");
            System.out.println("2 - Gerenciar Mesas");
            System.out.println("3 - Consultar cardápio");
            System.out.println("4 - Gerenciar Funcionários\n");

            // Lê a opção do gerente
            switch (scan.nextInt()) {
                case 0:
                    menu = false;
                    break;
                case 1:
                    scan.nextLine();
                    gerenciarPratos();
                    break;
                case 2:
                    scan.nextLine();
                    gerenciarMesa();
                    break;
                case 3:
                    scan.nextLine();
                    cardapio.exibirTabulado();
                    break;
                case 4:
                    scan.nextLine();
                    gerenciarFuncionarios();
                    break;

                default:
                    break;
            }
        }
    }

    public void gerenciarFuncionarios() {
        // Exibe opções para gerenciar funcionários
        System.out.println("\n0 - Sair\n1 - Adicionar funcionário\n2 - Listar usuários\n" + //
                "3 - Remover funcionário\n");

        // Lê a opção do gerente
        switch (scan.nextInt()) {
            case 1:
                scan.nextLine();

                System.out.print("\n1 - Adicionar Garçom\n2 - Adicionar Cozinheiro \n");
                int tipoFuncionario = scan.nextInt();
                System.out.print("\nDigite o id do funcionário: ");
                int idFuncionario = scan.nextInt();
                scan.nextLine();
                System.out.print("\nDigite o nome do funcionário: ");
                String nomeFuncionario = scan.nextLine();
                System.out.print("\nDigite o CPF do funcionário: ");
                int cpfFuncionario = scan.nextInt();
                scan.nextLine();
                System.out.print("\nDigite o email do funcionário: ");
                String emailFuncionario = scan.nextLine();
                System.out.print("\nDigite a senha de acesso do funcionário: ");
                String senhaFuncionario = scan.nextLine();
                if (tipoFuncionario == 1) {
                    userHandler.adicionarUsuario(new Garcom(idFuncionario, nomeFuncionario, emailFuncionario,
                            senhaFuncionario, cpfFuncionario));

                } else if (tipoFuncionario == 2) {
                    userHandler.adicionarUsuario(new Cozinheiro(idFuncionario, nomeFuncionario, emailFuncionario,
                            senhaFuncionario, cpfFuncionario));
                }
                break;

            case 2:
                userHandler.exibirTabulado();
                break;

            case 3:
                scan.nextLine();
                System.out.print("\nDigite o CPF do funcionário a ser removido: ");

                userHandler.removerUsuario(scan.nextInt());
                scan.nextLine();
                break;

            default:
                break;
        }
    }

    public void gerenciarPratos() {
        // Exibe opções para gerenciar pratos
        System.out.println("\n1 - Gerenciar Comidas\n2 - Gerenciar Bebidas\n3 - Exibir Itens\n");

        // Lê a opção do usuário
        switch (scan.nextInt()) {
            case 1:
                scan.nextLine();
                System.out.println("\n0 - Voltar\n1 - Adicionar Comidas\n2 - Remover Comidas\n3 - Exibir Comidas\n");
                switch (scan.nextInt()) {
                    case 1:
                        scan.nextLine();
                        System.out.print("\nNome da comida: ");
                        String nomeItem = scan.nextLine();
                        System.out.print("\nPreço da comida: ");
                        float precoItem = scan.nextFloat();
                        scan.nextLine();
                        System.out.print("\nPeso em gramas da comida: ");
                        int tamanhoGr = scan.nextInt();
                        scan.nextLine();
                        System.out.print("\nNúmero de ingredientes: ");
                        int nIngredientes = scan.nextInt();
                        scan.nextLine();

                        ArrayList<String> ingredientes = new ArrayList<String>();

                        // Lê os ingredientes da comida
                        for (int i = 0; i < nIngredientes; i++) {
                            System.out.print("\nDigite o nome do ingrediente: ");
                            ingredientes.add(scan.nextLine());
                        }
                        cardapio.adicionarComida(new Comida(nomeItem, precoItem, ingredientes, tamanhoGr));

                        break;
                    case 2:
                        scan.nextLine();
                        System.out.print("\nDigite o nome da comida a ser removida: ");

                        boolean removed = cardapio.removerItemPorNome(scan.next());
                        scan.nextLine();
                        if (removed) {
                            System.out.println("Comida removida com sucesso.\n");
                        } else {
                            System.out.println("Comida não encontrada.\n");
                        }
                        break;
                    case 3:
                        scan.nextLine();
                        cardapio.listarComidas();
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                scan.nextLine();
                System.out.println("\n0 - Sair\n1 - Adicionar Bebidas\n2 - Remover Bebidas\n3 - Exibir Bebidas\n");
                switch (scan.nextInt()) {
                    case 1:
                        scan.nextLine();
                        System.out.print("\nNome da bebida: ");
                        String nomeItem = scan.nextLine();
                        System.out.print("\nPreço da bebida: ");
                        float precoItem = scan.nextFloat();
                        scan.nextLine();
                        System.out.print("\nPeso em gramas da bebida: ");
                        int tamanhoGr = scan.nextInt();
                        scan.nextLine();
                        System.out.print("\nA bebida é alcoólica? [1 - Sim] [2 - Não] ");
                        int nAlcoolica = scan.nextInt();
                        scan.nextLine();
                        boolean alcoolica = nAlcoolica == 1;

                        System.out.print("\nNúmero de ingredientes: ");
                        int nIngredientes = scan.nextInt();
                        scan.nextLine();

                        ArrayList<String> ingredientes = new ArrayList<String>();

                        // Lê os ingredientes da bebida
                        for (int i = 0; i < nIngredientes; i++) {
                            System.out.print("\nDigite o nome do ingrediente: ");
                            ingredientes.add(scan.nextLine());
                        }
                        cardapio.adicionarBebida(new Bebida(nomeItem, precoItem, ingredientes, tamanhoGr, alcoolica));

                        break;
                    case 2:
                        scan.nextLine();
                        System.out.print("\nDigite o nome da bebida a ser removida: ");

                        boolean removedBebida = cardapio.removerItemPorNome(scan.next());
                        scan.nextLine();
                        if (removedBebida) {
                            System.out.println("Bebida removida com sucesso.\n");
                        } else {
                            System.out.println("Bebida não encontrada.\n");
                        }
                        break;

                    case 3:
                        scan.nextLine();
                        cardapio.listarBebidas();
                        break;
                    default:
                        break;
                }
                break;

            case 3:
                scan.nextLine();
                cardapio.exibirTabulado();
                break;
            default:
                break;
        }
    }

    public void gerenciarMesa() {
        // Solicita e lê o id da mesa a ser gerenciada
        System.out.print("\nDigite o id da mesa que você deseja gerenciar: ");
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
            System.out.println("2 - Desocupar mesa\n");

            // Lê a opção do usuário
            switch (scan.nextInt()) {
                case 1:
                    scan.nextLine();
                    adicionarPedido(mesaSelecionada);
                    break;
                case 2:
                    scan.nextLine();
                    mesaSelecionada.desocuparMesa();
                    break;

                default:
                    break;
            }

        } else {
            System.out.println("\nMesa não encontrada.\n");
        }
    }

    public void gerenciarPedidos() {
        // Exibe opções para gerenciar pedidos
        System.out.println("\n0 - Sair");
        System.out.println("1 - Listar pedidos");
        System.out.println("2 - Atualizar status do pedido");
        System.out.println("3 - Remover pedido\n");

        // Lê a opção do usuário
        switch (scan.nextInt()) {
            case 1:
                scan.nextLine();
                listarPedidos();
                break;
            case 2:
                scan.nextLine();
                atualizarStatusPedido();
                break;
            case 3:
                scan.nextLine();
                removerPedido();
                break;
            default:
                break;
        }
    }

    private void listarPedidos() {
        // Lista todos os pedidos das mesas
        for (Mesa mesa : mesas) {
            for (Pedido pedido : mesa.getPedidos()) {
                System.out.println(pedido);
            }
        }
    }

    private void atualizarStatusPedido() {
        // Solicita e lê o ID do pedido e o novo status
        System.out.print("\nDigite o ID do pedido: ");
        String idPedido = scan.next();
        scan.nextLine();
        System.out.print("\nDigite o status do pedido [1: Espera] [2: Preparando] [3: Pronto]: ");
        int statusEscolha = scan.nextInt();
        scan.nextLine();
        String statusPedido = (statusEscolha == 3 ? "Pronto" : statusEscolha == 2 ? "Preparando" : "Espera");

        // Atualiza o status do pedido
        for (Mesa mesa : mesas) {
            for (Pedido pedido : mesa.getPedidos()) {
                if (pedido.getIdPedido().equals(idPedido)) {
                    pedido.setStatusPedido(statusPedido);
                    System.out.println("Status atualizado com sucesso.\n");
                    return;
                }
            }
        }
        System.out.println("\nPedido não encontrado.\n");
    }

    private void removerPedido() {
        // Solicita e lê o ID do pedido a ser removido
        System.out.print("\nDigite o ID do pedido: ");
        String idPedido = scan.next();

        // Remove o pedido da mesa
        for (Mesa mesa : mesas) {
            if (mesa.removerPedido(idPedido)) {
                System.out.println("\nPedido removido com sucesso.\n");
                return;
            }
        }
        System.out.println("\nPedido não encontrado.\n");
    }

    public void adicionarPedido(Mesa mesaSelecionada) {
        // Solicita e lê os detalhes do pedido
        System.out.print("\nDigite o ID do pedido: ");
        String idPedido = scan.next();
        scan.nextLine();
        System.out.print("\nDigite o nome do cliente: ");
        String nomeCliente = scan.next();
        scan.nextLine();
        System.out.print("\nDigite o status do pedido [1: Espera] [2: Preparando] [3: Pronto]: ");
        int statusEscolha = scan.nextInt();
        scan.nextLine();
        String statusPedido = (statusEscolha == 3 ? "Pronto" : statusEscolha == 2 ? "Preparando" : "Espera");
        scan.nextLine();
        System.out.print("\nDigite o tempo estimado (em minutos): ");
        int tempoEstimado = scan.nextInt();
        scan.nextLine();
        System.out.print("\nO pedido é para levar? [true/false]: ");
        boolean paraLevar = scan.nextBoolean();
        scan.nextLine();

        List<Item> itens = new ArrayList<>();
        System.out.print("\nDigite o número de itens: ");
        int numeroItens = scan.nextInt();
        scan.nextLine();

        // Lê os itens do pedido
        for (int i = 0; i < numeroItens; i++) {
            cardapio.exibirTabulado();
            System.out.print("\nDigite o id do item: ");
            int id = scan.nextInt();
            scan.nextLine();

            // Verifica se o id é válido
            if (id >= 0 && id < cardapio.getItens().size()) {
                Item item = cardapio.getItens().get(id);
                itens.add(item);
                System.out.println(item);
            } else {
                System.out.println("\nID inválido. Tente novamente.");
                i--; // Decrementa i para repetir a iteração
            }
        }

        // Adiciona o pedido à mesa selecionada
        mesaSelecionada.adicionarPedido(new Pedido(idPedido, nomeCliente, statusPedido,
                tempoEstimado, paraLevar, itens));
    }
}