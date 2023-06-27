import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AulaController aulaController = new AulaController();
        DocenteController docenteController = new DocenteController();
        DotazioneController dotazioneController = new DotazioneController();
        PrenotazioneController prenotazioneController = new PrenotazioneController();
        ReportController reportController = new ReportController();

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Benvenuto nell'applicazione di gestione delle aule universitarie!\n");
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Gestione delle aule");
            System.out.println("2. Gestione dei docenti");
            System.out.println("3. Gestione delle dotazioni");
            System.out.println("4. Prenotazione delle aule");
            System.out.println("5. Generazione dei report");
            System.out.println("0. Esci\n");

            System.out.print("Inserisci la tua scelta: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    aulaController.menuAule(scanner);
                    break;
                case 2:
                    docenteController.menuDocenti(scanner);
                    break;
                case 3:
                    dotazioneController.menuDotazioni(scanner);
                    break;
                case 4:
                    prenotazioneController.menuPrenotazioni(scanner);
                    break;
                case 5:
                    reportController.menuReport(scanner);
                    break;
                case 0:
                    isRunning = false;
                    System.out.println("Grazie per aver utilizzato l'applicazione! Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.\n");
                    break;
            }
        }

        scanner.close();
    }
}
