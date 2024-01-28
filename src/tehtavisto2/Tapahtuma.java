package tehtavisto2;

import java.time.LocalDateTime;

public class Tapahtuma implements Comparable<Tapahtuma> {
    private LocalDateTime tapahtumaAika;
    private String nimi;

    public Tapahtuma(LocalDateTime tapahtumaAika, String nimi) {
        this.tapahtumaAika = tapahtumaAika;
        this.nimi = nimi;
    }

    public LocalDateTime getTapahtumaAika() {
        return tapahtumaAika;
    }

    public String getNimi() {
        return nimi;
    }

    @Override
    public int compareTo(Tapahtuma toinen) {
        return this.tapahtumaAika.compareTo(toinen.tapahtumaAika);
    }

    @Override
    public String toString() {
        return "Tapahtuma{" +
                "aika=" + tapahtumaAika +
                ", nimi='" + nimi + '\'' +
                '}';
    }
}