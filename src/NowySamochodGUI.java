import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NowySamochodGUI extends JFrame{
    private JPanel p;
    private JButton dodajButton;
    private JButton wyjdźButton;
    private JTextField NrRejTx;
    private JTextField ModelTx;
    private JTextField KolorTx;
    private JLabel Kolor;
    private JLabel Model;
    private JLabel NrRej;
    private JTextField NazwaTx;
    private JPanel Nazwa;
    private JCheckBox wlaczCheckBox;
    private JCheckBox wylaczCheckBox;
    private JLabel X;
    private JTextField XTx;
    private JLabel Y;
    private JTextField YTx;
    private boolean stanWlaczenia;

    public NowySamochodGUI(SamochodGUI samochodGUI){
        setContentPane(p);
        pack();

        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double x = Double.parseDouble(XTx.getText());
                double y = Double.parseDouble(YTx.getText());
                Pozycja pozycja1 = new Pozycja(0,0);
                Sprzeglo sprzeglo1 = new Sprzeglo("sprzeglo1", 80, 1500);
                SkrzyniaBiegow skrzynia1 = new SkrzyniaBiegow("skrzynia1", 300, 2000, 6, sprzeglo1);
                Silnik silnik1 = new Silnik("silnik1", 500, 20000);

                String nazwa = NazwaTx.getText();
                String model = ModelTx.getText();
                String nrrej = NrRejTx.getText();
                String kolor = KolorTx.getText();

                Samochod samochod = new Samochod(pozycja1, skrzynia1, silnik1, nrrej, model, 230, kolor);
                samochodGUI.getWybierzSam().addItem(samochod); //dodaje do listy

                dispose();


            }
        });
        wyjdźButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        wlaczCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                stanWlaczenia = true;
            }
        });

        wylaczCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                stanWlaczenia = false;
            }
        });
    }



}


