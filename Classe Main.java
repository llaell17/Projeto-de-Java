import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        try {
            UserInput userInput = new UserInput();
            System.out.println("Bem-vindo ao Recomendador de Linguagens de Programação!");

            String area = userInput.askArea();
            if (area == null) {
                System.out.println("Área inválida. Encerrando...");
                return;
            }

            String level = userInput.askLevel();
            if (level == null) {
                System.out.println("Nível inválido. Encerrando...");
                return;
            }

            RecommendationSet recommendations = RecommendationEngine.getRecommendations(area, level);
            if (recommendations == null) {
                System.out.println("Desculpe, não há recomendações disponíveis para essa combinação.");
                return;
            }

            // Criação do arquivo para salvar as recomendações
            try (FileWriter writer = new FileWriter("recomendacoes_linguagens.txt", false)) {
                writer.write("=== Linguagens Recomendadas ===\n");
                Iterator<Recommendation> languages = recommendations.getLanguages().iterator();
                while (languages.hasNext()) {
                    Recommendation language = languages.next();
                    writer.write(language + "\n");
                }

                writer.write("\n=== Ferramentas Recomendadas ===\n");
                Iterator<String> tools = recommendations.getTools().iterator();
                while (tools.hasNext()) {
                    String tool = tools.next();
                    writer.write("- " + tool + "\n");
                }

                writer.write("\n=== Roadmap ===\n");
                Iterator<String> roadmap = recommendations.getRoadmap().iterator();
                while (roadmap.hasNext()) {
                    String step = roadmap.next();
                    writer.write(step + "\n");
                }

                writer.write("\n=== Recursos de Aprendizado ===\n");
                Iterator<String> resources = recommendations.getResources().iterator();
                while (resources.hasNext()) {
                    String resource = resources.next();
                    writer.write("- " + resource + "\n");
                }

                // Mensagem de confirmação
                System.out.println("Recomendações salvas no arquivo 'recomendacoes_linguagens.txt'.");
            } catch (IOException e) {
                System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
            }

        } catch (NullPointerException e) {
            System.out.println("Erro: Um valor esperado era nulo. Verifique os dados fornecidos.");
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        } finally {
            System.out.println("Encerrando o programa. Obrigado por utilizar o Recomendador!");
        }
    }
}
