public class Silnik extends Komponent{
    private final double maxObroty = 4000;
    private double obroty;

    public void uruchom() {
        obroty = 800; //bieg jałowy
        System.out.println("silnik uruchomiony.");
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

    public Silnik(String nazwa, double waga, double cena) {
        super(nazwa, waga, cena);
        this.obroty = 0;
    }

    public double getObroty() {
        return obroty;
    }
}