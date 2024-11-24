package Models;

import java.util.List;

public class Cardapio {
    private static List<Object> itens;

    public Cardapio() {

    }

    public void adicionarBebida(Bebida bebida) {
        itens.add(bebida);
    }

    public void adicionarComida(Comida comida) {
        itens.add(comida);
    }
}
