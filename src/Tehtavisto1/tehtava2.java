package Tehtavisto1;

import java.util.Scanner;
import java.util.LinkedList;
public class tehtava2 {
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
            long kulunutAika = lopetusaika - aloitusaika;
            System.out.println("Asiakas " + id + ": Jonossa kulunut aika oli " + kulunutAika + " nanosekuntia.");
        }
    }
    public static void main(String[] args) {
        int loppu = 0;

        Scanner lukija = new Scanner(System.in);

        LinkedList <Asiakas> asiakasJono = new LinkedList<>();

        while (loppu == 0) {
            System.out.println("Mitä haluat tehdä? ");
            String input = lukija.nextLine();

            if ("lopeta".equals(input)) {
                loppu = 1;
                lukija.close();
            }
            else if ("lisää".equals(input)) {
                Asiakas uusiAsiakas = new Asiakas();
                asiakasJono.add(uusiAsiakas);
                System.out.println("Asiakas lisätty jonoon. Asiakkaan ID: " + uusiAsiakas.getId());
            }
            else if ("poista".equals(input)) {
                if (!asiakasJono.isEmpty()) {
                    Asiakas poistettuAsiakas = asiakasJono.remove();
                    poistettuAsiakas.tulostaKulunutAika();
                }
                else {
                    System.out.println("Jono on tyhjä.");
                }
            }
            else {
                System.out.println("Tuntematon komento.");
            }
        }
    }
}