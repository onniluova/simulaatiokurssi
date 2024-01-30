package Tehtavisto1;

public class tehtava1 {
    public static class Asiakas {
        private static int counter = 0; // Static counter for ID
        final private int id;
        private long aloitusaika; // Start time
        private long lopetusaika; // End time

        public Asiakas() {
            this.id = ++counter; // Increment counter for each new Asiakas
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

        // Method to calculate elapsed time
        public void getKulunutAika() {
            long kulunutAika = lopetusaika - aloitusaika;
            System.out.println("Asiakkaan " + id + " palveluaika oli " + kulunutAika + " millisekuntia.");
        }
    }

    public static void main(String[] args) {
        Asiakas asiakas1 = new Asiakas();
        asiakas1.setAloitusaika(1600);
        asiakas1.setLopetusaika(1700);
        asiakas1.getKulunutAika();

        Asiakas asiakas2 = new Asiakas();
        // You can set start and end times and test asiakas2 similarly
    }
}