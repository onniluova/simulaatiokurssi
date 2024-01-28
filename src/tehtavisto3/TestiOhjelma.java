package tehtavisto3;
import eduni.distributions.*;

import java.util.ArrayList;
import java.util.List;

public class TestiOhjelma {
    public static void main(String[] args) {
        Normal normaaliJakauma = new Normal(25000, 5000);
        Kello.annaKelloSingleton().muutaAikaa(0);
        List<SaapumisTapahtuma> saapumisTapahtumaList = new ArrayList<SaapumisTapahtuma>();
        Saapumisprosessi saapumisprosessi = new Saapumisprosessi(normaaliJakauma, 5, saapumisTapahtumaList);

        for(int i = 0; i < 10; i++) {
            SaapumisTapahtuma saapumisTapahtuma = saapumisprosessi.luoTapahtuma();
            System.out.println("Tapahtuma luotu " + saapumisTapahtuma);
        }
    }
}
