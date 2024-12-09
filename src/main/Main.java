package main;
import zegary.Czas;
import java.time.LocalTime;

public class Main {
    // public Czas koniecZajęć(Czas start, int[] przerwy) {
    //   //  ...
    // }

    public void testy(){
        System.out.println("Testy");
        Czas time1 = new Czas(12);
        assert time1.hour() == 12 : "Zła godzina!";
        System.out.println(time1);
        Czas time2 = new Czas(12, 30);
        assert time2.minute() == 30 : "Zła minuta!";
        System.out.println(time2);
        Czas time3 = new Czas(12, 30, 45);
        assert time3.second() == 45 : "Zła sekunda!";
        System.out.println(time3);
        Czas now = new Czas();
        assert now.hour() == now().getHour() && now.minute() == now().getMinute() && now.second() == now().getSecond() : "NIE DZIAŁA";
        System.out.println(now);

        System.out.println("Czy teraz jest " + time1 + "?🤔:  " +  time1.rowna(time2));
        System.out.println("Godzina za 12 godzin: " + Czas.dodaj(time1, Czas.zGodziny(12)));
        System.out.println("12:30 pomnożona przez 17: " + Czas.pomnmoz(time1, 17));

        System.out.println("Czy " + time1 + " jest przed " + time2 + "?🤔:  " +  time1.przed(time2));
        System.out.println(time1 + " to jest " + time1.hour() + " godzina, " + time1.minute() + " minuta, " + time1.second() + " sekunda.");

        System.out.println("Jeszcze robienie czasu z minuty i z sekundy:");
        System.out.println(Czas.zMinuty(30));
        System.out.println(Czas.zSekundy(30));
    }

    public static void main(String[] args) {
        System.out.println("Witaj szkoło!");

        // To powinno paść, jeśli tak się stanie, należy wykomentować poniższą linię.
        Czas zły = new Czas(25, 128, -1);

        Main main = new Main();

        main.testy();

        int[] przerwy = {5, 10, 5, 10, 25, 10, 5}; 
        Czas początek = new Czas(8, 15, 0);
        System.out.println("Zaczynamy o: " + początek);

        Czas koniec = main.koniecZajęć(początek, przerwy);

        System.out.println("Kończymy: " + koniec);

        System.out.println("Jest już ciemno ...");
    }
}