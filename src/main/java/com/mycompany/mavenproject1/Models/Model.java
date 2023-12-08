package com.mycompany.mavenproject1.Models;

import com.mycompany.mavenproject1.TableConfig.ButtonEditor;
import com.mycompany.mavenproject1.TableConfig.ButtonRenderer;
import com.mycompany.mavenproject1.Watchs.Time;
import com.mycompany.mavenproject1.Watchs.WatchHM;
import com.mycompany.mavenproject1.Watchs.WatchHMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Model implements Observable{
    private static Model model;
    public static Model getInstance(){
        if(model == null){
            model = new Model();
        }
        return model;
    }
    Model(){
        arrayList.add(new WatchHM(12, "TestEx1", 13, 59));
        arrayList.add(new WatchHM(13, "TestEx2", 14, 58));
        arrayList.add(new WatchHMS(14, "TestEx3", 15, 58,11));
    }
    ArrayList<Time> arrayList = new ArrayList<>();
    ArrayList<JTable> observers = new ArrayList<>();
    public void add(Time watch){
        arrayList.add(watch);
        notifyObserver();
    }
    public void deleteEl(int row){
        arrayList.remove(row);
    }
    @Override
    public void registerObserver(JTable table) {
        observers.add(table);
    }

    @Override
    public void removeObserver(JTable table) {
        observers.add(table);
    }
    public void deleteRow(int index){
        arrayList.remove(index);
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        for(JTable table1:observers) {
            Object[][] arr = new Object[arrayList.size()][5];
            for (int i = 0; i < arrayList.size(); ++i) {
                String name, cost, hour, minutes, seconds;
                WatchHM watchHM = (WatchHM) arrayList.get(i);
                name = watchHM.getName();
                cost = String.valueOf(watchHM.getCost());
                hour = String.valueOf(watchHM.getHour());
                minutes = String.valueOf(watchHM.getMinute());
                if (arrayList.get(i) instanceof WatchHMS watchHMS) {
                    seconds = String.valueOf(watchHMS.getSecond());
                    System.out.println(watchHMS);
                } else {
                    seconds = "does not support";
                    System.out.println(watchHM);
                }
                arr[i] = new Object[]{name, cost, hour, minutes, seconds};
            }
            DefaultTableModel dm = new DefaultTableModel();
            dm.setDataVector(arr, new Object[]{"Watch's name", "Cost", "Hour", "Minutes", "Seconds"});
            table1.setModel(dm);
        }
    }
}
