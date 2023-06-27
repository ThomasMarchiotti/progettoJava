public class Aula {
    private String nome;
    private int capienza;
    private String tipoAula;
    private List<String> dotazioni;

    public Aula(String nome, int capienza) {
        this.nome = nome;
        this.capienza = capienza;
        this.tipoAula = "";
        this.dotazioni = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getCapienza() {
        return capienza;
    }

    public String getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(String tipoAula) {
        this.tipoAula = tipoAula;
    }

    public List<String> getDotazioni() {
        return dotazioni;
    }

    public void addDotazione(String dotazione) {
        dotazioni.add(dotazione);
    }

    public void removeDotazione(String dotazione) {
        dotazioni.remove(dotazione);
    }
}
