import java.util.List;

public class RecommendationEngineCombinedManualTest {

    public static void main(String[] args) {
        testRecommendationEngineFunctionality();
    }

    private static void testRecommendationEngineFunctionality() {
        System.out.println("=== Testando RecommendationEngine ===");

        // Teste 1: Verificação para entradas válidas (web, beginner)
        try {
            RecommendationSet webBeginner = RecommendationEngine.getRecommendations("web", "beginner");
            if (webBeginner == null) {
                throw new AssertionError("As recomendações para 'web' no nível 'beginner' não deveriam ser nulas.");
            }
            if (webBeginner.getLanguages().size() != 3) {
                throw new AssertionError("Deveria haver 3 linguagens recomendadas para 'web' no nível 'beginner'.");
            }
            if (!"HTML/CSS".equals(webBeginner.getLanguages().get(0).getLanguage())) {
                throw new AssertionError("A primeira linguagem deveria ser 'HTML/CSS'.");
            }
            System.out.println("✓ Teste 1 passou.");
        } catch (AssertionError e) {
            System.out.println("✗ Teste 1 falhou: " + e.getMessage());
        }

        // Teste 2: Entrada inválida para área
        try {
            RecommendationSet invalidArea = RecommendationEngine.getRecommendations("invalid", "beginner");
            if (invalidArea != null) {
                throw new AssertionError("Deveria retornar nulo para uma área inválida.");
            }
            System.out.println("✓ Teste 2 passou.");
        } catch (AssertionError e) {
            System.out.println("✗ Teste 2 falhou: " + e.getMessage());
        }

        // Teste 3: Entrada inválida para nível
        try {
            RecommendationSet invalidLevel = RecommendationEngine.getRecommendations("web", "invalid");
            if (invalidLevel != null) {
                throw new AssertionError("Deveria retornar nulo para um nível inválido.");
            }
            System.out.println("✓ Teste 3 passou.");
        } catch (AssertionError e) {
            System.out.println("✗ Teste 3 falhou: " + e.getMessage());
        }

        // Teste 4: Entrada nula
        try {
            RecommendationEngine.getRecommendations(null, "beginner");
            System.out.println("✗ Teste 4A falhou: Deveria lançar IllegalArgumentException para entrada nula de área.");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Teste 4A passou.");
        } catch (Exception e) {
            System.out.println("✗ Teste 4A falhou: Exceção inesperada lançada: " + e.getMessage());
        }

        try {
            RecommendationEngine.getRecommendations("web", null);
            System.out.println("✗ Teste 4B falhou: Deveria lançar IllegalArgumentException para entrada nula de nível.");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Teste 4B passou.");
        } catch (Exception e) {
            System.out.println("✗ Teste 4B falhou: Exceção inesperada lançada: " + e.getMessage());
        }

        // Teste 5: Verificação da integridade de RecommendationSet
        try {
            Recommendation recommendation1 = new Recommendation("JavaScript", 100);
            Recommendation recommendation2 = new Recommendation("Python", 90);
            List<Recommendation> languages = List.of(recommendation1, recommendation2);
            List<String> tools = List.of("Git", "VS Code");
            List<String> roadmap = List.of("Aprenda JavaScript", "Aprenda Python");
            List<String> resources = List.of("FreeCodeCamp", "Coursera");

            RecommendationSet recommendationSet = new RecommendationSet(languages, tools, roadmap, resources);

            if (recommendationSet.getLanguages().size() != 2) {
                throw new AssertionError("O conjunto deveria conter 2 linguagens.");
            }
            if (!"JavaScript".equals(recommendationSet.getLanguages().get(0).getLanguage())) {
                throw new AssertionError("A primeira linguagem deveria ser JavaScript.");
            }
            if (!"Git".equals(recommendationSet.getTools().get(0))) {
                throw new AssertionError("A primeira ferramenta deveria ser Git.");
            }
            if (!"Aprenda JavaScript".equals(recommendationSet.getRoadmap().get(0))) {
                throw new AssertionError("O primeiro passo do roadmap deveria ser 'Aprenda JavaScript'.");
            }
            System.out.println("✓ Teste 5 passou.");
        } catch (AssertionError e) {
            System.out.println("✗ Teste 5 falhou: " + e.getMessage());
        }

        System.out.println("=== Testes Concluídos ===");
    }
}
