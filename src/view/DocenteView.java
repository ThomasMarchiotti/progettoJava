import java.util.List;

public class DocenteView {
    public void displayDocenti(List<Docente> docenti) {
        System.out.println("Lista dei docenti:");
        for (Docente docente : docenti) {
            System.out.println(docente);
        }
    }

    public void displayDocente(Docente docente) {
        System.out.println("Dettagli del docente:");
        System.out.println(docente);
    }
}
