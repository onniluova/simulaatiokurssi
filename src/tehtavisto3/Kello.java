package tehtavisto3;

public class Kello {
    double aika = System.currentTimeMillis();
    final private static Kello instanssi = new Kello();

    private Kello() {

    }

    public static Kello annaKelloSingleton() {
        return instanssi;
    }

    public double palautaAika() {
        return aika;
    }

    public void muutaAikaa(double uusiAika) {
        this.aika = uusiAika;
    }
}
