import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendationEngine {
    private static final Map<String, Map<String, RecommendationSet>> database = new HashMap<>();

    static {
        // Configuração de recomendações para Desenvolvimento Web
        // Iniciante
        List<Recommendation> webLanguagesBeginner = new ArrayList<>();
        webLanguagesBeginner.add(new Recommendation("HTML/CSS", 100));
        webLanguagesBeginner.add(new Recommendation("JavaScript", 95));
        webLanguagesBeginner.add(new Recommendation("Python", 80));

        List<String> webToolsBeginner = List.of("Visual Studio Code", "Git", "Chrome DevTools");
        List<String> webRoadmapBeginner = List.of("1. Aprenda HTML/CSS", "2. Estude JavaScript", "3. Domine Git");
        List<String> webResourcesBeginner = List.of("Curso em Vídeo - HTML e CSS", "Rocketseat");

        // Intermediário
        List<Recommendation> webLanguagesIntermediate = new ArrayList<>();
        webLanguagesIntermediate.add(new Recommendation("JavaScript", 100));
        webLanguagesIntermediate.add(new Recommendation("React", 90));
        webLanguagesIntermediate.add(new Recommendation("Node.js", 85));

        List<String> webToolsIntermediate = List.of("Sublime Text", "Docker", "Webpack");
        List<String> webRoadmapIntermediate = List.of("1. Aprenda React", "2. Estude Node.js", "3. Implemente APIs RESTful");
        List<String> webResourcesIntermediate = List.of("freeCodeCamp", "MDN Web Docs");

        // Avançado
        List<Recommendation> webLanguagesAdvanced = new ArrayList<>();
        webLanguagesAdvanced.add(new Recommendation("TypeScript", 100));
        webLanguagesAdvanced.add(new Recommendation("GraphQL", 90));
        webLanguagesAdvanced.add(new Recommendation("NestJS", 85));

        List<String> webToolsAdvanced = List.of("Postman", "Kubernetes", "Jenkins");
        List<String> webRoadmapAdvanced = List.of("1. Aprenda TypeScript", "2. Estude GraphQL", "3. Implemente microserviços");
        List<String> webResourcesAdvanced = List.of("Pluralsight", "Egghead.io");

        // Colocando dados no banco de recomendações
        database.put("web", new HashMap<>());
        database.get("web").put("beginner", new RecommendationSet(webLanguagesBeginner, webToolsBeginner, webRoadmapBeginner, webResourcesBeginner));
        database.get("web").put("intermediate", new RecommendationSet(webLanguagesIntermediate, webToolsIntermediate, webRoadmapIntermediate, webResourcesIntermediate));
        database.get("web").put("advanced", new RecommendationSet(webLanguagesAdvanced, webToolsAdvanced, webRoadmapAdvanced, webResourcesAdvanced));

        // Configuração de recomendações para Desenvolvimento Mobile
        // Iniciante
        List<Recommendation> mobileLanguagesBeginner = new ArrayList<>();
        mobileLanguagesBeginner.add(new Recommendation("Kotlin", 90));
        mobileLanguagesBeginner.add(new Recommendation("Swift", 85));

        List<String> mobileToolsBeginner = List.of("Android Studio", "Xcode", "Git");
        List<String> mobileRoadmapBeginner = List.of("1. Aprenda Kotlin/Swift", "2. Estude Android Studio ou Xcode", "3. Crie apps simples");
        List<String> mobileResourcesBeginner = List.of("Codecademy - Kotlin", "Udemy - Desenvolvimento iOS");

        // Intermediário
        List<Recommendation> mobileLanguagesIntermediate = new ArrayList<>();
        mobileLanguagesIntermediate.add(new Recommendation("Kotlin", 100));
        mobileLanguagesIntermediate.add(new Recommendation("Flutter", 95));
        mobileLanguagesIntermediate.add(new Recommendation("React Native", 90));

        List<String> mobileToolsIntermediate = List.of("Firebase", "Android Studio", "Xcode", "Postman");
        List<String> mobileRoadmapIntermediate = List.of("1. Aprenda Flutter/React Native", "2. Estude Firebase", "3. Crie apps interativos");
        List<String> mobileResourcesIntermediate = List.of("Udacity - Android", "Flutter Documentation");

        // Avançado
        List<Recommendation> mobileLanguagesAdvanced = new ArrayList<>();
        mobileLanguagesAdvanced.add(new Recommendation("Flutter", 100));
        mobileLanguagesAdvanced.add(new Recommendation("SwiftUI", 90));
        mobileLanguagesAdvanced.add(new Recommendation("Jetpack Compose", 85));

        List<String> mobileToolsAdvanced = List.of("Firebase", "Jenkins", "GitLab CI");
        List<String> mobileRoadmapAdvanced = List.of("1. Crie apps com SwiftUI/Jetpack Compose", "2. Implemente CI/CD", "3. Aprenda arquitetura de apps");
        List<String> mobileResourcesAdvanced = List.of("Ray Wenderlich - SwiftUI", "Google Codelabs");

        // Colocando dados no banco de recomendações
        database.put("mobile", new HashMap<>());
        database.get("mobile").put("beginner", new RecommendationSet(mobileLanguagesBeginner, mobileToolsBeginner, mobileRoadmapBeginner, mobileResourcesBeginner));
        database.get("mobile").put("intermediate", new RecommendationSet(mobileLanguagesIntermediate, mobileToolsIntermediate, mobileRoadmapIntermediate, mobileResourcesIntermediate));
        database.get("mobile").put("advanced", new RecommendationSet(mobileLanguagesAdvanced, mobileToolsAdvanced, mobileRoadmapAdvanced, mobileResourcesAdvanced));

        // Configuração de recomendações para Inteligência Artificial
        // Iniciante
        List<Recommendation> aiLanguagesBeginner = new ArrayList<>();
        aiLanguagesBeginner.add(new Recommendation("Python", 100));
        aiLanguagesBeginner.add(new Recommendation("R", 80));

        List<String> aiToolsBeginner = List.of("Jupyter Notebooks", "Google Colab", "Anaconda");
        List<String> aiRoadmapBeginner = List.of("1. Aprenda Python/R", "2. Estude bibliotecas como NumPy, Pandas", "3. Experimente com Google Colab");
        List<String> aiResourcesBeginner = List.of("Coursera - AI for Everyone", "Kaggle");

        // Intermediário
        List<Recommendation> aiLanguagesIntermediate = new ArrayList<>();
        aiLanguagesIntermediate.add(new Recommendation("Python", 100));
        aiLanguagesIntermediate.add(new Recommendation("TensorFlow", 90));

        List<String> aiToolsIntermediate = List.of("TensorFlow", "Keras", "Scikit-learn");
        List<String> aiRoadmapIntermediate = List.of("1. Estude Machine Learning com Python", "2. Experimente redes neurais com TensorFlow", "3. Implemente modelos de aprendizado supervisionado");
        List<String> aiResourcesIntermediate = List.of("Udacity - Deep Learning Nanodegree", "Fast.ai");

        // Avançado
        List<Recommendation> aiLanguagesAdvanced = new ArrayList<>();
        aiLanguagesAdvanced.add(new Recommendation("TensorFlow", 100));
        aiLanguagesAdvanced.add(new Recommendation("PyTorch", 90));

        List<String> aiToolsAdvanced = List.of("TensorFlow", "PyTorch", "CUDA", "Kubernetes");
        List<String> aiRoadmapAdvanced = List.of("1. Aprenda PyTorch", "2. Implemente redes neurais convolucionais", "3. Trabalhe com GPU para IA");
        List<String> aiResourcesAdvanced = List.of("Stanford CS231n", "DeepLearning.ai");

        // Colocando dados no banco de recomendações
        database.put("ai", new HashMap<>());
        database.get("ai").put("beginner", new RecommendationSet(aiLanguagesBeginner, aiToolsBeginner, aiRoadmapBeginner, aiResourcesBeginner));
        database.get("ai").put("intermediate", new RecommendationSet(aiLanguagesIntermediate, aiToolsIntermediate, aiRoadmapIntermediate, aiResourcesIntermediate));
        database.get("ai").put("advanced", new RecommendationSet(aiLanguagesAdvanced, aiToolsAdvanced, aiRoadmapAdvanced, aiResourcesAdvanced));

        // Configuração de recomendações para Ciência de Dados
        // Iniciante
        List<Recommendation> dataLanguagesBeginner = new ArrayList<>();
        dataLanguagesBeginner.add(new Recommendation("Python", 100));
        dataLanguagesBeginner.add(new Recommendation("R", 90));

        List<String> dataToolsBeginner = List.of("Jupyter Notebooks", "Pandas", "NumPy");
        List<String> dataRoadmapBeginner = List.of("1. Aprenda Python/R", "2. Estude Pandas e NumPy", "3. Pratique com datasets simples");
        List<String> dataResourcesBeginner = List.of("Kaggle - Data Science", "Coursera - Python for Data Science");

        // Intermediário
        List<Recommendation> dataLanguagesIntermediate = new ArrayList<>();
        dataLanguagesIntermediate.add(new Recommendation("Python", 100));
        dataLanguagesIntermediate.add(new Recommendation("SQL", 90));

        List<String> dataToolsIntermediate = List.of("SQL", "Pandas", "Tableau");
        List<String> dataRoadmapIntermediate = List.of("1. Aprenda SQL", "2. Estude visualização de dados", "3. Trabalhe com projetos reais");
        List<String> dataResourcesIntermediate = List.of("DataCamp", "Kaggle - Competitions");

        // Avançado
        List<Recommendation> dataLanguagesAdvanced = new ArrayList<>();
        dataLanguagesAdvanced.add(new Recommendation("Python", 100));
        dataLanguagesAdvanced.add(new Recommendation("Scala", 85));

        List<String> dataToolsAdvanced = List.of("Spark", "Hadoop", "Kubernetes");
        List<String> dataRoadmapAdvanced = List.of("1. Estude Big Data", "2. Trabalhe com Spark e Hadoop", "3. Implemente pipelines de dados");
        List<String> dataResourcesAdvanced = List.of("Coursera - Data Engineering", "Pluralsight - Data Science");

        // Colocando dados no banco de recomendações
        database.put("data", new HashMap<>());
        database.get("data").put("beginner", new RecommendationSet(dataLanguagesBeginner, dataToolsBeginner, dataRoadmapBeginner, dataResourcesBeginner));
        database.get("data").put("intermediate", new RecommendationSet(dataLanguagesIntermediate, dataToolsIntermediate, dataRoadmapIntermediate, dataResourcesIntermediate));
        database.get("data").put("advanced", new RecommendationSet(dataLanguagesAdvanced, dataToolsAdvanced, dataRoadmapAdvanced, dataResourcesAdvanced));

        // Configuração de recomendações para Desenvolvimento de Jogos
        // Iniciante
        List<Recommendation> gameLanguagesBeginner = new ArrayList<>();
        gameLanguagesBeginner.add(new Recommendation("C#", 90));
        gameLanguagesBeginner.add(new Recommendation("Python", 80));

        List<String> gameToolsBeginner = List.of("Unity", "Unreal Engine", "Git");
        List<String> gameRoadmapBeginner = List.of("1. Aprenda C# ou Python", "2. Estude Unity ou Unreal Engine", "3. Crie um jogo simples");
        List<String> gameResourcesBeginner = List.of("Unity Learn", "Udemy - Game Development");

        // Intermediário
        List<Recommendation> gameLanguagesIntermediate = new ArrayList<>();
        gameLanguagesIntermediate.add(new Recommendation("C#", 100));
        gameLanguagesIntermediate.add(new Recommendation("C++", 90));

        List<String> gameToolsIntermediate = List.of("Unity", "Unreal Engine", "Blender");
        List<String> gameRoadmapIntermediate = List.of("1. Crie jogos com Unity", "2. Estude gráficos e animações", "3. Implemente IA de jogos");
        List<String> gameResourcesIntermediate = List.of("Gamasutra", "GameDev.net");

        // Avançado
        List<Recommendation> gameLanguagesAdvanced = new ArrayList<>();
        gameLanguagesAdvanced.add(new Recommendation("C#", 100));
        gameLanguagesAdvanced.add(new Recommendation("C++", 95));

        List<String> gameToolsAdvanced = List.of("Unity", "Unreal Engine", "Maya", "ZBrush");
        List<String> gameRoadmapAdvanced = List.of("1. Crie jogos 3D avançados", "2. Trabalhe com motores gráficos", "3. Aprenda a criar mundos virtuais");
        List<String> gameResourcesAdvanced = List.of("GDC Talks", "Advanced Unity Course");

        // Colocando dados no banco de recomendações
        database.put("game", new HashMap<>());
        database.get("game").put("beginner", new RecommendationSet(gameLanguagesBeginner, gameToolsBeginner, gameRoadmapBeginner, gameResourcesBeginner));
        database.get("game").put("intermediate", new RecommendationSet(gameLanguagesIntermediate, gameToolsIntermediate, gameRoadmapIntermediate, gameResourcesIntermediate));
        database.get("game").put("advanced", new RecommendationSet(gameLanguagesAdvanced, gameToolsAdvanced, gameRoadmapAdvanced, gameResourcesAdvanced));
    }

    public static RecommendationSet getRecommendations(String area, String level) {
        if (database.containsKey(area) && database.get(area).containsKey(level)) {
            return database.get(area).get(level);
        }
        return null;
    }
}
