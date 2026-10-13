public class Elev {
    private String nume;
    private Gen gen;

    public Elev(String nume, Gen gen) {
        this.nume = nume;
        this.gen = gen;
    }

    public String getNume() {
        return nume;
    }

    public Gen getGen() {
        return gen;
    }
}
