package foreman.brandon.homework2;

import java.util.Calendar;

public class DateTime {
    private int second;
    private int minute;
    private int hour;
    private int dayOfWeek;
    private int day;
    private int month;
    private int year;

    public DateTime(int second, int minute, int hour, int dayOfWeek, int day, int month, int year) {
        this.second = second;
        this.minute = minute;
        this.hour = hour;
        this.dayOfWeek = dayOfWeek;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public DateTime(Calendar calendar) {
        this.second = calendar.get(Calendar.SECOND);
        this.minute = calendar.get(Calendar.MINUTE);;
        this.hour = calendar.get(Calendar.HOUR);;
        this.dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);;
        this.month = calendar.get(Calendar.MONTH);;
        this.year = calendar.get(Calendar.YEAR);;
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

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
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
