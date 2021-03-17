public class Samochod extends Thread{
    private boolean stanWlaczenia;
    private String nrRejestru;
    private String model;
    private double predkoscMax;
    private String kolor;

    private Pozycja cel;
    //private Pozycja cel = new Pozycja(0, 0);
    private Pozycja pozycja;
    private SkrzyniaBiegow skrzyniaBiegow;
    private Silnik silnik;

    public Samochod(Pozycja pozycja, SkrzyniaBiegow skrzyniaBiegow, Silnik silnik, boolean stanWlaczenia, String nrRejestru, String model, double predkoscMax, String kolor) {
        this.pozycja = pozycja;
        this.skrzyniaBiegow = skrzyniaBiegow;
        this.silnik = silnik;
        this.stanWlaczenia = stanWlaczenia;
        this.nrRejestru = nrRejestru;
        this.model = model;
        this.predkoscMax = predkoscMax;
        this.kolor = kolor;
        //cel = pozycja;
        start();
    }

    public void wlacz(){
        stanWlaczenia = true;
        silnik.uruchom();
        System.out.println(nrRejestru + " samochod wlaczony");
    }

    public void wylacz(){
        stanWlaczenia = false;
        silnik.zatrzymaj();
        System.out.println(nrRejestru + " samochod wylaczony");
    }

    public void jedzDo(double x, double y) {
        System.out.println(nrRejestru + " Jedziesz do (" + x + ", " + y + ")");
        if (cel == null) {
            cel = new Pozycja(x, y);
        }
        else {
            cel.setX(x);
            cel.setY(y);
        }
        //System.out.println("Jestes na miejscu (" + x + ", " + y + ")");
    }


    public void run(){
        while (true){
        //while(pozycja.getX() != cel.getX() && pozycja.getY() != cel.getY()){
            System.out.println(nrRejestru + " Pozycja x:" + pozycja.getX() + ", y:" + pozycja.getY());
            if (cel != null) {
                pozycja.przeniesc(getAktualnaPredkosc(), 0.2, cel.getX(), cel.getY());
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("jest problem");
            }
        }
        //System.out.println(nrRejestru + " Jestes na miejscu " + "x:" + pozycja.getX() + ", y:" + pozycja.getY());
    }


    public double getWaga(){
        return skrzyniaBiegow.getWaga() + silnik.getWaga();
    }

    public double getAktualnaPredkosc() {
        if (stanWlaczenia == false || cel == null) {
            return 0;
        }
        if (pozycja.getX() == cel.getX() && pozycja.getY() == cel.getY()){
            skrzyniaBiegow.setAktualnyBieg(1);
            return 0;
        }
        int aktualnyBieg = skrzyniaBiegow.getAktualnyBieg();
        double aktualnePrzelozenie = skrzyniaBiegow.getAktualnePrzelozenie();
        double aktualnaPredkosc = aktualnyBieg*aktualnePrzelozenie*3.5; //obwod kola
        if (aktualnaPredkosc > predkoscMax) {
            aktualnaPredkosc = predkoscMax;
        }
        return aktualnaPredkosc; //obwod kola
    }

    public double getAktualnaPozycjaX() {
        return pozycja.getX();
    }

    public double getAktualnaPozycjaY() {
        return pozycja.getY();
    }

    public double[] getAktualnaPozycja() {
        return pozycja.getXY();
    }

    public Silnik getSilnik() {
        return silnik;
    }

    public String getNrRejestru() {
        return nrRejestru;
    }

    public String getModel() {
        return model;
    }

    public SkrzyniaBiegow getSkrzyniaBiegow() {
        return skrzyniaBiegow;
    }

    public Pozycja getCel() {
        return cel;
    }

    public Pozycja getPozycja() {
        return pozycja;
    }

    public void setPozycja(Pozycja pozycja) {
        this.pozycja = pozycja;
    }

    public void setCel(Pozycja cel) {
        this.cel = cel;
    }

    @Override
    public String toString() {
        return model + " " + nrRejestru;
    }

}
