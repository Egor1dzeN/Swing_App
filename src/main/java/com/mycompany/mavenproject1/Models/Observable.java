package com.mycompany.mavenproject1.Models;

import javax.swing.*;

public interface Observable {
    public void registerObserver(JTable table);
    public void removeObserver(JTable table);
    public void notifyObserver();
}
