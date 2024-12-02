import java.util.List;

public class RecommendationSet {
    private List<Recommendation> languages;
    private List<String> tools;
    private List<String> roadmap;
    private List<String> resources;

    public RecommendationSet(List<Recommendation> languages, List<String> tools, List<String> roadmap, List<String> resources) {
        this.languages = languages;
        this.tools = tools;
        this.roadmap = roadmap;
        this.resources = resources;
    }

    public List<Recommendation> getLanguages() {
        return languages;
    }

    public List<String> getTools() {
        return tools;
    }

    public List<String> getRoadmap() {
        return roadmap;
    }

    public List<String> getResources() {
        return resources;
    }
}
