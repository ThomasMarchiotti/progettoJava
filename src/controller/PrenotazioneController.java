import java.util.List;
import java.util.Scanner;

public class PrenotazioneController {
    private PrenotazioneManager prenotazioneManager;
    private AulaManager aulaManager;
    private DocenteManager docenteManager;

    public PrenotazioneController() {
        prenotazioneManager = new PrenotazioneManager();
        aulaManager = new AulaManager();
        docenteManager = new DocenteManager();
    }

    public void menuPrenotazioni(Scanner scanner) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nPrenotazione delle Aule:");
            System.out.println("1. Visualizza tutte le prenotazioni");
            System.out.println("2. Effettua una prenotazione");
            System.out.println("0. Torna al menu principale\n");

            System.out.print("Inserisci la tua scelta: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    visualizzaPrenotazioni();
                    break;
                case 2:
                    effettuaPrenotazione(scanner);
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

    private void visualizzaPrenotazioni() {
        List<Prenotazione> prenotazioni = prenotazioneManager.getPrenotazioni();

        System.out.println("\nElenco delle prenotazioni:");
        for (Prenotazione prenotazione : prenotazioni) {
            System.out.println(prenotazione.toString());
        }
    }

    private void effettuaPrenotazione(Scanner scanner) {
        System.out.print("Inserisci la matricola del docente che effettua la prenotazione: ");
        String matricolaDocente = scanner.nextLine();

        // Verifica se il docente esiste nel sistema
        Docente docente = docenteManager.getDocenteByMatricola(matricolaDocente);
        if (docente == null) {
            System.out.println("Il docente con matricola " + matricolaDocente + " non esiste nel sistema.");
            return;
        }

        System.out.print("Inserisci il nome dell'aula da prenotare: ");
        String nomeAula = scanner.nextLine();

        // Verifica se l'aula esiste nel sistema
        Aula aula = aulaManager.getAulaByNome(nomeAula);
        if (aula == null) {
            System.out.println("L'aula con nome " + nomeAula + " non esiste nel sistema.");
            return;
        }

        System.out.print("Inserisci la data della prenotazione (dd/mm/yyyy): ");
        String data = scanner.nextLine();

        System.out.print("Inserisci l'orario di inizio della prenotazione (hh:mm): ");
        String orarioInizio = scanner.nextLine();

        System.out.print("Inserisci l'orario di fine della prenotazione (hh:mm): ");
        String orarioFine = scanner.nextLine();

        // Creazione di una nuova istanza di Prenotazione
        Prenotazione prenotazione = new Prenotazione(docente, aula, data, orarioInizio, orarioFine);

        // Aggiunta della prenotazione al gestore delle prenotazioni
        boolean successo = prenotazioneManager.aggiungiPrenotazione(prenotazione);

        if (successo) {
            System.out.println("Prenotazione effettuata correttamente.");
        } else {
            System.out.println("Impossibile effettuare la prenotazione. L'aula è già prenotata in quell'orario.");
        }
    }
}
