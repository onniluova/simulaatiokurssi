package tehtavisto3.tehtava5;

import eduni.distributions.ContinuousGenerator;

import java.util.List;

public class Saapumisprosessi {
    private ContinuousGenerator generator;
    private int tapahtumaType;
    private List <SaapumisTapahtuma> saapumisTapahtumaList;
    public Saapumisprosessi(ContinuousGenerator generator, int tapahtumaType, List<SaapumisTapahtuma> saapumisTapahtumaList) {
        this.generator = generator;
        this.tapahtumaType = tapahtumaType;
        this.saapumisTapahtumaList = saapumisTapahtumaList;
    }
    public SaapumisTapahtuma luoTapahtuma() {
        double tuloAika = generator.sample();
        double aikaNyt = Kello.annaKelloSingleton().palautaAika();
        double tapahtumaAika = tuloAika + aikaNyt;
        Kello.annaKelloSingleton().muutaAikaa(tapahtumaAika);
        SaapumisTapahtuma uusiTapahtuma = new SaapumisTapahtuma(tapahtumaType, tapahtumaAika);
        saapumisTapahtumaList.add(uusiTapahtuma);
        return uusiTapahtuma;
    }
}
