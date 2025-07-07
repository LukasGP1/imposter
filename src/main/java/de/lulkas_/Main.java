package de.lulkas_;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Options options = Options.getOptions(scanner);
        clearScreen();
        System.out.println(options);
    }

    private static void clearScreen() {
        for (int i = 0; i < 99999; i++) {
            System.out.println();
        }
    }
}