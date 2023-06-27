import java.util.List;

public class DotazioneView {
    public void displayDotazioni(List<Dotazione> dotazioni) {
        System.out.println("Lista delle dotazioni:");
        for (Dotazione dotazione : dotazioni) {
            System.out.println(dotazione);
        }
    }

    public void displayDotazione(Dotazione dotazione) {
        System.out.println("Dettagli della dotazione:");
        System.out.println(dotazione);
    }
}
