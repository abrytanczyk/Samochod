public class Sprzeglo extends Komponent {
    private boolean stanSprzegla;

    public Sprzeglo(String nazwa, double waga, double cena, boolean stanSprzegla) {
        super(nazwa, waga, cena);
        this.stanSprzegla = stanSprzegla;
    }

    public void wcisnij(){
        stanSprzegla = true;
        System.out.println("Sprzeglo jest wcisniete");
    }
    public void zwolnij(){
        stanSprzegla = false;
        System.out.println("Sprzeglo zostalo zwolnione");
    }
}
