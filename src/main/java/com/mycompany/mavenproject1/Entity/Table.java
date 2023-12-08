package com.mycompany.mavenproject1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name = "Watch's_Table")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    TypeWatch typeWatch;
    String name;
    int cost;
    int hour;
    int minutes;
    int seconds;

    public Table(TypeWatch typeWatch, String name, int cost, int hour, int minutes, int seconds) {
        this.typeWatch = typeWatch;
        this.name = name;
        this.cost = cost;
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Table() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeWatch getTypeWatch() {
        return typeWatch;
    }

    public void setTypeWatch(TypeWatch typeWatch) {
        this.typeWatch = typeWatch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
