package zegary;
public class Czas {

    private int hour;
    private int minute;
    private int second;

    // Constructors
    public Czas() {
        this(java.time.LocalTime.now().getHour(), 
             java.time.LocalTime.now().getMinute(), java.time.LocalTime.now().getSecond());
    }
    public Czas(int hour) {
        this(hour, 0, 0);
    }
    public Czas(int hour, int minute) {
        this(hour, minute, 0);
    }
    public Czas(int hour, int minute, int second) {
        assert hour <= 24 && hour >= 0 && minute >= 0 && minute <= 60 && second >= 0 && second <= 60: "Czas nie może być ujemny analfabeto!";

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void normalize() {
        this.minute += this.second / 60;
        this.second %= 60;
        this.hour += this.minute / 60;
        this.minute %= 60;
        this.hour %= 24;
    }

    @Override
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }

    public int hour() {
        return hour;
    }
    public int minute() {
        return minute;
    }
    public int second() {
        return second;
    }

    public boolean rowna(Czas time) {
        return this.hour == time.hour && this.minute == time.minute && this.second == time.second;
    }

    public boolean przed(Czas time) {
        if (this.hour < time.hour) {
            return true;
        }
        if (this.hour == time.hour && this.minute < time.minute) {
            return true;
        }
        if (this.hour == time.hour && this.minute == time.minute && this.second < time.second) {
            return true;
        } 
        return false;
    }

    public static Czas dodaj(Czas time1, Czas time2) {
        time1.hour += time2.hour;
        time1.minute += time2.minute;
        time1.second += time2.second;
        time1.normalize();
        return time1;
    }

    public static Czas pomnmoz(Czas time, int factor) {
        time.hour *= factor;
        time.minute *= factor;
        time.second *= factor;
        time.normalize();
        return time;
    }

    public static Czas zGodziny(int hour) {
        return new Czas(hour, 0, 0);
    }
    public static Czas zMinuty(int minute) {
        return new Czas(0, minute, 0);
    }
    public static Czas zSekundy(int second) {
        return new Czas(0, 0, second);
    }
}
    