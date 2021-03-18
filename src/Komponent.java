public class Komponent {
    public Komponent(String nazwa, float waga, float cena) {
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
    }

    public String getNazwa(){
        return nazwa;
    }
    public float getWaga(){
        return waga;
    }
    public float getCena(){
        return cena;
    }
    private String nazwa;
    private float waga;
    private float cena;
}
