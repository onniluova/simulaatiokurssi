import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.text.DecimalFormat;
public class tehtava3 {
    public static class Asiakas {
        private static int counter = 0; // Static counter for ID
        final private int id;
        private long aloitusaika; // Start time
        private long lopetusaika; // End time

        public Asiakas() {
            this.id = ++counter; // Increment counter for each new Asiakas
            this.aloitusaika = System.nanoTime();
        }

        // Getters and setters
        public long getAloitusaika() {
            return aloitusaika;
        }

        public void setAloitusaika(long aloitusaika) {
            this.aloitusaika = aloitusaika;
        }

        public long getLopetusaika() {
            return lopetusaika;
        }

        public void setLopetusaika(long lopetusaika) {
            this.lopetusaika = lopetusaika;
        }

        public int getId() {
            return id;
        }

        public void tulostaKulunutAika() {
            long lopetusaika = System.nanoTime();
            double kulunutAika = (lopetusaika - aloitusaika) / 1_000_000_000.0;
            System.out.println("Asiakas " + id + ": Jonossa kulunut aika oli " + kulunutAika + " sekuntia.");
        }
    }

    public static class Palvelupiste {
        final private LinkedList<Asiakas> jono;
        final private ArrayList<Double> palveluajat;

        public Palvelupiste() {
            jono = new LinkedList<>();
            palveluajat = new ArrayList<>();
        }

        public void lisaaJonoon(Asiakas a) {
            jono.add(a);
        }

        public Asiakas poistaJonosta() {
            return jono.isEmpty() ? null : jono.remove();
        }

        public void palvele() throws InterruptedException {

            while (!jono.isEmpty()) {
                int palveluaika = (int) (Math.random() * 10000);
                Thread.sleep(palveluaika);

                Asiakas asiakas = poistaJonosta();
                long paattymisaika = System.nanoTime();
                double palvelunAikaSekunteina = (paattymisaika - asiakas.getAloitusaika()) / 1_000_000_000.0;

                palveluajat.add(palvelunAikaSekunteina);

                System.out.println("Asiakas " + asiakas.getId() + " palveltu. Palvelun päättymisaika: " + palvelunAikaSekunteina);
            }
        }
        public double laskeKeskiarvoinenPalveluaika() {
            if (palveluajat.isEmpty()) {
                return 0;
            }

            double summa = 0;
            for (double aika : palveluajat) {
                summa += aika;
            }
            return summa / palveluajat.size();
        }
    }

    public static void main(String[] args) {
        Palvelupiste palvelupiste = new Palvelupiste();
        DecimalFormat df = new DecimalFormat("#.##");

        for (int i = 0; i < 5; i++) {
            Asiakas asiakas = new Asiakas();
            palvelupiste.lisaaJonoon(asiakas);
        }

        try {
            palvelupiste.palvele();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double keskiarvoinenPalveluaika = palvelupiste.laskeKeskiarvoinenPalveluaika();
        System.out.println("Keskimääräinen palveluaika: " + df.format(keskiarvoinenPalveluaika) + " sekuntia.");
    }
}