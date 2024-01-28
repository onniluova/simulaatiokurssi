package tehtavisto3;

public class SaapumisTapahtuma {
    private int tyyppi;
    private double kellonaika;
    public SaapumisTapahtuma(int tyyppi, double kellonaika) {
        this.tyyppi = tyyppi;
        this.kellonaika = kellonaika;
    }

    @Override
    public String toString() {
        return "Tyyppi = " + tyyppi + " kellonaika = " + (long)(kellonaika / 1000) + " sekuntia";
    }
}
