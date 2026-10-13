public class Main {
    public static void main(String[] args) {
        Scoala scoala = new Scoala();
        Clasa c1 = new Clasa(30, NumarClasa.I, 'A');
        c1.adaugaElev(new Elev("Ana", Gen.Feminin));
        c1.adaugaElev(new Elev("Andrei", Gen.Masculin));

        Clasa c2 = new Clasa(30, NumarClasa.II, 'B');
        c2.adaugaElev(new Elev("Bogdan", Gen.Masculin));
        c2.adaugaElev(new Elev("Cristina", Gen.Feminin));

        scoala.adaugaClasa("1A", c1);
        scoala.adaugaClasa("2B", c2);
        scoala.adaugaActivitate(new Activitate("Fotbal", new Profesor("Popescu")));
        scoala.adaugaActivitate(new Activitate("Cor", new Profesor("Ionescu")));
        scoala.adaugaActivitate(new Activitate("Programare", new Profesor("Georgescu")));

        scoala.inscrieElev("Ana", "Fotbal");
        scoala.inscrieElev("Ana", "Cor");
        scoala.inscrieElev("Andrei", "Fotbal");
        scoala.inscrieElev("Bogdan", "Fotbal");
        scoala.inscrieElev("Bogdan", "Programare");

        System.out.println("Top activitati:");
        scoala.afiseazaTop();
        System.out.println("Elevi cu cel putin o activitate: " + scoala.getElevCuActivitati());

        scoala.eliminaElevDinActivitate("Ana", "Fotbal");
        scoala.eliminaActivitate("Cor");

        System.out.println(" Dupa eliminari:");
        scoala.afiseazaTop();
        System.out.println("Elevi cu cel putin o activitate: " + scoala.getElevCuActivitati());

        System.out.println(" Clase: " + scoala.getNumarClase());
        System.out.println("Total elevi: " + scoala.getTotalElevi());
    }
    }
