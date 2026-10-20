import java.util.HashSet;
import java.util.Set;

public class Activitate {
    private String nume;
    private Profesor coordonator;
    private Set<Elev> participanti = new HashSet<>();

    public Activitate(String nume, Profesor coordonator) {
        this.nume = nume;
        this.coordonator = coordonator;
    }

    public String getNume() {
        return nume;
    }

    public Profesor getCoordonator() {
        return coordonator;
    }

    public Set<Elev> getParticipanti() {
        return participanti;
    }

    public void adaugaParticipant(Elev elev) {
        participanti.add(elev);
    }

    public void eliminaParticipant(Elev elev) {
        participanti.remove(elev);
    }
}
