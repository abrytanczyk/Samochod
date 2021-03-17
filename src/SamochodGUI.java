import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SamochodGUI{
    private JTextField NazwaTxt;
    private JTextField NrRejestracyjnyTxt;
    private JTextField PredkoscTxt;
    private JTextField XTxt;
    private JTextField YTxt;
    private JButton włączButton;
    private JButton wyłączButton;
    private JTextField XCelTxt;
    private JTextField YCelTxt;
    private JLabel X;
    private JLabel Y;
    private JButton jedzDoButton;
    private JPanel project;
    private JLabel XCel;
    private JLabel YCel;
    private JTextField SilnikModelTxt;
    private JTextField AktualneObrotyTxt;
    private JButton dodajGazuButton;
    private JButton ujmijGazuButton;
    private JButton zwiększBiegButton;
    private JButton zmniejszBiegButton;
    private JTextField AktualnyBiegTxt;
    private JTextField SkrzyniaBiegowModelTxt;
    private JPanel Mapa;
    private JPanel Mapka;
    private JLabel SamochodIkona;
    private JComboBox WybierzSamochod;
    private JButton dodajButton;
    private JButton usunButton;

    private Samochod samochod;
    private Samochod samochod1;

    public JComboBox getWybierzSamochod() {
        return WybierzSamochod;
    }

    public SamochodGUI() {
        Pozycja pozycja = new Pozycja(0, 0);
        Pozycja pozycja1 = new Pozycja(1, 1);
        Sprzeglo sprzeglo = new Sprzeglo("sprzeglo1", 100, 50, false);
        Sprzeglo sprzeglo1 = new Sprzeglo("sprzeglo2", 150, 70, false);
        SkrzyniaBiegow skrzyniaBiegow1 = new SkrzyniaBiegow("czadowa skrzynia", 70, 100,1, 6, sprzeglo);
        SkrzyniaBiegow skrzyniaBiegow2 = new SkrzyniaBiegow("super skrzynia", 70, 100,1, 6, sprzeglo1);
        Silnik silnik = new Silnik("super silnik", 500, 2000);
        Silnik silnik1 = new Silnik("czadowy silnik", 600, 2500);
        samochod = new Samochod(pozycja, skrzyniaBiegow1, silnik,false, "KR001", "Fiat", 220, "niebieski");
        samochod1 = new Samochod(pozycja1, skrzyniaBiegow2, silnik1, false, "KR002", "Opel", 250, "bialy");
        WybierzSamochod.addItem(samochod);
        WybierzSamochod.addItem(samochod1);

        włączButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.wlacz();
                samochod.getSilnik().uruchom();
                samochod.getSkrzyniaBiegow().setAktualnyBieg(1);
                odswiez();
            }
        });

        wyłączButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.getSilnik().zatrzymaj();
                samochod.wylacz();
                odswiez();
            }
        });

        zwiększBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.getSkrzyniaBiegow().zwiekszBieg();
                odswiez();
            }
        });

        zmniejszBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.getSkrzyniaBiegow().zmniejszBieg();
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

        ujmijGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.getSilnik().zmniejszObroty();
                odswiez();
            }
        });

        jedzDoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double x = Double.parseDouble(XCelTxt.getText());
                double y = Double.parseDouble(YCelTxt.getText());
                samochod.jedzDo(x, y);
                XCelTxt.setText(Double.toString(samochod.getCel().getX()));
                YCelTxt.setText(Double.toString(samochod.getCel().getY()));
                //odswiez();
            }
        });

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                odswiez();
            }
        });

        timer.setInitialDelay(500);
        timer.start();

        Mapka.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                samochod.jedzDo(e.getX(), e.getY());
                XCelTxt.setText(Double.toString(samochod.getCel().getX()));
                YCelTxt.setText(Double.toString(samochod.getCel().getY()));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }
        });

        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NowySamochodGUI nowy = new NowySamochodGUI(SamochodGUI.this);
                nowy.setVisible(true);
            }
        });

        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (WybierzSamochod.getItemCount() == 1) {
                    WybierzSamochod.removeAllItems();
                }
                else {
                    WybierzSamochod.removeItem(samochod);
                }

            }
        });

        WybierzSamochod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod = (Samochod) WybierzSamochod.getSelectedItem();
                if (samochod.getCel() == null) {
                    XCelTxt.setText("");
                    YCelTxt.setText("");
                }
                else {
                    XCelTxt.setText(Double.toString(samochod.getCel().getX()));
                    YCelTxt.setText(Double.toString(samochod.getCel().getY()));
                }
            }
        });
    }

    public void odswiez() {
        if (samochod == null) {
            NazwaTxt.setText("");
            NrRejestracyjnyTxt.setText("");
            XTxt.setText("");
            YTxt.setText("");
            PredkoscTxt.setText("");
            XCelTxt.setText("");
            YCelTxt.setText("");
            SkrzyniaBiegowModelTxt.setText("");
            AktualnyBiegTxt.setText("");
            SilnikModelTxt.setText("");
            AktualneObrotyTxt.setText("");
            SamochodIkona.setLocation(0, 0);
        } else {
            NazwaTxt.setText(samochod.getModel());
            NrRejestracyjnyTxt.setText(samochod.getNrRejestru());
            XTxt.setText(Double.toString(samochod.getAktualnaPozycjaX()));
            YTxt.setText(Double.toString(samochod.getAktualnaPozycjaY()));
            PredkoscTxt.setText(Double.toString(samochod.getAktualnaPredkosc()));
            SkrzyniaBiegowModelTxt.setText(samochod.getSkrzyniaBiegow().getNazwa());
            AktualnyBiegTxt.setText(Double.toString(samochod.getSkrzyniaBiegow().getAktualnyBieg()));
            SilnikModelTxt.setText(samochod.getSilnik().getNazwa());
            AktualneObrotyTxt.setText(Double.toString(samochod.getSilnik().getObroty()));
            SamochodIkona.setLocation((int) samochod.getAktualnaPozycjaX(), (int) samochod.getAktualnaPozycjaY());
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("SamochodGUI");
        frame.setContentPane(new SamochodGUI().project);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
