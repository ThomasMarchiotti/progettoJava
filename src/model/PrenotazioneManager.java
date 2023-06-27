import java.util.ArrayList;
import java.util.List;

public class PrenotazioneManager {
    private List<Prenotazione> prenotazioni;

    public PrenotazioneManager() {
        this.prenotazioni = new ArrayList<>();
    }

    public void inserisciPrenotazione(Prenotazione prenotazione) {
        prenotazioni.add(prenotazione);
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }
}
