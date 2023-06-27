import java.util.List;
import java.util.Scanner;

public class DocenteController {
    private DocenteManager docenteManager;

    public DocenteController() {
        docenteManager = new DocenteManager();
    }

    public void menuDocenti(Scanner scanner) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nGestione dei Docenti:");
            System.out.println("1. Visualizza tutti i docenti");
            System.out.println("2. Inserisci un nuovo docente");
            System.out.println("0. Torna al menu principale\n");

            System.out.print("Inserisci la tua scelta: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    visualizzaDocenti();
                    break;
                case 2:
                    inserisciDocente(scanner);
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

    private void visualizzaDocenti() {
        List<Docente> docenti = docenteManager.getDocenti();

        System.out.println("\nElenco dei docenti:");
        for (Docente docente : docenti) {
            System.out.println(docente.toString());
        }
    }

    private void inserisciDocente(Scanner scanner) {
        System.out.print("Inserisci il nome del docente: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci il cognome del docente: ");
        String cognome = scanner.nextLine();

        System.out.print("Inserisci la matricola del docente: ");
        String matricola = scanner.nextLine();

        // Creazione di una nuova istanza di Docente
        Docente docente = new Docente(nome, cognome, matricola);

        // Aggiunta del docente al gestore dei docenti
        docenteManager.aggiungiDocente(docente);

        System.out.println("Docente inserito correttamente.");
    }
}
