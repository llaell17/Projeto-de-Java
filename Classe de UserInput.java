import java.util.Scanner;

public class UserInput {
    private Scanner scanner = new Scanner(System.in);

    public String askArea() {
        System.out.println("Escolha uma área de interesse:");
        System.out.println("1. Desenvolvimento Web");
        System.out.println("2. Desenvolvimento Mobile");
        System.out.println("3. Inteligência Artificial");
        System.out.println("4. Ciência de Dados");
        System.out.println("5. Desenvolvimento de Jogos");
        int choice = scanner.nextInt();

        return switch (choice) {
            case 1 -> "web";
            case 2 -> "mobile";
            case 3 -> "ai";
            case 4 -> "data";
            case 5 -> "game";
            default -> null;
        };
    }

    public String askLevel() {
        System.out.println("Qual o seu nível de experiência?");
        System.out.println("1. Iniciante");
        System.out.println("2. Intermediário");
        System.out.println("3. Avançado");
        int choice = scanner.nextInt();

        return switch (choice) {
            case 1 -> "beginner";
            case 2 -> "intermediate";
            case 3 -> "advanced";
            default -> null;
        };
    }
}
