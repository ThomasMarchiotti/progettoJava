import java.util.ArrayList;
import java.util.List;

public class DocenteManager {
    private List<Docente> docenti;

    public DocenteManager() {
        this.docenti = new ArrayList<>();
    }

    public void inserisciDocente(Docente docente) {
        docenti.add(docente);
    }

    public List<Docente> getDocenti() {
        return docenti;
    }
}
