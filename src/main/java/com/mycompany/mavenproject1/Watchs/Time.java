package com.mycompany.mavenproject1.Watchs;

public interface Time {
    public void setTime(TypeTime type,int time ) throws TimeException;
    void move_forward(TypeTime type, int time) throws TimeException;
    void get_time();
    String getFullInfo();
}