package application;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioHandler userHandler = new UsuarioHandler();
        UserInterface interfaceDeTexto = new TextInterface(sc, userHandler);

        interfaceDeTexto.start();
    }
}
