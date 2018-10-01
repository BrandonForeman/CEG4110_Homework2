package foreman.brandon.homework2;

public class DateTime {
    private int second;
    private int minute;
    private int hour;
    private String dayOfWeek;
    private int day;
    private String month;
    private int year;

    public DateTime(int second, int minute, int hour, String dayOfWeek, int day, String month, int year) {
        this.second = second;
        this.minute = minute;
        this.hour = hour;
        this.dayOfWeek = dayOfWeek;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return dayOfWeek + ", " + month + " " + day + " " +  year + " (" + hour + ": " + minute + ": " + second + ") ";
    }
}
