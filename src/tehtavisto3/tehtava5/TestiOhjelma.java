package tehtavisto3.tehtava5;

import eduni.distributions.Normal;

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
        Palvelupiste palvelupiste = new Palvelupiste();


        // Käsitellään tapahtumat
        for (SaapumisTapahtuma tapahtuma : saapumisTapahtumaList) {
            Asiakas asiakas = new Asiakas(tapahtuma.getKellonaika());
            palvelupiste.lisaaAsiakas(asiakas);
        }

        // Siirretään kelloa eteenpäin ja tyhjennetään palvelupiste
        Kello.annaKelloSingleton().muutaAikaa(Kello.annaKelloSingleton().palautaAika() + 5);
        palvelupiste.tyhjennaPiste();
    }
}
