package services;

import models.Item;
import java.util.ArrayList;
import java.util.List;

public class EstoqueService {
    private List<Item> itensEstoque = new ArrayList<>();

    // Métodos para adicionar, remover e listar itens
    public void adicionarItem(Item item) {
        itensEstoque.add(item);
    }

    public List<Item> listarItens() {
        return itensEstoque;
    }

    // Outros métodos conforme necessário
}
