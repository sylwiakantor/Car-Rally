import java.lang.*;
public class Samochod extends Thread {
    public SkrzyniaBiegow skrzynia;
    private Pozycja pozycja, cel;
    private Silnik silnik;


    public Samochod(Pozycja pozycja, SkrzyniaBiegow skrzynia, Silnik silnik, String nrRejestr, String model, float predkoscMax, String kolor) {
        this.cel = pozycja;
        this.pozycja=pozycja;
        this.skrzynia = skrzynia;
        this.silnik = silnik;
        this.stanWlaczenia = false;
        this.nrRejestr = nrRejestr;
        this.model = model;
        this.predkoscMax = predkoscMax;
        this.kolor = kolor;
        this.start(); // tutaj zaczyna sie wykonywac to co w run czyli uruchamiamy wątek
    }
    public Samochod() {

    }
    public void wlacz(){
    stanWlaczenia=true;
    System.out.println("samochod wlaczony.");

    }
    public void wylacz(){
        stanWlaczenia = false;
        System.out.println("samochod wylaczony");
    }
    //@Override
    //cialo watku
    public void run(){
        while(true) {
            if(pozycja.x != cel.x || pozycja.y != cel.y)
                uaktualnijPozycje(0.2);
            try {
                Thread.sleep(200);
            }
            catch(InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
    public void jedzDo(Pozycja cel) {
        this.cel=cel;
    }
    public Pozycja getCel(){
        return cel;
    }
    public float getWaga(){
        return this.skrzynia.getWaga() + this.silnik.getWaga();
    }
    public double getAktPredkosc(){
        aktPredkosc = silnik.getObroty() * skrzynia.getAktPrzelozenie() * a;
        return aktPredkosc;

    }
    public Pozycja getPozycja(){
        return pozycja;

    }

    public void uaktualnijPozycje(double dt) {
        this.pozycja.przemiesc(getAktPredkosc(),dt,cel);
    }

    public String getModel(){
        return model;
    }
    public String getNrRejestr(){
        return nrRejestr;
    }
    public boolean isStanWlaczenia() {
        return stanWlaczenia;
    }
    public Silnik getSilnik(){
        return silnik;
    }
    public SkrzyniaBiegow getSkrzynia(){
        return skrzynia;
    }
    public float getPredkoscMax() {
        return predkoscMax;
    }

    public String getKolor() {
        return kolor;
    }
    private boolean stanWlaczenia;
    private String nrRejestr;
    private String model;
    private float predkoscMax;
    private String kolor;
    private double aktPredkosc;
    private double a = 0.01;


    //public void usunSamochod(Samochod selectedItem) {


    public String toString(){
        return model;
    }
}


