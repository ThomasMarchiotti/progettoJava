import java.time.LocalDateTime;

public class Prenotazione {
    private Aula aula;
    private Docente docente;
    private LocalDateTime dataOraInizio;
    private LocalDateTime dataOraFine;

    public Prenotazione(Aula aula, Docente docente, LocalDateTime dataOraInizio, LocalDateTime dataOraFine) {
        this.aula = aula;
        this.docente = docente;
        this.dataOraInizio = dataOraInizio;
        this.dataOraFine = dataOraFine;
    }

    public Aula getAula() {
        return aula;
    }

    public Docente getDocente() {
        return docente;
    }

    public LocalDateTime getDataOraInizio() {
        return dataOraInizio;
    }

    public LocalDateTime getDataOraFine() {
        return dataOraFine;
    }
}
