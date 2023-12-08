package com.mycompany.mavenproject1.Watchs;

public class Watch {
    protected int count;
    protected String name;

    public Watch(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public Watch() {

    }

    public int getCost() {
        return count;
    }


    public void setCost(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}