package Models;

import java.util.ArrayList;
import java.util.Scanner;
import application.UsuarioHandler;;

public class Gerente extends Usuario {
    Scanner sc = new Scanner(System.in);
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
        // Lógica para gerenciar funcionários
        System.out.println("1 - Adicionar funcionário\n2 - Remover funcionário");

        switch (sc.nextInt()) {
            case 1:
                System.out.print("Digite o nome do funcionário: ");
                String nomeFuncionario = sc.nextLine();
                System.out.print("\nDigite o CPF do funcionário: ");
                int cpfFuncionario = sc.nextInt();
                System.out.print("\nDigite o email do funcionário: ");
                String emailFuncionario = sc.nextLine();
                System.out.print("\nDigite a senha de acesso do funcionário: ");
                String senhaFuncionario = sc.nextLine();

                UsuarioHandler
                        .adicionarUsuario(
                                new Usuario(nomeFuncionario, emailFuncionario, senhaFuncionario, cpfFuncionario));
                break;

            case 2:
                System.out.print("Digite o CPF do funcionário a ser removido: \n");

                UsuarioHandler.removerUsuario(sc.nextInt());
                break;

            default:
                break;
        }
    }

    public void gerenciarPratos() {
        // Lógica para gerenciar pratos
        System.out.println("1 - Gerenciar Comidas\n 2 - Gerenciar Bebidas");

        switch (sc.nextInt()) {
            case 1:
                System.out.println("1 - Adicionar Comidas\n 2 - Remover Comidas");
                switch (sc.nextInt()) {
                    case 1:
                        System.out.print("Nome da comida: ");
                        String nomeItem = sc.nextLine();
                        System.out.println("\nPreço da comida: ");
                        float precoItem = sc.nextFloat();
                        System.out.println("\nPeso em gramas da comida: ");
                        String tamanhoGr = sc.nextLine();
                        System.out.println("\nNúmero de ingredientes: ");
                        int nIngredientes = sc.nextInt();

                        ArrayList<String> ingredientes = new ArrayList<String>();

                        for (int i = 0; i <= nIngredientes; i++) {
                            System.out.println("Digite o nome do ingrediente: ");
                            ingredientes.add(sc.nextLine());
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
                switch (sc.nextInt()) {
                    case 1:
                        System.out.print("Nome da bebida: ");
                        String nomeItem = sc.nextLine();
                        System.out.println("\nPreço da bebida: ");
                        float precoItem = sc.nextFloat();
                        System.out.println("\nPeso em gramas da bebida: ");
                        String tamanhoGr = sc.nextLine();
                        System.out.println("\nA bebida é alcoólica? [1 - Sim] [2 - Não]");
                        int nAlcoolica = sc.nextInt();
                        boolean alcoolica = false;

                        if (nAlcoolica == 1) {
                            alcoolica = true;
                        } else {
                            alcoolica = false;
                        }

                        System.out.println("\nNúmero de ingredientes: ");
                        int nIngredientes = sc.nextInt();

                        ArrayList<String> ingredientes = new ArrayList<String>();

                        for (int i = 0; i <= nIngredientes; i++) {
                            System.out.println("Digite o nome do ingrediente: ");
                            ingredientes.add(sc.nextLine());
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
