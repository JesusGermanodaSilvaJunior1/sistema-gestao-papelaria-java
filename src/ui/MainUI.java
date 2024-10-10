package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import services.EstoqueService;
import models.Item;

public class MainUI {
    private EstoqueService estoqueService = new EstoqueService();

    public void mostrar() {
        JFrame frame = new JFrame("Gestão de Papelaria");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nomeLabel = new JLabel("Nome do Item:");
        nomeLabel.setBounds(10, 20, 80, 25);
        panel.add(nomeLabel);

        JTextField nomeText = new JTextField(20);
        nomeText.setBounds(150, 20, 165, 25);
        panel.add(nomeText);

        JLabel precoLabel = new JLabel("Preço:");
        precoLabel.setBounds(10, 50, 80, 25);
        panel.add(precoLabel);

        JTextField precoText = new JTextField(20);
        precoText.setBounds(150, 50, 165, 25);
        panel.add(precoText);

        JLabel quantidadeLabel = new JLabel("Quantidade:");
        quantidadeLabel.setBounds(10, 80, 80, 25);
        panel.add(quantidadeLabel);

        JTextField quantidadeText = new JTextField(20);
        quantidadeText.setBounds(150, 80, 165, 25);
        panel.add(quantidadeText);

        JButton adicionarButton = new JButton("Adicionar Item");
        adicionarButton.setBounds(10, 110, 150, 25);
        panel.add(adicionarButton);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeText.getText();
                double preco = Double.parseDouble(precoText.getText());
                int quantidade = Integer.parseInt(quantidadeText.getText());

                Item item = new Item();
                item.setNome(nome);
                item.setPreco(preco);
                item.setQuantidade(quantidade);

                estoqueService.adicionarItem(item);
                JOptionPane.showMessageDialog(null, "Item adicionado com sucesso!");
            }
        });
    }
}
