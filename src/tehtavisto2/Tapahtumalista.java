package tehtavisto2;

import java.util.PriorityQueue;

public class Tapahtumalista {
    private PriorityQueue<Tapahtuma> tapahtumat;

    public Tapahtumalista() {
        this.tapahtumat = new PriorityQueue<>();
    }

    public void lisaaTapahtuma(Tapahtuma tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    public Tapahtuma poistaSeuraava() {
        return tapahtumat.poll();
    }

    public void tulostaTapahtumat() {
        PriorityQueue<Tapahtuma> kopio = new PriorityQueue<>(tapahtumat);
        while (!kopio.isEmpty()) {
            System.out.println(kopio.poll());
        }
    }
}