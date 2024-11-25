package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cardapio {
    private static List<Item> itens;

    public Cardapio() {
        itens = new ArrayList<>();
        adicionarBebida(new Bebida("Coca-Cola", 5.0f, Arrays.asList("Água", "Açúcar", "Corante"), 350, false));
        adicionarBebida(new Bebida("Pepsi", 4.5f, Arrays.asList("Água", "Açúcar", "Corante"), 350, false));
        adicionarBebida(new Bebida("Suco de Laranja", 6.0f, Arrays.asList("Laranja", "Água"), 300, false));
        adicionarBebida(new Bebida("Cerveja", 7.0f, Arrays.asList("Água", "Malte", "Lúpulo"), 500, true));
        adicionarBebida(new Bebida("Vinho", 20.0f, Arrays.asList("Uva"), 750, true));
        adicionarBebida(new Bebida("Whisky", 50.0f, Arrays.asList("Água", "Cevada"), 700, true));
        adicionarBebida(new Bebida("Água Mineral", 2.0f, Arrays.asList("Água"), 500, false));
        adicionarBebida(new Bebida("Chá Gelado", 3.5f, Arrays.asList("Água", "Chá", "Açúcar"), 400, false));

        adicionarComida(new Comida("Pizza", 25.0f, Arrays.asList("Massa", "Queijo", "Tomate"), 500));
        adicionarComida(new Comida("Hambúrguer", 15.0f, Arrays.asList("Pão", "Carne", "Queijo"), 300));
        adicionarComida(new Comida("Salada", 10.0f, Arrays.asList("Alface", "Tomate", "Cenoura"), 200));
        adicionarComida(new Comida("Lasanha", 30.0f, Arrays.asList("Massa", "Queijo", "Molho de Tomate"), 400));
        adicionarComida(new Comida("Sushi", 20.0f, Arrays.asList("Arroz", "Peixe", "Alga"), 150));
        adicionarComida(new Comida("Taco", 12.0f, Arrays.asList("Tortilla", "Carne", "Queijo"), 250));
        adicionarComida(new Comida("Bolo", 18.0f, Arrays.asList("Farinha", "Açúcar", "Ovos"), 350));
        adicionarComida(new Comida("Sorvete", 8.0f, Arrays.asList("Leite", "Açúcar", "Baunilha"), 100));

    }

    public void adicionarBebida(Bebida bebida) {
        itens.add(bebida);
    }

    public void adicionarComida(Comida comida) {
        itens.add(comida);
    }

    public void listarCardapio() {
        for (Item item : itens) {
            System.out.println(item + "\n");
        }
    }
}
