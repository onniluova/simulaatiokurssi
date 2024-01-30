package tehtavisto3;

import java.util.LinkedList;
import java.util.Queue;

public class Palvelupiste {
    private Queue<Asiakas> jono;

    public Palvelupiste() {
        jono = new LinkedList<>();
    }

    public void lisaaAsiakas(Asiakas asiakas) {
        jono.add(asiakas);
    }

    public void tyhjennaPiste() {
        while (!jono.isEmpty()) {
            Asiakas asiakas = jono.poll();
            double viipyminen = Kello.annaKelloSingleton().palautaAika() - asiakas.getSaapumisaika();
            System.out.println("Asiakas vietti järjestelmässä " + viipyminen + " aikayksikköä.");
        }
    }
}