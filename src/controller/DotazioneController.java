import java.util.List;
import java.util.Scanner;

public class DotazioneController {
    private DotazioneManager dotazioneManager;

    public DotazioneController() {
        dotazioneManager = new DotazioneManager();
    }

    public void menuDotazioni(Scanner scanner) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nGestione delle Dotazioni:");
            System.out.println("1. Visualizza tutte le dotazioni");
            System.out.println("2. Inserisci una nuova dotazione");
            System.out.println("0. Torna al menu principale\n");

            System.out.print("Inserisci la tua scelta: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    visualizzaDotazioni();
                    break;
                case 2:
                    inserisciDotazione(scanner);
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

    private void visualizzaDotazioni() {
        List<Dotazione> dotazioni = dotazioneManager.getDotazioni();

        System.out.println("\nElenco delle dotazioni:");
        for (Dotazione dotazione : dotazioni) {
            System.out.println(dotazione.toString());
        }
    }

    private void inserisciDotazione(Scanner scanner) {
        System.out.print("Inserisci il nome della dotazione: ");
        String nome = scanner.nextLine();

        // Creazione di una nuova istanza di Dotazione
        Dotazione dotazione = new Dotazione(nome);

        // Aggiunta della dotazione al gestore delle dotazioni
        dotazioneManager.aggiungiDotazione(dotazione);

        System.out.println("Dotazione inserita correttamente.");
    }
}
