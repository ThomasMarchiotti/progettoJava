import java.util.List;
import java.util.Scanner;

public class AulaController {
    private AulaManager aulaManager;

    public AulaController() {
        aulaManager = new AulaManager();
    }

    public void menuAule(Scanner scanner) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nGestione delle Aule:");
            System.out.println("1. Visualizza tutte le aule");
            System.out.println("2. Inserisci una nuova aula");
            System.out.println("0. Torna al menu principale\n");

            System.out.print("Inserisci la tua scelta: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    visualizzaAule();
                    break;
                case 2:
                    inserisciAula(scanner);
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.\n");
                    break;
            }
        }
    }

    private void visualizzaAule() {
        List<Aula> aule = aulaManager.getAule();

        System.out.println("\nElenco delle aule:");
        for (Aula aula : aule) {
            System.out.println(aula.toString());
        }
    }

    private void inserisciAula(Scanner scanner) {
        System.out.print("Inserisci il nome dell'aula: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci la capienza dell'aula: ");
        int capienza = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Creazione di una nuova istanza di Aula
        Aula aula = new Aula(nome, capienza);

        // Aggiunta dell'aula al gestore delle aule
        aulaManager.aggiungiAula(aula);

        System.out.println("Aula inserita correttamente.");
    }
}
