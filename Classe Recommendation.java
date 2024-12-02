public class Recommendation {
    private String language;
    private int compatibility;

    public Recommendation(String language, int compatibility) {
        this.language = language;
        this.compatibility = compatibility;
    }

    public String getLanguage() {
        return language;
    }

    public int getCompatibility() {
        return compatibility;
    }

    @Override
    public String toString() {
        return "Linguagem: " + language + " | Compatibilidade: " + compatibility + "%";
    }
}
