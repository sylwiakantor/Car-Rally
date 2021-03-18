public class Sprzeglo extends Komponent {

    public Sprzeglo(String nazwa, float waga, float cena) {
        super(nazwa, waga, cena);
        this.stanSprzegla = false;
    }

    public void wcisnij(){
        stanSprzegla=true;
        System.out.println("wlaczone");
    }
    public void zwolnij(){
        stanSprzegla=false;
        System.out.println("wylaczone");
    }
    private boolean stanSprzegla;
}
