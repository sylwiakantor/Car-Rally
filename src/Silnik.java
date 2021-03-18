public class Silnik extends Komponent {

    public Silnik(String nazwa, float waga, float cena) {
        super(nazwa, waga, cena);
        obroty = 0;    }

    public void uruchom(){
        obroty = 800;
        System.out.println("silnik uruchoomiony.");
        System.out.println("obroty = " + obroty);
    }
    public void zatrzymaj() {
        obroty = 0; //stop
        System.out.println("silnik zatrzymany.");
        System.out.println("obroty = " + obroty);
    }
    public void zwiekszObroty() {
        obroty = obroty + 100;
        if (obroty > maxObroty) obroty = maxObroty;
        System.out.println("obroty = " + obroty);
    }
    public void zmniejszObroty() {
        obroty = obroty - 100;
        if (obroty < 800) obroty = 800;
        System.out.println("obroty = " + obroty);
    }
    public double getObroty(){
        return obroty;
    }
    public double maxObroty = 5000;
    public double obroty;
}
