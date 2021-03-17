public class project {
    public static void main(String[] args) {
        Pozycja pozycja1 = new Pozycja(15, 9);
        Pozycja pozycja2 = new Pozycja(1, 1);
        Sprzeglo sprzeglo = new Sprzeglo("sprzeglo1", 100, 50, false);
        SkrzyniaBiegow skrzyniaBiegow1 = new SkrzyniaBiegow("s1", 70, 100,1, 6,  sprzeglo);
        SkrzyniaBiegow skrzyniaBiegow2 = new SkrzyniaBiegow("s2", 80, 150, 1, 6,  sprzeglo);
        Silnik silnik = new Silnik("super silnik", 500, 2000);

        Samochod car1 = new Samochod(pozycja1, skrzyniaBiegow1, silnik,false, "KR001", "Fiat", 220, "niebieski");
        car1.wlacz();
        System.out.println("waga car1 " + car1.getWaga());
        System.out.println(car1.getAktualnaPredkosc());
        car1.getSkrzyniaBiegow().zwiekszBieg();
        System.out.println(car1.getAktualnaPredkosc());
        car1.getSkrzyniaBiegow().zwiekszBieg();
        System.out.println(car1.getAktualnaPredkosc());
        car1.getSkrzyniaBiegow().zwiekszBieg();
        System.out.println(car1.getAktualnaPredkosc());
        //System.out.println("pozycja car1 (" + car1.getAktualnaPozycjaX() + ", " + car1.getAktualnaPozycjaY() + ")");
        car1.jedzDo(100, 130);
        //System.out.println("pozycja car1 (" + car1.getAktualnaPozycjaX() + ", " + car1.getAktualnaPozycjaY() + ")");
        //car1.wylacz();

        //car2
        Samochod car2 = new Samochod(pozycja2, skrzyniaBiegow2, silnik, false,"KR002", "BMW", 250f, "bialy");
        car2.wlacz();
        System.out.println("waga car2 " + car2.getWaga());
        car2.jedzDo(10, 15);

        //car1.wylacz();


    }
}
