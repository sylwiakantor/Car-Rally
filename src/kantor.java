import java.sql.SQLOutput;

public class kantor {
    public static void main(String[] args){
        Pozycja pozycja1 = new Pozycja(0,0);
        Sprzeglo sprzeglo1 = new Sprzeglo("sprzeglo1", 80, 1500);
        SkrzyniaBiegow skrzynia1 = new SkrzyniaBiegow("skrzynia1", 300, 2000, 6, sprzeglo1);
        Silnik silnik1 = new Silnik("silnik1", 500, 20000);


        //Pozycja pozycja22 = new Pozycja(0,0);
        Pozycja pozycja2 = new Pozycja(0, 0);
        SkrzyniaBiegow skrzynia2 = new SkrzyniaBiegow("skrzynia1", 700, 19000, 6, sprzeglo1);
        Sprzeglo sprzeglo2 = new Sprzeglo("sprzeglo1", 100, 2000);
        Silnik silnik2 = new Silnik("silnik1", 600, 25000);
        Pozycja cel = new Pozycja(20, 20);

        Samochod car1 = new Samochod(pozycja1, skrzynia1, silnik1, "KR1111", "ford", 230, "czarny");
        car1.wlacz();
        car1.skrzynia.zwiekszBieg();
        car1.skrzynia.zwiekszBieg();

        Samochod car2 = new Samochod(pozycja2, skrzynia2, silnik2, "KPR3333", "fiat", 230, "czarny");
        car2.wlacz();
        car2.skrzynia.zwiekszBieg();
        car2.skrzynia.zwiekszBieg();
        car2.skrzynia.zwiekszBieg();

        System.out.println("waga samochodu 1: " + car1.getWaga());
        System.out.println("waga samochodu 2: " + car2.getWaga());
        System.out.println("aktualna predkosc sam 1: " + car1.getAktPredkosc());
        System.out.println("aktualna predkosc sam 2: " + car2.getAktPredkosc());

        car1.jedzDo(new Pozycja(300,200));
        car2.jedzDo(new Pozycja(100,200));
        //car1.jedzDo(0)


        //car2.jedzDo(20);

        car1.wylacz();
        car2.wylacz();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

