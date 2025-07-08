package de.lulkas_;

import de.lulkas_.options.Words;
import de.lulkas_.window.SettingsWindow;

public class Main {
    public static void main(String[] args) {
        Words.init();
        new SettingsWindow();
    }
}