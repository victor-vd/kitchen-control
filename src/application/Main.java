package application;

import java.util.Scanner;

import Models.Gerente;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioHandler userHandler = new UsuarioHandler();
        TextInterface textInterface = new TextInterface(sc, userHandler);

        textInterface.start();
    }
}
