public abstract class VisualizadorLog {

    // Método abstrato para obter o conteúdo do log. Deve ser implementado pelas subclasses.
    public abstract String obterConteudoLog();

    // Método concreto para exibir o log. Usa o método obter Conteúdo Log para buscar o conteúdo e exibi-lo
    public void exibirLog() {
        String conteudoLog = obterConteudoLog(); // Obtém o conteúdo do log
        if (conteudoLog != null && !conteudoLog.isEmpty()) {
            System.out.println("=== Log ===");
            System.out.println(conteudoLog); // Exibe o conteúdo do log
        } else {
            System.out.println("Não há conteúdo no log."); // Caso o log esteja vazio
        }
    }
}
