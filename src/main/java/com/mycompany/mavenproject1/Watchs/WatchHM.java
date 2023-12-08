package com.mycompany.mavenproject1.Watchs;

import jakarta.persistence.*;

public class WatchHM extends Watch implements Time{
    private int hour;
    private int minute;

    public WatchHM(int count, String name, int hour, int minute) {
        super(count, name);
        this.hour = hour;
        this.minute = minute;
    }

    public WatchHM() {
        super();
        hour = 0;
    }

    @Override
    public void setTime(TypeTime type, int time) throws TimeException {
        if(type == TypeTime.HOUR){
            if(!(time>=0 && time<=23))
                throw new TimeException("Часы должны быть в пределах от 0 до 23");
            setHour(time);
        }
        else if(type == TypeTime.MINUTE){
            if(!(time>=0 && time<=59))
                throw new TimeException("Минуты должны быть в пределах от 0 до 59");
            setHour(time);
        }
        else
        {
            throw  new TimeException("Секунды не подходят для выбранного времени");
        }
        System.out.println("Успешно установлено!");
    }
    @Override
    public String getFullInfo() {
        return "Type: HM, H: "+getHour()+", M: "+getMinute();
    }

    @Override
    public String toString() {
        return "WatchHM{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", count=" + count +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void move_forward(TypeTime type, int time) throws TimeException {
        if(type == TypeTime.HOUR){
            if(time<0)
                throw new TimeException("Укажите положительное время");
            setHour((hour+time)%24);
        }
        else if(type == TypeTime.MINUTE){
            if(time<0)
                throw new TimeException("Укажите положительное время");
            setHour((minute+time)%60);
        }
        else
        {
            throw  new TimeException("Секунды не подходят для выбранного времени");
        }
    }

    @Override
    public void get_time() {
        System.out.println(hour+" : "+minute);
    }


    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

}
