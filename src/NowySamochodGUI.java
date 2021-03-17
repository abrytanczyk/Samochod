import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NowySamochodGUI extends JFrame {
    private JButton utworzButton;
    private JButton cancelButton;
    private JTextField XTxt;
    private JTextField YTxt;
    private JTextField NrRejestracyjnyTxt;
    private JPanel p;
    private JTextField KolorTxt;
    private JTextField ModelTxt;
    private JTextField PredkoscMaksymalnaTxt;
    private JCheckBox wyłączonyCheckBox;
    private JCheckBox włączonyCheckBox;

    private boolean stanWlaczenia;

    public NowySamochodGUI(SamochodGUI samochodGUI) {
        setContentPane(p);
        pack();
        utworzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double x = Double.parseDouble(XTxt.getText());
                double y = Double.parseDouble(YTxt.getText());
                Pozycja pozycja = new Pozycja(x, y);
                Sprzeglo sprzeglo = new Sprzeglo("czadowe sprzeglo", 43, 500, false);
                SkrzyniaBiegow skrzyniaBiegow = new SkrzyniaBiegow("super skrzynia", 34,632, 1,6, sprzeglo);
                Silnik silnik = new Silnik("najlepszy silnik", 222, 1000);
                double predkoscMax = Double.parseDouble(PredkoscMaksymalnaTxt.getText());

                Samochod samochod = new Samochod(pozycja, skrzyniaBiegow, silnik, stanWlaczenia, NrRejestracyjnyTxt.getText(), ModelTxt.getText(), predkoscMax, KolorTxt.getText());
                samochodGUI.getWybierzSamochod().addItem(samochod);
                dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        włączonyCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                stanWlaczenia = true;
            }
        });
        wyłączonyCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                stanWlaczenia = false;
            }
        });
    }
}
