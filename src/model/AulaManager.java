import java.util.ArrayList;
import java.util.List;

public class AulaManager {
    private List<Aula> aule;

    public AulaManager() {
        this.aule = new ArrayList<>();
    }

    public void inserisciAula(Aula aula) {
        aule.add(aula);
    }

    public List<Aula> getAule() {
        return aule;
    }

    public List<Aula> ricercaAuleLibere(LocalDateTime dataOraInizio, LocalDateTime dataOraFine, int capienzaMinima, List<String> dotazioni) {
        List<Aula> auleLibere = new ArrayList<>();

        for (Aula aula : aule) {
            boolean aulaOccupata = false;

            for (Prenotazione prenotazione : aula.getPrenotazioni()) {
                if (prenotazione.getDataOraInizio().isBefore(dataOraFine) && prenotazione.getDataOraFine().isAfter(dataOraInizio)) {
                    aulaOccupata = true;
                    break;
                }
            }

            if (!aulaOccupata && aula.getCapienza() >= capienzaMinima && aula.getDotazioni().containsAll(dotazioni)) {
                auleLibere.add(aula);
            }
        }

        return auleLibere;
    }

    public void prenotaAula(Aula aula, Docente docente, LocalDateTime dataOraInizio, LocalDateTime dataOraFine) {
        Prenotazione prenotazione = new Prenotazione(aula, docente, dataOraInizio, dataOraFine);
        aula.addPrenotazione(prenotazione);
    }

    public Report generateReportByAula(Aula aula, LocalDate date) {
        Report report = new Report();

        for (Prenotazione prenotazione : aula.getPrenotazioni()) {
            if (prenotazione.getDataOraInizio().toLocalDate().equals(date)) {
                report.addPrenotazione(prenotazione);
            }
        }

        return report;
    }

    public Report generateReportByDocente(Docente docente, LocalDate date) {
        Report report = new Report();

        for (Aula aula : aule) {
            for (Prenotazione prenotazione : aula.getPrenotazioni()) {
                if (prenotazione.getDataOraInizio().toLocalDate().equals(date) && prenotazione.getDocente().equals(docente)) {
                    report.addPrenotazione(prenotazione);
                }
            }
        }

        return report;
    }
}
