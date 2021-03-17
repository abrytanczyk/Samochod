public class SkrzyniaBiegow extends Komponent {
    private int aktualnyBieg ;
    private int iloscBiegow;
    private double aktualnePrzelozenie;
    private Sprzeglo sprzeglo;

    public SkrzyniaBiegow(String nazwa, double waga, double cena, int aktualnyBieg, int iloscBiegow, Sprzeglo sprzeglo) {
        super(nazwa, waga, cena);
        this.aktualnyBieg = aktualnyBieg;
        this.iloscBiegow = iloscBiegow;
        this.zmienAktualnePrzelozenie();
        //this.aktualnePrzelozenie = aktualnePrzelozenie;
        this.sprzeglo = sprzeglo;
    }

    public void zwiekszBieg(){
        sprzeglo.wcisnij();
        aktualnyBieg++;
        if (aktualnyBieg>iloscBiegow){
            aktualnyBieg = iloscBiegow;
        }
        zmienAktualnePrzelozenie();
        sprzeglo.zwolnij();
    }

    public void zmniejszBieg(){
        sprzeglo.wcisnij();
        aktualnyBieg--;
        if (aktualnyBieg<=0){
            aktualnyBieg = 1;
        }
        zmienAktualnePrzelozenie();
        sprzeglo.zwolnij();
    }

    public int getAktualnyBieg() {
        //System.out.println("AKtualny bieg " + aktualnyBieg);
        return aktualnyBieg;
    }

    public void setAktualnyBieg(int aktualnyBieg) {
        this.aktualnyBieg = aktualnyBieg;
    }

    public void zmienAktualnePrzelozenie(){
        switch (aktualnyBieg){
            case 1: aktualnePrzelozenie = 1.1;
            case 2: aktualnePrzelozenie = 1.5;
            case 3: aktualnePrzelozenie = 1.7;
            case 4: aktualnePrzelozenie = 1.9;
            case 5: aktualnePrzelozenie = 2.2;
            case 6: aktualnePrzelozenie = 2.5;
            default: aktualnePrzelozenie = 1;
        }
    }

    public double getAktualnePrzelozenie() {
        //System.out.println("AKtualne przelozenie " + aktualnePrzelozenie);
        return aktualnePrzelozenie;
    }

    @Override
    public double getWaga() {
        return super.getWaga() + sprzeglo.getWaga();
    }
}
