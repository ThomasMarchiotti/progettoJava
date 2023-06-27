import java.util.ArrayList;
import java.util.List;

public class DotazioneManager {
    private List<Dotazione> dotazioni;

    public DotazioneManager() {
        this.dotazioni = new ArrayList<>();
    }

    public void inserisciDotazione(Dotazione dotazione) {
        dotazioni.add(dotazione);
    }

    public List<Dotazione> getDotazioni() {
        return dotazioni;
    }
}
