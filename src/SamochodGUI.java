import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ClientInfoStatus;

public class SamochodGUI{

    private Pozycja pozycja;
    private JTextField Samochód;
    private JButton dodajButton;
    private JButton usuńButton;
    private JPanel p;
    private JTextField NazwaTx;
    private JTextField NrRejTx;
    private JTextField PredkoscTx;
    private JButton dodajGazuButton;
    private JButton ujmijGazuButton;
    private JTextField NazwaSilnikaTx;
    private JTextField ObrotyTx;
    private JTextField AktPozXTx;
    private JTextField AktPozYTx;
    private JButton jedzDoButton;
    private JTextField JedzDoX;
    private JTextField JedzDoY;
    private JButton włączButton;
    private JButton wyłączButton;
    private JButton zmniejszBiegButton;
    private JButton zwiększBiegButton;
    private JTextField AktualnyBiegTx;
    private JTextField AktPrzelozenieTx;
    private JTextField NazwaSkrzyniTx;
    private JPanel okno;
    private JLabel Nazwa;
    private JLabel NrRej;
    private JLabel Predkosc;
    private JLabel aktX;
    private JLabel aktY;
    private JLabel nazwaSilnika;
    private JLabel nazwaSkrzyni;
    private JLabel aktualnyBieg;
    private JLabel aktualnePrzelozenie;
    private JLabel AktPoz;
    private JLabel Obroty;
    private JPanel mapka;
    private JLabel autko;
    private JComboBox WybierzSam;
    private JTextField mapa;

    public JComboBox getWybierzSam(){
        return WybierzSam;
    }
    private Samochod samochod;

    public SamochodGUI() {
        //super();
        //this.samochod = samochod;

        Pozycja pozycja1 = new Pozycja(0,0);
        Sprzeglo sprzeglo1 = new Sprzeglo("sprzeglo1", 80, 1500);
        SkrzyniaBiegow skrzynia1 = new SkrzyniaBiegow("skrzynia1", 300, 2000, 6, sprzeglo1);
        Silnik silnik1 = new Silnik("silnik1", 500, 20000);

        samochod = new Samochod(pozycja1, skrzynia1, silnik1, "KR1111", "ford", 230, "czarny");
        WybierzSam.addItem(samochod);

        włączButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                samochod.wlacz();
                samochod.getSilnik().uruchom();
                odswiez();

            }
        });
        wyłączButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.wylacz();
                samochod.getSilnik().zatrzymaj();
                odswiez();


            }
        });

        ujmijGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.getSilnik().zmniejszObroty();
                odswiez();

            }
        });
        dodajGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.getSilnik().zwiekszObroty();
                odswiez();

            }
        });

        zwiększBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.getSkrzynia().zwiekszBieg();
                odswiez();

            }
        });
        zmniejszBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.getSkrzynia().zmniejszBieg();
                odswiez();

            }
        });
        jedzDoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.jedzDo(new Pozycja(Double.parseDouble(JedzDoX.getText()), Double.parseDouble(JedzDoY.getText())));

            }
        });



        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                odswiez();
            }
        });
        timer.start();
        mapka.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Pozycja poz = new Pozycja(e.getX(), e.getY());
                samochod.jedzDo(poz);
                //JedzDoX.setText(Double.toString(samochod.getCel().getX()));
                //JedzDoY.setText(Double.toString(samochod.getCel().getY()));
            }
            /*@Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }*/
        });
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NowySamochodGUI nowy = new NowySamochodGUI(SamochodGUI.this);
                nowy.setVisible(true);
            }
        });

        usuńButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (WybierzSam.getItemCount() == 1){
                    WybierzSam.removeAllItems();
                }
                else {
                    WybierzSam.removeItem(WybierzSam.getSelectedItem());
                    //System.out.println(WybierzSam.getItemCount());
                }
            }

        });

        WybierzSam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod = (Samochod) WybierzSam.getSelectedItem();
                /*if (samochod.getCel()==null){
                    JedzDoX.setText(" ");
                    JedzDoY.setText(" ");
                }else{
                    samochod.jedzDo(new Pozycja(Double.parseDouble(JedzDoX.getText()), Double.parseDouble(JedzDoY.getText())));
                    //samochod.jedzDo(poz);
                }*/
            }
        });
    }
//DOKONCZYC

    public void odswiez(){
        if (samochod==null){
            PredkoscTx.setText("");
            NazwaTx.setText("");
            NrRejTx.setText("");

            AktPozXTx.setText("");
            AktPozYTx.setText("");

            NazwaSilnikaTx.setText("");
            ObrotyTx.setText("");

            JedzDoX.setText("");
            JedzDoY.setText("");

            NazwaSkrzyniTx.setText("");
            AktualnyBiegTx.setText("");
            AktPrzelozenieTx.setText("");

            autko.setLocation(0,0);

        }else {
            PredkoscTx.setText(Double.toString(samochod.getAktPredkosc()));
            NazwaTx.setText(samochod.getModel());
            NrRejTx.setText(samochod.getNrRejestr());

            AktPozXTx.setText(Double.toString(samochod.getPozycja().x));
            AktPozYTx.setText(Double.toString(samochod.getPozycja().y));

            NazwaSilnikaTx.setText(samochod.getSilnik().getNazwa());
            ObrotyTx.setText(Double.toString(samochod.getSilnik().getObroty()));

            NazwaSkrzyniTx.setText(samochod.getSkrzynia().getNazwa());
            AktualnyBiegTx.setText(Double.toString(samochod.getSkrzynia().getAktBieg()));
            AktPrzelozenieTx.setText(Double.toString(samochod.getSkrzynia().getAktPrzelozenie()));

            autko.setLocation((int) samochod.getPozycja().x, (int) samochod.getPozycja().y);
        }

    }


    public static void main(String[] args) {
        Pozycja pozycja1 = new Pozycja(0,0);
        Sprzeglo sprzeglo1 = new Sprzeglo("sprzeglo1", 80, 1500);
        SkrzyniaBiegow skrzynia1 = new SkrzyniaBiegow("skrzynia1", 300, 2000, 6, sprzeglo1);
        Silnik silnik1 = new Silnik("silnik1", 500, 20000);

        Samochod car1 = new Samochod(pozycja1, skrzynia1, silnik1, "KR1111", "ford", 230, "czarny");

        JFrame frame = new JFrame("SamochodGUI");
        frame.setContentPane(new SamochodGUI().okno);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

