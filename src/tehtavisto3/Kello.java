package tehtavisto3;

public class Kello {
    long aika = System.currentTimeMillis();
    final private static Kello instanssi = new Kello();

    private Kello() {

    }

    public static Kello annaKelloSingleton() {
        return instanssi;
    }

    public long palautaAika() {
        return aika;
    }

    public void muutaAikaa(long uusiAika) {
        this.aika = uusiAika;
    }
}
