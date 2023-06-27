import java.util.ArrayList;
import java.util.List;

public class Report {
    private List<Prenotazione> prenotazioni;

    public Report() {
        this.prenotazioni = new ArrayList<>();
    }

    public void addPrenotazione(Prenotazione prenotazione) {
        prenotazioni.add(prenotazione);
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }
}
