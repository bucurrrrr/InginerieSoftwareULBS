import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Scoala {
    private Map<String, Clasa> clase = new HashMap<>();
    private Map<String, Activitate> activitati = new HashMap<>();

    public void adaugaClasa(String id, Clasa clasa) {
        clase.put(id, clasa);
    }

    public void eliminaClasa(String id) {
        clase.remove(id);
    }

    public void adaugaElevInClasa(String id, Elev elev) {
        clase.get(id).adaugaElev(elev);
    }

    public void eliminaElevDupaNume(String nume) {
        for (Clasa clasa : clase.values()) {
            for (Elev elev : clasa.getElevi()) {
                if (elev.getNume().equals(nume)) {
                    clasa.eliminaElev(elev);
                    return;
                }
            }
        }
    }

    public int getNumarClase() {
        return clase.size();
    }

    public int getTotalElevi() {
        int total = 0;
        for (Clasa clasa : clase.values()) {
            total += clasa.getTotalElevi();
        }
        return total;
    }

    public void adaugaActivitate(Activitate activitate) {
        activitati.put(activitate.getNume(), activitate);
    }

    public void eliminaActivitate(String numeActivitate) {
        activitati.remove(numeActivitate);
    }

    private Elev gasesteElev(String nume) {
        for (Clasa clasa : clase.values()) {
            for (Elev elev : clasa.getElevi()) {
                if (elev.getNume().equals(nume)) {
                    return elev;
                }
            }
        }
        return null;
    }

    public void inscrieElev(String numeElev, String numeActivitate) {
        Elev elev = gasesteElev(numeElev);
        Activitate activitate = activitati.get(numeActivitate);
        if (elev != null && activitate != null) {
            activitate.adaugaParticipant(elev);
        }
    }

    public void eliminaElevDinActivitate(String numeElev, String numeActivitate) {
        Elev elev = gasesteElev(numeElev);
        Activitate activitate = activitati.get(numeActivitate);
        if (elev != null && activitate != null) {
            activitate.eliminaParticipant(elev);
        }
    }

    public void afiseazaTop() {
        List<Activitate> lista = new ArrayList<>(activitati.values());
        lista.sort((a, b) -> b.getParticipanti().size() - a.getParticipanti().size());

        for (Activitate a : lista) {
            System.out.println(a.getNume() + " - " + a.getParticipanti().size() + " elevi");
        }
    }

    public int getElevCuActivitati() {
        Set<Elev> unici = new HashSet<>();
        for (Activitate a : activitati.values()) {
            unici.addAll(a.getParticipanti());
        }
        return unici.size();
    }
}
