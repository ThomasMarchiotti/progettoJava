import java.util.List;

public class AulaView {
    public void displayAule(List<Aula> aule) {
        System.out.println("Lista delle aule:");
        for (Aula aula : aule) {
            System.out.println(aula);
        }
    }

    public void displayAula(Aula aula) {
        System.out.println("Dettagli dell'aula:");
        System.out.println(aula);
    }
}
