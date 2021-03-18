public class SkrzyniaBiegow extends Komponent {
    private Sprzeglo sprzeglo;

    public SkrzyniaBiegow(String nazwa, float waga, float cena, int iloscBiegow, Sprzeglo sprzeglo) {
        super(nazwa, waga, cena);
        aktualnyBieg = 1;
        this.iloscBiegow = iloscBiegow;
        this.sprzeglo = sprzeglo;
        zmianaPrzelozenia();
    }

    public void zwiekszBieg(){
        if (aktualnyBieg < iloscBiegow) {
            aktualnyBieg ++;
            aktualnePrzelozenie = aktualnyBieg;
            zmianaPrzelozenia();
        }
    }
    public void zmniejszBieg(){
        if (aktualnyBieg > 1) {
            aktualnyBieg -= 1;
            aktualnePrzelozenie = aktualnyBieg;
            zmianaPrzelozenia();
        }
    }
    public Integer getAktBieg(){
        return aktualnyBieg;
    }
    public double getAktPrzelozenie() {
        return aktualnePrzelozenie;
    }
    public float zmianaPrzelozenia(){
        switch(aktualnyBieg){
            case 1:
                return aktualnePrzelozenie=1.1f;

            case 2:
                return aktualnePrzelozenie=1.5f;

            case 3:
                return aktualnePrzelozenie=1.9f;

            case 4:
                return aktualnePrzelozenie=2.2f;

            case 5:
                return aktualnePrzelozenie=2.5f;

            case 6:
                return aktualnePrzelozenie=2.8f;

        }

        return 0;
    }
    public float getWaga() {
        return this.sprzeglo.getWaga() + super.getWaga();
    }

    private int aktualnyBieg;
    private int iloscBiegow;
    private float aktualnePrzelozenie;
}


