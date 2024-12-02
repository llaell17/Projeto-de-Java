import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class RecommendationUI extends JFrame {

    private JComboBox<String> areaComboBox;
    private JComboBox<String> levelComboBox;
    private JTextArea recommendationTextArea;

    public RecommendationUI() {
        setTitle("Recomendador de Linguagens de Programação");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centraliza a janela na tela
        setLayout(new BorderLayout());

        // Painel de entrada
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel areaLabel = new JLabel("Escolha a área de interesse:");
        areaComboBox = new JComboBox<>(new String[] {
                "Desenvolvimento Web", "Desenvolvimento Mobile", "Inteligência Artificial",
                "Ciência de Dados", "Desenvolvimento de Jogos"
        });

        JLabel levelLabel = new JLabel("Escolha o nível de experiência:");
        levelComboBox = new JComboBox<>(new String[] {
                "Iniciante", "Intermediário", "Avançado"
        });

        JButton recommendButton = new JButton("Mostrar Recomendações");

        inputPanel.add(areaLabel);
        inputPanel.add(areaComboBox);
        inputPanel.add(levelLabel);
        inputPanel.add(levelComboBox);
        inputPanel.add(new JLabel());  // Célula vazia
        inputPanel.add(recommendButton);

        // Área de texto para exibição das recomendações
        recommendationTextArea = new JTextArea();
        recommendationTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(recommendationTextArea);

        // Adiciona os componentes à janela
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Ação do botão para mostrar recomendações
        recommendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedArea = getAreaFromComboBox(areaComboBox.getSelectedIndex());
                    String selectedLevel = getLevelFromComboBox(levelComboBox.getSelectedIndex());

                    if (selectedArea == null || selectedLevel == null) {
                        throw new IllegalArgumentException("Área ou nível selecionado inválido.");
                    }

                    RecommendationSet recommendations = RecommendationEngine.getRecommendations(selectedArea, selectedLevel);

                    if (recommendations != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("=== Linguagens Recomendadas ===\n");
                        for (Recommendation language : recommendations.getLanguages()) {
                            sb.append(language).append("\n");
                        }

                        sb.append("\n=== Ferramentas Recomendadas ===\n");
                        for (String tool : recommendations.getTools()) {
                            sb.append("- ").append(tool).append("\n");
                        }

                        sb.append("\n=== Roadmap ===\n");
                        for (String step : recommendations.getRoadmap()) {
                            sb.append(step).append("\n");
                        }

                        sb.append("\n=== Recursos de Aprendizado ===\n");
                        for (String resource : recommendations.getResources()) {
                            sb.append("- ").append(resource).append("\n");
                        }

                        // Exibe as recomendações na interface
                        recommendationTextArea.setText(sb.toString());

                        // Salva as recomendações em um arquivo
                        saveRecommendationsToFile(sb.toString());
                    } else {
                        recommendationTextArea.setText("Desculpe, não há recomendações disponíveis para essa combinação.");
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(RecommendationUI.this, ex.getMessage(), "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(RecommendationUI.this, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Método para mapear o índice da combobox para a área
    private String getAreaFromComboBox(int selectedIndex) {
        switch (selectedIndex) {
            case 0: return "web";
            case 1: return "mobile";
            case 2: return "ai";
            case 3: return "data";
            case 4: return "game";
            default: return null;
        }
    }

    // Método para mapear o índice da combobox para o nível
    private String getLevelFromComboBox(int selectedIndex) {
        switch (selectedIndex) {
            case 0: return "beginner";
            case 1: return "intermediate";
            case 2: return "advanced";
            default: return null;
        }
    }

    // Método para salvar as recomendações em um arquivo
    private void saveRecommendationsToFile(String recommendations) {
        try (FileWriter writer = new FileWriter("recomendacoes_linguagens.txt", false)) {
            writer.write(recommendations);
            JOptionPane.showMessageDialog(this, "Recomendações salvas no arquivo 'recomendacoes_linguagens.txt'.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao gravar no arquivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RecommendationUI ui = new RecommendationUI();
                ui.setVisible(true);
            }
        });
    }
}
