package View;

import Model.ListarTarefas;
import Model.Tarefa;

import javax.swing.*;
import java.awt.*;

public class TarefasView extends JFrame {

    private JPanel listaPanel;
    private JPanel root;
    private ListarTarefas listarTarefasServico;

    public TarefasView(){
        setTitle("Lista");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,500);
        listarTarefasServico = new ListarTarefas();
        configurarJanela();
    }

    private void configurarJanela() {
        listaPanel = new JPanel();
        root = new JPanel();
        root.setLayout(new BorderLayout());
        listaPanel.setLayout(new BoxLayout(listaPanel,BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(listaPanel);
        popularLista();

        root.add(obterHeader(), BorderLayout.NORTH);
        root.add(scrollPane, BorderLayout.CENTER);

        add(root);
    }

    private JPanel obterHeader(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel.add(new JLabel("Tarefas"));
        panel.add(new JButton("Adicionar Tarefa"));
        panel.setPreferredSize(new Dimension(290,40));
        panel.setSize(290,20);
        return panel;
    }

    private void popularLista(){
        for(Tarefa tarefa : listarTarefasServico.obterTodos()){
            listaPanel.add(criarItemDaLista(tarefa));
        }
    }

    private JPanel criarItemDaLista(Tarefa item){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        JCheckBox checkBox = new JCheckBox();
        checkBox.setSelected(item.isConcluido());
        JLabel label = new JLabel(item.getDescricao());
        panel.add(checkBox);
        panel.add(label);
        panel.setPreferredSize(new Dimension(290,20));
        return panel;
    }

}
