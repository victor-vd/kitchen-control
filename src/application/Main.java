package application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioHandler userHandler = new UsuarioHandler();
        TextInterface textInterface = new TextInterface(sc, userHandler);

        textInterface.start();
    }

    /*
            Scanner sc = new Scanner(System.in);
        String emailDigitado = "";
        String senhaDigitada = "";

        System.out.println(
                "1 - Entrar como Gerente" +
                        "2 - Entrar como Cozinheiro" +
                        "3 - Entrar como Garçom");

        switch (sc.nextInt()) {
            case 1:
                System.out.print("Digite seu email: ");
                emailDigitado = sc.nextLine();
                System.out.print("Digite sua senha: ");
                senhaDigitada = sc.nextLine();
                break;

            case 2:
                System.out.print("Digite seu email: ");
                emailDigitado = sc.nextLine();
                System.out.print("Digite sua senha: ");
                senhaDigitada = sc.nextLine();

                break;

            case 3:
                System.out.print("Digite seu email: ");
                emailDigitado = sc.nextLine();
                System.out.print("Digite sua senha: ");
                senhaDigitada = sc.nextLine();

                break;

            default:
                break;
        }

        System.out.println(
                "1 - " +
                        "2 - " +
                        "3 - " +
                        "4 - " +
                        "5 - " +
                        "6 - " +
                        "7 - " +
                        "8 - " +
                        "9 - " +
                        "10 - ");

        switch (sc.nextInt()) {
            case 1:

                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            case 5:

                break;

            case 6:

                break;

            case 7:

                break;

            case 8:

                break;

            case 9:

                break;

            case 10:

                break;
            default:
                break;
        }
     */
}
