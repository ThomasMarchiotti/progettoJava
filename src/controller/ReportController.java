import java.util.List;
import java.util.Scanner;

public class ReportController {
    private PrenotazioneManager prenotazioneManager;
    private AulaManager aulaManager;
    private DocenteManager docenteManager;

    public ReportController() {
        prenotazioneManager = new PrenotazioneManager();
        aulaManager = new AulaManager();
        docenteManager = new DocenteManager();
    }

    public void menuReport(Scanner scanner) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nGestione dei Report:");
            System.out.println("1. Report delle prenotazioni per un'aula in una data");
            System.out.println("2. Report delle prenotazioni per un docente in una data");
            System.out.println("0. Torna al menu principale\n");

            System.out.print("Inserisci la tua scelta: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    reportPrenotazioniAula(scanner);
                    break;
                case 2:
                    reportPrenotazioniDocente(scanner);
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

    private void reportPrenotazioniAula(Scanner scanner) {
        System.out.print("Inserisci il nome dell'aula: ");
        String nomeAula = scanner.nextLine();

        System.out.print("Inserisci la data delle prenotazioni (dd/mm/yyyy): ");
        String data = scanner.nextLine();

        Aula aula = aulaManager.getAulaByNome(nomeAula);
        if (aula == null) {
            System.out.println("L'aula con nome " + nomeAula + " non esiste nel sistema.");
            return;
        }

        List<Prenotazione> prenotazioni = prenotazioneManager.getPrenotazioniByAulaData(aula, data);

        if (prenotazioni.isEmpty()) {
            System.out.println("Nessuna prenotazione trovata per l'aula " + nomeAula + " nella data " + data);
        } else {
            System.out.println("\nReport delle prenotazioni per l'aula " + nomeAula + " nella data " + data + ":");
            for (Prenotazione prenotazione : prenotazioni) {
                System.out.println(prenotazione.toString());
            }
        }
    }

    private void reportPrenotazioniDocente(Scanner scanner) {
        System.out.print("Inserisci la matricola del docente: ");
        String matricolaDocente = scanner.nextLine();

        System.out.print("Inserisci la data delle prenotazioni (dd/mm/yyyy): ");
        String data = scanner.nextLine();

        Docente docente = docenteManager.getDocenteByMatricola(matricolaDocente);
        if (docente == null) {
            System.out.println("Il docente con matricola " + matricolaDocente + " non esiste nel sistema.");
            return;
        }

        List<Prenotazione> prenotazioni = prenotazioneManager.getPrenotazioniByDocenteData(docente, data);

        if (prenotazioni.isEmpty()) {
            System.out.println("Nessuna prenotazione trovata per il docente con matricola " + matricolaDocente + " nella data " + data);
        } else {
            System.out.println("\nReport delle prenotazioni per il docente con matricola " + matricolaDocente + " nella data " + data + ":");
            for (Prenotazione prenotazione : prenotazioni) {
                System.out.println(prenotazione.toString());
            }
        }
    }
}
