import java.util.ArrayList; // Importa a classe ArrayList, que permite criar listas dinâmicas
import java.util.Scanner;   // Importa a classe Scanner para ler entradas do usuário

// Classe principal do programa To-Do List
public class ToDoList {

    // Lista de tarefas (ArrayList que guarda Strings)
    private static ArrayList<String> tasks = new ArrayList<>();

    // Scanner para ler entradas do usuário pelo terminal
    private static Scanner sc = new Scanner(System.in);

    // Método principal: ponto de entrada do programa
    public static void main(String[] args) {
        // Loop infinito para exibir o menu continuamente até o usuário escolher sair
        while (true) {
            displayMenu();           // Chama o método que mostra o menu
            int choice = sc.nextInt(); // Lê a escolha do usuário
            sc.nextLine();            // Consome o ENTER que fica pendente no buffer

            // Estrutura switch para escolher a ação com base na opção digitada
            switch (choice) {
                case 1 -> addTask();           // Adicionar uma tarefa
                case 2 -> viewTasks();         // Visualizar todas as tarefas
                case 3 -> markTaskComplete();  // Marcar uma tarefa como concluída
                case 4 -> deleteTask();        // Deletar uma tarefa
                case 5 -> {                    // Sair do programa
                    System.out.println("Saindo... Até logo!");
                    return;                   // Encerra o método main, finalizando o programa
                }
                default -> System.out.println("Opção inválida. Tente novamente."); // Caso a opção seja inválida
            }
        }
    }

    // Método que exibe o menu principal para o usuário
    public static void displayMenu() {
        System.out.println("\n--- Menu da Lista de Tarefas ---");
        System.out.println("1. Adicionar uma tarefa");
        System.out.println("2. Visualizar todas as tarefas");
        System.out.println("3. Marcar uma tarefa como concluída");
        System.out.println("4. Deletar uma tarefa");
        System.out.println("5. Sair");
        System.out.print("Digite sua escolha: ");
    }

    // Método para adicionar uma tarefa à lista
    public static void addTask() {
        System.out.print("Digite a tarefa: ");      // Solicita a tarefa ao usuário
        String task = sc.nextLine();                // Lê a entrada do usuário
        tasks.add(task);                            // Adiciona a tarefa à lista
        System.out.println("Tarefa adicionada com sucesso!");
    }

    // Método para visualizar todas as tarefas
    public static void viewTasks() {
        if (tasks.isEmpty()) {                      // Verifica se a lista está vazia
            System.out.println("Nenhuma tarefa disponível.");
            return;                                 // Sai do método se não houver tarefas
        }
        System.out.println("\n--- Suas Tarefas ---");
        for (int i = 0; i < tasks.size(); i++) {   // Percorre todas as tarefas da lista
            System.out.println((i + 1) + ". " + tasks.get(i)); // Exibe cada tarefa numerada
        }
    }

    // Método para marcar uma tarefa como concluída
    public static void markTaskComplete() {
        if (tasks.isEmpty()) {                      // Verifica se há tarefas
            System.out.println("Nenhuma tarefa disponível.");
            return;
        }
        viewTasks();                                // Exibe todas as tarefas
        System.out.print("Digite o número da tarefa para marcar como concluída: ");
        int taskNumber = sc.nextInt();             // Lê o número da tarefa
        sc.nextLine();                              // Limpa o buffer do ENTER

        // Validação do número da tarefa
        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            System.out.println("Número de tarefa inválido.");
        } else {
            // Marca a tarefa como concluída adicionando "[Concluída]" no final
            String completedTask = tasks.get(taskNumber - 1) + " [Concluída]";
            tasks.set(taskNumber - 1, completedTask); // Atualiza a tarefa na lista
            System.out.println("Tarefa marcada como concluída!");
        }
    }

    // Método para deletar uma tarefa
    public static void deleteTask() {
        if (tasks.isEmpty()) {                      // Verifica se há tarefas
            System.out.println("Nenhuma tarefa disponível.");
            return;
        }
        viewTasks();                                // Mostra todas as tarefas
        System.out.print("Digite o número da tarefa para deletar: ");
        int taskNumber = sc.nextInt();             // Lê o número da tarefa
        sc.nextLine();                              // Limpa o buffer do ENTER

        // Validação do número da tarefa
        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            System.out.println("Número de tarefa inválido.");
        } else {
            tasks.remove(taskNumber - 1);          // Remove a tarefa da lista
            System.out.println("Tarefa deletada com sucesso.");
        }
    }
}
