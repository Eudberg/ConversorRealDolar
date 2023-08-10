import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ParteGrafica extends JFrame {
    private JMenuBar BarraDoMenuSuperior;
    private JMenu MenuPrincipal;
    private JMenuItem opcao1;
    private JMenuItem opcao2;
    private JMenuItem opcao3;

    public static int exibirMenu() {
        String[] opcoes = { "Real para Dólar", "Dólar para Real", "Sair" };
        return JOptionPane.showOptionDialog(null, "Escolha uma opção", "Conversor de Moedas", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
    }

    public ParteGrafica() {
        setSize(300, 200);
        setTitle("Conversor de Moedas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel painel = new JPanel();

        painel.setBackground(Color.YELLOW);

        abrirMenu();
        painel.add(BarraDoMenuSuperior);
        add(painel);
    }

    public void abrirMenu() {
        BarraDoMenuSuperior = new JMenuBar();
        MenuPrincipal = new JMenu("Escolha uma opção!");
        opcao1 = new JMenuItem("Real para Dollar");
        opcao2 = new JMenuItem("Dollar para Real");
        opcao3 = new JMenuItem("Sair");

        MenuPrincipal.add(opcao1);
        MenuPrincipal.add(opcao2);
        MenuPrincipal.add(opcao3);

        BarraDoMenuSuperior.add(MenuPrincipal);

        opcao1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String realValorStr = JOptionPane.showInputDialog(null, "Digite o valor em Reais:");
                try {
                    double valorReal = Double.parseDouble(realValorStr);
                    double valorDolar = valorReal * 0.20;
                    JOptionPane.showMessageDialog(null, String.format("O valor é: %.2f dólares", valorDolar));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Valor inválido");
                }
            }
        });

        opcao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dolarValorStr = JOptionPane.showInputDialog(null, "Digite o valor em Dólares:");
                try {
                    double valorDolar = Double.parseDouble(dolarValorStr);
                    double valorReal = valorDolar * 4.89;
                    JOptionPane.showMessageDialog(null, String.format("O valor é:  %.2f reais", valorReal));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Valor inválido");
                }
            }
        });

        opcao3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Obrigado por utilizar o conversor!");
                System.exit(0); // Fechar o programa ao selecionar "Sair"
            }
        });

    }

    public static void main(String[] args) {
        ParteGrafica janela = new ParteGrafica();

        // Definir a cor de fundo do JFrame como preto
        janela.getContentPane().setBackground(Color.BLACK);

        // Exibir a janela
        janela.setVisible(true);
    }
}
