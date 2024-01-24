package tehtavisto2;

import java.time.LocalDateTime;

public class TapahtumaMain {
    public static void main(String[] args) {
        Tapahtumalista lista = new Tapahtumalista();

        // Generoidaan tapahtumia
        lista.lisaaTapahtuma(new Tapahtuma(LocalDateTime.now().plusDays(1), "Tapahtuma 1"));
        lista.lisaaTapahtuma(new Tapahtuma(LocalDateTime.now().plusDays(2), "Tapahtuma 2"));
        lista.lisaaTapahtuma(new Tapahtuma(LocalDateTime.now().plusDays(3), "Tapahtuma 3"));

        // Poistetaan ja tulostetaan seuraava tapahtuma
        System.out.println("Seuraava tapahtuma: " + lista.poistaSeuraava());

        // Tulostetaan jäljellä olevat tapahtumat
        System.out.println("Jäljellä olevat tapahtumat:");
        lista.tulostaTapahtumat();
    }
}