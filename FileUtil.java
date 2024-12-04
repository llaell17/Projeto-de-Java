import java.io.*;

public class FileUtil {

    private static final String FILE_NAME = "recommendation_log.txt";

    // Método para escrever texto no arquivo
    public static void writeToFile(String text) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME,  true))) {
            writer.println(text);
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }


    // Método para ler todo o conteúdo do arquivo
    public static String readFile() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return content.toString();
    }

    // Método para obter o nome do arquivo
    public static String getFileName() {
        return FILE_NAME;
    }

    // Método para limpar o conteúdo do arquivo
    public static void clearFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, false))) {
            // Sobrescreve o arquivo com nada
        } catch (IOException e) {
            System.out.println("Erro ao limpar o arquivo: " + e.getMessage());
        }
    }

}
